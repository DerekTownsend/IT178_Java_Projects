/*File name: Ticket.java
 *
 *Programmer: Derek Townsend
 *ULID: djtown1
 *
 *Date: Mar 5, 2018
 *
 *Class: IT 178
 *Lecture Section: 001
 *Lecture Instructor:Ms. Matsuda
 * 
 */
package edu.ilstu;

/**
 * @author derek
 *
 */
public abstract class Ticket {
	private String firstName,lastName,seatNum;
	private double price;
	
	public Ticket(String firstName, String lastName, String seatNum, double price) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.seatNum = seatNum;
		this.price = price;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public abstract void displayTicketInfo();
	

}
