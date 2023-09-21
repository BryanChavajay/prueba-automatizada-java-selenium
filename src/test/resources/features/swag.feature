Feature: swag

  @ingresarASwag
  Scenario: ingresar a swag
    Given Se abre swag
    When Se ingresen las credenciales
    Then Se presiona el boton login

  @salirDeSwag
  Scenario: salir de swag
    When Se cierra la sesion
    Then Se ha cerrado la sesión correctamente
    And Se cierra el navegador