package org.generation.apigrupo2.services;

import jakarta.transaction.Transactional;
import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listaDeUsuario() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existeUsuario = usuarioRepository.existsById(id);
        if (existeUsuario){
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        }else {
            System.out.println("id invalido o inexistente");
            return null;
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {
        Usuario usuarioGuardado = usuarioRepository.save(usuarioNuevo);
        return usuarioGuardado;
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario UsuarioActualizado) {
        Boolean existeUsuario = usuarioRepository.existsById(id);
        if (existeUsuario) {
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            usuarioEscogido.setUsuarioNombre(UsuarioActualizado.getUsuarioNombre());
            usuarioEscogido.setUsuarioCorreo(UsuarioActualizado.getUsuarioCorreo());
            System.out.println("usuario actualizado");
            return usuarioRepository.save(usuarioEscogido);
        }else {
            System.out.println("el usuario no existe o es invalido");
            return null;
        }

    }

}
