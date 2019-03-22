package com.example.demo_boot.dao;

import com.example.demo_boot.persistence.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpExtendedRepo extends ExtendedRepository<Emp, Long> {
}
