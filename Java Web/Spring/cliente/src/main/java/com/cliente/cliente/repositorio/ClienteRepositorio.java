package com.cliente.cliente.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cliente.cliente.modelo.ClienteModelo;

public interface ClienteRepositorio extends CrudRepository<ClienteModelo, Integer>{
	
	// Selecionar clientes (SELECT * FROM clientes)
	List<ClienteModelo> findAll();

	// Cadastrar clientes (INSERT INTO clientes (nome, idade) VALUES (?, ?))
	<CliModel extends ClienteModelo> CliModel save(ClienteModelo cliente);
	
	// Selecionar cliente através do código (SELECT * FROM clientes WHERE codigo = ?)
	ClienteModelo findByCodigo(int codigo);	

	// Deletar cliente (DELETE FROM clientes WHERE codigo = ?)
	void delete(ClienteModelo cliente);
	
}





