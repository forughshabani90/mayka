package com.mayka.task.Controller;

import com.mayka.task.model.Customer;
import com.mayka.task.repository.CustomRepository;
import com.mayka.task.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomControler {
    @Autowired
    CustomRepository customRepository;
    @Autowired
    CustomService customService;

    @GetMapping
    public List<Customer> get() {
        return customRepository.findAll();
    }
    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customRepository.save(customer);
    }
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        customRepository.deleteById(id);
    }
    @PutMapping
    public Customer update(@PathVariable("{id}") Long id,@RequestBody Customer customer){
        return customService.update(customer,id);
    }

}
