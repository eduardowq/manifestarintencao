package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Docente;
import br.universidade.manifestarintencao.entity.ManifestacaoInteresse;
import br.universidade.manifestarintencao.entity.StatusManifestacao;
import br.universidade.manifestarintencao.entity.Turma;
import br.universidade.manifestarintencao.repository.DocenteRepository;
import br.universidade.manifestarintencao.repository.ManifestacaoInteresseRepository;
import br.universidade.manifestarintencao.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManifestacaoService {
    private final ManifestacaoInteresseRepository manifestacaoRepo;
    private final DocenteRepository docenteRepo;
    private final TurmaRepository turmaRepo;

    public ManifestacaoService(ManifestacaoInteresseRepository manifestacaoRepo,
                             DocenteRepository docenteRepo,
                             TurmaRepository turmaRepo) {
        this.manifestacaoRepo = manifestacaoRepo;
        this.docenteRepo = docenteRepo;
        this.turmaRepo = turmaRepo;
    }

    public ManifestacaoInteresse salvarManifestacao(ManifestacaoInteresse manifestacao) {
        if (manifestacao.getDocente() == null || manifestacao.getDocente().getId() == null) {
            throw new IllegalArgumentException("Docente é obrigatório");
        }
        if (manifestacao.getTurma() == null || manifestacao.getTurma().getId() == null) {
            throw new IllegalArgumentException("Turma é obrigatória");
        }
        if (manifestacao.getTurnoPreferido() == null || manifestacao.getTurnoPreferido().isEmpty()) {
            throw new IllegalArgumentException("Turno preferido é obrigatório");
        }

        Docente docente = docenteRepo.findById(manifestacao.getDocente().getId())
            .orElseThrow(() -> new IllegalArgumentException("Docente não encontrado"));
        
        Turma turma = turmaRepo.findById(manifestacao.getTurma().getId())
            .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        boolean existeManifestacao = manifestacaoRepo.existsByDocenteIdAndTurmaId(
            docente.getId(), turma.getId());
        
        if (existeManifestacao) {
            throw new IllegalStateException("Já existe uma manifestação para este docente e turma");
        }

        manifestacao.setDocente(docente);
        manifestacao.setTurma(turma);
        //manifestacao.setStatus(StatusManifestacao.PENDENTE);

        return manifestacaoRepo.save(manifestacao);
    }

    public List<ManifestacaoInteresse> listarTodasManifestacoes() {
        return manifestacaoRepo.findAll();
    }

    public List<ManifestacaoInteresse> listarPorDocente(Long docenteId) {
        return manifestacaoRepo.findByDocenteId(docenteId);
    }

    public ManifestacaoInteresse atualizarStatus(Long id, StatusManifestacao status) {
        ManifestacaoInteresse manifestacao = manifestacaoRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Manifestação não encontrada"));
        
        manifestacao.setStatus(status);
        return manifestacaoRepo.save(manifestacao);
    }
}
