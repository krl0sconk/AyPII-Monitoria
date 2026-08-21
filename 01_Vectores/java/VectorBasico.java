public class VectorBasico {

    static void leaVector(int[] vec) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        for (int i = 0; i < vec.length; i++) {
            System.out.print("Posicion " + (i + 1) + ": ");
            vec[i] = sc.nextInt();
        }
    }

    static void escribaVector(int[] vec) {
        for (int v : vec) System.out.print(v + " ");
        System.out.println();
    }

    static int mayor(int[] vec) {
        int may = vec[0];
        for (int i = 1; i < vec.length; i++)
            if (vec[i] > may) may = vec[i];
        return may;
    }

    public static void main(String[] args) {
        int[] v = {5, 2, 9, 1, 7};
        escribaVector(v);
        System.out.println("Mayor: " + mayor(v));
    }
}
