package ar.edu.utn.frba.dds.regventas;

import ar.edu.utn.regventas.prenda.Estado;
import ar.edu.utn.regventas.prenda.Prenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.utn.regventas.prenda.PrendaNueva;
import ar.edu.utn.regventas.venta.LineaDeVenta;

public class LineaDeVentaTest {

  @Test
  public void elPrecioDeLineaEsLaCantidadPorElPrecioDeLaPrenda() {
    Estado prendaNueva = new PrendaNueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    LineaDeVenta unaLinea = new LineaDeVenta(prenda, 5);

    Assertions.assertEquals(5 * 1000, unaLinea.precioTotalLinea());
  }

}
