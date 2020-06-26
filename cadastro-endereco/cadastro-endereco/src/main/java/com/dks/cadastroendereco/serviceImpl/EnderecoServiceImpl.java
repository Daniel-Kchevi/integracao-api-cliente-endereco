package com.dks.cadastroendereco.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dks.cadastroendereco.domain.Endereco;
import com.dks.cadastroendereco.repository.EnderecoRepository;
import com.dks.cadastroendereco.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> listar() {
		return (List<Endereco>) enderecoRepository.findAll();
	}

	@Override
	public Endereco listarPorCep(String cep) {
		List<Endereco> enderecos = listar();
		Endereco enderecoEncontrado = new Endereco();
		
		for(Endereco endereco : enderecos) {
			if(endereco.getCep().replace("-", "").equals(cep)) {
				enderecoEncontrado = endereco;
				return enderecoEncontrado;
			}
		}
		return enderecoEncontrado;
	}


}
