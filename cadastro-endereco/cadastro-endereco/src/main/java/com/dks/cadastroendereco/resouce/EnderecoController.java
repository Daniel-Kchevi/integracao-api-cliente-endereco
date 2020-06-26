package com.dks.cadastroendereco.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dks.cadastroendereco.domain.Endereco;
import com.dks.cadastroendereco.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco){
		enderecoService.salvar(endereco);
		return new ResponseEntity<>(endereco, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarEnderecos(){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listar());
	}
	
	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> listarEnderecoPorCep(@PathVariable("cep")String cep){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarPorCep(cep));
	}
}
