package com.asd.drone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asd.drone.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	List<Delivery> findBySerialNo(String serialNo);
	List<Delivery> findByCode(String serialNo);
}
