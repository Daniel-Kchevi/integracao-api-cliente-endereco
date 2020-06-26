package com.dks.cadastrocliente.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dks.cadastrocliente.domain.Cliente;
import com.dks.cadastrocliente.domain.Endereco;
import com.dks.cadastrocliente.repository.ClienteRepository;
import com.dks.cadastrocliente.service.ClienteService;

import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private WebClient webCliente;

//	https://viacep.com.br/ws/05102090/json
	
	@Override
	public Cliente cadastrar(Cliente cliente) {		
		Endereco endereco = buscaEndereco(cliente.getCep());
		
		cliente.setLogradouro(endereco.getLogradouro());
		cliente.setBairro(endereco.getBairro());
		cliente.setLocalidade(endereco.getLocalidade());
		cliente.setUf(endereco.getUf());
		
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listar() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	private Endereco buscaEndereco(String cep) {
		Mono<Endereco> monoEndCep = this.webCliente
				.method(HttpMethod.GET)
				.uri("/{codigo}/json", cep)
				.retrieve()
				.bodyToMono(Endereco.class);
		Endereco returnCep = monoEndCep.block();
		return returnCep;
	}

}
