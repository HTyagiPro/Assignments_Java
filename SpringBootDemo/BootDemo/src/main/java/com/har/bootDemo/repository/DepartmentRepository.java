package com.har.bootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.bootDemo.beans.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
