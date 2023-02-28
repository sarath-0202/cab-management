package com.msys.cbt1.dao;

import java.util.List;

import com.msys.cbt1.entities.Cab;
import com.msys.cbt1.exception.CabNotFoundException;

public interface ICabDao {

	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;

	public int countCabsOfType(String carType) throws CabNotFoundException;
}