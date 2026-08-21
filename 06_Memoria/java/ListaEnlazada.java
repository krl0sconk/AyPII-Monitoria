public class ListaEnlazada {

    static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int dato) { this.dato = dato; }
    }

    Nodo cabeza;

    void insertarInicio(int val) {
        Nodo nuevo = new Nodo(val);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    void insertarFinal(int val) {
        Nodo nuevo = new Nodo(val);
        if (cabeza == null) { cabeza = nuevo; return; }
        Nodo actual = cabeza;
        while (actual.siguiente != null) actual = actual.siguiente;
        actual.siguiente = nuevo;
    }

    void recorrer() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarFinal(1);
        lista.insertarFinal(2);
        lista.insertarInicio(0);
        lista.recorrer(); // 0 1 2
    }
}
