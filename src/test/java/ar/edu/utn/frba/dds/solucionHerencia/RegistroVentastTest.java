package ar.edu.utn.frba.dds.solucionHerencia;

import ar.edu.utn.solucionHerencia.prenda.PrendaNueva;
import ar.edu.utn.solucionHerencia.venta.LineaDeVenta;
import ar.edu.utn.solucionHerencia.venta.MetodosDePago;
import ar.edu.utn.solucionHerencia.venta.RegistroVentas;
import ar.edu.utn.solucionHerencia.venta.Venta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class RegistroVentastTest {
  int cuotas = 1;
  int coeficiente = 1;
  int cantidadUnaPrenda = 2;
  int cantidadOtraPrenda = 1;
  LocalDate unaFecha = LocalDate.now();
  LocalDate otraFecha = LocalDate.now().plusDays(10);
  PrendaNueva unaPrenda = new PrendaNueva("Remera", 500);

  PrendaNueva otraPrenda = new PrendaNueva("Pantalon", 300);
  LineaDeVenta unaLinea =  new LineaDeVenta(unaPrenda, cantidadUnaPrenda);
  LineaDeVenta otraLinea = new LineaDeVenta(otraPrenda, cantidadOtraPrenda);

  Venta  unaVenta = new Venta(coeficiente, cuotas, MetodosDePago.EFECTIVO, unaFecha);
  Venta  dosVenta = new Venta(coeficiente, cuotas, MetodosDePago.EFECTIVO, unaFecha);
  Venta tresVenta = new Venta(coeficiente, cuotas, MetodosDePago.EFECTIVO, otraFecha);

  @Test
  public void ventasDelMismoDia() {
    RegistroVentas regVentas = new RegistroVentas();

    unaVenta.agregarLinea(unaLinea);
    unaVenta.agregarLinea(otraLinea);

    dosVenta.agregarLinea(unaLinea);
    dosVenta.agregarLinea(otraLinea);

    tresVenta.agregarLinea(unaLinea);
    tresVenta.agregarLinea(otraLinea);

    regVentas.agregarVenta(unaVenta);
    regVentas.agregarVenta(dosVenta);
    regVentas.agregarVenta(tresVenta);

    Assertions.assertEquals(tresVenta.precioFinal(), regVentas.gananciasEnFecha(otraFecha));

    Assertions.assertEquals(
        dosVenta.precioFinal() + unaVenta.precioFinal(),
        regVentas.gananciasEnFecha(unaFecha)
    );
  }
}