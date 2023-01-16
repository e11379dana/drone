package com.asd.drone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asd.drone.entity.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
	List<Medication> findByCode(String serialNo);
}
