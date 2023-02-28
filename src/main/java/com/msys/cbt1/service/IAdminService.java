package com.msys.cbt1.service;

import java.time.LocalDateTime;
import java.util.List;

import com.msys.cbt1.entities.Admin;
import com.msys.cbt1.entities.TripBooking;
import com.msys.cbt1.exception.CustomerNotFoundException;

public interface IAdminService {
	public Admin insertAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public List<Admin> deleteAdmin(int adminId);

	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException;

	public List<TripBooking> getTripsCabwise();

	public List<TripBooking> getTripsCustomerwise();

	public List<TripBooking> getTripsDatewise();

	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException;

	public List<Admin> viewALlAdmin();

	public Admin getAdminById(int adminId);
}