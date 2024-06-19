package BackEndC3.ClinicaOdontologica.security;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.entity.Usuario;
import BackEndC3.ClinicaOdontologica.entity.UsuarioRole;
import BackEndC3.ClinicaOdontologica.repository.OdontologoRepository;
import BackEndC3.ClinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado=  passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("rene","user","user@user.com",passCifrado, UsuarioRole.ROLE_USER);
        Usuario admin= new Usuario("mathi","admin","admin@admin.com",passCifrado, UsuarioRole.ROLE_ADMIN);

        // Dato de odontologo hard-coded
        Odontologo odontologo= new Odontologo(420, "Mathi", "El Anestecista");
        usuarioRepository.save(usuario);
        usuarioRepository.save(admin);
        odontologoRepository.save(odontologo);
    }
}
