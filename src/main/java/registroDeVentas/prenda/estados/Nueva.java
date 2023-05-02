package registroDeVentas.prenda;

public class PrendaNueva implements Estado {
  @Override
  public float precioModificado(float precioBase) {
    return precioBase;
  }
}
