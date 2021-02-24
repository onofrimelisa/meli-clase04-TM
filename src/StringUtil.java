import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String str = "";

        for (int i = 0; i < n; i++) {
            str = str + c;
        }

        return str;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        int length = s.length();

        if(length < n) {
            int difference = n - length;
            s = replicate(c, difference) + s;
        }

        return s;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y seguida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "500"
    public static String rpad(String s,char c,int n) {
        int length = s.length();

        if(length < n) {
            int difference = n - length;
            s = s + replicate(c, difference);
        }

        return s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        int length = arr.length;
        String stringArray[] = new String[length];

        for (int i = 0; i < length; i++) {
            stringArray[i] = String.valueOf(arr[i]);
        }

        return stringArray;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como enteros
    public static int[] toIntArray(String arr[])
    {
        int length = arr.length;
        int intArray[] = new int[length];

        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.valueOf(arr[i]);
        }

        return intArray;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        List<String> strings = Arrays.asList(arr);
        String maxLength = strings.stream().max(Comparator.comparingInt(String::length)).get();

        return maxLength.length();
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }

    // Retorna una cadena idéntica a s pero sin espacios a la izquierda.
    public static String ltrim(String s) {
        String withoutLeftSpaces = new String(s);

        return withoutLeftSpaces.replaceAll("^\\s*", "");
    }

    // Retorna una cadena idéntica a s pero sin espacios a la derecha.
    public static String rtrim(String s) {
        String withoutRightSpaces = new String(s);

        return withoutRightSpaces.replaceAll("\\s*$", "");
    }

    // Retorna una cadena idéntica a s pero sin espacios ni a la derecha ni a la izquierda.
    public static String trim(String s) {
        String withoutSpaces = new String(s);

        return ltrim(rtrim(withoutSpaces));
    }

    // Retorna la posición de la n-ésima
    // ocurrencia del carácter c dentro de s, o -1 si s no contiene a c.
    public static int indexOfN(String s,char c,int n) {
        boolean found = false;
        int index = 0, count = 0, result = -1;
        s = s.toLowerCase(Locale.ROOT);

        while (!found && index < s.length()) {
            if (s.charAt(index) == c) {
                count ++;
                if (count == n) {
                    result = index;
                    found = true;
                }
            }
            index ++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Testing rpad method...");
        String newString = rpad("12", '0', 5);
        System.out.println("The rpad method transforms the string 12 into " + newString + " successfully");

        System.out.println("");
        System.out.println("Testing ltrim method...");
        String leftSpaces = "    LeftSpaces";
        String withoutLeftSpaces = ltrim(leftSpaces);
        System.out.println("The ltrim method transforms the string \"" + leftSpaces + "\" into \"" + withoutLeftSpaces + "\" successfully");

        System.out.println("");
        System.out.println("Testing rtrim method...");
        String rightSpaces = "RightSpaces    ";
        String withoutRightSpaces = rtrim(rightSpaces);
        System.out.println("The rtrim method transforms the string \"" + rightSpaces + "\" into \"" + withoutRightSpaces + "\" successfully");

        System.out.println("");
        System.out.println("Testing trim method...");
        String spaces = "     Spaces    ";
        String withoutSpaces = trim(spaces);
        System.out.println("The trim method transforms the string \"" + spaces + "\" into \"" + withoutSpaces + "\" successfully");

        System.out.println("");
        System.out.println("Testing indexOfN method...");
        String str = "MelisaOnofri";
        int indexOfN = indexOfN(str, 'o', 2);
        System.out.println("The indexOfN method returns the index " + indexOfN + " when searching for the char 'o' in the string " + str);
        int indexOfN2 = indexOfN(str, 'x', 2);
        System.out.println("The indexOfN method returns the index " + indexOfN2 + " when searching for the char 'x' in the string " + str);
    }
}
