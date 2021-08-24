package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FilterTransactionService;
import com.example.demo.service.ScreenTransactionService;
import com.example.demo.service.UploadAndValidateTransactionService;
import com.example.demo.model.Transaction;
import com.example.demo.repository.ScreenTransactionRepository;
import com.example.demo.repository.TransactionRepository;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("api/v1")
public class TransactionController {

	@Autowired
	private FilterTransactionService filterTransactionService;
	@Autowired
	private UploadAndValidateTransactionService uploadAndValidateTransactionService;
	@Autowired
	private ScreenTransactionService screenTransactionService;
	
//	@GetMapping("/transaction")
//	public List<Transaction> getAllTransaction()
//	{
//		return transactionRepository.findAll();
//	}
	
//	@GetMapping("/validatePasstransaction")
//	public List<Transaction> getAllPassTransaction()
//	{
//		return transactionRepository.findPassTransaction();
//	}
//	
	@GetMapping("/filterTransactions")
	public List<Transaction> filterTransactions(@RequestParam("status") String status)
	{
		return filterTransactionService.FilterTransaction(status);
	}
	
//	@GetMapping("/validationFailtransaction")
//	public List<Transaction> getAllvalidationFailTransaction()
//	{
//		return transactionRepository.findValidationFailTransaction();
//	}
//	
//	@GetMapping("/screeningPasstransaction")
//	public List<Transaction> getAllscreeningPassTransaction()
//	{
//		return transactionRepository.findScreeningpassTransaction();
//	}
//	
//	@GetMapping("/screeningFailtransaction")
//	public List<Transaction> getAllscreeningFailTransaction()
//	{
//		return transactionRepository.findScreeningfailTransaction();
//	}
	
	@PostMapping("/UploadAndValidateTransaction")
	public List<Transaction> UploadAndValidateTransaction(@RequestBody String urlFile) throws ClassNotFoundException, SQLException
	{
		return uploadAndValidateTransactionService.insertvalidatetransaction(urlFile);
	}
	
//	@GetMapping("/validateTransaction")
//	public boolean validation() throws ClassNotFoundException, SQLException
//	{
//		return validatetransaction.insertvalidatetransaction();
//	}
	
	@GetMapping("/screenTransaction")
	private boolean screening()
	{
		return screenTransactionService.sreeningService();
	}
	
//	@PostMapping(value="/uploadFile")
//	public url uploadTransactioFile(@RequestBody url urlFile)
//	{
//		return urlRepository.save(urlFile);
//	}
//	
	
}
