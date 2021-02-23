public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    private static int MCD (int numero1, int numero2) {
        int temporal;//Para no perder b
        while (numero2 != 0) {
            temporal = numero2;
            numero2 = numero1 % numero2;
            numero1 = temporal;
        }

        return numero1;
    }

    private static int MCM (int numero1, int numero2) {
        // MCM(a, b) = (a * b) / MCD(a, b)
        return (numero1 * numero2) / MCD(numero1, numero2);
    }

    public static Fraccion sumar (Fraccion fraccion1, Fraccion fraccion2) {
        int mcm = MCM(fraccion1.denominador, fraccion2.denominador);
        int division1 = mcm / fraccion1.denominador;
        int division2 = mcm / fraccion2.denominador;
        int multiplicacion1 = division1 * fraccion1.numerador;
        int multiplicacion2 = division2 * fraccion2.numerador;
        int sumaMultiplicaciones = multiplicacion1 + multiplicacion2;

        return new Fraccion(sumaMultiplicaciones, mcm);
    }

    public static Fraccion sumar (Fraccion fraccion1, int numero) {
        int sumaNumeradores = fraccion1.numerador + numero;

        return new Fraccion(sumaNumeradores, fraccion1.denominador);
    }

    public static void main(String[] args) {
        System.out.println("Testeando fracciones...");
        Fraccion fraccion1 = new Fraccion(5, 2);
        Fraccion fraccion2 = new Fraccion(7, 3);

        System.out.println("Sumando dos fracciones...");

        System.out.println("Sumando " + fraccion1.getNumerador() + "/" + fraccion1.getDenominador() + " con " + fraccion2.getNumerador() + "/" + fraccion2.getDenominador());
        Fraccion resultado = Fraccion.sumar(fraccion1, fraccion2);
        System.out.println("Resultado: " + resultado.getNumerador() + "/" + resultado.getDenominador());

        System.out.println("Sumando una fraccion con un entero...");
        int entero = 73;

        System.out.println("Sumando " + fraccion1.getNumerador() + "/" + fraccion1.getDenominador() + " con " + entero);
        Fraccion resultado2 = Fraccion.sumar(fraccion1, entero);
        System.out.println("Resultado: " + resultado2.getNumerador() + "/" + resultado2.getDenominador());
    }
}
