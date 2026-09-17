# Atrapa el círculo — Tabla de puntajes con Roble

Juego de 15 segundos: se inicia sesión con una cuenta de Roble, se hace clic en el círculo la mayor cantidad de veces posible, el puntaje se guarda en Roble y se muestran los 5 mejores.

## Antes de correrlo (en roble.uninorte.edu.co)

1. Crear un proyecto y copiar su **contrato** (id del proyecto) y la **URL de la API**.
2. Crear la tabla `puntajes` con dos columnas: `nombre` (texto) y `puntaje` (entero).
3. Crear las cuentas de los estudiantes (correo y clave).
4. Pegar la URL y el contrato al inicio de `TablaPuntajes.pde`:

```java
String URL_ROBLE = "https://...";
String CONTRATO  = "tu_contrato_aqui";
```

## Pestañas

| Pestaña | Qué tiene |
|---|---|
| `TablaPuntajes` | Pantallas, juego, burbuja. Aquí se trabaja. |
| `ROBLE` | Conexión. Solo se usan sus 3 funciones. |

Las 3 funciones de Roble:

```java
iniciarSesion(correo, clave)   // true si entró
guardarPuntaje(nombre, valor)  // agrega una fila a la tabla
cargarPuntajes()               // llena nombres[], marcas[] y n
```

## Conceptos del curso que aparecen

- Vectores paralelos `nombres[]` y `marcas[]` con contador `n`.
- Burbuja descendente con `AUX`: al mover una marca se mueve también su nombre.
- Cadenas: `indexOf("@")` y `substring` para sacar el nombre del correo, `substring` para borrar la última letra, concatenación para los asteriscos.
- Procedimientos: cada pantalla es un procedimiento; `draw()` solo decide cuál llamar.

## Errores comunes

- **Todo da "Correo o clave incorrectos"**: revisar `URL_ROBLE` y `CONTRATO`. La consola de Processing muestra el código que respondió Roble.
- **Los puntajes no aparecen**: la tabla no se llama exactamente `puntajes` o las columnas no son `nombre` y `puntaje`.
- **Funciona un rato y luego deja de guardar**: la sesión venció (sale un 401 en la consola). Se cierra y se vuelve a entrar.
- **El top 5 sale desordenado**: la burbuja compara con `<` para que quede de mayor a menor.
