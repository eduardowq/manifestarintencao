package br.universidade.manifestarintencao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ano;
    private int semestre;

    @ManyToOne
    @JsonBackReference
    private Disciplina disciplina;

    public Turma() {}

}
