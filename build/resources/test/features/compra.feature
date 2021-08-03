Feature: Seccion de Proceso de compra de un artículo
  As
  comprador de la tienda
  I want
  poder entrar al home principal de la aplicacion y comprar los productos de mayor interes

  Scenario: Verificar ingreso a la URL y Login
    Given un usuario entro a la url de la aplicacion
    When un usuario ingresa datos validos para loguearse
    Then podra acceder al home principal de la app llamado productos

  Scenario: Verificar existencia y funcionalidad del boton 'Add to cart'
    Given un usuario entro al home principal de la aplicacion
    When el comprador presione el boton de addToCart
    Then el producto deseado se agregara a la lista del carrito de compras

  Scenario: Comprobar funcionamiento del elemento con logo de carro de compras
    Given un usuario entro a la zona de productos
    When el comprador de click sobre el icono de carro de compras
    Then se accedera a la zona de yourCart

  Scenario: Verificar la existencia y funcionalidad del boton 'Checkout'
    Given un usuario entro a la zona de yourCart
    When el usuario presione el boton de checkOut
    Then se accedera a una nueva zona llamada checkOutYourInfromation

  Scenario:Comprobar validaciones de los datos de nombre, apellido y codigo postal
    Given un comprador se dirigio a la zona de checkOutYourInfromation
    When un usuario ingrese los datos para la orden de envio
    Then se mostrara el mensaje de error si los datos son incorrectos de lo contrario podra dar click a continue

  Scenario: Verificar existencia y funcionalidad del boton 'Continue'
    Given el usuario ya ingreso los datos de nombre, apellido y codigo postal
    When el usuario presione el boton de continue
    Then podra acceder a una nueva zona llamada checkOutOverView

  Scenario: Comprobar la infomacion para el envio del producto y la existencia del boton 'Finish'.
    Given un comprador entro a la zona de checkOutOverView
    When el usuario desea ver la informacion que ingreso para el envio de la orden
    Then podra ver el resumen de la informacion del envio y ver el boton finish

  Scenario: Verificar el envio exitoso del producto con el mensaje y logo de confirmación.
    Given un usuario entro a la zona de checkOutOverView
    When el usuario presiona el boton de finish
    Then podra acceder a la zona de complete y ver el mensaje de envio exitoso con su respectiva imagen