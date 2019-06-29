package com.usernameisax.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usernameisax.crud.api.documents.Cliente;
import com.usernameisax.crud.api.responses.Response;
import com.usernameisax.crud.api.services.ClienteService;


@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteControllers {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
	return ResponseEntity.ok(this.clienteService.listarTodos());
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable(name = "id") String id){
			return ResponseEntity.ok(this.clienteService.listarPorId(id));
	}
	@PostMapping
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente,BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
		return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
	}
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(name= "id") String id,Cliente cliente){
		cliente.setId(id);
		return ResponseEntity.ok(this.clienteService.atualizar(cliente));
	}
	
	@DeleteMapping (path="/{id}")
	public ResponseEntity<Integer> remover(@PathVariable(name= "id") String id){
		this.clienteService.remover(id);
		return ResponseEntity.ok(1);
	}
}
