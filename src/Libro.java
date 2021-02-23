public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean prestamo () {
        if (!this.prestado) {
            this.setPrestado(true);
            System.out.println("El libro se prestó con exito");
            return true;
        }

        System.out.println("El libro ya se encuentra prestado, no está disponible ahora");
        return false;
    }

    public boolean devolucion () {
        if (this.prestado) {
            this.setPrestado(false);
            System.out.println("El libro se devolvió con exito");
            return true;
        }

        System.out.println("El libro no se encuentra prestado, no se puede devolver");
        return false;
    }

    @Override
    public String toString() {
        return this.titulo + ", " + this.isbn + ", " + this.autor;
    }

    public static void main(String[] args) {
        System.out.println("Testeando libros...");
        Libro libro = new Libro("Juego de Tronos", "4523699", "George RR Martin");

        System.out.println("El titulo del libro es: " + libro.getTitulo());
        System.out.println("El autor del libro es: " + libro.getAutor());
        System.out.println("El isbn del libro es: " + libro.getIsbn());

        System.out.println("Prestando libro...");
        libro.prestamo();

        System.out.println("Si queremos prestar nuevamente el libro sin devolverlo, no es posible");
        libro.prestamo();

        System.out.println("Devolviendo libro...");
        libro.devolucion();

        System.out.println("Resultado del metodo toString(): " + libro.toString());
    }
}

