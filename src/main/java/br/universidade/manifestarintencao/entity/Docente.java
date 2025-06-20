package br.universidade.manifestarintencao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String siape;

}
