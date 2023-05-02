package ar.edu.utn.regventas.venta;

public class Tarjeta implements MetodoDePago {
  int coeficienteFijo;
  int cantidadDeCuotas;
  float factorAumento = 0.01f;

  public Tarjeta(int coeficienteFijo, int cantidadCuotas) {
    this.coeficienteFijo = coeficienteFijo;
    this.cantidadDeCuotas = cantidadCuotas;
  }

  @Override
  public float recargo(float precioTotal) {
    return this.cantidadDeCuotas * this.coeficienteFijo + factorAumento * precioTotal;
  }

}

