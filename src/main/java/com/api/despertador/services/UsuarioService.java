package com.api.despertador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.despertador.models.Usuario;
import com.api.despertador.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
