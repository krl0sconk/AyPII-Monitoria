public class Cola {
    private int[] datos;
    private int frente = 0, fin = 0, cantidad = 0;

    Cola(int capacidad) { datos = new int[capacidad]; }

    void encolar(int val) {
        datos[fin] = val;
        fin = (fin + 1) % datos.length;
        cantidad++;
    }

    int desencolar() {
        if (esVacia()) throw new RuntimeException("Cola vacia");
        int val = datos[frente];
        frente = (frente + 1) % datos.length; // circular
        cantidad--;
        return val;
    }

    boolean esVacia() { return cantidad == 0; }

    public static void main(String[] args) {
        Cola c = new Cola(5);
        c.encolar(1); c.encolar(2); c.encolar(3);
        while (!c.esVacia()) System.out.print(c.desencolar() + " "); // 1 2 3
    }
}
