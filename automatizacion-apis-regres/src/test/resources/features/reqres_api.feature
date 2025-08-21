Feature: Testing Reqres.in API

  Background:
    Given que quiero consumir los servicios de regres

  @ObtenerListaUsuarios
  Scenario Outline: Obtener lista de usuarios
    When realizo una peticion GET a la API con la pagina <page>
    Then recibo un codigo de respuesta 200
    And la lista de usuarios no esta vacia
    Examples: Consulta de usuarios para varias paginas
      | page |
      | 2    |

  @CrearNuevoUsuario
  Scenario: Crear un nuevo usuario
    When realizo una peticion POST a la API con los datos del usuario
    Then recibo un codigo de respuesta 201
    And el usuario es creado con los datos correctos

  @ActualizarUsuario
  Scenario: Actualizar un usuario existente
    When realizo una peticion PUT a la API con los nuevos datos del usuario
    Then recibo un codigo de respuesta 200
    And el usuario es actualizado correctamente

  @EliminarUsuario
  Scenario: Eliminar un usuario
    When realizo una peticion DELETE a la API
    Then recibo un codigo de respuesta 204
