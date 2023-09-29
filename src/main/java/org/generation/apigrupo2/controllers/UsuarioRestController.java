package org.generation.apigrupo2.controllers;

import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.services.UsuarioService;
import org.generation.apigrupo2.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaUsuario(){
        List<Usuario> mostrarLista = usuarioService.listaDeUsuario();
        return mostrarLista;
    }
    @PostMapping("/guardar")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo){
        Usuario usuarioGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarUsuarioPorId(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "el estudiante ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        return usuarioEditado;
    }

    @GetMapping("/buscar/{id}")
    public Usuario usuarioPorId(@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }


}
