package com.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bean.TransferDetails;
import com.bean.UserDetails;
import com.service.Calculation;

public class Store implements StoreInter {
	
	UserDetails ud;
	TransferDetails td;
	Calculation c;
	
	Scanner sc=new Scanner(System.in);
	
	HashMap<Long,UserDetails> hm=new HashMap<Long,UserDetails>();
	HashMap<TransferDetails,Long> hm1=new HashMap<TransferDetails,Long>();
	
	public void addDetails(UserDetails ud)
	{
		this.ud=ud;
		hm.put(ud.getAccNo(),ud);
		System.out.println(hm);
	}
	
	public void transferDetails(TransferDetails td)
	{
		this.td=td;
		
		System.out.println(hm1);
	}

	public HashMap<Long,UserDetails> hm()
	{
		return hm;
	}
	
	public HashMap<TransferDetails,Long> hm1()
	{
		return hm1;
	}

	
	
	public void createAccount(UserDetails ud) 
	{
		hm.put(ud.getAccNo(),ud);
		ud=(UserDetails)hm.get(ud.getAccNo());
	}

	public double showBalance(long accNo) 
	{
		ud=(UserDetails)hm.get(accNo);
		double bal=ud.getBalance();
		return bal;
	}

	public double depositBalance(long accNo,double deposit) 
	{
		ud=(UserDetails)hm.get(accNo);
		double bal=ud.getBalance();
		double d=bal+deposit;
		ud.setBalance(d);
		hm.put(accNo,ud);
		TransferDetails td=new TransferDetails();
		td.setAccNoFrom(accNo);
		td.setTransferAmt(deposit);
		td.setTransType("deposit");
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now=LocalDateTime.now();
		td.setDateOfTrans(dt.format(now));
		td.setBalance(d);
		hm1.put(td,(long) deposit);
		return d;
	}
	
	public double withdrawBalance(long accNo, double withdraw) 
	{
		ud=(UserDetails)hm.get(accNo);
		double bal=ud.getBalance();
		double d=bal-withdraw;
		ud.setBalance(d);
		hm.put(accNo,ud);
		
		TransferDetails td=new TransferDetails();
		td.setAccNoFrom(accNo);
		td.setTransferAmt(withdraw);
		td.setTransType("withdraw");
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now=LocalDateTime.now();
		td.setDateOfTrans(dt.format(now));
		td.setBalance(d);
		hm1.put(td,(long) withdraw);
		
		return d;
	}

	public double fundTransfer(long accNo,long accNo1,double balance) 
	{
		
		
		ud=(UserDetails)hm.get(accNo);
		double bal=ud.getBalance();
		bal=bal-balance;
		ud.setBalance(bal);
		hm.put(accNo,ud);
		
		ud=(UserDetails)hm.get(accNo1);
		double bal1=ud.getBalance();
		bal1=bal1+balance;
		ud.setBalance(bal1);
		hm.put(accNo1,ud);
		
		TransferDetails td=new TransferDetails();
		td.setAccNoFrom(accNo);
		td.setAccNoTo(accNo1);
		td.setTransferAmt(balance);
		td.setTransType("transfer");
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now=LocalDateTime.now();
		td.setDateOfTrans(dt.format(now));
		td.setBalance(bal);
		
		hm1.put(td,(long) balance);
		
		return bal;
	}
	
	public List<TransferDetails> printTrans(long accNo)
	{
		ArrayList<TransferDetails> al=new ArrayList<>(hm1.keySet());
		return al;
		
	}
}
