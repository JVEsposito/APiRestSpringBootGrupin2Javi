package org.generation.apigrupo2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarea_id;

    @Column(name = "titulo")
    private String tareaTitulo;

    @Column(name = "descripcion")
    private String tareaDescripcion;

    @Column(name = "fecha de vencimiento")
    @DateTimeFormat
    private Date tareaFecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> comentariosTarea;
}
