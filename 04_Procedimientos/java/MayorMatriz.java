public class MayorMatriz {

    static int mayorMatriz(int[][] mat) {
        int may = mat[0][0];
        for (int[] fila : mat)
            for (int x : fila)
                if (x > may) may = x;
        return may;
    }

    // Subrutina: llena un vector (parametro de salida) con los pares.
    // Devuelve la cantidad K encontrada.
    static int paresMatriz(int[][] mat, int[] vec) {
        int k = 0;
        for (int[] fila : mat)
            for (int x : fila)
                if (x % 2 == 0) vec[k++] = x;
        return k;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Mayor: " + mayorMatriz(a));
        int[] pares = new int[a.length * a[0].length];
        int k = paresMatriz(a, pares);
        for (int i = 0; i < k; i++) System.out.print(pares[i] + " "); // 2 4 6
    }
}
