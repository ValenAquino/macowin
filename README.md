# Macowins
[Link de la consigna](https://docs.google.com/document/d/1mjWKl9YH9Bb39iIUl1bQj_xhx_-CjCAMpcAXRqKhVjU/edit#)

## Requerimientos Identificados
-   Conocer el precio de venta de una prenda
-   Conocer la prenda y los tipos (saco, pantalon, camisa)
-   Registrar ventas
-   Conocer ganancias de un día determinado

## Diagrama de Clases

![enter image description here](https://www.plantuml.com/plantuml/dsvg/XL51JiCm4Bpx5OPJGKeVK5LLHTEU026ekA-SJUegiOkzwONoTpQf7OSAwA5IEZixipDUUW97RLEB6zfXWr8voYg7Q8HGDNWlNnoQ0kIda9BqmSgPV2EdJSN_aPUB3bdt7umS72fj7y0ZesLjWGPmSYU-XD26q9MWCEomRYGysKANMZ7OKQFzSuj7kCfwr1-jBe3dviorJg4Xs6EENhNyQVzNu9YsiSD-OtaZJyifpHyY8Sqy2tqDm6awFMSO8-DxntYw8WKp23c-ew6X1PQNi_Wk32amn685Wrml0xhX_8JTPJ8A9OMwa_HHSyOMdkPZdmMJIbIxVcWLr3aGogIxjGHrw2vfhwpPWjjZS54MkH_D4zpeVIemdPlZgcKbFnfnjU0ghlHNiqkRxBGuMuiVBMNPGjxAU_w5fxY4n-mOuHKhhi7P0Fi-GmK6ZDBWrsRJzJ59RVJzT6SUE_frGkmv5CnfBXtJWI7Kaezlc_eR)

## Alternativas descartadas

### Herencia en las prendas

* En un principio pensé en crear una super clase prenda y subclases dependiendo su estado (Nuevo, Liquidación, Promoción). Esta solución me impide que las prendas cambien de estado.


* Por ello, decidí implementar el patrón de diseño strategy ya que el problema encajaba perfecto. Se necesitaba diferenciar la "estrategía" de calculo de precio. 

### Métodos de pago

* Consideré crear un `enum` para moledar los métodos de pago y utilizar un `if` o `switch` para controlar que debe hacer en cada caso, pero agrega una responsabilidad extra a la clase que lo utiliza


* También pensé en abstraerlo a una `interfaz MetodoDePago` donde delegar esa responsabilidad. Pero para la consigna actual, genera una clase extra para implementar el efectivo y que el recargo sea de 0.


* Por lo tanto, decidí que para  `VentaConTarjeta` se cree una subclase que herede de `Venta` con un `@Override` al método `importeTotal()`

Como agregado final, en el caso de que exista una nueva iteración donde se agreguen metodos de pago distinto que varían el recargo aplicable o un descuento del precio final, podría existir la necesidad de utilizar una interfaz de metodoDePago, pero basandome en el principio YAGNI, es preferible no agregar complejidad adicional innecesaria.

