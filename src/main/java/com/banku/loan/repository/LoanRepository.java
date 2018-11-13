package com.banku.loan.repository;

import com.banku.loan.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("loanRepository")
public interface LoanRepository extends JpaRepository<LoanEntity, Serializable> {

	public List<LoanEntity> findLoanEntitiesByAccountNumber(long accountNumber);

	public List<LoanEntity> findLoanEntityByDocumentClient(int documentClient);

	public LoanEntity findLoanEntityByLoanId(int loanId);

}
