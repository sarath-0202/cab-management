package com.msys.cbt1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msys.cbt1.dao.ITripBookingDao;
import com.msys.cbt1.entities.TripBooking;

@Repository("tbDao")
public interface ITripBookingRepository extends ITripBookingDao, JpaRepository<TripBooking, Integer> {

}