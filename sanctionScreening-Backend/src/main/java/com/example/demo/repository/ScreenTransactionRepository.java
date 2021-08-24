package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@Repository
public interface ScreenTransactionRepository extends JpaRepository<Transaction, String>
{
	//function for screening using sql query
	@Modifying 
	@Query(value="update transaction_list set txstatus = 'screening passed' where payer_name not in( select Name from sanctions) and payee_name not in( select Name from sanctions) and txstatus='validation passed'", nativeQuery=true)
	int ScreeningPass();
	
	@Modifying 
	@Query(value="update transaction_list set txstatus = 'screening failed' where payer_name in( select Name from sanctions) or payee_name in( select Name from sanctions) and txstatus='validation passed'", nativeQuery=true)
	int ScreeningFail();
//    public boolean screening()
//    {
//    	int rows_pass=0, rows_fail=0;
//    	try
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citiproject","root","mysql@123");
//			System.out.println("Connection established");
//		
//			String updateTableSQL = "update transaction_list set txstatus = \"screening passed\" where payer_name not in( select Name from sanctions) and payee_name not in( select Name from sanctions) and txstatus=\"validation passed\"";
//			PreparedStatement ps1 = con.prepareStatement(updateTableSQL);
//			rows_pass= ps1.executeUpdate();
//			
//			updateTableSQL = "update transaction_list set txstatus = \"screening failed\" where payer_name in( select Name from sanctions) or payee_name in( select Name from sanctions) and txstatus=\"validation passed\"";
//			PreparedStatement ps2 = con.prepareStatement(updateTableSQL);
//			rows_fail=ps2.executeUpdate();
//			System.out.println("Screening done. Records updated !");
//			
//			if (ps1 != null) 
//			{
//				ps1.close();
//			}
//			con.close(); 
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//    	if(rows_pass+rows_fail>0)
//		{
//			return true;
//		}
//    	return false;
//		
//		
//    	
//    }
    
}
