package org.generation.apigrupo2.services;

import jakarta.transaction.Transactional;
import org.generation.apigrupo2.models.Comentario;
import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    ComentarioRepository comentarioRepository;
    @Override
    public  List<Comentario> listaDeComentarios(){
        List<Comentario> listaComentarios = comentarioRepository.findAll();
        return listaComentarios;
    }
    @Override
    public Comentario buscarComentarioPorId(Long id){
        Boolean existeComentario = comentarioRepository.existsById(id);
        if (existeComentario){
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            return comentarioEscogido;
        }else {
            System.out.println("comentario invalido o inexistente");
            return null;
        }
    }
    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo){
        Comentario comentarioGuardado = comentarioRepository.save(comentarioNuevo);
        return comentarioGuardado;
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existeComentario = comentarioRepository.existsById(id);
        if (existeComentario){
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            comentarioEscogido.setComentarioTexto(comentarioActualizado.getComentarioTexto());
            comentarioEscogido.setComentarioFecha(comentarioActualizado.getComentarioFecha());
            System.out.println("comentario actualizado");
            return comentarioRepository.save(comentarioEscogido);
        }else {
            System.out.println("comentario inexistente o invalido");
            return null;

        }
    }

}


