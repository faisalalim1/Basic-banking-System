package com.newton.daoapp.usecases;

import java.util.Scanner;

import com.newton.daoapp.beans.Account;
import com.newton.daoapp.dao.AccountDao;
import com.newton.daoapp.dao.AccountDaoImpl;

public class WithdrawUseCase {
	
	public static void main(String[] args) {
		
		
		AccountDao dao = new AccountDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account number");
		int accno = sc.nextInt();
		
		
		Account acc = dao.findAccount(accno);
		
		if(acc == null)
			System.out.println("Account does not exist...!");
		else {
			System.out.println("Enter the withdraw amount..");
			int amt = sc.nextInt();
			
			if(amt <= acc.getBalance()) {
				
				acc.setBalance(acc.getBalance() - amt);
				
				boolean f = dao.updateAccount(acc);
				
				if(f) 
					System.out.println("Please collect the cash..");
				else
					System.out.println("Techanical error...!");
			}else
				System.out.println("Inufficient Amount");
			
			
		}
	}

}
