package br.universidade.manifestarintencao.repository;

import br.universidade.manifestarintencao.entity.ManifestacaoInteresse;
import br.universidade.manifestarintencao.entity.StatusManifestacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManifestacaoInteresseRepository 
       extends JpaRepository<ManifestacaoInteresse, Long> {

    boolean existsByDocenteIdAndTurmaId(Long docenteId, Long turmaId);

    List<ManifestacaoInteresse> findByDocenteId(Long docenteId);

    List<ManifestacaoInteresse> findByStatus(StatusManifestacao status);
}