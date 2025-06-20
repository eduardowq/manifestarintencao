package br.universidade.manifestarintencao.controller;

import br.universidade.manifestarintencao.entity.Turma;
import br.universidade.manifestarintencao.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "http://localhost:4200")
public class TurmaController {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<Turma> salvar(@Valid @RequestBody Turma turma) {
        Turma saved = turmaService.salvarTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listar() {
        return ResponseEntity.ok(turmaService.listarTodasTurmas());
    }
}
