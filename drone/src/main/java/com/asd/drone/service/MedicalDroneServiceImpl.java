package com.asd.drone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asd.drone.dto.DroneDTO;
import com.asd.drone.entity.Delivery;
import com.asd.drone.entity.Drone;
import com.asd.drone.entity.Medication;
import com.asd.drone.entity.State;
import com.asd.drone.exception.DroneLoadingException;
import com.asd.drone.exception.ResourceNotFoundException;
import com.asd.drone.mapper.CommonMapper;
import com.asd.drone.repository.DeliveryRepository;
import com.asd.drone.repository.DroneRepository;
import com.asd.drone.repository.MedicationRepository;

@Service
public class MedicalDroneServiceImpl implements MedicalDroneService {
	
	final static int MINIMUM_BATTERY_CAPACITY = 25;

	@Autowired
	DroneRepository droneRepository;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	MedicationRepository medicationRepository;
	
	@Override
	public Drone saveDrone(DroneDTO droneDto) {
		Drone drone = CommonMapper.dtoToDbObj(droneDto);
		return droneRepository.save(drone);
	}
	
	public void loadDrone(String serialNo, String code) {
		List<Drone> drones = droneRepository.findBySerialNo(serialNo);
		List<Medication> medications = medicationRepository.findByCode(code);
		if(drones != null && drones.size() > 0) {
			if(medications != null && medications.size() > 0) {
				Medication med = medications.get(0);
				Drone drone = drones.get(0);
				if(med.getWeight() > drone.getWeightLimit()) {
					throw new DroneLoadingException("MEDICATION:code [" +code+"] weight is higher than DRONE:serialNo ["+serialNo+"]");
				} else if(drone.getBatteryCapacity() < MINIMUM_BATTERY_CAPACITY) { 
					throw new DroneLoadingException("DRONE:serialNo ["+serialNo+"] battery capacity is less than 25%");
				}else {
					if(State.IDLE.equals(drone.getState())) {
						drone.setState(State.LOADING);
						droneRepository.save(drone);
						Delivery delivery = new Delivery();
						delivery.setSerialNo(serialNo);
						delivery.setCode(code);
						deliveryRepository.save(delivery);
						drone.setState(State.LOADED);
						droneRepository.save(drone);
					}
				}
			} else {
				throw new ResourceNotFoundException("MEDICATION not found for Code : "+code);
			}
		} else {
			throw new ResourceNotFoundException("DRONE not found for Serial No : "+serialNo);
		}
	}
	
	public String getMedication(String serialNo) {
		Drone drone = droneRepository.findBySerialNo(serialNo).get(0);
		if(drone != null) {
			if(!State.IDLE.equals(drone.getState())) {
				Delivery del = deliveryRepository.findBySerialNo(serialNo).get(0);
				return medicationRepository.findByCode(del.getCode()).get(0).getName();
			} else {
				throw new ResourceNotFoundException("DRONE is not loaded with any MEDICATION");
			}
		} else {
			throw new ResourceNotFoundException("DRONE not found for Serial No : "+serialNo);
		}
	}
	
	public List<Drone> getAvailDrones() {
		List<Drone> drones = droneRepository.findByState(State.IDLE);
		if(drones != null && drones.size() > 0) {
			return drones;
		} else {
			throw new ResourceNotFoundException("There are no any available DRONES");
		}
	}

	@Override
	public Integer getBatteryLevel(String serialNo) {
		List<Drone> drones = droneRepository.findBySerialNo(serialNo);
		if(drones != null && drones.size() > 0) {
			return drones.get(0).getBatteryCapacity();
		} else {
			throw new ResourceNotFoundException("DRONE not found for Serial No : "+serialNo);
		}
	}
	
	@Override
	public Drone getDrone(Long id) {
		return droneRepository.findById(id).get();
	}

	@Override
	public Drone updateDrone(Drone drone, Long id) {
		return droneRepository.save(drone);
	}

	@Override
	public void deleteDroneById(Long id) {
		droneRepository.deleteById(id);
	}
}
