package ar.edu.utn.solucionHerencia.prenda;

public class PrendaLiquidacion extends Prenda {
  protected float porcentajeDeDescuento;

  public PrendaLiquidacion(String tipo, float precioBase, float porcentajeDeDescuento) {
    super(tipo, precioBase);
    this.porcentajeDeDescuento = porcentajeDeDescuento;
  }

  @Override
  public float getPrecio() {
    float factorDeDescuento = this.porcentajeDeDescuento / 100;
    return this.precioBase - (this.precioBase * factorDeDescuento);
  }
}
