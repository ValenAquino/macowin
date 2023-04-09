package ar.edu.utn.solucionHerencia.venta;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class RegistroVentas {
  private final ArrayList<Venta> ventas;
  // final hace que el compilador detecte como error cambiar el valor de la varaible
  // final es inicializada al momento de usarse, mientras const al momento de escribirse.

  public RegistroVentas() {
    ventas = new ArrayList<>(); // a partir de acá, no se puede cambiar el valor
  }

  public void agregarVenta(Venta venta) {
    ventas.add(venta);
  }

  public ArrayList<Venta> ventasEnFecha(LocalDate fecha) {
    return ventas.stream()
        .filter(venta -> venta.getFechaVenta() == fecha)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public float gananciasEnFecha(LocalDate fecha) {
    return this.ventasEnFecha(fecha).stream()
        .map(Venta::precioFinal)
        .reduce(0.0f, Float::sum);
  }

}
