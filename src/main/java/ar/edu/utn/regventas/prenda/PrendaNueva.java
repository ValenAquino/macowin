package ar.edu.utn.regventas.prenda;

public class PrendaNueva implements Estado {
  @Override
  public float precioModificado(float precioBase) {
    return precioBase;
  }
}
