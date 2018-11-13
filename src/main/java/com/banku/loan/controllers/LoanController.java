package com.banku.loan.controllers;

import com.banku.loan.entities.LoanEntity;
import com.banku.loan.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	@Qualifier("loanService")
	private LoanService loanService;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody LoanEntity loanEntity) {
		ResponseEntity<Object> responseEntity = loanService.createLoan(loanEntity);
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> update(@RequestBody LoanEntity loanEntity) {
		ResponseEntity<Object> responseEntity = loanService.updateLoan(loanEntity);
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findAll() {
		ResponseEntity<Object> responseEntity = loanService.findAllLoans();
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findByAccount")
	public ResponseEntity<Object> findByAccount(@RequestParam long accountNumber) {
		ResponseEntity<Object> responseEntity = loanService.findByAccount(accountNumber);
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/findByDocument")
	public ResponseEntity<Object> findByDocument(@RequestParam int documentClient) {
		ResponseEntity<Object> responseEntity = loanService.findByDocument(documentClient);

		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/findByLoanId")
	public ResponseEntity<Object> findLoanEntityByLoanId(@RequestParam int loanId) {
		ResponseEntity<Object> responseEntity = loanService.findLoanEntityByLoanId(loanId);

		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}



}
