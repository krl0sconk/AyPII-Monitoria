# Práctica Parcial 2 — Cadenas y Procedimientos

Ocho ejercicios en pseudocódigo para preparar el Parcial 2 (semana 12), de menos a más. Siguen el estilo del Manual de Informática II: recorrer con `SUBSTR`, construir cadenas concatenando, cambio de base con funciones compuestas, y primos y perfectos.

| Archivo | Contenido |
|---|---|
| `01_enunciados.txt` | Repaso rápido + los 8 enunciados con ejemplos de entrada y salida |
| `02_soluciones.txt` | Soluciones completas con trazas y el porqué de cada decisión |

**Intenten primero sin mirar las soluciones.**

## Ejercicios

| Nivel | # | Ejercicio | Practica |
|---|---|---|---|
| Calentamiento | 1A | ¿Qué queda en cada variable? | `LONG`, `IZQ`, `DER`, `SUBSTR`, `VAL`, `STR`, `\|\|` |
| Calentamiento | 1B | La función misterio | Traza, PARA con paso 2, funciones compuestas |
| Calentamiento | 2 | ¿FUNCION o SUBRUTINA? | Decidir según cuántos valores se devuelven |
| Nivel 1 | 3 | Buscar y reemplazar | Tope `LONG(FRA) - LONG(P) + 1`, MQ con salto variable |
| Nivel 1 | 4 | Anagramas | Una función que usa otra, bandera, lectura hasta 'FIN' |
| Nivel 2 | 5 | Cifrado César | `MOD` con desfase de base 1 |
| Nivel 2 | 6 | Cambio de base con cadenas | Composición `de_decimal(a_decimal(...))` |
| Nivel 3 | 7 | Números escondidos en una frase | Separar palabras, SUBRUTINA con 3 salidas, primos y perfectos |
| Nivel 3 | 8 | Un vector de palíndromos | Estilo parcial: vectores + módulos + SI en cascada |

## Sesión sugerida (~95 min)

1. Repaso relámpago de las funciones de cadena y FUNCION vs SUBRUTINA (5 min)
2. Calentamiento, ejercicios 1–2 (15 min)
3. Nivel 1, ejercicios 3–4 (25 min)
4. Nivel 2, ejercicios 5–6 (25 min)
5. Nivel 3, ejercicios 7–8; el 8 cronometrado a 20 min como simulacro (30 min)

## Errores que más puntos quitan

1. Recorrer hasta `LONG(FRA)` al buscar una palabra, en vez de `LONG(FRA) - LONG(P) + 1`.
2. Confundir el orden de la concatenación: `X || R` invierte, `R || X` copia igual.
3. Olvidar `nombre <-- resultado` al final de una FUNCION.
4. Sumar cadenas sin `VAL` o concatenar números sin `STR`.
5. Usar PARA cuando el índice avanza distinto en cada vuelta (eso es MQ).
6. Hacer una FUNCION que devuelve dos datos o un vector (eso es SUBRUTINA).
