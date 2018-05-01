/*
 *File name: EventSaleApplication.java
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

import java.util.Scanner;

/**
 * @author derek
 *
 */
public class EventSaleApplication {

	public static void main(String[] args) {
		Scanner keyboard= new Scanner(System.in);
		Event seating =new Event();
		boolean flag=true;
		int row,col;
		String firstName,lastName;
		double price=0,totalCost=0;
		
		seating.displaySeatingMap();
		while(flag) {
			
		System.out.print("\nDo you wish to buy a ticket? (Y or N): ");
			String buyTicket= keyboard.nextLine();
			if(buyTicket.equalsIgnoreCase("Y")) {
				System.out.println("Which row would you like?");
				row=keyboard.nextInt();
				System.out.println("Which column would you like?");
				col=keyboard.nextInt();
				
				if(seating.checkSeating(row-1, col-1)) {
					if(row<=3) {
						price=189;
					}else if(row<=10) {
						price=169;
					}else if(row<=20) {
						price=99;
					}else {
						price=79;
					}
					keyboard.nextLine();
				System.out.print("Please enter first name: ");
				firstName=keyboard.nextLine();
				System.out.print("Please enter last name: ");
				lastName=keyboard.nextLine();
				
				while(true) {
				System.out.print("Would you like insurance  (Y or N): ");
				String buyInsurance= keyboard.nextLine();
				
					if(buyInsurance.equalsIgnoreCase("Y")) {
						totalCost=(price *seating.getSalesTax())+seating.getInsuranceFee()+seating.getProcessFee();
						Ticket ticket= new Ticket(row-1, col-1, price, firstName, lastName);
						seating.updateSeating(ticket);
						System.out.printf("\n"+lastName+", "+firstName+"\n\nRow: "+row+"  Seat: "+col+"\nInsurance: $"+seating.getInsuranceFee()+"\nTotal Cost: $%.2f\n",totalCost);
						break;
					}else if(buyInsurance.equalsIgnoreCase("N")) {
						totalCost=(price *seating.getSalesTax())+seating.getProcessFee();
						Ticket ticket= new Ticket(row-1, col-1, price, firstName, lastName);
						seating.updateSeating(ticket);
						System.out.printf("\n"+lastName+", "+firstName+"\n\nRow: "+row+"  Seat: "+col+"\nTotal Cost: $%.2f\n",totalCost);
						break;
					}else {
						System.out.println("Please enter a valid input");
						
					}
				}
				
				
				}else {
					System.out.println("Sorry that Seat is unavailable.");	
				}
				seating.displaySeatingMap();				
			}else if(buyTicket.equalsIgnoreCase("N")) {
				System.out.println("Thank you for checking out our event.");
				flag=false;
			}else {
				System.out.println("\nPlease enter a valid input");
			}
		}
		
		
		
		keyboard.close();
	}

}
