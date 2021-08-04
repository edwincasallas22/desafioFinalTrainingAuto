Feature: Sección de Cargue de productos


  Scenario: Verificar ingreso a la URL y Login
    Given un usuario entro a la url de la aplicacion web
    When un usuario ingresa datos validos para loguearse
    Then podra acceder al home princiapl de la app llamado productos

  Scenario: Comprobar existencia de los productos
    Given un comprador entro al home de la aplicacion Sauce demo
    When el usuario desea visualizar todos los productos que existen en la la zona de productos
    Then podra ver cada uno de los articulos puestos en venta

