package br.universidade.manifestarintencao.controller;

import br.universidade.manifestarintencao.entity.Nucleo;
import br.universidade.manifestarintencao.service.NucleoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nucleos")
@CrossOrigin(origins = "http://localhost:4200")
public class NucleoController {
    private final NucleoService nucleoService;

    public NucleoController(NucleoService nucleoService) {
        this.nucleoService = nucleoService;
    }

    @PostMapping
    public ResponseEntity<Nucleo> salvar(@Valid @RequestBody Nucleo nucleo) {
        Nucleo saved = nucleoService.salvarNucleo(nucleo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Nucleo>> listar() {
        return ResponseEntity.ok(nucleoService.listarTodosNucleos());
    }
}
