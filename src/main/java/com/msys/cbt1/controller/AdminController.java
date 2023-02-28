package com.msys.cbt1.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msys.cbt1.entities.Admin;
import com.msys.cbt1.entities.Customer;
import com.msys.cbt1.entities.TripBooking;
import com.msys.cbt1.exception.AdminNotFoundException;
import com.msys.cbt1.exception.CustomerNotFoundException;
import com.msys.cbt1.exception.InvalidUserOrPasswordException;
import com.msys.cbt1.service.IAdminService;
import com.msys.cbt1.service.ICustomerService;
import com.msys.cbt1.util.LoginService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	IAdminService ias;

	@Autowired
	LoginService ls;

	@Autowired
	ICustomerService cusService;

	/**
	 * validateAdmin
	 * 
	 * @param admin
	 * @return String
	 * @throws InvalidUserOrPasswordException
	 */
	@PostMapping("/login")
	public String validateAdmin(@RequestBody Admin admin) throws InvalidUserOrPasswordException {
		Integer adminId;
		JSONObject jsonObject = new JSONObject();
		try {
			adminId = ls.validateCredintials(admin);
			if (adminId != null) {
				jsonObject.put("status", "success");
				jsonObject.put("adminId", adminId);
			} else {
				jsonObject.put("status", "failure");
			}
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return jsonObject.toString();
	}

	/**
	 * viewAllAdmin
	 * 
	 * @return List<Admin>
	 */

	@GetMapping
	public List<Admin> viewALlAdmin() {
		return ias.viewALlAdmin();
	}

	/**
	 * insertAdmin
	 * 
	 * @param admin
	 * @return Admin
	 */

	@PostMapping
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}

	/**
	 * deleteAdmin
	 * 
	 * @param adminId
	 * @return List<Admin>
	 * @throws AdminNotFoundException
	 */

	@DeleteMapping("/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException {
		List<Admin> s = null;
		try {
			s = ias.deleteAdmin(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with given ID: " + adminId + " Not Found to Delete");
		}
		return s;

	}

	/**
	 * updateAdmin
	 * 
	 * @param admin
	 * @return Admin
	 * @throws AdminNotFoundException
	 */

	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(admin.getAdminId());
			ias.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin Not Found to Update");
		}
		return a;
	}

	/**
	 * GetAdminById
	 * 
	 * @param adminId
	 * @return Admin
	 * @throws AdminNotFoundException
	 */
	@GetMapping("/{adminId}")
	public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with ID: " + adminId + " not found!");
		}
		return a;
	}

	/**
	 * getAllTrips
	 * 
	 * @param customerId
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@SuppressWarnings("unused")
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {

		Customer c = null;
		List<TripBooking> t = null;
		try {
			c = cusService.viewCustomer(customerId);
			t = ias.getAllTrips(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Can not find trips of Customer ID: " + customerId);
		}
		return t;
	}

	/**
	 * getTripsCabwise(
	 * 
	 * @return List<TripBooking>
	 */

	@GetMapping("/cabwise")
	public List<TripBooking> getTripsCabwise() {
		return ias.getTripsCabwise();
	}

	/**
	 * getTripsCustomerwise
	 * 
	 * @return List<TripBooking>
	 */

	@GetMapping("/customerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return ias.getTripsCustomerwise();
	}

	/**
	 * getTripsDatewise
	 * 
	 * @return List<TripBooking>
	 */

	@GetMapping("/datewise")
	public List<TripBooking> getTripsDatewise() {
		return ias.getTripsDatewise();
	}

	/**
	 * getAllTripsForDays
	 * 
	 * @param customerId
	 * @param fromDate
	 * @param toDate
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			throws CustomerNotFoundException {
		return ias.getAllTripsForDays(customerId, fromDate, toDate);
	}

}