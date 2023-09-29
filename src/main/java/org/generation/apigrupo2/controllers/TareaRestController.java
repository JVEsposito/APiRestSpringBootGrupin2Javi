package org.generation.apigrupo2.controllers;

import org.generation.apigrupo2.models.Tarea;
import org.generation.apigrupo2.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {

    @Autowired
    TareaServiceImpl tareaService;

    @GetMapping("/lista")
    public List<Tarea> listaTareas() {
        List<Tarea> mostratListaTareas = tareaService.listaDeTarea();
        return mostratListaTareas;
    }

    @PostMapping("/guardar")
    public Tarea guardarTarea(@RequestBody Tarea nuevaTarea) {
        Tarea tareaGuardar = tareaService.guardarTarea(nuevaTarea);
        return tareaGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarTareaPorId(@PathVariable Long id){
        tareaService.borrarTarea(id);
        return "la tarea ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Tarea editarTareaPorId(@PathVariable Long id, @RequestBody Tarea tareaActualizado){
        Tarea tareaEditado = tareaService.editarTareaPorId(id, tareaActualizado);
        return tareaEditado;
    }

    @GetMapping("/buscar/{id}")
    public Tarea tareaPorId(@PathVariable Long id){
        Tarea tareaMostrar = tareaService.buscarTareaPorId(id);
        return tareaMostrar;
    }

}
