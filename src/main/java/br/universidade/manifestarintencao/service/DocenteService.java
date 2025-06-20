package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Docente;
import br.universidade.manifestarintencao.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {
    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public Docente salvarDocente(Docente docente) {
        if (docente.getNome() == null || docente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do docente é obrigatório");
        }
        if (docente.getSiape() == null || docente.getSiape().isEmpty()) {
            throw new IllegalArgumentException("SIAPE do docente é obrigatório");
        }
        return docenteRepository.save(docente);
    }

    public List<Docente> listarTodosDocentes() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> buscarPorId(Long id) {
        return docenteRepository.findById(id);
    }
}
