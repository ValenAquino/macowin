package ar.edu.utn.solucionHerencia.prenda;

public class PrendaNueva extends Prenda {
  public PrendaNueva(String tipo, float precioBase) {
    super(tipo, precioBase);
  }

  @Override
  public float getPrecio() {
    return this.precioBase;
  }
}
