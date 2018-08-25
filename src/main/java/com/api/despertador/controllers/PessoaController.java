package com.api.despertador.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.despertador.models.Pessoa;
import com.api.despertador.services.PessoaService;

@RestController
@RequestMapping("api/usuario")
@Secured("ROLE_ADMIN")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) throws Exception {
		return ResponseEntity.ok(service.save(pessoa));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pessoa>> getOne(@PathVariable Integer id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("anderson");
		return ResponseEntity.ok(Optional.of(pessoa));
		// return ResponseEntity.ok(Optional.of(service.findById(id)).get());
	}
}
