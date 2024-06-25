package BackEndC3.ClinicaOdontologica.security;

import BackEndC3.ClinicaOdontologica.entity.*;
import BackEndC3.ClinicaOdontologica.repository.OdontologoRepository;
import BackEndC3.ClinicaOdontologica.repository.PacienteRepository;
import BackEndC3.ClinicaOdontologica.repository.TurnoRepository;
import BackEndC3.ClinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class DatosIniciales implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado=  passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("rene","user","user@user.com",passCifrado, UsuarioRole.ROLE_USER);
        Usuario admin= new Usuario("mathi","admin","admin@admin.com",passCifrado, UsuarioRole.ROLE_ADMIN);

        // Dato de odontologo, paciente  y turnos hard-coded
        Odontologo odontologo= new Odontologo("420","mathias", "el anestecista");
        Odontologo odontologo2= new Odontologo("421","rene", "el doktor");
        Paciente paciente= new Paciente ("Jorgito","Pereyra", "4564", "jorgito@gmail.com");
        Paciente paciente2= new Paciente ("German","el paciente", "464", "german@gmail.com");
        Turno turno = new Turno(paciente, odontologo, LocalDate.now());
        usuarioRepository.save(usuario);
        usuarioRepository.save(admin);
        odontologoRepository.save(odontologo);
        odontologoRepository.save(odontologo2);
        pacienteRepository.save(paciente);
        pacienteRepository.save(paciente2);
        turnoRepository.save(turno);
    }
}
