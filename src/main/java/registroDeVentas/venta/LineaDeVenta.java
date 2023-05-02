package ar.edu.utn.regventas.venta;

import ar.edu.utn.regventas.prenda.Prenda;

public class LineaDeVenta {
  private int cantidad;
  private Prenda unaPrenda;

  public LineaDeVenta(Prenda unaPrenda, int cantidad) {
    this.unaPrenda = unaPrenda;
    this.cantidad = cantidad;
  }

  public float precioTotalLinea() {
    return cantidad * unaPrenda.getPrecio();
  }
}