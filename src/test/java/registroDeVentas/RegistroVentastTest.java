package ar.edu.utn.frba.dds.regventas;

import registroDeVentas.prenda.estados.Estado;
import registroDeVentas.prenda.Prenda;
import registroDeVentas.prenda.estados.Nueva;
import registroDeVentas.venta.Efectivo;
import registroDeVentas.venta.LineaDeVenta;
import registroDeVentas.venta.MetodoDePago;
import registroDeVentas.venta.RegistroVentas;
import registroDeVentas.venta.Venta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class RegistroVentastTest {
  // TODO: Hay demasiadas cosas para inicializar, ver si se puede abstraer de alguna manera
  int cuotas = 1;
  int coeficiente = 1;
  int cantidadUnaPrenda = 2;
  int cantidadOtraPrenda = 1;
  LocalDate unaFecha = LocalDate.now();
  LocalDate otraFecha = LocalDate.now().plusDays(10);
  Estado prendaNueva = new Nueva();
  Prenda unaPrenda = new Prenda("Remera", 500, prendaNueva);
  Prenda otraPrenda = new Prenda("Pantalon", 300, prendaNueva);
  LineaDeVenta unaLinea =  new LineaDeVenta(unaPrenda, cantidadUnaPrenda);
  LineaDeVenta otraLinea = new LineaDeVenta(otraPrenda, cantidadOtraPrenda);
  MetodoDePago efectivo = new Efectivo();
  Venta  unaVenta = new Venta(coeficiente, cuotas, efectivo, unaFecha);
  Venta  dosVenta = new Venta(coeficiente, cuotas, efectivo, unaFecha);
  Venta tresVenta = new Venta(coeficiente, cuotas, efectivo, otraFecha);

  @Test
  public void elRegistroDeVentasMeDevuelveLasVentasDelDiaQueLePido() {
    RegistroVentas regVentas = new RegistroVentas();

    //TODO: Hay que abstraer esta lógica en otra parte
    unaVenta.agregarLinea(unaLinea);
    unaVenta.agregarLinea(otraLinea);

    dosVenta.agregarLinea(unaLinea);
    dosVenta.agregarLinea(otraLinea);

    tresVenta.agregarLinea(unaLinea);
    tresVenta.agregarLinea(otraLinea);

    regVentas.agregarVenta(unaVenta);
    regVentas.agregarVenta(dosVenta);
    regVentas.agregarVenta(tresVenta);

    //TODO: Hay que separar esto en dos tests
    float precioDeVentasEnUnDia = dosVenta.precioFinal() + unaVenta.precioFinal();

    Assertions.assertEquals(tresVenta.precioFinal(), regVentas.gananciasEnFecha(otraFecha));
    Assertions.assertEquals(precioDeVentasEnUnDia, regVentas.gananciasEnFecha(unaFecha));
  }
}