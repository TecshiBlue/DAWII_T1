package org.cibertec.service;

import org.cibertec.common_service.entity.Moroso;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class MessageMorosoService {
	
	@Value("${app.queue.name}")
	private String queueName;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(Moroso objMoroso) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			
			String message = mapper.writeValueAsString(objMoroso);
			
			rabbitTemplate.convertAndSend("", queueName, message);
			System.out.println("Mensaje enviado: " + message);
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.err.println("Problemas al enviar el mensaje");
			}
			
	}
}
