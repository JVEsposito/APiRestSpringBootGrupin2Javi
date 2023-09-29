package org.generation.apigrupo2.services;

import jakarta.transaction.Transactional;
import org.generation.apigrupo2.models.Tarea;
import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaServiceImpl implements TareaService {
    @Autowired
    TareaRepository tareaRepository;

    @Override
    public List<Tarea> listaDeTarea() {
        List<Tarea> listaTarea = tareaRepository.findAll();
        return listaTarea;
    }

    @Override
    public Tarea buscarTareaPorId(Long id) {
        Boolean existeTarea = tareaRepository.existsById(id);
        if (existeTarea){
            Tarea tareaEscogida = tareaRepository.findById(id).get();
            return tareaEscogida;
        } else {
            System.out.println("id invalido o inexistente");
            return null;
        }
    }

    @Override
    public Tarea guardarTarea(Tarea tareaNueva) {
        Tarea tareaGuardada = tareaRepository.save(tareaNueva);
        return tareaGuardada;
    }

    @Override
    public void borrarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existeTarea = tareaRepository.existsById(id);
        if (existeTarea){
            Tarea tareaEscogida = tareaRepository.findById(id).get();
            tareaEscogida.setTareaTitulo(tareaActualizada.getTareaTitulo());
            tareaEscogida.setTareaDescripcion(tareaActualizada.getTareaDescripcion());
            tareaEscogida.setTareaFecha(tareaActualizada.getTareaFecha());
            System.out.println("tarea actualizada");
            return tareaRepository.save(tareaEscogida);
        }else {
            System.out.println("tarea inexistente o invalida");
            return null;
        }
    }
}

