package br.universidade.manifestarintencao.controller;

import br.universidade.manifestarintencao.entity.Disciplina;
import br.universidade.manifestarintencao.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "http://localhost:4200")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<Disciplina> salvar(@Valid @RequestBody Disciplina disciplina) {
        Disciplina saved = disciplinaService.salvarDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listar() {
        return ResponseEntity.ok(disciplinaService.listarTodasDisciplinas());
    }
}
