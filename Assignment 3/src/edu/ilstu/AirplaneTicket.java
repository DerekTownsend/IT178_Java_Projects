/*File name: AirplaneTicket.java
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
public class AirplaneTicket extends Ticket {
	String flightNum, section, departureDay, departureTime, departureAirport, arrivalDay, arrivalTime, arrivalAirport;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param seatNum
	 * @param price
	 * @param flightNum
	 * @param section
	 * @param departureDay
	 * @param departureTime
	 * @param departureAirport
	 * @param arrivalDay
	 * @param arrivalTime
	 * @param arrivalAirport
	 */
	public AirplaneTicket(String firstName, String lastName, String seatNum, double price, String flightNum, String section, String departureDay, String departureTime, String departureAirport, String arrivalDay,
			String arrivalTime, String arrivalAirport) {
		super(firstName, lastName, seatNum, price);
		this.flightNum = flightNum;
		this.section = section;
		this.departureDay = departureDay;
		this.departureTime = departureTime;
		this.departureAirport = departureAirport;
		this.arrivalDay = arrivalDay;
		this.arrivalTime = arrivalTime;
		this.arrivalAirport = arrivalAirport;
	}
	
	public double ticketPrice() {
		return AirplaneDeals.getTicketPrice(departureAirport,arrivalAirport);
	}
	@Override
	public void displayTicketInfo() {
		System.out.println(getLastName()+", "+getFirstName()+"\nFlight Number: "+flightNum+"\nSeat:   "+getSeatNum()+"\t\t\t\tTotal cost: $" +ticketPrice()+"\n\nDeparture:\nAirport: "+departureAirport+"\tDate: "+departureDay+"\tTime: "+departureTime+"\n\nArrival:\nAirport: "+arrivalAirport+"\tDate: "+arrivalDay+"\tTime: "+arrivalTime);
		
	}
}
