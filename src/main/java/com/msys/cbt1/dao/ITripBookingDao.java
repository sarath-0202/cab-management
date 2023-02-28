package com.msys.cbt1.dao;

import java.util.List;

import com.msys.cbt1.entities.TripBooking;

public interface ITripBookingDao {

	public List<TripBooking> viewAllTripsCustomer(int customerId);

	public float calculateBill(int customerId);

	public List<TripBooking> viewAllTripsById(int tripbookingId);
}
