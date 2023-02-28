package com.msys.cbt1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msys.cbt1.dao.IAdminDao;
import com.msys.cbt1.entities.Admin;

@Repository("aDao")
public interface IAdminRepository extends IAdminDao, JpaRepository<Admin, Integer> {

}