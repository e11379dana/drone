package com.asd.drone.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asd.drone.dto.DroneDTO;
import com.asd.drone.entity.Drone;
import com.asd.drone.service.MedicalDroneService;

@RestController
public class DroneController {
	
	Logger logger = LoggerFactory.getLogger(DroneController.class);

	@Autowired
	MedicalDroneService medicalDroneService;

	@PostMapping("/regDrone")
	public String registerDrone(@RequestBody DroneDTO drone) {
		Drone d = medicalDroneService.saveDrone(drone);
		return d.getSerialNo();
	}
	
	@PostMapping("/loadDrone")
	public void loadDrone(@RequestBody Map<String, String> request) {
		String serialNo = request.get("serialNo");
		String code = request.get("code");
		medicalDroneService.loadDrone(serialNo, code);
	}
	
	@PostMapping("/getMedication")
	public String getMedication(@RequestBody Map<String, String> request) {
		String serialNo = request.get("serialNo");
		String medName = medicalDroneService.getMedication(serialNo);
		return medName;
	}
	
	@PostMapping("/getAvailDrones")
	public ResponseEntity<List<Drone>> getAvailDrones() {
		List<Drone> drones = medicalDroneService.getAvailDrones();
		return new ResponseEntity<List<Drone>>(drones, HttpStatus.OK);
	}
	
	@PostMapping("/getBatteryLevel")
	public Integer getBatteryLevel(@RequestBody Map<String, String> request) {
		String serialNo = request.get("serialNo");
		return medicalDroneService.getBatteryLevel(serialNo);
	}

}
