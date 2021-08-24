package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> 
{
	
	@Query(value="select * from transaction_list where txstatus = 'validation passed' or txstatus= 'screening passed' or txstatus='screening failed'", nativeQuery=true)
	List<Transaction> findValidationPassTransaction();
	
	@Query(value="select * from transaction_list where txstatus = 'validation failed'" , nativeQuery=true)
	List<Transaction> findValidationFailTransaction();
	
	@Query(value="select * from transaction_list where txstatus = 'screening passed'" , nativeQuery=true)
	List<Transaction> findScreeningpassTransaction();
	
	@Query(value="select * from transaction_list where txstatus = 'screening failed'" , nativeQuery=true)
	List<Transaction> findScreeningfailTransaction();
	
	List<Transaction> findAll();
	
}
