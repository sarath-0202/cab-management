package com.msys.cbt1.service;

import java.util.List;

import com.msys.cbt1.entities.TripBooking;

public interface ITripBookingService {

	public TripBooking insertTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public List<TripBooking> deleteTripBooking(TripBooking tripBooking);

	public List<TripBooking> viewAllTripsCustomer(int customerId);

	public float calculateBill(int customerId);

	public List<TripBooking> viewAllTripsById(int tripbookingId);
}