#language: es
Característica: Loguin Siigo

  Como usuario
  Quiero autenticarme en la pagina de Siigo
  Para verificar el correcto funcionamiento

  @LoguinExitoso
  Escenario: Login Exitoso
    Dado que javier quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "retoautomationsiigo@yopmail.com" y "T4b4ck0ff1c3P455w0rd658*"
    Entonces el verifica el loguin existoso con el mensaje "automation"

  @LoguinFallido
  Escenario: Login fallido
    Dado que javier quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "retoautomationsiigo@yopmail.com" y "T4b4ck0ff1c3P455w0rd659*"
    Entonces el verifica el mensaje de login fallido con el mensaje "Usuario o contraseña inválidos"




