package BackEndC3.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;

    public Odontologo(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Long id) {this.id = id;
    }

    public Odontologo() {
    }

    @Override
    public String toString() {
        return "Odontologo con: " +
                "id=" + id +
                ", matricula=" + matricula +
                ", nombre='" + nombre + apellido;
    }
}
