package dominio;

import dominio.prenda.estados.Estado;
import dominio.prenda.Prenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dominio.prenda.estados.Nueva;
import dominio.venta.LineaDeVenta;

public class LineaDeVentaTest {

  @Test
  public void elPrecioDeLineaEsLaCantidadPorElPrecioDeLaPrenda() {
    Estado prendaNueva = new Nueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    LineaDeVenta unaLinea = new LineaDeVenta(prenda, 5);

    Assertions.assertEquals(5 * 1000, unaLinea.importe());
  }

}
