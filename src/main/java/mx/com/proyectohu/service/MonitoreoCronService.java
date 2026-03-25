package mx.com.proyectohu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.TareaCronRepository;



@Service
public class MonitoreoCronService {
	
	@Autowired
	public TareaCronRepository monitoreoRepository;
	
	@Scheduled(cron= "${cron.monitoreo.configuracion}")
	public void ejetarSP() {
		
		monitoreoRepository.ejecutarSP();
		
	}

}
