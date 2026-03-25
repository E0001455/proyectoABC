package mx.com.proyectohu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.TareaCronRepository;



@Service
public class TareaCronService {
	
	@Autowired
	public TareaCronRepository monitoreoRepository;
	
	@Scheduled(cron= "${cron.tarea.configuracion}")
	public void ejecutarSP() {
		
		monitoreoRepository.ejecutarSP();
		
	}

}
