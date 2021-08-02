Feature: Sección de Cargue de productos
  As
  comprador de la tienda
  I want
  poder entrar al home principal de la aplicacion y ver los diferentes tipos de articulos puestos en venta

  Scenario: Verificar ingreso a la URL y Login
    Given un usuario entro a la url de la aplicacion
    When un usuario ingresa datos validos para loguearse
    Then podra acceder al home princiapl de la app llamado productos

  Scenario: Comprobar existencia de los productos
    Given un comprador entro al home de la aplicacion Sauce demo
    When el usuario desea visualizar todos los productos que existen en la la zona de productos
    Then podra ver cada uno de los articulos puestos en venta

  Scenario: Verificar los elementos de Imagen, titulo, resumen, precio y boton de 'Add to cart' en cada uno de los articulos
    Given un comprador entro al home de la aplicacion Sauce demo
    When el comprador desea conocer mas informacion acerca de cada producto
    Then podra ver cada uno de los elementos que dan informacion detallada del articulo