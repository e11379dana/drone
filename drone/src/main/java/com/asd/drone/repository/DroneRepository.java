package com.asd.drone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asd.drone.entity.Drone;
import com.asd.drone.entity.State;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
	List<Drone> findBySerialNo(String serialNo);
	List<Drone> findByState(State state);
}
