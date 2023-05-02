package registroDeVentas.prenda.estados;

public class Promocion implements Estado {
  float montoDeDescuento;

  public Promocion(float montoDeDescuento) {
    this.montoDeDescuento = montoDeDescuento;
  }

  @Override
  public float precioModificado(float precioBase) {
    return precioBase - this.montoDeDescuento;
  }

}
