#language: es
Característica: Seccion de Login de Usuario

  Escenario: Verificar existencia para loguearse
    Dado un usuario entro a la url de la aplicacion
    Cuando el usuario desea visualizar los campos para loguearse
    Entonces podra ver los elementos para loguearse username, password y el boton de Login

   Escenario: Autentificación exitosa y direccionamineto a la zona de productos
     Dado un usuario entro a la url de la aplicacion
     Cuando el usuario ingresa un usuario y clave validos
     Entonces podra autenticarse correctamente y acceder a la zona de productos

  Esquema del escenario: Autentificación fallida
    Dado un usuario entro a la url de la aplicacion
    Cuando el usuario ingresa "<usuario>" y "<clave>" invalidos
    Entonces se mostrara el mensaje de  autentificacion fallida
    Ejemplos:
      | usuario                 | clave        |
      |                         |              |
      | edwinCasallas           | secret_sauce |
      | edwin@Casallas.com      | 1234567      |
      | edwinCasallas           | 1234567      |
      | performance_glitch_user |              |

  Escenario: Verificar existencia y funcionalidad del elemento Logout
    Dado un usuario entro a la pagina principal de souce demo con usuario y clave validos
    Cuando el comprador desea salir del home principal de la aplicacion
    Entonces podra salir por medio del boton Logout
