package ar.edu.utn.regventas.prenda;

public class PrendaLiquidacion implements Estado{
  protected float porcentajeDeDescuento;

  public PrendaLiquidacion(float porcentajeDeDescuento) {
    this.porcentajeDeDescuento = porcentajeDeDescuento;
  }

  @Override
  public float precioModificado(float precioBase) {
    float factorDeDescuento = this.porcentajeDeDescuento / 100;

    return precioBase - (precioBase * factorDeDescuento);
  }
}
