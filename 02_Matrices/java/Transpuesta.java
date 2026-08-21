public class Transpuesta {

    // No requiere matriz cuadrada: matt debe ser [M][N] si mat es [N][M]
    static int[][] transpuesta(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] matt = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matt[j][i] = mat[i][j];
        return matt;
    }

    // Solo valida para matriz cuadrada
    static void transpuestaEnSitio(int[][] mat) {
        int n = mat.length;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
    }

    static void imprimir(int[][] m) {
        for (int[] fila : m) {
            for (int x : fila) System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}}; // 2x3
        imprimir(transpuesta(a)); // 3x2: 1 4 / 2 5 / 3 6
    }
}
