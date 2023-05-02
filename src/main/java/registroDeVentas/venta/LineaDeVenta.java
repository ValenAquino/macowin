package registroDeVentas.venta;

import registroDeVentas.prenda.Prenda;

public class LineaDeVenta {
  private final int cantidad;
  private final Prenda unaPrenda;

  public LineaDeVenta(Prenda unaPrenda, int cantidad) {
    this.unaPrenda = unaPrenda;
    this.cantidad = cantidad;
  }

  public float importe() {
    return cantidad * unaPrenda.precio();
  }
}
