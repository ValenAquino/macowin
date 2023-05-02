package registroDeVentas.prenda;

import registroDeVentas.prenda.estados.Estado;

public class Prenda {
  protected String tipo;
  protected float precioBase;
  Estado estado;

  public Prenda(String tipo, float precioBase, Estado estado) {
    this.tipo = tipo;
    this.precioBase = precioBase;
    this.estado = estado;
  }

  public String getTipo() {
    return tipo;
  }

  public float precio() {
    return estado.precioModificado(precioBase);
  }
}