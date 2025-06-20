package br.universidade.manifestarintencao.repository;

import br.universidade.manifestarintencao.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
