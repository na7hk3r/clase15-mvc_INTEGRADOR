package BackEndC3.ClinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Odontologo {
    private Integer id;
    private Integer nroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(Integer id, Integer nroMatricula, String nombre, String apellido) {
        this.id = id;
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Integer nroMatricula, String nombre, String apellido) {
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo con: " +
                "id=" + id +
                ", nroMatricula=" + nroMatricula +
                ", nombre='" + nombre + apellido;
    }
}
