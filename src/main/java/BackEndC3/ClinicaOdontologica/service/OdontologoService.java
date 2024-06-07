package BackEndC3.ClinicaOdontologica.service;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    public Odontologo guardar(Odontologo odontologo){ return odontologoRepository.save(odontologo); }
    public Optional<Odontologo> buscarPorId(Integer id) { return odontologoRepository.findById(id); }
    public List<Odontologo> buscarTodos(){ return odontologoRepository.findAll(); }
    public void actualizarOdontologo(Odontologo odontologo){ odontologoRepository.save(odontologo); }
    public void eliminarOdontologo(Integer id){ odontologoRepository.deleteById(id); }
}
