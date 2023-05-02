package dominio.venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
  private final List<LineaDeVenta> lineasDeVentas = new ArrayList<>();
  private final LocalDate fechaVenta;

  public Venta(LocalDate fechaVenta) {
    this.fechaVenta = fechaVenta;
  }

  public LocalDate getFechaVenta() {
    return fechaVenta;
  }

  public void agregarLineaDeVenta(LineaDeVenta nuevaLinea) {
    this.lineasDeVentas.add(nuevaLinea);
  }

  public float importeTotal() {
    // mapeeo a Double porque no se puede a float directamente
    // por eso casteo a float
    return (float) this.lineasDeVentas.stream()
        .mapToDouble(LineaDeVenta::importe) // linea -> linea.precioTotalLinea()
        .sum();
  }
}
