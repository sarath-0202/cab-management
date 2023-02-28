package com.msys.cbt1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msys.cbt1.dao.ICustomerDao;
import com.msys.cbt1.entities.Customer;

@Repository("cDao")
public interface ICustomerRepository extends ICustomerDao, JpaRepository<Customer, Integer> {

}