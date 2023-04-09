  package ar.edu.utn.frba.dds.regventas;

import ar.edu.utn.regventas.prenda.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void seInstanciasLasPrendas() {
    Estado prendaNueva = new PrendaNueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    Assertions.assertEquals("Remera", prenda.getTipo());
  }

  @Test
  public void lasPrendasEnLiquidacionTienenPorcentajeDeDescuento() {
    Estado prendaLiquidacion = new PrendaLiquidacion(50);
    Prenda prenda = new Prenda("Remera", 1000, prendaLiquidacion);
    Assertions.assertEquals(500, prenda.getPrecio());
  }

  @Test
  public void lasPrendasEnPromocionTienenValorDeDescuento() {
    Estado prendaPromocion = new PrendaPromocion(50);
    Prenda prenda = new Prenda("Remera", 1000, prendaPromocion);
    Assertions.assertEquals(1000 - 50, prenda.getPrecio());
  }

  @Test
  public void lasPrendasNuevasDevuelvenPrecioBase() {
    Estado prendaNueva = new PrendaNueva();
    Prenda prenda = new Prenda("Remera", 1000, prendaNueva);
    Assertions.assertEquals(1000, prenda.getPrecio());
  }

}