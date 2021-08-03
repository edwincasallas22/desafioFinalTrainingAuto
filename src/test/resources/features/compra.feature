Feature: Seccion de Proceso de compra de un artículo
  As
  comprador de la tienda
  I want
  poder entrar al home principal de la aplicacion y comprar los productos de mayor interes

  Scenario: Verificar ingreso a la URL y Login
    Given un comprador entro a la url de la aplicacion web
    When un comprador ingresa datos validos para loguearse
    Then podra acceder al home principal de la app llamado productos









 

  Scenario: Comprobar la infomacion para el envio del producto y la existencia del boton 'Finish'.
    Given un comprador entro a la zona de checkOutOverView
    When el usuario desea ver la informacion que ingreso para el envio de la orden
    Then podra ver el resumen de la informacion del envio y ver el boton finish

  Scenario: Verificar el envio exitoso del producto con el mensaje y logo de confirmación.
    Given un usuario entro a la zona de checkOutOverView
    When el usuario presiona el boton de finish
    Then podra acceder a la zona de complete y ver el mensaje de envio exitoso con su respectiva imagen