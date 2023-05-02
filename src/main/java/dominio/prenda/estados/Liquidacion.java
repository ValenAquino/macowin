package dominio.prenda.estados;

public class Liquidacion implements Estado {
  protected float porcentajeDeDescuento = 50;

  @Override
  public float precioModificado(float precioBase) {
    float factorDeDescuento = this.porcentajeDeDescuento / 100;

    return precioBase - (precioBase * factorDeDescuento);
  }
}
