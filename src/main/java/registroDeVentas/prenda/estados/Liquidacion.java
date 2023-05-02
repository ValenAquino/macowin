package registroDeVentas.prenda.estados;

public class Liquidacion implements Estado {
  protected float porcentajeDeDescuento;

  public Liquidacion(float porcentajeDeDescuento) {
    this.porcentajeDeDescuento = porcentajeDeDescuento;
  }

  @Override
  public float precioModificado(float precioBase) {
    float factorDeDescuento = this.porcentajeDeDescuento / 100;

    return precioBase - (precioBase * factorDeDescuento);
  }
}
