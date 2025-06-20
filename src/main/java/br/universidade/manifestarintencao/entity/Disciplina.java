package br.universidade.manifestarintencao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int cargaHoraria;

    @ManyToOne
    @JsonBackReference
    private Nucleo nucleo;

    @OneToMany(mappedBy = "disciplina")
    @JsonManagedReference
    private List<Turma> turmas;

    public Disciplina() {}

}
