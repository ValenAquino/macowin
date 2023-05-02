package registroDeVentas.venta;

import java.time.LocalDate;

public class VentaConTarjeta extends Venta {
  int coeficienteFijo;
  int cuotas;
  float factorRecargo = 0.01f;

  public VentaConTarjeta(LocalDate fecha, int coefFijo, int cuotas) {
    super(fecha);
    this.coeficienteFijo = coefFijo;
    this.cuotas = cuotas;
  }

  public float recargo(float precioTotal) {
    return this.cuotas * this.coeficienteFijo + factorRecargo * precioTotal;
  }

  @Override
  public float importeTotal() {
    float precioTotal = super.importeTotal();
    return precioTotal + this.recargo(precioTotal);
  }

}

