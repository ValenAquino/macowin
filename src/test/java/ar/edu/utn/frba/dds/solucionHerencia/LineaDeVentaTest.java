package ar.edu.utn.frba.dds.solucionHerencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.utn.solucionHerencia.prenda.PrendaNueva;
import ar.edu.utn.solucionHerencia.venta.LineaDeVenta;

public class LineaDeVentaTest {

  @Test
  public void elPrecioDeLineaEsLaCantidadPorElPrecioDeLaPrenda() {
    PrendaNueva prenda = new PrendaNueva("Remera", 1000);
    LineaDeVenta unaLinea = new LineaDeVenta(prenda, 5);

    Assertions.assertEquals(5 * 1000, unaLinea.precioTotalLinea());
  }

}
