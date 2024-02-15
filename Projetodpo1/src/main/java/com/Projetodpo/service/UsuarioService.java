package com.Projetodpo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetodpo.dto.UsuarioDTO;
import com.Projetodpo.entities.Usuario;
import com.Projetodpo.repository.UsuarioRepository;

@Service
public class UsuarioService {


	@Autowired
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

	
	
	 public List<Usuario> getAllTarefa() {
	        return usuarioRepository.findAll();
	    }

	    public Usuario getUsuarioById(Long id) {
	        Optional<Usuario> usuario = usuarioRepository.findById(id);
	        return usuario.orElse(null);
	    }

	    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
	    	Usuario usuario = new Usuario(usuarioDTO.nome(), usuarioDTO.senha());
	    	Usuario salvarUsuario = usuarioRepository.save(usuario);
	        return new UsuarioDTO (salvarUsuario.getId(), salvarUsuario.getNome(), salvarUsuario.getSenha());
	    }

	    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
	    	Usuario existeUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
	    	existeUsuario.setNome(usuarioDTO.nome());
	    	existeUsuario.setSenha(usuarioDTO.senha());
	    	
	    	Usuario updateUsuario = usuarioRepository.save(existeUsuario);
	    	
	    	 return new UsuarioDTO (updateUsuario.getId(), updateUsuario.getNome(), updateUsuario.getSenha());
	        }
	       
	    

	    public boolean delete(Long id) {
	        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
	        if (existingUsuario.isPresent()) {
	        	usuarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	    
	    public List <Usuario> buscarTodos(){
	    return usuarioRepository.findAll();	
	    }
	    
	    public Usuario buscaPorId (Long id) {
	    	Optional <Usuario> usuario = usuarioRepository.findById(id);
	    	return usuario.orElse(null);
	    }

}
