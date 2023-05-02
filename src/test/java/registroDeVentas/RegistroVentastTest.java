package registroDeVentas;

import org.junit.jupiter.api.BeforeEach;
import registroDeVentas.prenda.estados.Estado;
import registroDeVentas.prenda.Prenda;
import registroDeVentas.prenda.estados.Nueva;
import registroDeVentas.venta.LineaDeVenta;
import registroDeVentas.venta.RegistroVentas;
import registroDeVentas.venta.Venta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class RegistroVentastTest {
  LocalDate unaFecha;
  LocalDate otraFecha;

  Prenda unaPrenda;
  Prenda otraPrenda;

  LineaDeVenta unaLinea;
  LineaDeVenta otraLinea;

  Venta ventaUno;
  Venta ventaDos;
  Venta ventaTres;

  @BeforeEach
  public void setUp() {
    this.setUpPrendas();
    this.setUpLineasDeVenta();
    this.setUpVentas();
    this.agregarLineasVentas();
  }

  public void agregarLineasVentas() {
    ventaUno.agregarLineaDeVenta(unaLinea);
    ventaUno.agregarLineaDeVenta(otraLinea);

    ventaDos.agregarLineaDeVenta(unaLinea);
    ventaDos.agregarLineaDeVenta(otraLinea);

    ventaTres.agregarLineaDeVenta(unaLinea);
    ventaTres.agregarLineaDeVenta(otraLinea);
  }

  public void setUpLineasDeVenta() {
    int cantidadUnaPrenda = 2;
    unaLinea =  new LineaDeVenta(unaPrenda, cantidadUnaPrenda);

    int cantidadOtraPrenda = 1;
    otraLinea = new LineaDeVenta(otraPrenda, cantidadOtraPrenda);
  }

  public void setUpVentas() {
    int diasSumados = 10;
    unaFecha = LocalDate.now();
    otraFecha = LocalDate.now().plusDays(diasSumados);

    ventaUno = new Venta(unaFecha);
    ventaDos = new Venta(unaFecha);
    ventaTres = new Venta(otraFecha);
  }

  public void setUpPrendas() {
    int precioBaseUnaPrenda = 500;
    int precioBaseOtraPrenda = 300;
    Estado prendaNueva = new Nueva();

    unaPrenda = new Prenda("Remera", precioBaseUnaPrenda, prendaNueva);
    otraPrenda = new Prenda("Pantalon", precioBaseOtraPrenda, prendaNueva);
  }

  @Test
  public void elRegistroDeVentasMeDevuelveLasVentasDelDiaQueLePido() {
    RegistroVentas regVentas = new RegistroVentas();
    float precioDeVentasEnUnDia = ventaDos.importeTotal() + ventaUno.importeTotal();

    regVentas.agregarVenta(ventaUno);
    regVentas.agregarVenta(ventaDos);
    regVentas.agregarVenta(ventaTres);

    Assertions.assertEquals(ventaTres.importeTotal(), regVentas.gananciasEnFecha(otraFecha));
    Assertions.assertEquals(precioDeVentasEnUnDia, regVentas.gananciasEnFecha(unaFecha));
  }
}