Feature: swag

  @ingresarASwag
  Scenario: ingresar a swag
    Given Se abre swag
    When Se ingresen las credenciales
    Then Se presiona el boton login

  @comprarProducto
  Scenario: Comprar un producto en swag
    When El usuario selecciona un producto
    And El usuario agrega el producto al carrito
    And Completa los datos para la compra
    And Finalizar compra

  @eliminarProducto
  Scenario: Seleccionar y eliminar productos en swag
    When Cuando el cliente elimina un producto
    And El cliente agrega el producto al carrito
    And El cliente elimina producto del carrito
    And Registra los datos para la compra
    And Finish
    And Verificar la compra con exito

  @salirDeSwag
  Scenario: salir de swag
    When Se cierra la sesion
    Then Se ha cerrado la sesión correctamente
    And Se cierra el navegador