package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Disciplina;
import br.universidade.manifestarintencao.entity.Turma;
import br.universidade.manifestarintencao.repository.DisciplinaRepository;
import br.universidade.manifestarintencao.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final DisciplinaRepository disciplinaRepository;

    public TurmaService(TurmaRepository turmaRepository, DisciplinaRepository disciplinaRepository) {
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public Turma salvarTurma(Turma turma) {
        if (turma.getAno() <= 0) {
            throw new IllegalArgumentException("Ano da turma deve ser maior que zero");
        }
        if (turma.getSemestre() < 1 || turma.getSemestre() > 2) {
            throw new IllegalArgumentException("Semestre deve ser 1 ou 2");
        }
        if (turma.getDisciplina() == null || turma.getDisciplina().getId() == null) {
            throw new IllegalArgumentException("Disciplina da turma é obrigatória");
        }
        
        Disciplina disciplina = disciplinaRepository.findById(turma.getDisciplina().getId())
            .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));
        
        turma.setDisciplina(disciplina);
        return turmaRepository.save(turma);
    }

    public List<Turma> listarTodasTurmas() {
        return turmaRepository.findAll();
    }
}
