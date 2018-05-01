package edu.ilstu;

/*
 * File name:  FlightData.java 
 * 
 * Programmer:  Patricia Matsuda
 *  ULID:  mpmatsu
 *
 *  Date:  Mar 18, 2018
 *
 *  Class: IT 168
 *  Lecture Section:   10
 *  Lecture Instructor:   Matsuda  
 *  Lab Section:  11, 12
 *  Lab Instructor:  West
 */

/**
 * This class will store information about a single flight - 
 * 	information about airports of origin and destination, price for 
 *  the flight, the flight number and the time of the flight.
 *  
 * @author Patricia Matsuda
 *
 */
public class FlightData
{
	private String airportOrigin;
	private String airpotDestination;
	private String flightNumber;
	private String flightTime;
	private double price;
	
	/**
	 * Constuctor that accepts values for all flight data information.
	 * 
	 * @param cityOrigin city that flight departs from
	 * @param cityDestination city that flight will fly to
	 * @param flightNumber number that identifies the flight
	 * @param flightTime time that the flight departs from city of departure/origin
	 * @param price the cost of the flight from city of origin to destination
	 */
	public FlightData(String cityOrigin, String cityDestination, String flightNumber, String flightTime, double price)
	{
		super();
		this.airportOrigin = cityOrigin;
		this.airpotDestination = cityDestination;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.price = price;
	}

	/**
	 * Returns the airport code where the flight starts from
	 * 
	 * @return the airport code where the flight departs from
	 */
	public String getCityOrigin()
	{
		return airportOrigin;
	}

	/**
	 * Returns the airport code where the flight is flying to 
	 * 
	 * @return the airport where the flight will arrive/land as its destination
	 */
	public String getCityDestination()
	{
		return airpotDestination;
	}

	/**
	 * Returns the flight number that identifies the flight 
	 * 
	 * @return the flight number
	 */
	public String getFlightNumber()
	{
		return flightNumber;
	}

	/**
	 * Returns the time that the flight will arrive at its destination airport
	 * 
	 * @return the departure time for the flight at departure airport
	 */
	public String getFlightTime()
	{
		return flightTime;
	}

	/**
	 * Returns the cost of the airplane ticket
	 * 
	 * @return the price of the airplane ticket
	 */
	public double getPrice()
	{
		return price;
	}
	
	
}
