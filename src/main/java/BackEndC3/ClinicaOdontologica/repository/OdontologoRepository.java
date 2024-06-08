package BackEndC3.ClinicaOdontologica.repository;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
    Optional<Odontologo> findByMatricula(Integer matricula);
}
