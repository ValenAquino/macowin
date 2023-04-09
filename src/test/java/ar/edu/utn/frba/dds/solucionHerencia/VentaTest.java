package ar.edu.utn.frba.dds.solucionHerencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.utn.solucionHerencia.prenda.*;
import ar.edu.utn.solucionHerencia.venta.LineaDeVenta;
import ar.edu.utn.solucionHerencia.venta.Venta;
import ar.edu.utn.solucionHerencia.venta.MetodosDePago;
import java.time.LocalDate;

public class VentaTest {
  int cuotas = 1;
  int coeficiente = 1;
  int cantidadUnaPrenda = 2;
  int cantidadOtraPrenda = 1;
  LocalDate unaFecha = LocalDate.now();
  PrendaNueva unaPrenda = new PrendaNueva("Remera", 500);
  PrendaNueva otraPrenda = new PrendaNueva("Pantalon", 300);
  LineaDeVenta unaLinea = new LineaDeVenta(unaPrenda, cantidadUnaPrenda);
  LineaDeVenta otraLinea = new LineaDeVenta(otraPrenda, cantidadOtraPrenda);
  Venta unaVenta = new Venta(coeficiente, cuotas, MetodosDePago.EFECTIVO, unaFecha);

  @Test
  public void elPrecioDeUnaVentaEnEfectivoEsLaSumaDelPrecioDeLasLineasDeVenta() {
    float precioDeLasLineas = unaLinea.precioTotalLinea() + otraLinea.precioTotalLinea();

    unaVenta.agregarLinea(unaLinea);
    unaVenta.agregarLinea(otraLinea);

    Assertions.assertEquals(precioDeLasLineas, unaVenta.precioFinal());
  }

  @Test
  public void elPrecioDeUnaVentaPagandoConTarjetaTieneRecargo() {
    float precioDeLasLineas = unaLinea.precioTotalLinea() + otraLinea.precioTotalLinea();
    float recargoPorTarjeta = coeficiente * cuotas + precioDeLasLineas * 0.01f;

    unaVenta.setMetodoDePago(MetodosDePago.TARJETA);
    unaVenta.agregarLinea(unaLinea);
    unaVenta.agregarLinea(otraLinea);

    Assertions.assertEquals(recargoPorTarjeta + precioDeLasLineas, unaVenta.precioFinal());
  }

}
