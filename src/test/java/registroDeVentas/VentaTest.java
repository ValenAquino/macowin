package registroDeVentas;

import org.junit.jupiter.api.BeforeEach;
import registroDeVentas.prenda.estados.Estado;
import registroDeVentas.prenda.Prenda;
import registroDeVentas.prenda.estados.Nueva;
import registroDeVentas.venta.VentaConTarjeta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import registroDeVentas.venta.LineaDeVenta;
import registroDeVentas.venta.Venta;
import java.time.LocalDate;

public class VentaTest {
  LocalDate unaFecha;
  Estado prendaNueva;
  Prenda unaPrenda;
  Prenda otraPrenda;
  LineaDeVenta unaLinea;
  LineaDeVenta otraLinea;

  @BeforeEach
  public void setUp() {
    this.prendaNueva = new Nueva();
    this.unaFecha = LocalDate.now();

    int precioBaseUnaPrenda = 500;
    this.unaPrenda = new Prenda("Remera", precioBaseUnaPrenda, prendaNueva);

    int precioBaseOtraPrenda = 300;
    this.otraPrenda = new Prenda("Pantalon", precioBaseOtraPrenda, prendaNueva);

    int cantidadUnaPrenda = 2;
    this.unaLinea = new LineaDeVenta(unaPrenda, cantidadUnaPrenda);

    int cantidadOtraPrenda = 1;
    this.otraLinea = new LineaDeVenta(otraPrenda, cantidadOtraPrenda);
  }

  @Test
  public void elPrecioDeUnaVentaEnEfectivoEsLaSumaDelPrecioDeLasLineasDeVenta() {
    float precioDeLasLineas = unaLinea.importe() + otraLinea.importe();

    Venta unaVenta = new Venta(unaFecha);
    unaVenta.agregarLineaDeVenta(unaLinea);
    unaVenta.agregarLineaDeVenta(otraLinea);

    Assertions.assertEquals(precioDeLasLineas, unaVenta.importeTotal());
  }

  @Test
  public void elPrecioDeUnaVentaPagandoConTarjetaTieneRecargo() {
    int cuotas = 1;
    int coeficienteFijo = 1;

    float importeLineas = unaLinea.importe() + otraLinea.importe();
    float recargoTarjeta = coeficienteFijo * cuotas + importeLineas * 0.01f;
    float importeTotal = recargoTarjeta + importeLineas;

    VentaConTarjeta ventaConTarjeta = new VentaConTarjeta(this.unaFecha, coeficienteFijo, cuotas);
    ventaConTarjeta.agregarLineaDeVenta(unaLinea);
    ventaConTarjeta.agregarLineaDeVenta(otraLinea);

    Assertions.assertEquals(importeTotal, ventaConTarjeta.importeTotal());
  }

}
