package ar.edu.utn.regventas.prenda;

public class Prenda {
  protected String tipo;
  protected float precioBase;
  Estado estado;

  public Prenda(String tipo,float precioBase, Estado estado) {
    this.tipo = tipo;
    this.precioBase = precioBase;
    this.estado = estado;
  }

  public String getTipo() {
    return tipo;
  }

  public float getPrecio() {
    return estado.precioModificado(precioBase);
  }
}