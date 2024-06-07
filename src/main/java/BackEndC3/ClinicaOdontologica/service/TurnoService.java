package BackEndC3.ClinicaOdontologica.service;

import BackEndC3.ClinicaOdontologica.entity.Turno;
import BackEndC3.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;
    public Turno guardarTurno(Turno turno){ return turnoRepository.save(turno); }
    public Optional<Turno> buscarPorId(Integer id){ return turnoRepository.findById(id); }
    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }
    public void actualizarTurno(Turno turno){ turnoRepository.save(turno); }
    public void eliminarTurno(Integer id){ turnoRepository.deleteById(id); }
}