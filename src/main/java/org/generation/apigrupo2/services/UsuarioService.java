package org.generation.apigrupo2.services;

import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.repositories.UsuarioRepository;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaDeUsuario();

    Usuario buscarUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuarioNuevo);

    void borrarUsuario(Long id);

    Usuario editarUsuarioPorId(Long id, Usuario UsuarioActualizado);


}
