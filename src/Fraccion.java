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
        int sumaNumeradores = fraccion1.numerador + (numero * fraccion1.denominador);

        return new Fraccion(sumaNumeradores, fraccion1.denominador);
    }

    public static Fraccion restar (Fraccion fraccion1, Fraccion fraccion2) {
        int mcm = MCM(fraccion1.denominador, fraccion2.denominador);
        int division1 = mcm / fraccion1.denominador;
        int division2 = mcm / fraccion2.denominador;
        int multiplicacion1 = division1 * fraccion1.numerador;
        int multiplicacion2 = division2 * fraccion2.numerador;
        int restaMultiplicaciones = multiplicacion1 - multiplicacion2;

        return new Fraccion(restaMultiplicaciones, mcm);
    }

    public static Fraccion restar (Fraccion fraccion1, int numero) {
        int restaNumeradores = fraccion1.numerador - (numero * fraccion1.denominador);

        return new Fraccion(restaNumeradores, fraccion1.denominador);
    }

    public static Fraccion multiplicar (Fraccion fraccion1, Fraccion fraccion2) {
        int multiplicacionNumeradores = fraccion1.numerador * fraccion2.numerador;
        int multiplicacionDenominadores = fraccion1.denominador * fraccion2.denominador;

        return new Fraccion(multiplicacionNumeradores, multiplicacionDenominadores);
    }

    public static Fraccion multiplicar (Fraccion fraccion1, int entero) {
        int multiplicacionNumeradores = fraccion1.numerador * entero;

        return new Fraccion(multiplicacionNumeradores, fraccion1.denominador);
    }

    public static Fraccion dividir (Fraccion fraccion1, Fraccion fraccion2) {
        int multiplicacion1 = fraccion1.numerador * fraccion2.denominador;
        int multiplicacion2 = fraccion1.denominador * fraccion2.numerador;

        return new Fraccion(multiplicacion1, multiplicacion2);
    }

    public static Fraccion dividir (Fraccion fraccion1, int entero) {
        int multiplicacion = fraccion1.denominador * entero;

        return new Fraccion(fraccion1.numerador, multiplicacion);
    }

    public static void main(String[] args) {
        System.out.println("Testeando fracciones...");
        Fraccion fraccion1 = new Fraccion(5, 2);
        Fraccion fraccion2 = new Fraccion(7, 3);

        System.out.println("");

        System.out.println("Sumando dos fracciones...");

        System.out.println("Sumando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + fraccion2.getNumerador()
                + "/"
                + fraccion2.getDenominador());
        Fraccion resultadoSuma1 = Fraccion.sumar(fraccion1, fraccion2);
        System.out.println("Resultado: "
                + resultadoSuma1.getNumerador()
                + "/"
                + resultadoSuma1.getDenominador());

        System.out.println("Sumando una fraccion con un entero...");
        int entero = 73;

        System.out.println("Sumando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + entero);
        Fraccion resultadoSuma2 = Fraccion.sumar(fraccion1, entero);
        System.out.println("Resultado: "
                + resultadoSuma2.getNumerador()
                + "/"
                + resultadoSuma2.getDenominador());

        System.out.println("");

        System.out.println("Restando dos fracciones...");

        System.out.println("Restando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + fraccion2.getNumerador()
                + "/"
                + fraccion2.getDenominador());
        Fraccion resultadoResta1 = Fraccion.restar(fraccion1, fraccion2);
        System.out.println("Resultado: "
                + resultadoResta1.getNumerador()
                + "/"
                + resultadoResta1.getDenominador());

         System.out.println("Restando una fraccion con un entero...");

        System.out.println("Restando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + entero);
        Fraccion resultadoResta2 = Fraccion.restar(fraccion1, entero);
        System.out.println("Resultado: "
                + resultadoResta2.getNumerador()
                + "/"
                + resultadoResta2.getDenominador());

        System.out.println("");

        System.out.println("Multiplicando dos fracciones...");

        System.out.println("Multiplicando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + fraccion2.getNumerador()
                + "/"
                + fraccion2.getDenominador());
        Fraccion resultadoMultiplicacion1 = Fraccion.multiplicar(fraccion1, fraccion2);
        System.out.println("Resultado: "
                + resultadoMultiplicacion1.getNumerador()
                + "/"
                + resultadoMultiplicacion1.getDenominador());

        System.out.println("Multiplicando una fraccion con un entero...");

        System.out.println("Multiplicando "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + entero);
        Fraccion resultadoMultiplicacion2 = Fraccion.multiplicar(fraccion1, entero);
        System.out.println("Resultado: "
                + resultadoMultiplicacion2.getNumerador()
                + "/"
                + resultadoMultiplicacion2.getDenominador());

        System.out.println("");

        System.out.println("Dividiendo dos fracciones...");

        System.out.println("Dividiendo "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + fraccion2.getNumerador()
                + "/"
                + fraccion2.getDenominador());
        Fraccion resultadoDivision1 = Fraccion.dividir(fraccion1, fraccion2);
        System.out.println("Resultado: "
                + resultadoDivision1.getNumerador()
                + "/"
                + resultadoDivision1.getDenominador());

        System.out.println("Dividiendo una fraccion con un entero...");

        System.out.println("Dividiendo "
                + fraccion1.getNumerador()
                + "/"
                + fraccion1.getDenominador()
                + " con "
                + entero);
        Fraccion resultadoDivision2 = Fraccion.dividir(fraccion1, entero);
        System.out.println("Resultado: "
                + resultadoDivision2.getNumerador()
                + "/"
                + resultadoDivision2.getDenominador());
    }
}
