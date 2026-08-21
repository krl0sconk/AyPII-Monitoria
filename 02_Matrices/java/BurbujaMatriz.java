public class BurbujaMatriz {

    static void burbujaMatriz(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = i; k < n; k++)
                    for (int p = 0; p < m; p++) {
                        if (k == i && p <= j) continue;
                        if (mat[i][j] > mat[k][p]) {
                            int t = mat[i][j]; mat[i][j] = mat[k][p]; mat[k][p] = t;
                        }
                    }
    }

    public static void main(String[] args) {
        int[][] a = {{5, 2}, {9, 1}};
        burbujaMatriz(a);
        for (int[] f : a) { for (int x : f) System.out.print(x + " "); }
        // 1 2 5 9
    }
}
