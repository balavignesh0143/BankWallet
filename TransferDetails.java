package com.bean;

public class TransferDetails {
	private int transId;
	private long accNoFrom;
	private long accNoTo;
	private double transferAmt;
	private String transType;
	private String dateOfTrans;
	private double balance;
	
	public long getAccNoFrom() {
		return accNoFrom;
	}
	public void setAccNoFrom(long accNoFrom) {
		this.accNoFrom = accNoFrom;
	}
	public long getAccNoTo() {
		return accNoTo;
	}
	public void setAccNoTo(long accNoTo) {
		this.accNoTo = accNoTo;
	}
	public double getTransferAmt() {
		return transferAmt;
	}
	public void setTransferAmt(double transferAmt) {
		this.transferAmt = transferAmt;
	}
	
	public String getDateOfTrans() {
		return dateOfTrans;
	}
	public void setDateOfTrans(String dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	


	public TransferDetails(int transId,long accNoFrom,long accNoTo,double transferAmt,String transType,String dateOfTrans,double balance)
	{
		this.transId=transId;
		this.accNoFrom=accNoFrom;
		this.accNoTo=accNoTo;
		this.transferAmt=transferAmt;
		this.transType=transType;
		this.dateOfTrans=getDateOfTrans();
		this.balance=balance;
	}
	public TransferDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	public String toString()
	{
		return "Account transId="+transId+" accNoFrom= "+accNoFrom+" accNoTo= "+accNoTo+" transType= "+ transType+" dateOfTrans= "+dateOfTrans+" balance= "+balance;
	}

}
