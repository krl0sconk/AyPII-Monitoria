public class RecursividadBasica {

    static long factorial(int n) {
        if (n == 0) return 1;               // caso base
        return n * factorial(n - 1);         // llamador mas pequeno
    }

    static long potencia(long x, int n) {
        if (n == 1) return x;
        return x * potencia(x, n - 1);
    }

    static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));   // 120
        System.out.println(potencia(2, 10)); // 1024
        System.out.println(fibonacci(10));    // 55
    }
}
