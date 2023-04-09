# Macowins
[Link de la consigna](https://docs.google.com/document/d/1mjWKl9YH9Bb39iIUl1bQj_xhx_-CjCAMpcAXRqKhVjU/edit#)

## Requerimientos Identificados
-   Conocer el precio de venta de una prenda y sus tipos (saco, pantalon, camisa).
-   Conocer las ganancias de un determinado día.

## Diagrama de Clases

![enter image description here](https://github.com/ValenAquino/macowin/blob/main/assets/DiagramaDeClases.jpg?raw=true)

## Alternativas descartadas

### Herencia en las prendas

En un principio pensé en crear una super clase prenda y subclases dependiendo su estado (Nuevo, Liquidación, Promoción). Pero considero que es mas conveniente delegarlo a una clase estado a parte para evitar repetir código y que existan muchos constructores distintos para crear una prenda.

Ademas, no se podría  cambiar el estado de una prenda directamente y habría que instanciarla en otra clase distinta.

### Métodos de pago

Consideré crear un `enum` para moledar los métodos de pago y utilizar un `if` o `switch` para controlar que debe hacer en cada caso, pero agrega una responsabilidad extra a la clase que lo utiliza, por lo que decidí abstraerlo a una `interfaz MetodoDePago` donde delegar esa responsabilidad.

