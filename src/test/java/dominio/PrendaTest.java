package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import dominio.prenda.estados.Estado;
import dominio.prenda.Prenda;
import dominio.prenda.estados.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  private Prenda pantalonEnPromocion(int precioBase, int descuento) {
    Estado prendaPromocion = new Promocion(descuento);
    return new Prenda("PANTLON", precioBase, prendaPromocion);
  }

  private Prenda camisaNueva(float precioBase) {
    Estado nueva = new Nueva();
    return new Prenda("CAMISA", precioBase, nueva);
  }

  private Prenda sacoEnLiquidacion(float precioBase) {
    Estado liquidacion = new Liquidacion();
    return new Prenda("SACO", precioBase, liquidacion);
  }

}