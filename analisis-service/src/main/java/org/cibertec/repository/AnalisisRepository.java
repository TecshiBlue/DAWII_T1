package org.cibertec.repository;

import java.util.List;

import org.cibertec.common_service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnalisisRepository extends JpaRepository<Cliente, Integer>{
	
	List<Cliente> findByEstado(String estado);
	

}
