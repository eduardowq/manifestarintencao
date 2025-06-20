package br.universidade.manifestarintencao.controller;

import br.universidade.manifestarintencao.entity.Docente;
import br.universidade.manifestarintencao.service.DocenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docentes")
@CrossOrigin(origins = "http://localhost:4200")
public class DocenteController {
    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public ResponseEntity<Docente> salvar(@Valid @RequestBody Docente docente) {
        Docente saved = docenteService.salvarDocente(docente);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Docente>> listar() {
        return ResponseEntity.ok(docenteService.listarTodosDocentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> buscarPorId(@PathVariable Long id) {
        return docenteService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
