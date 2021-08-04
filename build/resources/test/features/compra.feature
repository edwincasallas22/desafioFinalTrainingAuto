Feature: Seccion de Proceso de compra de un artículo

   Scenario: Verificar ingreso a la URL y Login
    Given un comprador entro a la url de la aplicacion web
    When un comprador ingresa datos validos para loguearse
    Then podra acceder al home principal de la app llamado productos


   Scenario: Mostrar botones ADD TO CART
   Given que un usuario se encuentre Autenticado
   When un usuario ingresa a la pagina home del sitio Sauce demo
   Then visualizara los botones para anadir al carro de compras ADD TO CART en los productos

   Scenario Outline: : Funcionalidad carro de compras
   Given que un usuario se encuentre Autenticado
   When un usuario ingresa a la pagina home del sitio Sauce demo
   And da click en el boton ADD TO CART de cualquier "<producto>"
   Then el producto se agrega a la lista de ADD TO CART
   Examples: :
   | producto |
   | 1        |
   | 2        |
   | 3        |
   | 4        |
   | 5        |
   | 0        |

   Scenario: Ingreso de infomacion personal para la compra de un producto
   Given que un usuario autenticado con usuario y password validos
   And haya agregado un producto al carro de compras
   When el usuario ingresa en la pagina CHECKOUT: YOUR INFORMATION
   Then Se podra ingresar informacion personal en los respectivos campos

   Scenario: Verificar el envio exitoso del producto con el mensaje y logo de confirmación.
      Given un usuario entro a la zona de checkOutOverView
      When el usuario presiona el boton de finish
      Then podra acceder a la zona de complete y ver el mensaje de envio exitoso con su respectiva imagen






