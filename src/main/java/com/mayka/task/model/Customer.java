package com.mayka.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Customer {
    private String name;
    private int phone;
    private String email;
    private double balance;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
