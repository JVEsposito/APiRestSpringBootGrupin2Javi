package org.generation.apigrupo2.controllers;

import org.generation.apigrupo2.models.Comentario;
import org.generation.apigrupo2.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {

    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping("/lista")
    public List<Comentario> listaComentarios() {
        List<Comentario> mostrarListaComentario = comentarioService.listaDeComentarios();
        return mostrarListaComentario;
    }

    @PostMapping("/guardar")
    public Comentario guardarcomentario(@RequestBody Comentario nuevoComentario) {
        Comentario comentarioGuardar = comentarioService.guardarComentario(nuevoComentario);
        return comentarioGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarComentarioPorId(@PathVariable Long id){
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id, @RequestBody Comentario comentarioActualizado){
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizado);
        return comentarioEditado;
    }

    @GetMapping("/buscar/{id}")
    public Comentario comentarioPorId(@PathVariable Long id){
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }

}
