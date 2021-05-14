package com.cliente.cliente.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.cliente.modelo.ClienteModelo;
import com.cliente.cliente.repositorio.ClienteRepositorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClienteControle {
	
	// Referenciando o repositório
	@Autowired
	private ClienteRepositorio acao;
	
	//@RequestMapping(value="", method=RequestMethod.GET)
	@GetMapping(value="")
	public String helloWorld() {
		return "Hello World!";
	}
	
	
	@GetMapping(value="/clientes")
	public @ResponseBody List<ClienteModelo> selecionar(){
		return acao.findAll();
	}
	
	@PostMapping(value="/clientes")
	public @ResponseBody ClienteModelo cadastrar(@RequestBody ClienteModelo cliente) {
		return acao.save(cliente);
	}
	
	@GetMapping(value="/clientes/{codigo}")
	public @ResponseBody ClienteModelo procurar(@PathVariable int codigo) {
		return acao.findByCodigo(codigo);
	}
	
	@PutMapping(value="/clientes")
	public @ResponseBody ClienteModelo alterar(@RequestBody ClienteModelo cliente) {
		return acao.save(cliente);
	}
	
	@DeleteMapping(value="/clientes/{codigo}")
	public void remover(@PathVariable int codigo) {
		
		ClienteModelo cliente = acao.findByCodigo(codigo);
		
		acao.delete(cliente);
		
	}

}












