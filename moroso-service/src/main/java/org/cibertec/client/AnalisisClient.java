package org.cibertec.client;

import java.util.List;

import org.cibertec.common_service.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "analisis-service", url="http://localhost:9080")
public interface AnalisisClient {
	@GetMapping("/analisis/{estado}")
	List<Cliente> getClientesPorEstado(@PathVariable String estado);

}
