public class Burbuja {

    static void burbujaAscendente(int[] vec) {
        int n = vec.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1 - i; j++)
                if (vec[j] > vec[j + 1]) {
                    int t = vec[j]; vec[j] = vec[j + 1]; vec[j + 1] = t;
                }
    }

    static void burbujaOptimizada(int[] vec) {
        int n = vec.length;
        boolean hayCambio = true;
        int i = 0;
        while (i < n - 1 && hayCambio) {
            hayCambio = false;
            for (int j = 0; j < n - 1 - i; j++)
                if (vec[j] > vec[j + 1]) {
                    int t = vec[j]; vec[j] = vec[j + 1]; vec[j + 1] = t;
                    hayCambio = true;
                }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] v = {5, 2, 9, 1, 7, 3};
        burbujaAscendente(v);
        for (int x : v) System.out.print(x + " "); // 1 2 3 5 7 9
    }
}
