package com.usernameisax.crud.api.services.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usernameisax.crud.api.documents.Cliente;
import com.usernameisax.crud.api.repositories.ClieteRepository;
import com.usernameisax.crud.api.services.ClienteService;

@Service
public class ClienteServiceImple implements ClienteService {

	
	@Autowired
	private ClieteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		return this.clienteRepository.findOne(id);

	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	

	@Override
	public void remover(String id) {
		this.clienteRepository.delete(id);

	}

}
