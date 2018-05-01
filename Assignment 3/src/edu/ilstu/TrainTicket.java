/*File name: TrainTicket.java
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
public class TrainTicket extends Ticket{
	String trainNum, ticketType, departureDay, departureTime, departureLocation, arrivalDay, arrivalTime, arrivalLocation;
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param seatNum
	 * @param price
	 * @param trainNumber
	 * @param typeOfTicket
	 * @param departureDay
	 * @param departureTime
	 * @param departureLocation
	 * @param arrivalDay
	 * @param arrivalTime
	 * @param arrivalLocation
	 */
	public TrainTicket(String firstName, String lastName, String seatNum, double price, String trainNum,
			String ticketType, String departureDay, String departureTime, String departureLocation, String arrivalDay,
			String arrivalTime, String arrivalLocation) {
		super(firstName, lastName, seatNum, price);
		this.trainNum = trainNum;
		this.ticketType = ticketType;
		this.departureDay = departureDay;
		this.departureTime = departureTime;
		this.departureLocation = departureLocation;
		this.arrivalDay = arrivalDay;
		this.arrivalTime = arrivalTime;
		this.arrivalLocation = arrivalLocation;
	}
	
	public double ticketPrice() {
		return TrainDeals.getTicketPrice(ticketType.charAt(0));
	}
	
	@Override
	public void displayTicketInfo() {
		System.out.println(getLastName()+", "+getFirstName()+"\nTrain Number: "+trainNum+"\nSeat:   "+getSeatNum()+"\tType: "+ticketType+"\tPrice: $"+ticketPrice()+"\n\nDeparture:\nStation: "+departureLocation+"\tDate: "+departureDay+"\tTime: "+departureTime+"\n\nArrival:\nStation: "+arrivalLocation+"\tDate: "+arrivalDay+"\tTime: "+arrivalTime);
		
	}
}
