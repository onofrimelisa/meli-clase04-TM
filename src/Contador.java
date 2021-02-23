public class Contador {
    private int contador = 0;

    public Contador(){}

    public Contador(int contador) {
        this.contador = contador;
    }

    public Contador(Contador contador){
        this.contador = contador.getContador();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public static void main(String[] args) {
        System.out.println("Testeando contadores...");
        Contador contador1 = new Contador();
        Contador contador2 = new Contador(10);
        Contador contador3 = new Contador(contador2);

        System.out.println("El valor del contador 1 es: " + contador1.getContador());
        System.out.println("El valor del contador 2 es: " + contador2.getContador());
        System.out.println("El valor del contador 3 es: " + contador3.getContador());
    }
}
