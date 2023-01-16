package com.asd.drone.service;

import java.util.List;

import com.asd.drone.dto.DroneDTO;
import com.asd.drone.entity.Drone;
import com.asd.drone.exception.ResourceNotFoundException;

public interface MedicalDroneService {
	Drone saveDrone(DroneDTO drone);

	Drone getDrone(Long id);

	Drone updateDrone(Drone drone, Long id);

	void deleteDroneById(Long id);
	
	Integer getBatteryLevel(String serialNo);
	
	void loadDrone(String serialNo, String code) throws ResourceNotFoundException;
	
	String getMedication(String serialNo);
	
	List<Drone> getAvailDrones();
}
