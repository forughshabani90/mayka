package com.mayka.task.Controller;

import com.mayka.task.model.TransactionHistory;
import com.mayka.task.repository.TransactionalRepository;
import com.mayka.task.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactional")
public class TransactionControler {
    @Autowired
    TransactionalRepository transactionalRepository;
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<TransactionHistory> get() {
        return transactionalRepository.findAll();
    }

    @PostMapping
    public TransactionHistory save(@RequestBody TransactionHistory transactionHistory) {
        return transactionalRepository.save(transactionHistory);
    }

    @DeleteMapping
    public void delet(@PathVariable("id") Long id) {
        transactionalRepository.deleteById(id);
    }

    @PutMapping
    public TransactionHistory update(@PathVariable("id") Long id, TransactionHistory transactionHistory) {
        return transactionService.update(transactionHistory, id);
    }
}
