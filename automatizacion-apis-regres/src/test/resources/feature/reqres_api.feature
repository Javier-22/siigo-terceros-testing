# language: es
Característica: Pruebas de la API Reqres.in

  Antecedentes:
    Dado que se va a consumir la API de seqRes

  @cp @crear
  Escenario: Crear un Usuario Exitosamente
    Cuando creo un usuario con datos aleatorios
    Entonces valido el codigo de estado 201

  @cp  @consultar
  Escenario: Consulta un Usuario Exitosamente
    Cuando consulta la informacion del usuario creado
    Entonces valido el codigo de estado 200

  @cp @modificar
  Escenario: Modificar un  Usuario Exitosamente
    Cuando actualizo el usuario 2 con datos aleatorios
    Entonces valido el codigo de estado 200

  @cp  @eliminar
  Escenario: Eliminar un  Usuario Exitosamente
    Cuando se elmina el Usuario con el Id 2
    Entonces valido el codigo de estado 204