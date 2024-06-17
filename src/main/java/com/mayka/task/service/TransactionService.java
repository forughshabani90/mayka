package com.mayka.task.service;

import com.mayka.task.model.TransactionHistory;
import com.mayka.task.repository.TransactionalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    TransactionalRepository transactionalRepository;

    public TransactionHistory update(TransactionHistory transactRequest, Long id) {
        TransactionHistory transact;
        Optional<TransactionHistory> transactData = transactionalRepository.findById(id);
        if (transactData.isPresent()) {
            transact = transactData.get();
        } else {
            return null;
        }
        if (transactRequest.getDate() != null) {
            transact.setDate(transactRequest.getDate());
        }
        if (transactRequest.getCustomerId() != 0 && transactRequest.getCustomerId() > 0) {
            transact.setCustomerId(transactRequest.getCustomerId());
        }
        if (transactRequest.getDeposit() != 0 && transactRequest.getDeposit() != 0) {
            transact.setDeposit(transactRequest.getDeposit());
        }
        if (transactRequest.getWithDrawal() != null) {
            transact.setWithDrawal(transactRequest.getWithDrawal());
        }
        return transactionalRepository.save(transact);
    }
}
