public class Contador {
    private int contador;

    public Contador(){
        this.contador = 0;
    }

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
}
