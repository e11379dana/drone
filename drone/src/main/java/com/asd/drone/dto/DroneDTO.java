package com.asd.drone.dto;

import com.asd.drone.entity.State;

public class DroneDTO {
	
	private Long id;
	private String serialNo;
	private String model;
	private double weightLimit;
	private int batteryCapacity;
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
