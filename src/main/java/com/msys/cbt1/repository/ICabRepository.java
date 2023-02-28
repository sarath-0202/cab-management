package com.msys.cbt1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msys.cbt1.dao.ICabDao;
import com.msys.cbt1.entities.Cab;

public interface ICabRepository extends ICabDao, JpaRepository<Cab, Integer> {

}