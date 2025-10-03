package org.cibertec.controller;

import java.util.List;

import org.cibertec.common_service.entity.Cliente;
import org.cibertec.service.ClienteAnalisisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analisis")
public class AnalisisController {
	
	@Autowired
    private ClienteAnalisisService service;
	
	@GetMapping
    public List<Cliente> listarTodos() {
        return service.listarTodosClientes();
    }
	
	@GetMapping("/{estado}")
	public List<Cliente> getAnalisis(@PathVariable String estado) {
		return service.listarClientesMorosos(estado);
	}
	
	 @PostMapping
	    public Cliente guardarCliente(@RequestBody Cliente cliente) {
	        return service.guardarCliente(cliente);
	    }
}
