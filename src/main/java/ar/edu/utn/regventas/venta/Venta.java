package ar.edu.utn.regventas.venta;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Venta {
  private final List<LineaDeVenta> lineasDeVentas = new ArrayList<>();
  private MetodoDePago metodoDePago;
  private int cantidadDeCuotas = 1;
  private final int coeficienteFijo;
  private final LocalDate fechaVenta;

  public Venta(int coeficienteFijo, LocalDate fechaVenta) {
    this.coeficienteFijo = coeficienteFijo;
    this.fechaVenta = fechaVenta;
  }

  public Venta(
      int coeficienteFijo,
      int cantidadDeCuotas,
      MetodoDePago metodoDePago,
      LocalDate fechaVenta
  ) {
    this.coeficienteFijo = coeficienteFijo;
    this.cantidadDeCuotas = cantidadDeCuotas;
    this.metodoDePago = metodoDePago;
    this.fechaVenta = fechaVenta;
  }

  public LocalDate getFechaVenta() {
    return fechaVenta;
  }

  public void setCantidadDeCuotas(int cantidadDeCuotas) {
    this.cantidadDeCuotas = cantidadDeCuotas;
  }

  public void setMetodoDePago(MetodoDePago metodoDePago) {
    this.metodoDePago = metodoDePago;
  }

  public void agregarLinea(LineaDeVenta nuevaLinea) {
    this.lineasDeVentas.add(nuevaLinea);
  }

  public float precioTotal() {
    return this.lineasDeVentas
        .stream()
        .map(LineaDeVenta::precioTotalLinea) // linea -> linea.precioTotalLinea()
        .reduce(0.0f, Float::sum); // (a, b) -> a + b
  }

  public float precioFinal() {
    float precioTotal = this.precioTotal();
    return precioTotal + metodoDePago.recargo(precioTotal);
  }
}
