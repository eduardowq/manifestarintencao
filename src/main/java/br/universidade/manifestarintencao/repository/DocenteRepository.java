package br.universidade.manifestarintencao.repository;

import br.universidade.manifestarintencao.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
