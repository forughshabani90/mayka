package com.mayka.task.repository;

import com.mayka.task.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends JpaRepository<Customer,Long> {
}
