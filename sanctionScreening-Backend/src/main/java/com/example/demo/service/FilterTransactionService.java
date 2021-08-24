package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
@Transactional
public class FilterTransactionService 
{
	@Autowired
	private TransactionRepository transactionRepository;
	public List<Transaction> FilterTransaction(String status)
	{
		if(status.equals("validation pass"))
		{
			return transactionRepository.findValidationPassTransaction();
		}
		if(status.equals("validation fail"))
		{
			return transactionRepository.findValidationFailTransaction();
		}
		if(status.equals("screen pass"))
		{
			return transactionRepository.findScreeningpassTransaction();
		}
		if(status.equals("screen fail"))
		{
			return transactionRepository.findScreeningfailTransaction();
		}
		if(status.equals("all"))
		{
			List<Transaction> list=transactionRepository.findAll();
			for(Transaction l:list)
			{
				System.out.println(l.getPayer_name());
				System.out.println(l.getStatus());
			}
			return transactionRepository.findAll();
		}
		return transactionRepository.findValidationPassTransaction();
	}
}
