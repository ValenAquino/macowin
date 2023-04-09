package ar.edu.utn.regventas.venta;

public class Efectivo implements MetodoDePago {

  @Override
  public float recargo(float precioTotal) {
    return 0.0f; // Número mágico ?
  }

}
