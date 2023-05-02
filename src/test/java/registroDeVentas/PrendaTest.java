  package registroDeVentas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import registroDeVentas.prenda.estados.Estado;
import registroDeVentas.prenda.Prenda;
import registroDeVentas.prenda.estados.*;

  public class PrendaTest {

  @Test
  public void seInstanciasLasPrendas() {
    Estado prendaNueva = new Nueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    Assertions.assertEquals("Remera", prenda.getTipo());
  }

  @Test
  public void lasPrendasEnLiquidacionTienenPorcentajeDeDescuento() {
    Estado prendaLiquidacion = new Liquidacion(50);
    Prenda prenda = new Prenda("Remera", 1000, prendaLiquidacion);
    Assertions.assertEquals(500, prenda.precio());
  }

  @Test
  public void lasPrendasEnPromocionTienenValorDeDescuento() {
    Estado prendaPromocion = new Promocion(50);
    Prenda prenda = new Prenda("Remera", 1000, prendaPromocion);
    Assertions.assertEquals(1000 - 50, prenda.precio());
  }

  @Test
  public void lasPrendasNuevasDevuelvenPrecioBase() {
    Estado prendaNueva = new Nueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    Assertions.assertEquals(1000, prenda.precio());
  }

}