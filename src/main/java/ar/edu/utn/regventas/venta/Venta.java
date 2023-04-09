package ar.edu.utn.regventas.venta;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Venta {
  private final List<LineaDeVenta> lineasDeVentas = new ArrayList<>();
  private MetodosDePago metodoDePago = MetodosDePago.EFECTIVO;
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
      MetodosDePago metodoDePago,
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

  public void setMetodoDePago(MetodosDePago metodoDePago) {
    this.metodoDePago = metodoDePago;
  }

  public void agregarLinea(LineaDeVenta nuevaLinea) {
    this.lineasDeVentas.add(nuevaLinea);
  }

  public float precioTotal() {
    if (lineasDeVentas.size() == 0) {
      return 0.0f;
    }

    return this.lineasDeVentas
        .stream()
        .map(LineaDeVenta::precioTotalLinea) // linea -> linea.precioTotalLinea()
        .reduce(0.0f, Float::sum); // (a, b) -> a + b
  }

  public float recargoPorTarjeta() {
    float porcentajeDeAumentoPorPrenda = 0.01f;
    float recargoTotal = this.precioTotal() * porcentajeDeAumentoPorPrenda;
    return recargoTotal + this.cantidadDeCuotas * this.coeficienteFijo;
  }

  public float precioFinal() {
    float precioFinal = this.precioTotal();

    if(this.metodoDePago == MetodosDePago.TARJETA) {
      precioFinal += recargoPorTarjeta();
    }

    return precioFinal;
  }
}
