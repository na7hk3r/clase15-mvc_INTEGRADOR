package BackEndC3.ClinicaOdontologica.controller;
import BackEndC3.ClinicaOdontologica.entity.Paciente;
import BackEndC3.ClinicaOdontologica.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;


import BackEndC3.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    // relacion de asociacion con el servicio
    @Autowired
    private PacienteService pacienteService;

    @PutMapping
    public ResponseEntity<String>actualizarPaciente(
            @RequestBody Paciente paciente
    ) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(
                paciente.getId()
        );

        if (pacienteBuscado.isPresent()) {
            pacienteService.actualizarPaciente(paciente);

            return ResponseEntity.ok("Paciente actualizado");
        } else {
            return ResponseEntity.badRequest().body("Paciente no encontrado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorID(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @GetMapping("/busqueda/{email}")
    public ResponseEntity<Optional<Paciente>> buscarPorCorreo(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(pacienteService.buscarPorCorreo(email));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {

        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id)
            throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(id);

        if (pacienteBuscado.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No se pudo eliminar el paciente, debido a que no existe"
            );
        } else {
            pacienteService.eliminarPaciente(id);

            return ResponseEntity.ok("Se elmino con exito");
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(
            @RequestBody Paciente paciente
    ) {
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }
}