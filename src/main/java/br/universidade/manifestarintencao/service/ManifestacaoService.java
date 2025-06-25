package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Disciplina;
import br.universidade.manifestarintencao.entity.ManifestacaoInteresse;
import br.universidade.manifestarintencao.entity.StatusManifestacao;
import br.universidade.manifestarintencao.entity.Turma;
import br.universidade.manifestarintencao.repository.DisciplinaRepository;
import br.universidade.manifestarintencao.repository.ManifestacaoInteresseRepository;
import br.universidade.manifestarintencao.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManifestacaoService {
    private final ManifestacaoInteresseRepository manifestacaoRepo;
    private final DisciplinaRepository disciplinaRepo;
    private final TurmaRepository turmaRepo;

    public ManifestacaoService(ManifestacaoInteresseRepository manifestacaoRepo,
                             DisciplinaRepository disciplinaRepo,
                             TurmaRepository turmaRepo) {
        this.manifestacaoRepo = manifestacaoRepo;
        this.disciplinaRepo = disciplinaRepo;
        this.turmaRepo = turmaRepo;
    }

    public ManifestacaoInteresse salvarManifestacao(ManifestacaoInteresse manifestacao) {
        if (manifestacao.getDisciplina() == null || manifestacao.getDisciplina().getId() == null) {
            throw new IllegalArgumentException("Disciplina é obrigatório");
        }
        if (manifestacao.getTurma() == null || manifestacao.getTurma().getId() == null) {
            throw new IllegalArgumentException("Turma é obrigatória");
        }
        if (manifestacao.getTurnoPreferido() == null || manifestacao.getTurnoPreferido().isEmpty()) {
            throw new IllegalArgumentException("Turno preferido é obrigatório");
        }

        Disciplina disciplina = disciplinaRepo.findById(manifestacao.getDisciplina().getId())
            .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado"));
        
        Turma turma = turmaRepo.findById(manifestacao.getTurma().getId())
            .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        boolean existeManifestacao = manifestacaoRepo.existsByDisciplinaIdAndTurmaId(
            disciplina.getId(), turma.getId());
        
        if (existeManifestacao) {
            throw new IllegalStateException("Já existe uma manifestação para este disciplina e turma");
        }

        manifestacao.setDisciplina(disciplina);
        manifestacao.setTurma(turma);//manifestacao.setStatus(StatusManifestacao.PENDENTE);

        return manifestacaoRepo.save(manifestacao);
    }

    public List<ManifestacaoInteresse> listarTodasManifestacoes() {
        return manifestacaoRepo.findAll();
    }

    public List<ManifestacaoInteresse> listarPorDisciplina(Long disciplinaId) {
        return manifestacaoRepo.findByDisciplinaId(disciplinaId);
    }

    public ManifestacaoInteresse atualizarStatus(Long id, StatusManifestacao status) {
        ManifestacaoInteresse manifestacao = manifestacaoRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Manifestação não encontrada"));
        
        manifestacao.setStatus(status);
        return manifestacaoRepo.save(manifestacao);
    }
}
