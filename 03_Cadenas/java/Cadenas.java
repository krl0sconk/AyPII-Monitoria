// Tabla de equivalencias pseudocodigo (Manual de Informatica II) <-> Java
//
//   LONG(cad)              -> cad.length()
//   DER(cad, n)             -> cad.substring(cad.length() - n)
//   IZQ(cad, n)              -> cad.substring(0, n)
//   SUBSTR(cad, posini, n)    -> cad.substring(posini - 1, posini - 1 + n)   (posini en base 1)
//   VAL(cad)                  -> Integer.parseInt(cad)
//   STR(n)                     -> String.valueOf(n)
//   A || B                      -> A + B
public class Cadenas {

    static String der(String cad, int n) {
        return cad.substring(cad.length() - n);
    }

    static String izq(String cad, int n) {
        return cad.substring(0, n);
    }

    // posini en base 1, igual que en el pseudocodigo del manual
    static String substr(String cad, int posini, int n) {
        return cad.substring(posini - 1, posini - 1 + n);
    }

    static String invertir(String cad) {
        return new StringBuilder(cad).reverse().toString();
    }

    static boolean esPalindromo(String cad) {
        String sinEspacios = cad.replace(" ", "");
        return sinEspacios.equals(invertir(sinEspacios));
    }

    static int contarVocales(String cad) {
        int cont = 0;
        for (char c : cad.toLowerCase().toCharArray())
            if ("aeiou".indexOf(c) >= 0) cont++;
        return cont;
    }

    public static void main(String[] args) {
        System.out.println(der("casa", 2));           // sa
        System.out.println(izq("casa", 2));            // ca
        System.out.println(substr("argentina", 3, 2));  // ge
        System.out.println(esPalindromo("anita lava la tina")); // true
        System.out.println(contarVocales("programacion"));      // 5
    }
}
