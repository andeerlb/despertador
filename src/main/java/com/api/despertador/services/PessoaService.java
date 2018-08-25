package com.api.despertador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.despertador.models.Pessoa;
import com.api.despertador.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa save(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Optional<Pessoa> findById(Integer id) {
		return repository.findById(id);
	}
}
