public class Insercion {

    // Insercion en una posicion (POS en base 1, como en pseudocodigo)
    static int insertarPosicion(int[] vec, int tam, int pos, int val) {
        for (int i = tam; i >= pos; i--)
            vec[i] = vec[i - 1]; // vec en base 0: desplaza
        vec[pos - 1] = val;
        return tam + 1;
    }

    // Insercion manteniendo el vector ordenado ascendentemente
    static int insertarOrdenado(int[] vec, int tam, int val) {
        int i = tam - 1;
        while (i >= 0 && vec[i] > val) {
            vec[i + 1] = vec[i];
            i--;
        }
        vec[i + 1] = val;
        return tam + 1;
    }

    public static void main(String[] args) {
        int[] v = new int[10];
        v[0]=2; v[1]=4; v[2]=7; v[3]=9;
        int tam = 4;
        tam = insertarOrdenado(v, tam, 5);
        for (int i = 0; i < tam; i++) System.out.print(v[i] + " "); // 2 4 5 7 9
    }
}
