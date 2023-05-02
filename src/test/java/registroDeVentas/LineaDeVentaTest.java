package ar.edu.utn.frba.dds.regventas;

import registroDeVentas.prenda.estados.Estado;
import registroDeVentas.prenda.Prenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import registroDeVentas.prenda.estados.Nueva;
import registroDeVentas.venta.LineaDeVenta;

public class LineaDeVentaTest {

  @Test
  public void elPrecioDeLineaEsLaCantidadPorElPrecioDeLaPrenda() {
    Estado prendaNueva = new Nueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    LineaDeVenta unaLinea = new LineaDeVenta(prenda, 5);

    Assertions.assertEquals(5 * 1000, unaLinea.precioTotalLinea());
  }

}
