public class Pila {
    private int[] datos;
    private int tope = -1;

    Pila(int capacidad) { datos = new int[capacidad]; }

    void apilar(int val) { datos[++tope] = val; }

    int desapilar() {
        if (esVacia()) throw new RuntimeException("Pila vacia");
        return datos[tope--];
    }

    boolean esVacia() { return tope == -1; }

    public static void main(String[] args) {
        Pila p = new Pila(5);
        p.apilar(1); p.apilar(2); p.apilar(3);
        while (!p.esVacia()) System.out.print(p.desapilar() + " "); // 3 2 1
    }
}
