package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_list")
public class Transaction 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  String transaction_id;
	private  Date tx_date;
	private  String payer_name;
	private  String payer_acc;
	private  String payee_name;
	private  String payee_acc;
	private  String amount;
	private  String txstatus;
	
	public Transaction()
	{
		
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getTx_date() {
		return tx_date;
	}

	public void setTx_date(Date tx_date) {
		this.tx_date = tx_date;
	}

	public String getPayer_name() {
		return payer_name;
	}

	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}

	public String getPayer_acc() {
		return payer_acc;
	}

	public void setPayer_acc(String payer_acc) {
		this.payer_acc = payer_acc;
	}

	public String getPayee_name() {
		return payee_name;
	}

	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}

	public String getPayee_acc() {
		return payee_acc;
	}

	public void setPayee_acc(String payee_acc) {
		this.payee_acc = payee_acc;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return txstatus;
	}

	public void setStatus(String txstatus) {
		this.txstatus = txstatus;
	}

	public Transaction(String transaction_id, Date tx_date, String payer_name, String payer_acc, String payee_name,
			String payee_acc, String amount, String txstatus) {
		super();
		this.transaction_id = transaction_id;
		this.tx_date = tx_date;
		this.payer_name = payer_name;
		this.payer_acc = payer_acc;
		this.payee_name = payee_name;
		this.payee_acc = payee_acc;
		this.amount = amount;
		this.txstatus = txstatus;
	}
	
}