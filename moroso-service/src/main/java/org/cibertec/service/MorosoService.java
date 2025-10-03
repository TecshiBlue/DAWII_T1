package org.cibertec.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.cibertec.client.AnalisisClient;
import org.cibertec.common_service.entity.Cliente;
import org.cibertec.common_service.entity.Moroso;
import org.cibertec.repository.MorosoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MorosoService {
	@Autowired
	private AnalisisClient analisisClient;
	
	@Autowired
	private MorosoRepository repository;
	
	@Autowired
	private MessageMorosoService messageMorosoService;
	
	public void generarMorososDesdeClientes() {
        List<Cliente> clientesMorosos = analisisClient.getClientesPorEstado("M");

        for (Cliente cliente : clientesMorosos) {
            Moroso moroso = new Moroso();
            moroso.setFechareporte(LocalDateTime.now());
            moroso.setIdcliente(cliente.getId());
            moroso.setMontoprestado(cliente.getMontoprestamo());

            repository.save(moroso);
        }
    }
	
	public List<Moroso> getMorosos() {
		return repository.findAll();
	}

}
