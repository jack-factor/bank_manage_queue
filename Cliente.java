package TF;

public class Cliente {

    int dni;
    String nombre;
    String apellido;
    String tipoAtencion;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoAtencion = null;
    }


    public Cliente(int dni, String nombre, String apellido, String tipoAtencion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoAtencion = tipoAtencion;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    @Override
    public String toString() {
        return "dni=" + dni +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                ", tipoAtencion=" + tipoAtencion;
    }

    public String toStringFull() {
        return "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoAtencion='" + tipoAtencion;
    }
}
