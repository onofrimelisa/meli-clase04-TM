import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private Calendar calendar;

    public Fecha() {
        this.calendar = GregorianCalendar.getInstance();
        this.dia = calendar.get(Calendar.DATE);
        this.mes = calendar.get(Calendar.MONTH) + 1;
        this.anio = calendar.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anio) {
        this.calendar = new GregorianCalendar(dia, mes, anio);
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String toString() {
        return "Día "
                + this.dia
                + " del mes "
                + this.mes
                + " del año "
                + this.anio;
    }

    public void agregarDia(int cantidad) {
        this.calendar.add(Calendar.DAY_OF_MONTH, cantidad);
        this.dia = calendar.get(Calendar.DATE);
        this.mes = calendar.get(Calendar.MONTH) + 1;
        this.anio = calendar.get(Calendar.YEAR);
    }

    public static boolean esFechaCorrecta (Fecha fecha) {
        int dias = fecha.calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (fecha.dia <= dias && fecha.mes <= 12 && fecha.mes >= 0) {
            System.out.println("La fecha es correcta");
            return true;
        }

        System.out.println("La fecha no es correcta");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Testeando fechas...");

        Fecha fecha = new Fecha();
        System.out.println("La fecha de hoy es: " + fecha.toString());
        esFechaCorrecta(fecha);

        fecha.agregarDia(10);
        System.out.println("Le sumamos 10 dias a la fecha actual, y obtenemos: " + fecha.toString());
        esFechaCorrecta(fecha);

        System.out.println("");
        System.out.println("Creamos una fecha custom...");

        Fecha fecha2 = new Fecha(5, 8, 1998);
        System.out.println("La fecha custom es: " + fecha2.toString());
        esFechaCorrecta(fecha2);

        System.out.println("");
        System.out.println("Creamos una fecha custom incorrecta (con día 85 y mes 81)...");

        Fecha fecha3 = new Fecha(85, 18, 1998);
        System.out.println("La fecha custom es: " + fecha3.toString());
        esFechaCorrecta(fecha3);
    }
}
