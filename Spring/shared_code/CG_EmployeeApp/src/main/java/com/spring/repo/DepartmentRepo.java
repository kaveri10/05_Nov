package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long>{
}
