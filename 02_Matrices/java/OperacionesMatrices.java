public class OperacionesMatrices {

    static int[][] sumaResta(int[][] a, int[][] b, int signo) {
        int n = a.length, m = a[0].length;
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                c[i][j] = a[i][j] + signo * b[i][j];
        return c;
    }

    // a es N x M, b es M x N -> resultado N x N
    static int[][] multiplicar(int[][] a, int[][] b) {
        int n = a.length, m = a[0].length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int acum = 0;
                for (int k = 0; k < m; k++) acum += a[i][k] * b[k][j];
                c[i][j] = acum;
            }
        return c;
    }
}
