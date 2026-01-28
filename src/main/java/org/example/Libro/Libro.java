package org.example.Libro;

public class Libro {
    private static int cantidadLibros = 0;
    private static int librosDisponibles= 0;
    private static String LIBRO= "LIB";

    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;
    private Estudiante estudiantePrestado;
    private Editorial editorial;

    public Libro(String titulo, String autor,Editorial editorial) {
        ++cantidadLibros;
        librosDisponibles++;
        this.titulo = titulo;
        this.autor = autor;
        calcularId();
        this.disponible = true;
        estudiantePrestado = new Estudiante("");
        this.editorial = editorial;
        editorial.anyadirLibro(this);
    }

    public void calcularId(){
        this.id = LIBRO + cantidadLibros;
    }


    public Prestamo prestar(Estudiante estudiante){

        Prestamo prestamo = null;

        if (!estudiante.getListaLibro().contains(this) && disponible){
            System.out.println("El libro " + titulo + " ha sido prestado con exito a " + estudiante.getNombre());
            librosDisponibles--;
            disponible = false;
            estudiantePrestado = estudiante;
            estudiante.insertarLibro(this);
            prestamo = new Prestamo(this,estudiante);
            System.out.println("Prestamo relaizado con exito");
        }else if (estudiante.getListaLibro().contains(this)){
            System.out.println("El estudiamte " + estudiante.getNombre() + " ya tiene libro");
        }
        else{
            System.out.println("El libro ya ha sido prestado");
        }
        return prestamo;
    }

    public void devolver(){
        if (!disponible && estudiantePrestado.getListaLibro() == null){
            System.out.println("El libro " + titulo + " ha sido devuelto con exito");
            librosDisponibles++;
            disponible = true;
            estudiantePrestado.borrarLibro(null);
            estudiantePrestado = null;
        } else if (estudiantePrestado.getListaLibro() != null) {
            System.out.println("El estudiante " + estudiantePrestado.getNombre() + " ya tiene un libro prestado");
        } else{
            System.out.println("El libro no se puede devolver");
        }
    }

    public boolean estaDisponible(){
        return disponible;
    }

    public static int getTotalLibros(){
        return cantidadLibros;
    }

    public static int getLibrosDisponibles(){
        return  librosDisponibles;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Estudiante getEstudiantePrestado() {
        return estudiantePrestado;
    }

    public void setEstudiantePrestado(Estudiante estudiantePrestado) {
        this.estudiantePrestado = estudiantePrestado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id='" + id + '\'' +
                ", disponible=" + disponible +
                ", estudiante=" + estudiantePrestado+
                ", editorial=" + editorial+
                '}';
    }
}
