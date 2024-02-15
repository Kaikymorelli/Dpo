package com.Projetodpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetodpo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
