package com.msys.cbt1.service;

import java.util.List;

import com.msys.cbt1.entities.Driver;
import com.msys.cbt1.exception.DriverNotFoundException;

public interface IDriverService {
	public List<Driver> displayAllDriver();

	public Driver viewDriver(int driverId) throws DriverNotFoundException;

	public List<Driver> viewBestDrivers() throws DriverNotFoundException;

	public List<Driver> insertDriver(Driver driver);

	public Driver updateDriver(Driver driver) throws DriverNotFoundException;

	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;

}