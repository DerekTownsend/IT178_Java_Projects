/*
 *File name: Ticket.java
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
public class Ticket {
	private int rowNum,colNum;
	private double price;
	private String firstName;
	private String lasttName;
	
	public Ticket(int rowNum, int colNum, double price, String firstName, String lasttName) {
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.price = price;
		this.firstName = firstName;
		this.lasttName = lasttName;
	}

	public int getRowNum() {
		return rowNum;
	}

	public int getColNum() {
		return colNum;
	}

	public double getPrice() {

		return price;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLasttName() {
		return lasttName;
	}
	
	
}
