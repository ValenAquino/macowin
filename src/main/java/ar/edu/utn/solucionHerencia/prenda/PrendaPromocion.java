package ar.edu.utn.solucionHerencia.prenda;

public class PrendaPromocion extends Prenda {
  float descuento;

  public PrendaPromocion(String tipo, float precioBase, float descuento) {
    super(tipo, precioBase);
    this.descuento = descuento;
  }

  @Override
  public float getPrecio() {
    return this.precioBase - descuento;
  }

}
