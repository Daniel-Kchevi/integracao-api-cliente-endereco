package com.dks.cadastrocliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dks.cadastrocliente.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
