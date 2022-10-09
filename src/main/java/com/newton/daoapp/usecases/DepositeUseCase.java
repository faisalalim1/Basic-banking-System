package com.newton.daoapp.usecases;

import java.util.Scanner;

import com.newton.daoapp.beans.Account;
import com.newton.daoapp.dao.AccountDao;
import com.newton.daoapp.dao.AccountDaoImpl;

public class DepositeUseCase {
	
	
	public static void main(String[] args) {
		
		AccountDao dao = new AccountDaoImpl();
//		
//		
//		Account acc1 = new Account();
//		acc1.setName("john");
//		acc1.setBalance(886700);
//		
//		boolean f = dao.createAccount(acc1);
//		
//		if(f)
//			System.out.println("Account created...");
//		else
//			System.out.println("Not created...");
//		
		
		
		
	Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account number");
		int accno = sc.nextInt();
		
		
		Account acc = dao.findAccount(accno);
		
		if(acc == null)
			System.out.println("Account does not exist...");
		else {
			
			System.out.println("Enter the amount to Deposite");
			int amt = sc.nextInt();
			
			acc.setBalance(acc.getBalance() + amt);
			
			boolean f = dao.updateAccount(acc);
			
			if(f)
				System.out.println("Depositd sucessfully...");
			else
				System.out.println("Techanical Error...!");
		
		
		
	
		}
	}
	
}


















