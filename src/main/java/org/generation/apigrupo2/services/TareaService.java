package org.generation.apigrupo2.services;

import org.generation.apigrupo2.models.Tarea;
import org.generation.apigrupo2.models.Usuario;

import java.util.List;

public interface TareaService {

    List<Tarea> listaDeTarea();

    Tarea buscarTareaPorId(Long id);
    Tarea guardarTarea(Tarea tareaNueva);
    void borrarTarea(Long id);
    Tarea editarTareaPorId(Long id, Tarea tareaActualizada);

}