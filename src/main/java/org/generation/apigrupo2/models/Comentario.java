package org.generation.apigrupo2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentario_id;

    @Column(name = "comentario")
    private String comentarioTexto;

    @Column(name = "fecha creado")
    @DateTimeFormat
    private Date comentarioFecha;


    @ManyToOne
    @JoinColumn(name = "tarea_id", nullable = false)
    private Tarea tarea;
}
