package com.api.despertador.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.despertador.models.Pessoa;
import com.api.despertador.services.PessoaService;

@RestController
@RequestMapping("api/pessoa")
public class UsuarioController {

	@Autowired
	private PessoaService service;

	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) throws Exception {
		return ResponseEntity.ok(service.save(pessoa));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pessoa>> getOne(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
