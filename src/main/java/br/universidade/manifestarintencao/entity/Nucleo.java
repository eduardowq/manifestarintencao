package br.universidade.manifestarintencao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Nucleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "nucleo")
    @JsonManagedReference
    private List<Disciplina> disciplinas;

    public Nucleo() {}

}
