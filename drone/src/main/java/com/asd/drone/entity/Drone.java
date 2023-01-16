package com.asd.drone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="DRONE")
@Entity
public class Drone {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SERIAL_NO")
	private String serialNo;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="WEIGHT_LIMIT")
	private double weightLimit;
	
	@Column(name="BATTERY_CAPACITY")
	private int batteryCapacity;
	
	@Column(name="STATE")
	@Enumerated(EnumType.STRING)
	private State state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getWeightLimit() {
		return weightLimit;
	}
	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
