package br.universidade.manifestarintencao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ManifestacaoInteresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Turma turma;

    private String turnoPreferido;

    private StatusManifestacao status;

    public ManifestacaoInteresse() {}

}
