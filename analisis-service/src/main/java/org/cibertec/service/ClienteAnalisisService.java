package org.cibertec.service;

import java.util.List;

import org.cibertec.common_service.entity.Cliente;
import org.cibertec.repository.AnalisisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteAnalisisService {
	
	@Autowired
	private AnalisisRepository repository;
	
	public List<Cliente> listarTodosClientes(){
		return repository.findAll();
	}
	
	
	public List<Cliente> listarClientesMorosos(String estado){
		return repository.findByEstado("M");
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return repository.save(cliente);
	}
	

}
