Feature: Sección de Login de Usuario
  As
  comprador de la tienda
  I want
  poder entrar al home principal de la aplicacion por medio del LOGIN con los diferentes tipos de usuario

  Scenario: Verificar existencia para loguearse
    Given un usuario entra a la url de la aplicacion
    When el usuario desea visualizar los campos para loguearse
    Then podra ver los elementos para loguearse username, password y el boton de login