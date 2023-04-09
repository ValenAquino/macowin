package ar.edu.utn.frba.dds.solucionHerencia;

import ar.edu.utn.solucionHerencia.prenda.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void seInstanciasLasPrendas() {
    Prenda prenda = new Prenda("Remera", 1000);
    Assertions.assertEquals("Remera", prenda.getTipo());
  }

  @Test
  public void lasPrendasEnLiquidacionTienenPorcentajeDeDescuento() {
    Prenda prenda = new PrendaLiquidacion("Remera", 1000, 50);
    Assertions.assertEquals(500, prenda.getPrecio());
  }

  @Test
  public void lasPrendasEnPromocionTienenValorDeDescuento() {
    Prenda prenda = new PrendaPromocion("Remera", 1000, 50);
    Assertions.assertEquals(1000 - 50, prenda.getPrecio());
  }

  @Test
  public void lasPrendasNuevasDevuelvenPrecioBase() {
    Prenda prenda = new PrendaNueva("Remera", 1000);
    Assertions.assertEquals(1000, prenda.getPrecio());
  }

}