package BackEndC3.ClinicaOdontologica.controller;
import BackEndC3.ClinicaOdontologica.dao.PacienteDAOH2;
import BackEndC3.ClinicaOdontologica.model.Paciente;
import BackEndC3.ClinicaOdontologica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
=======
import java.util.List;

>>>>>>> 68f719ac0ad83308b92b10f60809a4dc53434eac
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;
    public PacienteController(){
        pacienteService = new PacienteService();
    }
<<<<<<< HEAD
=======
    //Métodos que actúan como intermediarios

  /*
    @GetMapping
    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email){
>>>>>>> 68f719ac0ad83308b92b10f60809a4dc53434eac

    @PostMapping //--> nos permite persistir los datos que vienen desde la vista
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
<<<<<<< HEAD
    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){

        Paciente pacienteBuscado= pacienteService.buscarPorID(paciente.getId());
        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "paciente actualizado con exito";
        }else{
            return "paciente no encontrado";
        }

    }
    @GetMapping("/{id}")
    public Paciente buscarPorPaciente(@PathVariable Integer id){
        return pacienteService.buscarPorID(id);
    }

=======
   */

   @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable Integer id){
        return pacienteService.buscarPorID(id);
    }

    @PostMapping //Permite persistir datos que vienen desde vista
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteBuscado= pacienteService.buscarPorID(paciente.getId());
        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "Paciente actualizado con exito";
        } else {
            return "Paciente no encontrado";
        }
    }

    @GetMapping("/all")
    public List<Paciente> listarTodos(){
        return pacienteService.buscarTodos();
    }


>>>>>>> 68f719ac0ad83308b92b10f60809a4dc53434eac
}
