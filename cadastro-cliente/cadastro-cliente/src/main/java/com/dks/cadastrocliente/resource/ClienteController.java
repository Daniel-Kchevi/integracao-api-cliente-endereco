package com.dks.cadastrocliente.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dks.cadastrocliente.domain.Cliente;
import com.dks.cadastrocliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		clienteService.cadastrar(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar());
	}

}
