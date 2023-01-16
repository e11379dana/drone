package com.asd.drone.mapper;

import com.asd.drone.dto.DroneDTO;
import com.asd.drone.entity.Drone;

public class CommonMapper {

	public static Drone dtoToDbObj(DroneDTO droneDto) {
		Drone drone = new Drone();
		drone.setBatteryCapacity(droneDto.getBatteryCapacity());
		drone.setModel(droneDto.getModel());
		drone.setSerialNo(droneDto.getSerialNo());
		drone.setState(droneDto.getState());
		drone.setWeightLimit(droneDto.getWeightLimit());
		return drone;
	}
	
}
