package com.asd.drone.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.asd.drone.entity.Drone;
import com.asd.drone.repository.DroneRepository;

@Component
public class DroneScheduler {
	
	Logger logger = LoggerFactory.getLogger(DroneScheduler.class);
	
	@Autowired
	DroneRepository droneRepository;
	
	@Scheduled(fixedDelay = 36000)
	public void checkDroneBattery() {
		StringBuffer sb = new StringBuffer();
		List<Drone> drones = droneRepository.findAll();
		for(Drone drone : drones) {
			sb.append(System.lineSeparator());
			sb.append("Drone["+drone.getSerialNo()+"] : Battery Level " + drone.getBatteryCapacity());
		}
		logger.info(sb.toString());
	}

}
