public class CuentaCorriente {
    private double saldo;
    private String numero;
    private String titular;

    public CuentaCorriente() {}

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

    public static void main(String[] args) {
        System.out.println("Testeando cuentas...");
        CuentaCorriente cuenta1 = new CuentaCorriente();
        CuentaCorriente cuenta2 = new CuentaCorriente(70.50,"4875 2546 258", "Melisa Onofri");
        CuentaCorriente cuenta3 = new CuentaCorriente(cuenta2);

        System.out.println("Cuentas 1, 2 y 3 creadas.");
        if (cuenta2.getTitular() == cuenta3.getTitular()) {
            System.out.println("Los titulares de las cuentas 2 y 3 coinciden: " + cuenta2.getTitular());
        }
        if (cuenta2.getSaldo() == cuenta3.getSaldo()) {
            System.out.println("Los saldos de las cuentas 2 y 3 coinciden: " + cuenta2.getSaldo());
        }
        if (cuenta2.getNumero() == cuenta3.getNumero()) {
            System.out.println("Los numeros de las cuentas 2 y 3 coinciden: " + cuenta2.getNumero());
        }

        cuenta1.setTitular("Gabriela Lemos");
        System.out.println("El titular de la cuenta 1 es: " + cuenta1.getTitular());

        System.out.println("Ingresando $89.50 a la cuenta1");
        cuenta1.ingreso(89.50);
        System.out.println("El saldo de la cuenta1 luego de ingresar $89.50 es: " + cuenta1.getSaldo());

        System.out.println("Egresando $89.50 de la cuenta1");
        cuenta1.egreso(89.50);
        System.out.println("El saldo de la cuenta1 luego de egresar $89.50 es: " + cuenta1.getSaldo());

        System.out.println("Reintegrando $89.50 a la cuenta1");
        cuenta1.reintegro(89.50);
        System.out.println("El saldo de la cuenta1 luego de reintegrar $89.50 es: " + cuenta1.getSaldo());

        System.out.println("Realizando transferencia desde cuenta 1 a cuenta 2 de $89.50");
        cuenta1.transferencia(cuenta2, 89.50);
        System.out.println("El saldo de la cuenta1 luego de realizar transferencia es: " + cuenta1.getSaldo());
        System.out.println("El saldo de la cuenta2 luego de recibir transferencia es: " + cuenta2.getSaldo());
    }

}
