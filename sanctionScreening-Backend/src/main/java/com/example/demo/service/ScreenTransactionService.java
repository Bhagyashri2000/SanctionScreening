package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ScreenTransactionRepository;

@Service
@Transactional

public class ScreenTransactionService {
	@Autowired
	private ScreenTransactionRepository screenTransactionRepository;
	
	public boolean sreeningService()
	{
		boolean bool;
		int rows_pass= screenTransactionRepository.ScreeningPass();
		int rows_fail=screenTransactionRepository.ScreeningFail();
		System.out.println(rows_pass+rows_fail);
		if(rows_pass+rows_fail>0)
			bool=true;
		else
			bool=false;
		return bool;
	}

}
