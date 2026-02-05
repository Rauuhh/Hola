package org.example.Practica1;

public class Empleado {

    private static String IDE = "EP";
    private static String TRABAJODEFECTO = "PTE";
    private int numero = 0;
    private  String Id;
    private String nombre;
    private String cargo;
    private Empleado director;

    public Empleado(String nombre, String cargo, Empleado director) {
        this.Id = IDE + numero++;
        this.nombre = nombre;
        this.cargo = setCargo(cargo);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String setCargo(String cargo) {
        if (cargo.equalsIgnoreCase("tecnico") || cargo.equalsIgnoreCase("presentador") || cargo.equalsIgnoreCase("colaborador")){
            return cargo;
        }else{
            return TRABAJODEFECTO;
        }
    }

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numero=" + numero +
                ", Id='" + Id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
