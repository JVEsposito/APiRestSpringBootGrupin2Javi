package org.generation.apigrupo2.services;

import org.generation.apigrupo2.models.Comentario;
import org.generation.apigrupo2.models.Tarea;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listaDeComentarios();

    Comentario buscarComentarioPorId(Long id);
    Comentario guardarComentario(Comentario comentarioNuevo);
    void borrarComentario(Long id);
    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);
}
