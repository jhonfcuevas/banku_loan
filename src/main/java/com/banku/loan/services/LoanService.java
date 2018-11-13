package com.banku.loan.services;

import com.banku.loan.entities.LoanEntity;
import com.banku.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loanService")
public class LoanService {

    @Autowired
    @Qualifier("loanRepository")
    private LoanRepository loanRepository;

    public ResponseEntity<Object> createLoan(LoanEntity loanEntity) {
        try {
            loanEntity.setLoanId(0);
            LoanEntity loanEntity2 = loanRepository.save(loanEntity);

            return new ResponseEntity<>(loanEntity2, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> updateLoan(LoanEntity loanEntity) {
        try {
            LoanEntity loanEntity2 = loanRepository.findLoanEntityByLoanId(loanEntity.getLoanId());

            if (loanEntity2 != null) {
                loanEntity.setLoanId(loanEntity2.getLoanId());
                LoanEntity loanEntity3 = loanRepository.save(loanEntity);
                return new ResponseEntity<>(loanEntity3, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findAllLoans() {
        try {
            List<LoanEntity> loanEntities = loanRepository.findAll();
            return new ResponseEntity<>(loanEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findByAccount(long accountNumber) {
        try {
            List<LoanEntity> loanEntitys = loanRepository.findLoanEntitiesByAccountNumber(accountNumber);
            return new ResponseEntity<>(loanEntitys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findByDocument(int documentClient) {
        try {
            List<LoanEntity> loanEntitys = loanRepository.findLoanEntityByDocumentClient(documentClient);
            return new ResponseEntity<>(loanEntitys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Object> findLoanEntityByLoanId(int loanId) {
        try {
            LoanEntity loanEntity = loanRepository.findLoanEntityByLoanId(loanId);
            return new ResponseEntity<>(loanEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
