package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Disciplina;
import br.universidade.manifestarintencao.entity.Nucleo;
import br.universidade.manifestarintencao.repository.DisciplinaRepository;
import br.universidade.manifestarintencao.repository.NucleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;
    private final NucleoRepository nucleoRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository, NucleoRepository nucleoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.nucleoRepository = nucleoRepository;
    }

    public Disciplina salvarDisciplina(Disciplina disciplina) {
        if (disciplina.getNome() == null || disciplina.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da disciplina é obrigatório");
        }
        if (disciplina.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }
        if (disciplina.getNucleo() == null || disciplina.getNucleo().getId() == null) {
            throw new IllegalArgumentException("Núcleo da disciplina é obrigatório");
        }
        
        Nucleo nucleo = nucleoRepository.findById(disciplina.getNucleo().getId())
            .orElseThrow(() -> new IllegalArgumentException("Núcleo não encontrado"));
        
        disciplina.setNucleo(nucleo);
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarTodasDisciplinas() {
        return disciplinaRepository.findAll();
    }
}
