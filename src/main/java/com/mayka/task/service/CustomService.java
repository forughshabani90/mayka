package com.mayka.task.service;

import com.mayka.task.model.Customer;
import com.mayka.task.model.TransactionHistory;
import com.mayka.task.repository.CustomRepository;
import com.mayka.task.repository.TransactionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CustomService {
    CustomRepository customRepository;

    public Customer update(Customer customerRequest, Long id) {
        Customer customer;
        Optional<Customer> customerData = customRepository.findById(id).get();
        if (customerData.isPresent()) {
            customer = customerData.get();
        }
        else {
            return null;
        }
       if (customerRequest.getId()!=0 && customerRequest.getId() >0){
           customer.setId(customerRequest.getId());
       }
       if(customerRequest.getName()!=null){
           customer.setName(customerRequest.getName());
       }
       if (customerRequest.getPhone()!=0){
           customer.setPhone(customerRequest.getPhone());
       }
       if (customerRequest.getBalance()!=0 && customerRequest.getBalance()>0 ){
           customer.setBalance(customerRequest.getBalance());
       }
       if (customerRequest.getEmail()!=null){
           customer.setEmail(customerRequest.getEmail());
       }
    }
}
