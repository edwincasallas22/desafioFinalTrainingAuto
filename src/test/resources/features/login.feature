Feature: Seccion de Login de Usuario
  As
  comprador de la tienda
  I want
  poder entrar al home principal de la aplicacion por medio del LOGIN con los diferentes tipos de usuario

  Scenario: Verificar existencia para loguearse
    Given un usuario entro a la url de la aplicacion
    When el usuario desea visualizar los campos para loguearse
    Then podra ver los elementos para loguearse username, password y el boton de Login

  Scenario: Autentificación exitosa y direccionamineto a la zona de productos
    Given un usuario entro a la url de la aplicacion
    When el usuario ingresa un usuario y contraseña validos
    Then podra autenticarse correctamente y acceder a la zona de productos

  Scenario: Autentificación fallida
    Given un usuario entro a la url de la aplicacion
    When el usuario ingresa usuarios y contraseñas invalidos
    Then se mostrara el mensaje de  autentificación fallida

  Scenario: Verificar existencia y funcionalidad del elemento Logout
    Given un usuario entro a la pagina principal de souce demo
    When el comprador desea salir del home principal de la aplicacion
    Then podra salir por medio del boton Logout