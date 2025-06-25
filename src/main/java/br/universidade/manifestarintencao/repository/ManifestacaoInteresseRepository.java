package br.universidade.manifestarintencao.repository;

import br.universidade.manifestarintencao.entity.ManifestacaoInteresse;
import br.universidade.manifestarintencao.entity.StatusManifestacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManifestacaoInteresseRepository 
       extends JpaRepository<ManifestacaoInteresse, Long> {

    boolean existsByDisciplinaIdAndTurmaId(Long disciplinaId, Long turmaId);

    List<ManifestacaoInteresse> findByDisciplinaId(Long disciplinaId);

    List<ManifestacaoInteresse> findByStatus(StatusManifestacao status);
}
