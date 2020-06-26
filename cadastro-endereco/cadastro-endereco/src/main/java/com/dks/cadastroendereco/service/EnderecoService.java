package com.dks.cadastroendereco.service;

import java.util.List;

import com.dks.cadastroendereco.domain.Endereco;

public interface EnderecoService {
	
	Endereco salvar(Endereco endereco);
	
	List<Endereco> listar();
	
	Endereco listarPorCep(String cep);
}
