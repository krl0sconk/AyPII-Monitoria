import java.util.Scanner;

public class Ejercicio2doCorte {

    static Scanner leer = new Scanner(System.in);

    // ===================== LECTURA / ESCRITURA =====================

    static void LeerMatriz(int n, int m, int[][] M) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + i + "][" + j + "] = ");
                M[i][j] = leer.nextInt();
            }
        }
    }

    static void ImprimirMatriz(int n, int m, int[][] M) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void LeerVector(int n, int[] V) {
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] = ");
            V[i] = leer.nextInt();
        }
    }

    static void ImprimirVector(int n, int[] V) {
        for (int i = 0; i < n; i++) {
            System.out.print(V[i] + "\t");
        }
        System.out.println();
    }

    // ===================== FUNCIONES (retornan UN valor) =====================

    // Primo: exactamente dos divisores. 0, 1 y negativos no son primos.
    static boolean esPrimo(int x) {
        if (x < 2) return false;
        for (int d = 2; d * d <= x; d++) {
            if (x % d == 0) return false;
        }
        return true;
    }

    // Suma de divisores PROPIOS: de 1 hasta x-1
    static int sumaDivisores(int x) {
        int s = 0;
        for (int d = 1; d < x; d++) {
            if (x % d == 0) s += d;
        }
        return s;
    }

    static boolean esPerfecto(int x) {
        return x > 0 && sumaDivisores(x) == x;
    }

    static int SumaDiagPrincipal(int n, int[][] A) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += A[i][i];
        }
        return s;
    }

    // En base 0 la secundaria es A[i][n-1-i]  (en pseudocódigo: N - I + 1)
    static int SumaDiagSecundaria(int n, int[][] A) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += A[i][n - 1 - i];
        }
        return s;
    }

    // ===================== PUNTO 1: W = A x V =====================

    // W debe tener na elementos. Solo se puede si ma == n
    static boolean MultiplicarMatrizVector(int na, int ma, int[][] A,
                                           int n, int[] V, int[] W) {
        if (ma != n) return false;
        for (int i = 0; i < na; i++) {
            W[i] = 0;
            for (int j = 0; j < ma; j++) {
                W[i] += A[i][j] * V[j];
            }
        }
        return true;
    }

    // ===================== PUNTO 2: vector de primos =====================

    // Llena P con los primos de A y retorna cuántos quedaron (k).
    // P debe tener capacidad na*ma (el peor caso: todos primos).
    static int ConstruirPrimos(int na, int ma, int[][] A, int[] P) {
        int k = 0;
        for (int i = 0; i < na; i++) {
            for (int j = 0; j < ma; j++) {
                if (esPrimo(A[i][j])) {
                    P[k] = A[i][j];
                    k++;
                }
            }
        }
        return k;
    }

    static void Burbuja(int n, int[] V) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (V[j] > V[j + 1]) {
                    int aux = V[j];
                    V[j] = V[j + 1];
                    V[j + 1] = aux;
                }
            }
        }
    }

    // ===================== PUNTO 3: matriz cuadrada =====================

    // Triangular superior = por ENCIMA de la diagonal principal (j > i)
    static void ReemplazarTriangularSuperior(int n, int[][] A) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                A[i][j] = sumaDivisores(A[i][j]);
            }
        }
    }

    // T = A^T  (A es n x m, T queda m x n)
    static void Transpuesta(int n, int m, int[][] A, int[][] T) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                T[j][i] = A[i][j];
            }
        }
    }

    // R = X + Y, con validación de tamaños
    static boolean Sumar(int n1, int m1, int[][] X,
                         int n2, int m2, int[][] Y, int[][] R) {
        if (n1 != n2 || m1 != m2) return false;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                R[i][j] = X[i][j] + Y[i][j];
            }
        }
        return true;
    }

    // ===================== PUNTO 4: eliminar perfectos de V =====================

    // Eliminación física con corrimiento. Retorna el nuevo tamaño.
    // Se usa while y no for: al correr, el siguiente elemento cae en la
    // posición i, así que i solo avanza cuando NO se elimina.
    static int EliminarPerfectos(int n, int[] V) {
        int i = 0;
        while (i < n) {
            if (esPerfecto(V[i])) {
                for (int k = i; k < n - 1; k++) {
                    V[k] = V[k + 1];
                }
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    // ===================== PROGRAMA PRINCIPAL =====================

    public static void main(String[] args) {
        // ---- Lectura de A ----
        System.out.print("Filas de A (nA): ");
        int nA = leer.nextInt();
        System.out.print("Columnas de A (mA): ");
        int mA = leer.nextInt();
        int[][] A = new int[nA][mA];
        System.out.println("Datos de A:");
        LeerMatriz(nA, mA, A);

        // ---- Lectura de V ----
        System.out.print("Tamaño de V (n): ");
        int n = leer.nextInt();
        int[] V = new int[n];
        System.out.println("Datos de V:");
        LeerVector(n, V);

        // ---- 1. W = A x V ----
        System.out.println("\n1) W = A x V:");
        int[] W = new int[nA];
        if (MultiplicarMatrizVector(nA, mA, A, n, V, W)) {
            ImprimirVector(nA, W);
        } else {
            System.out.println("No se puede: columnas de A (" + mA
                    + ") != tamaño de V (" + n + ")");
        }

        // ---- 2. Vector de primos ordenado ----
        System.out.println("\n2) Primos de A ordenados:");
        int[] P = new int[nA * mA];
        int k = ConstruirPrimos(nA, mA, A, P);
        if (k == 0) {
            System.out.println("La matriz no tiene números primos");
        } else {
            Burbuja(k, P);
            ImprimirVector(k, P);
            System.out.println("Cantidad de primos: " + k);
        }

        // ---- 3. Solo si A es cuadrada ----
        System.out.println("\n3)");
        if (nA != mA) {
            System.out.println("A no es cuadrada: no tiene diagonales");
        } else {
            int sp = SumaDiagPrincipal(nA, A);
            int ss = SumaDiagSecundaria(nA, A);
            System.out.println("Suma diagonal principal: " + sp);
            System.out.println("Suma diagonal secundaria: " + ss);

            if (sp > ss) {
                System.out.println("Principal > secundaria: se reemplaza la triangular superior");
                ReemplazarTriangularSuperior(nA, A);
                ImprimirMatriz(nA, mA, A);
            } else {
                System.out.println("Principal <= secundaria: A + A^T");
                int[][] T = new int[mA][nA];
                Transpuesta(nA, mA, A, T);
                int[][] R = new int[nA][mA];
                if (Sumar(nA, mA, A, mA, nA, T, R)) {
                    ImprimirMatriz(nA, mA, R);
                }
            }
        }

        // ---- 4. Eliminar perfectos de V ----
        System.out.println("\n4) V sin números perfectos:");
        n = EliminarPerfectos(n, V);
        if (n == 0) {
            System.out.println("V quedó vacío");
        } else {
            ImprimirVector(n, V);
        }
    }
}
