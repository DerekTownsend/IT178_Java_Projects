/*
 *File name: Event.java
 *
 *Programmer: Derek Townsend
 *ULID: djtown1
 *
 *Date: Jan 30, 2018
 *
 *Class: IT 178
 *Lecture Section: 001
 *Lecture Instructor:Ms. Matsuda
 */
package edu.ilstu;

/**
 * @author derek
 *
 */
public class Event {
	private final double SALES_TAX=1.0775;
	private final int PROCCESS_FEE=15;
	private final int INSURANCE_FEE=10;
	private Ticket[][] tickets;

	public Event() {
		tickets=new Ticket[30][8];
	} 
	public double getSalesTax() {
		return SALES_TAX;
	}

	public int getProcessFee() {
		return PROCCESS_FEE;
	}

	public int getInsuranceFee() {
		return INSURANCE_FEE;
	}
	
	public void displaySeatingMap() {
		for(int i=0;i<tickets.length;i++) {
			System.out.printf("%-3d",i+1);
			for(int j=0; j<tickets[i].length;j++) {
				
				if(tickets[i][j]!=null) {
					System.out.print("[X] ");
				}else {
					System.out.print("[ ] ");
				}
				
			}
			System.out.println();
		}
	}
	
	public boolean checkSeating(int row, int col) {
		boolean flag=true;
		
		if(tickets[row][col]!=null) {
			flag=false;
		}
		
		return flag;
	}
	
	public void updateSeating(Ticket ticket) {
		int row=ticket.getRowNum();
		int col=ticket.getColNum();
		tickets[row][col]=ticket;
	}
	
	
	
}
