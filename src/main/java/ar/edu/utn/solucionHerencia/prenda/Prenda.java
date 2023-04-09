package ar.edu.utn.solucionHerencia.prenda;

public class Prenda {
  protected String tipo;
  protected float precioBase;

  public Prenda(String tipo,float precioBase) {
    this.tipo = tipo;
    this.precioBase = precioBase;
  }

  public String getTipo() {
    return tipo;
  }

  public float getPrecio() {
    return precioBase;
  }
}