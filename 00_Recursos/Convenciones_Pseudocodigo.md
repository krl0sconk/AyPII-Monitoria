# Convenciones de pseudocódigo — AyP II

Sintaxis basada en el Manual de Informática II (Jabba) y unificada para todo el repo.

## Asignación, lectura y escritura

    X <-- 5                 Asignación
    C <-- 'casa'             Cadena literal (comillas simples)
    LEA n                    Leer del teclado
    LEA Vec(i)                Leer en una posición del vector
    ESCRIBA "texto", x        Escribir en pantalla

## Bloques

    INICIO                          FUNCION Nombre(p1, p2)
       ...                             ...
    FIN                                nombre <-- resultado
                                    F_FUNCION

    SUBRUTINA Nombre(p1, p2)
       ...
    F_SUBRUTINA

- **Función**: devuelve un valor único (no arreglos). Se invoca sin la palabra EJECUTE.
- **Subrutina**: no retorna valor por su nombre; se invoca con EJECUTE nombre(parametros).

## Estructuras de control

    PARA I = 1, N, 1 HAGA ... F_PARA
    MQ (condicion) HAGA ... F_MQ
    SI (condicion) ENTONCES ... SINO ... F_SI

## Índices

Pseudocódigo: vectores y matrices en base 1 (V(1) es el primer elemento).
Java: arreglos en base 0 (V[0] es el primer elemento). Esta es la causa más común
de errores al traducir — recuérdalo en cada sesión.

## Operaciones sobre cadenas (nivel de algoritmo)

- LONG(cad), DER(cad,n), IZQ(cad,n), SUBSTR(cad,posini,n), VAL(cad), STR(n), concatenación con `||`
