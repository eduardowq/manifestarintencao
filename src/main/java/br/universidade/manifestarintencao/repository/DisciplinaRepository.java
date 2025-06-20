package br.universidade.manifestarintencao.repository;

import br.universidade.manifestarintencao.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
