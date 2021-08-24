package com.example.demo.service;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
@Service
@Transactional
public class UploadAndValidateTransactionService {
//	private static final String Name = "D:\\test_eclipse\\demo\\sample_transaction.xlsx";
	@Autowired
	public TransactionRepository transactionRepository;
	
	public List<Transaction> insertvalidatetransaction(String Name) throws ClassNotFoundException, SQLException {
		//JDBC Code
		//1 Connect
		//1.1 Register Driver
		ArrayList<Transaction> all_transactions = new ArrayList<Transaction>();
		try {
			System.out.print("-----"+Name);
			FileInputStream file = new FileInputStream(new File(Name));

			Workbook workbook =new XSSFWorkbook(file);
			//DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();

			//PreparedStatement preparedStatement=connection.prepareStatement("insert into employes values(?,?,?,?,?,?,?)");
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.println("Validating transactions....");
				System.out.println("Sheet name is "+sh.getSheetName());
				
//				Class.forName("com.mysql.cj.jdbc.Driver");
				//1.2 Connect to DB
//				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/citiproject", "root", "mysql@123");
				
				for(Sheet sheet : workbook) {
					DataFormatter dataFormatter = new DataFormatter();

					for(Row row: sheet) {

						//System.out.println(row.getCell(0).getStringCellValue());
						String RefNo =row.getCell(0).getStringCellValue();

						Date date= row.getCell(1).getDateCellValue();
						java.sql.Date sqlDate =new java.sql.Date(date.getTime());

						String Payer =row.getCell(2).getStringCellValue();
                        String PayerNo=row.getCell(3).getStringCellValue();

						String Payee=row.getCell(4).getStringCellValue();
						String PayeeNo=row.getCell(5).getStringCellValue();
						
						String Amount=row.getCell(6).getStringCellValue();
						
						//to convert Date to String
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
						String strDate = formatter.format(date); 
						
						Transaction t = new Transaction(RefNo , sqlDate, Payer , PayerNo , Payee , PayeeNo , Amount ,"processing" );
						
						boolean b = validate(t);
						
						String status;
						
						if(b)
						{
							status="validation passed";
						}
						else
						{
							status = "validation failed";
						}
						t.setStatus(status);
						System.out.print("***********************************");
						System.out.print(t);
						System.out.print("***********************************");
						all_transactions.add(t);
						transactionRepository.saveAndFlush(t);
						
						
						System.out.println(RefNo+" "+date+" "+Payer+" "+PayerNo+" "+Payee+" "+PayeeNo+"  "+Amount+" "+status);
						
						//if(cell.getCellType()== CellType.STRING)
//						PreparedStatement preparedStatement=connection.prepareStatement("insert into transaction_list values(?,?,?,?,?,?,?,?)");
//						preparedStatement.setString(1, RefNo);
//						preparedStatement.setDate(2,sqlDate);
//						preparedStatement.setString(3,Payer);
//						preparedStatement.setString(4, PayerNo);
//						preparedStatement.setString(5,Payee);
//						preparedStatement.setString(6,PayeeNo);
//						preparedStatement.setString(7,Amount);
//						preparedStatement.setString(8,status);
//						
//						rows =preparedStatement.executeUpdate();
					}
					
					
					System.out.println();


					//
					//System.out.println();
				}
				//connection.close();
			}
			workbook.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return all_transactions;
	}
	
	public boolean validate(Transaction t) throws ParseException
	{
		Date today = new Date();
		java.util.Date utilDate = new java.util.Date(t.getTx_date().getTime());
//		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(t.getTx_date());
		
		//Validating transaction id
		if(t.getTransaction_id().length()!=12 || !(t.getTransaction_id().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		
		//Validating Date
		if(utilDate.compareTo(today)>0)
		{
			return false;
		}
		
		//Valiadting payer details
		if(!(t.getPayer_name().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		
		if(t.getPayer_acc().length()!=12 || !(t.getPayer_acc().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		
		//Validating Payee details
		if(!(t.getPayee_name().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		
		if(t.getPayee_acc().length()!=12 || !(t.getPayee_acc().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		
		//Validating Transaction Amount
		if(!(t.getAmount().matches("[0-9.]+")) || t.getAmount().length()!=13 || t.getAmount().indexOf(".")!=10)
		{
			return false;
		}
		
		return true;
	}

}
