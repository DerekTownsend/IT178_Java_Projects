/*File name: TicketApp.java
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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author derek
 *
 */
public class TicketSaleApp {
	Scanner keyboard=null;
	ArrayList<Ticket> tickets=null;
	private void setUp(){
		keyboard=new Scanner(System.in);
		tickets=new ArrayList<Ticket>();
	}
	
	private void run(){
		char answer=' ';

		System.out.print("Would you like buy a train or airplane ticket? Enter Y or N: ");
		answer=keyboard.next().charAt(0);
		
		while(answer!='N'&&answer!='n'){
			System.out.print("\nTrain or airplane ticket? Enter 1 for train or 2 for plane: ");
			answer=keyboard.next().charAt(0);
			if(answer=='1'){
				processTrainTicket();
			}else if(answer=='2'){
				processPlaneTicket();
			}else{
				System.out.println("Please enter valid input: ");
			}
			System.out.print("\nWould you like buy a train or airplane ticket? Enter Y or N: ");
			answer=keyboard.next().charAt(0);
		}
		
		for(int i=0;i<tickets.size();i++) {
			tickets.get(i).displayTicketInfo();
		}
	}
	
	private  void processTrainTicket(){
		String firstName,  lastName,  seatNum,  trainNum, ticketType,  departureDay, departureTime, departureLocation, arrivalDay,arrivalTime, arrivalLocation;
		double price;
		keyboard.nextLine();
		System.out.println("Plese enter first name: ");
		firstName=keyboard.nextLine();
		System.out.println("Plese enter last name: ");
		lastName=keyboard.nextLine();
		System.out.println("Plese enter seat number: ");
		seatNum=keyboard.nextLine();
		System.out.println("Plese enter train number: ");
		trainNum=keyboard.nextLine();
		System.out.println("Plese enter ticket type: ");
		ticketType=keyboard.nextLine();
		System.out.println("Plese enter departure date: ");
		departureDay=keyboard.nextLine();
		System.out.println("Plese enter departure time: ");
		departureTime=keyboard.nextLine();
		System.out.println("Plese enter departure location: ");
		departureLocation=keyboard.nextLine();
		System.out.println("Plese enter arrival date: ");
		arrivalDay=keyboard.nextLine();
		System.out.println("Plese enter arrival time: ");
		arrivalTime=keyboard.nextLine();
		System.out.println("Plese enter arrival location: ");
		arrivalLocation=keyboard.nextLine();
		price=0;
		tickets.add(new TrainTicket(firstName,  lastName,  seatNum, price, trainNum, ticketType,  departureDay, departureTime, departureLocation, arrivalDay,arrivalTime, arrivalLocation));
	}
	
	private void processPlaneTicket(){
		String firstName,  lastName,  seatNum,  flightNum,  departureDay, departureTime, departureLocation, arrivalDay,arrivalTime, arrivalLocation,section;
		double price;
		keyboard.nextLine();
		System.out.println("Plese enter first name: ");
		firstName=keyboard.nextLine();
		System.out.println("Plese enter last name: ");
		lastName=keyboard.nextLine();
		System.out.println("Plese enter seat number: ");
		seatNum=keyboard.nextLine();
		System.out.println("Plese enter section: ");
		section=keyboard.nextLine();
		System.out.println("Plese enter Flight number: ");
		flightNum=keyboard.nextLine();
		System.out.println("Plese enter departure date: ");
		departureDay=keyboard.nextLine();
		System.out.println("Plese enter departure time: ");
		departureTime=keyboard.nextLine();
		System.out.println("Plese enter departure location: ");
		departureLocation=keyboard.nextLine();
		System.out.println("Plese enter arrival date: ");
		arrivalDay=keyboard.nextLine();
		System.out.println("Plese enter arrival time: ");
		arrivalTime=keyboard.nextLine();
		System.out.println("Plese enter arrival location: ");
		arrivalLocation=keyboard.nextLine();
		price=0;
		tickets.add(new AirplaneTicket(firstName,  lastName,  seatNum, price, flightNum,section, departureDay, departureTime, departureLocation, arrivalDay,arrivalTime, arrivalLocation));
		
	}
	private void cleanUp(){
		keyboard.close();
	}
	/**
	* Method is running the code
	*
	* @param name description 
	* @return description 
	* @throws classname description
	* 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketSaleApp app=new TicketSaleApp();
		app.setUp();
		app.run();
		app.cleanUp();
	}

}
