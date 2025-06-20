package br.universidade.manifestarintencao.controller;

import br.universidade.manifestarintencao.entity.ManifestacaoInteresse;
import br.universidade.manifestarintencao.entity.StatusManifestacao;
import br.universidade.manifestarintencao.service.ManifestacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manifestacoes")
@CrossOrigin(origins = "http://localhost:4200")
public class ManifestacaoController {
    private final ManifestacaoService manifestacaoService;

    public ManifestacaoController(ManifestacaoService manifestacaoService) {
        this.manifestacaoService = manifestacaoService;
    }

    @PostMapping
    public ResponseEntity<ManifestacaoInteresse> manifestar(@Valid @RequestBody ManifestacaoInteresse manifestacao) {
        ManifestacaoInteresse saved = manifestacaoService.salvarManifestacao(manifestacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<ManifestacaoInteresse>> listar() {
        return ResponseEntity.ok(manifestacaoService.listarTodasManifestacoes());
    }

    @GetMapping("/docente/{docenteId}")
    public ResponseEntity<List<ManifestacaoInteresse>> listarPorDocente(@PathVariable Long docenteId) {
        return ResponseEntity.ok(manifestacaoService.listarPorDocente(docenteId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ManifestacaoInteresse> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusManifestacao status) {
        return ResponseEntity.ok(manifestacaoService.atualizarStatus(id, status));
    }
}
