package BackEndC3.ClinicaOdontologica.controller;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.entity.Paciente;
import BackEndC3.ClinicaOdontologica.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import BackEndC3.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(
            @RequestBody Odontologo odontologo
    ) {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(
                odontologo.getId()
        );

        if (odontologoBuscado.isPresent()) {
            odontologoService.actualizarOdontologo(odontologo);

            return ResponseEntity.ok("Odontologo actualizado");
        } else {
            return ResponseEntity.badRequest().body("Odontologo no encontrado");
        }
    }

    @GetMapping("/buscarid/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarPaciente(@PathVariable Integer id) {
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @GetMapping("/busqueda/{matricula}")
    public ResponseEntity<Optional<Odontologo>> buscarPorMatricula(
            @PathVariable Integer matricula
    ) {
        return ResponseEntity.ok(odontologoService.buscarPorMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id)
            throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);

        if (odontologoBuscado.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No se pudo eliminar el odontologo, debido a que no existe"
            );
        } else {
            odontologoService.eliminarOdontologo(id);

            return ResponseEntity.ok("Se elmino con exito");
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(
            @RequestBody Odontologo odontologo
    ) {
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }
}
