package com.dks.cadastroendereco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dks.cadastroendereco.domain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
