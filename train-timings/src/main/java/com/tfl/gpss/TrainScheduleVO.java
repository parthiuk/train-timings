package com.tfl.gpss;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TrainScheduleVO {
	private String id;
	private int operationType;
	private String vehicleId;
	private String naptanId;
	private String stationName;
	private String lineId;
	private String lineName;
	private String platformName;
	private String direction;
	private String bearing;
	private String destinationNaptanId;
	private String destinationName;
	private String timestamp;
	private String timeToStation;
	private String currentLocation;
	private String towards;
	private Date expectedArrivalTime;
	private String timeToLive;
	private String modeName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOperationType() {
		return operationType;
	}
	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getNaptanId() {
		return naptanId;
	}
	public void setNaptanId(String naptanId) {
		this.naptanId = naptanId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getBearing() {
		return bearing;
	}
	public void setBearing(String bearing) {
		this.bearing = bearing;
	}
	public String getDestinationNaptanId() {
		return destinationNaptanId;
	}
	public void setDestinationNaptanId(String destinationNaptanId) {
		this.destinationNaptanId = destinationNaptanId;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName.replace("Underground Station", "");
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTimeToStation() {
		return timeToStation;
	}
	public void setTimeToStation(String timeToStation) {
		this.timeToStation = timeToStation;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getTowards() {
		return towards;
	}
	public void setTowards(String towards) {
		this.towards = towards;
	}
	public Date getExpectedArrivalTime() {
		return expectedArrivalTime;
	}
	public void setExpectedArrival(String expectedArrival) {
		
		String str = expectedArrival.replaceAll("T", "-").replaceAll("Z", "");
		LocalDateTime gmt = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss"));
		ZonedDateTime instant = ZonedDateTime.of(gmt, ZoneId.of("GMT"));
		LocalDateTime bst = instant.withZoneSameInstant(ZoneId.of("Europe/London")).toLocalDateTime();

		this.expectedArrivalTime = Date.from( bst.atZone( ZoneId.systemDefault()).toInstant());
	}
	public String getTimeToLive() {
		return timeToLive;
	}
	public void setTimeToLive(String timeToLive) {
		this.timeToLive = timeToLive;
	}
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	
}
