package com.dks.cadastrocliente.service;

import java.util.List;

import com.dks.cadastrocliente.domain.Cliente;

public interface ClienteService {

	Cliente cadastrar(Cliente cliente);
	
	List<Cliente> listar();
	
//	String buscaEndereco(String cpf);
}
