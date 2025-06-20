package br.universidade.manifestarintencao.service;

import br.universidade.manifestarintencao.entity.Nucleo;
import br.universidade.manifestarintencao.repository.NucleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NucleoService {
    private final NucleoRepository nucleoRepository;

    public NucleoService(NucleoRepository nucleoRepository) {
        this.nucleoRepository = nucleoRepository;
    }

    public Nucleo salvarNucleo(Nucleo nucleo) {
        if (nucleo.getNome() == null || nucleo.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do núcleo é obrigatório");
        }
        return nucleoRepository.save(nucleo);
    }

    public List<Nucleo> listarTodosNucleos() {
        return nucleoRepository.findAll();
    }
}
