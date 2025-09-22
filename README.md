# `Siigo-automatización`

Este proyecto es un ejemplo de automatización de pruebas para la plataforma Siigo, tiene una parte frontend(Plataforma interna) y una parte (Backend) utilizando la página de regres.in

## Descripción del Proyecto

Este proyecto se centra en la automatización de pruebas para:

* **Aplicaciones Web:** Específicamente, el flujo de creación de terceros (clientes) en la plataforma Siigo.
* **Servicios y APIs:** Pruebas funcionales de los endpoints para la gestión de usuarios.

---

## Funcionalidades Automatizadas

### Web 

* **Validación de ingreso:** Verificación del acceso a la aplicación.
* **Creación de Terceros:** Automatización del flujo de creación de un nuevo cliente.

### APIs 

* **Creación de Usuario:** Escenario de creación exitosa.
* **Consulta de Usuario:** Escenario de consulta exitosa.
* **Modificación de Usuario:** Escenario de modificación exitosa.
* **Eliminación de Usuario:** Escenario de eliminación exitosa.

---

## Instalación y Configuración

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/Javier-22/siigo-terceros-testing.git](https://github.com/Javier-22/siigo-terceros-testing#)
    ```

2.  **Instalar dependencias:**
    Utilizagradle para instalar las dependencias necesarias.
    ```bash
    ./gradlew clean build
    ```

3.  **Configurar variables de entorno:**
    Asegúrate de configurar las credenciales y URLs en el archivo de propiedades:
    * **Ruta del archivo:** `src/test/resources/config.properties`
    
4. **Requisitos Previos**
 **Java 17**
 **Gradle 8+**
 **Serenity BDD**
 **Cucumber**
 **RestAssured**
 Navegadores: **Chrome** y **Edge**

---

## Diseño de Casos de Prueba 

A continuación se presenta la aplicación de diferentes técnicas de diseño de pruebas para la funcionalidad de creación de clientes (terceros) en el formulario de Siigo. Se aplicaron técnicas de caja negra, incluyendo:

* **Partición de equivalencia
* **Valores límite
* **Transición de estados
* **Tabla de decisiones

Estas técnicas permiten generar casos de prueba más eficientes y robustos, asegurando que la funcionalidad se valide correctamente en distintos escenarios, tanto válidos como inválidos.

### 1. Partición de Equivalencias
**Objetivo:**  Dar cobertura a los escenarios posibles aplicados a uno de los campos obligatorios tomando como base la implementación de la técnica de diseño de partición de equivalencias. Se enfocó el diseño sobre el campo de Nombres y sus valores posibles admitidos.

| Caso  | Valor       | Tipo       | Resultado Esperado |
| :---- | :---------- | :--------- | :----------------- |
| **CP-01** | `123`        | Numérico   | Al diligenciar los campos obligatorios y el campo “Nombres” tenga un valor numérico se permita realizar el proceso de guardado de forma automática |
| **CP-02** | `Pedro`      | Alfabético | Al diligenciar los campos obligatorios y el campo “Nombres” tenga un valor alfabético se permita realizar el proceso de guardado de forma automática |
| **CP-03** | `/%$_-*`     | Especial   | Al diligenciar los campos obligatorios y el campo “Nombres” tenga caracteres especiales se permita realizar el proceso de guardado de forma automática |
| **CP-04** | `""` (vacío) | Vacío      | Al diligenciar los campos obligatorios y el campo “Nombres” esté vacío, al dar click en guardar, debe indicar que “el campo nombre es obligatorio” |
| **CP-05** | `" "` (espacio) | Espacios | Al diligenciar los campos obligatorios y el campo “Nombres” esté vacío, al dar click en guardar, debe indicar que “el campo nombre es obligatorio” |

## Precondiciones ✅
- La aplicación web debe ser accesible.  
- Se debe contar con credenciales correctas.  
- Contar con un cliente no existente en la web.  

## Pasos a Ejecutar 📝
1. Iniciar sesión en la aplicación.  
2. Dar clic en el botón superior **"CREAR"**.  
3. Seleccionar la opción **"CLIENTES"**.  
4. Diligenciar otros valores obligatorios (validados en otros escenarios).  
5. Diligenciar valores indicados por caso de prueba.  
6. Hacer clic en **"Guardar"**.  


### 2. Valores Límite

**Objetivo:** Dar cobertura a los escenarios posibles aplicados a uno de los campos obligatorios tomando como base la implementación de la técnica de diseño de valores límite. Se enfocó el diseño sobre el campo de identificación ya que cuenta con validaciones de longitud.

| Caso   | Valor            | Límite            | Resultado Esperado |
| :----- | :--------------- | :---------------- | :----------------- |
| **CP-01** | `12`              | Justo Inferior    | Al diligenciar los campos obligatorios y el campo “Identificación” con valor menor a 3 dígitos, debe aparecer un alert indicando que “debe tener un mínimo de 3 caracteres y un máximo de 13” |
| **CP-02** | `123`             | Mínimo Válido     | Al diligenciar los campos obligatorios y el campo “Identificación” con valor mayor a 3 dígitos, debe permitir el registro exitoso. |
| **CP-03** | `1234567890123`   | Máximo Válido     | Al diligenciar los campos obligatorios y el campo “Identificación” con valor menor a 13 dígitos, debe permitir el registro exitoso. |
| **CP-04** | `12345678901234`  | Justo Superior    | Al diligenciar los campos obligatorios y el campo “Identificación” con valor mayor a 13 dígitos, debe aparecer un alert indicando que “debe tener un mínimo de 3 caracteres y un máximo de 13” |

## Precondiciones 
- La aplicación web debe ser accesible.  
- Se debe contar con credenciales correctas.  
- Contar con un cliente no existente en la web.  

## Pasos a Ejecutar 
1. Iniciar sesión en la aplicación.  
2. Dar clic en el botón superior **"CREAR"**.  
3. Seleccionar la opción **"CLIENTES"**.  
4. Seleccionar tipo de documento **"Cédula de Ciudadanía"**.  
5. Diligenciar otros valores obligatorios (validados en otros escenarios).  
6. Diligenciar valores indicados por caso de prueba.  
7. Hacer clic en **"Guardar"**.  

### 3. Tablas de Decisión
**Objetivo:** 
Validar todas las combinaciones posibles de estados válidos e inválidos de los campos obligatorios principales  para asegurar que el sistema responde correctamente a cada combinación de condiciones.

| Caso   | c1  | c2  | c3  | c4  | c5  | c6  | Validación | Resultado Esperado |
| :----- | :-- | :-- | :-- | :-- | :-- | :-- | :--------- | :----------------- |
| **CP-01** | Sí  | Sí  | Sí  | Sí  | Sí  | Sí  | OK        | Al diligenciar los campos obligatorios correctamente el registro debe ser exitoso |
| **CP-02** | No  | Sí  | Sí  | Sí  | Sí  | Sí  | Error     | Al no diligenciar el tipo de tercero no debe continuar con el registro |
| **CP-03** | Sí  | No  | Sí  | Sí  | Sí  | Sí  | Error     | Al no diligenciar Tipo de identificación no debe continuar con el registro |
| **CP-04** | Sí  | Sí  | No  | Sí  | Sí  | Sí  | Error     | Al no diligenciar Número de identificación no debe continuar con el registro |
| **CP-05** | Sí  | Sí  | Sí  | No  | Sí  | Sí  | Error     | Al no diligenciar el Nombre no debe continuar con el registro |
| **CP-06** | Sí  | Sí  | Sí  | Sí  | No  | Sí  | Error     | Al no diligenciar el Apellido no debe continuar con el registro |
| **CP-07** | Sí  | Sí  | Sí  | Sí  | Sí  | No  | Error     | Al no diligenciar Nombre de la sección “Contáctenos tercero” no debe continuar con el registro|

### 4. Transición de Estados

**Objetivo:** Validar las transiciones de estados del formulario de creación de terceros, especialmente el comportamiento del botón "Guardar" y los estados de validación en tiempo real, asegurando que todas las transiciones válidas e inválidas se comporten correctamente.

| Estado | Descripción                | Características |
| :----- | :------------------------- | :-------------- |
| **E0** | Formulario vacío al cargar | Campos vacíos, Botón "Guardar" deshabilitado, sin mensajes de error |
| **E1** | Algunos campos válidos     | Al menos un campo válido, otros campos vacíos o inválidos, Botón "Guardar" deshabilitado |
| **E2** | Todos los campos válidos   | Digitar todos los campos obligatorios:<br>- Tipo de tercero<br>- Tipo de identificación<br>- Número de identificación<br>- Nombre válido<br>- Apellido válido<br>- Nombre (sección de contactos)<br>Botón "Guardar" habilitado |
| **E3** | Campos con errores de validación | Al menos un campo con error muestra mensajes de error visibles, Botón "Guardar" deshabilitado |

| Evento                          | Código | Descripción |
| :------------------------------ | :----- | :---------- |
| Cargar Formulario               | T1     | Inicialización del formulario |
| Ingresar Identificación Válida  | T2     | Campo identificación con formato correcto |
| Ingresar Identificación Inválida| T3     | Campo identificación con formato incorrecto |
| Ingresar Nombre Válido          | T4     | Campo nombre con texto válido |
| Ingresar Nombre Inválido        | T5     | Campo nombre vacío o solo espacios |
| Ingresar Apellido Válido        | T6     | Campo apellido con texto válido |
| Ingresar Apellido Inválido      | T7     | Campo apellido vacío o solo espacios |
| Seleccionar Ciudad Válida       | T8     | Ciudad seleccionada de la lista |
| Ciudad No Seleccionada          | T9     | Campo ciudad vacío |
| Limpiar Campo                   | T10    | Borrar contenido de campo |

| Caso de Prueba               | Código                 | Resultado Esperado |
| :--------------------------- | :--------------------- | :----------------- |
| Transición Inicial a Parcial | T1 → T2                | Primer campo válido ingresado |
| Transición Inicial a Error   | T1 → T3                | Estado error, mensaje visible, botón deshabilitado |
| Completar Formulario Gradual | T1 → T2 → T4 → T6 → T8 | Botón habilitado solo cuando todos los campos son válidos |
| Error de Validación en Campo Parcial | T1 → T2 → T5 | Transición a error, mensaje específico del campo |
| Invalidar Campo en Estado Válido | T1 → T2 → T4, T6, T8 → T5 | Botón se deshabilita, aparece error |
| Limpiar Campo y Revalidar    | T1 → T2 → T4 → T10     | Regreso a estado inicial si se limpian todos los campos |

## Casos de Prueba en Gherkin 

### Nivel Unitario


```bash

Scenario: Verificar obligatoriedad del campo vacio
Given Que ingreso a la web de SIIGO
And diligencio credenciales correctas
When Ingreso a la opción de crear Clientes
And doy click en el campo de texto de identificación
And doy click fuera del campo de texto
Then debe aparecer un mensaje indicando "Campo Obligatorio"

```

###  Nivel de Integración 

```bash

Scenario: Verificar fallida de datos en DIAN
Given Que ingreso a la web de SIIGO
And diligencio credenciales correctas
When Ingreso a la opción de crear Clientes
And digito el valor "123459876123456" en el campo identificación
And doy click en "Autocompletar Datos"
Then debe aparecer un popup indicando "Información no encontrada"

```
###  E2E 

```bash

Scenario: Registro exitoso de cliente tercero
Given Que ingreso a la web de SIIGO
And diligencio credenciales correctas
When Ingreso a la opción de crear Clientes
And selecciono tipo de cliente "es persona"
And diligencio todos los campos obligatorios
And diligencio todos los campos opcionales
And doy click en el botón guardar 
Then me debe redirigir al perfil del cliente creado

```

## Reporte de Bug  

### **Título:** No se eliminan contactos en registro de cliente tercero  
**ID del Bug:** BUG-003  
**Componente:** Módulo de Creación de Terceros - Sección Contactos  
**Severidad:** Media (no borra datos, pero no afecta otras funcionalidades).  
**Prioridad:** Media (permite entrega en próximo despliegue).  

**Entorno:**  
- **Navegadores:** Microsoft Edge 138.0.3351.95 / Chrome 115.0.5790.102  
- **OS:** Windows 11 64-bit  

**Pasos para Reproducir:**  
1. Inicia sesión en la aplicación.  
2. Haz clic en el botón superior **"CREAR"**.  
3. Selecciona la opción **"CLIENTES"**.  
4. Dirígete a la parte inferior en la sección **"Contactos"**.  
5. Despliega la sección de contactos.  
6. Diligencia los datos de un contacto.  
7. Haz clic en **"Agregar otro contacto"**.  
8. Haz clic en el botón **"Eliminar"**.  
9. Confirma la eliminación en el popup generado.  

**Comportamiento Esperado:**  
- Al confirmar la eliminación en el popup, el registro de contacto debería borrarse de la pantalla.  

**Comportamiento Actual:**  
- El popup de eliminación se cierra, pero el registro de contacto sigue en pantalla sin eliminarse.  
 


