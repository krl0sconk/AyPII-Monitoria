import java.util.Scanner;

// Menu interactivo para usar en vivo durante la monitoria.
public class CadenasInteractivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menu de cadenas ---");
            System.out.println("1) Palindromo");
            System.out.println("2) Contar vocales");
            System.out.println("3) Invertir");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion != 0) {
                System.out.print("Escriba una cadena: ");
                String cad = sc.nextLine();
                switch (opcion) {
                    case 1 -> System.out.println(Cadenas.esPalindromo(cad) ? "Es palindromo" : "No es palindromo");
                    case 2 -> System.out.println("Vocales: " + Cadenas.contarVocales(cad));
                    case 3 -> System.out.println("Invertida: " + Cadenas.invertir(cad));
                }
            }
        } while (opcion != 0);
    }
}
