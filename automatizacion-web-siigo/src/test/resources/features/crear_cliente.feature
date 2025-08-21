#language: es

  Característica: Crear Cliente

    Como usuario de siigo
    Quiero diligenciar el formulario para crear un tercero
    Para validar que la creación sea exitosa

  Antecedentes:
    Dado que javier quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "retoautomationsiigo@yopmail.com" y "T4b4ck0ff1c3P455w0rd658*"

  @CrearCliente
   Escenario: Crear cliente tercero
    Cuando el realiza la creación de un tercero con su informacion
    Entonces el verifica la creación  del tercero con sus datos
    Y el verifica que el estado del tercero sea "Activo"

