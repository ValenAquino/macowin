package dominio.prenda.estados;

public class Nueva implements Estado {
  @Override
  public float precioModificado(float precioBase) {
    return precioBase;
  }
}

/*
* Use @Override every time you override a method for two benefits.
*
* Take advantage of the compiler checking to make sure
* you actually are overriding a method when you think you are.
*
* If you make a common mistake of misspelling a method name or not correctly matching
* the parameters, you will be warned that your method does not actually override as you think it
* does.
*
*  Secondly, it makes your code easier to understand
*/