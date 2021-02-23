public class CuentaCorriente {
    private double saldo;
    private String numero;
    private String titular;

    public CuentaCorriente() {

    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
        this.numero = cuentaCorriente.getNumero();
        this.titular = cuentaCorriente.getTitular();

    }

    public CuentaCorriente(double saldo, String numero, String titular) {
        this.saldo = saldo;
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public boolean ingreso (double monto) {
        if (monto > 0) {
            System.out.println("Se pudo ingresar el monto con exito!");
            this.saldo += monto;
            return true;
        }
        System.out.println("No se pudo ingresar el monto");
        return false;
    }

    public boolean egreso (double monto) {
        if (this.saldo >= monto) {
            System.out.println("Se pudo egresar el monto con exito!");
            this.saldo -= monto;
            return true;
        }
        System.out.println("No se pudo egresar el monto");
        return false;
    }

    public boolean reintegro (double monto) {
        if (ingreso(monto)){
            System.out.println("Se pudo reintegrar el monto con exito!");
            return true;
        }
        System.out.println("No se pudo reintegrar el monto");
        return false;
    }

    public boolean transferencia(CuentaCorriente cuentaDestino, double monto) {
        if (this.saldo >= monto) {
            this.egreso(monto);
            cuentaDestino.ingreso(monto);
            System.out.println("Se pudo realizar la transferencia con exito!");
            return true;
        }

        System.out.println("No se pudo realizar la transferencia");
        return false;
    }

}
