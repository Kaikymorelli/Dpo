package com.Projetodpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetodpo.dto.UsuarioDTO;
import com.Projetodpo.entities.Usuario;
import com.Projetodpo.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "usuario", description = "API REST DE GERECIAMENTO DE USUARIO")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	@PostMapping

	public ResponseEntity<UsuarioDTO> update(@RequestBody @Valid UsuarioDTO usuarioDTO){

	UsuarioDTO salvarUsuario = usuarioService.salvar(usuarioDTO);

	return ResponseEntity.status(HttpStatus.CREATED).body(salvarUsuario);

	}


	@PutMapping("/{id}")

	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){

	UsuarioDTO updateUsuarioDTO = usuarioService.update(id, usuarioDTO);

	if(updateUsuarioDTO != null) {

	return ResponseEntity.ok(updateUsuarioDTO);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@DeleteMapping ("/{id}")

	public ResponseEntity<Usuario> delete (@PathVariable Long id) {

	boolean delete = usuarioService.delete(id);

	if (delete) {

	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@GetMapping("/{id}")

	public ResponseEntity<Usuario> buscarPorId (@PathVariable Long id){

	Usuario usuario = usuarioService.buscaPorId(id);

	if(usuario != null) {

	return ResponseEntity.ok(usuario);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}
	@GetMapping

	public ResponseEntity<List<Usuario>> buscaTodos() {

	List <Usuario> usuario = usuarioService.buscarTodos();

	return ResponseEntity.ok(usuario);

	}



}