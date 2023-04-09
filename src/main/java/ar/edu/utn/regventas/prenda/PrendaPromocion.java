package ar.edu.utn.regventas.prenda;

public class PrendaPromocion implements Estado {
  float descuento;

  public PrendaPromocion(float descuento) {
    this.descuento = descuento;
  }

  @Override
  public float precioModificado(float precioBase) {
    return precioBase - this.descuento;
  }

}
