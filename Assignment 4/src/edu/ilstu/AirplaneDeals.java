package edu.ilstu;

import java.util.ArrayList;

/*
 * File name:  AirplaneDeals.java 
 * 
 * Programmer:  Patricia Matsuda
 *  ULID:  mpmatsu
 *
 *  Date:  Feb 22, 2018
 *
 *  Class: IT 168
 *  Lecture Section:   10
 *  Lecture Instructor:   Matsuda  
 *  Lab Section:  11, 12
 *  Lab Instructor:  West
 */

/**
 * This class manages the current deal prices for tickets from point of origin to destination cities.
 * 
 * @author Patricia Matsuda
 *
 */
public class AirplaneDeals
{
	private ArrayList<FlightData> flightDeals;
	
	/**
	 * This is the constructor that loads Ticket objects with the following information:
	 * 		- airport/city where flight departs from
	 * 		- airport/city where flight travels to
	 * 		- flight number
	 * 		- time of the flight
	 * 		- price of the lifght
	 */
	public AirplaneDeals()
	{
		flightDeals = new ArrayList<FlightData>();
		flightDeals.add(new FlightData("CHI", "LAX", "AL231", "2:35 pm", 544.50));
		flightDeals.add(new FlightData("CHI", "YVR", "AL12", "12:35 pm", 235.25));
		flightDeals.add(new FlightData("LAX", "CHI", "AL1115", "7:35 am", 444.00));
		flightDeals.add(new FlightData("LAX", "YVR", "AL322", "10:00 am", 180.50));
		flightDeals.add(new FlightData("YVR", "CHI", "AL1212", "9:12 pm", 745.99));
		flightDeals.add(new FlightData("YVR", "LAX", "AL24", "6:55 am", 195.50));
	}
	
	/**
	 * This method accepts the city of origin and the city of destination 
	 * and returns the current deal price for a one-way trip.
	 * 
	 * @param origin city where the ticket holder will board the plane
	 * @param destination city where the ticket holder is going to
	 * @return price of the ticket for the one way trip
	 */
	public double getTicketPrice(String origin, String destination)
	{
		double cost = 0;
		int i = 0;
		boolean notFound = true;
		
		while(i < flightDeals.size() && notFound)
		{
			if(flightDeals.get(i).getCityOrigin().equalsIgnoreCase(origin) && 
					flightDeals.get(i).getCityDestination().equalsIgnoreCase(destination))
			{
				cost = flightDeals.get(i).getPrice();
				notFound = false;
			}
			i++;				
		}
		return cost;
	}
	
	/**
	 * This method accepts the city of departure and the city of arrival and returns the Ticket object
	 * that has the data for the flight.
	 * 
	 * @param origin city where flight departs from
	 * @param destination city where flight travels to
	 * @return the Ticket object that contains information about the flight - flight number, flight time and price
	 */
	public FlightData getTicket(String origin, String destination)
	{
		FlightData temp = null;
		int i = 0;
		boolean notFound = true;
		
		while(i < flightDeals.size() && notFound)
		{
			if(flightDeals.get(i).getCityOrigin().equalsIgnoreCase(origin) && 
					flightDeals.get(i).getCityDestination().equalsIgnoreCase(destination))
			{
				temp = flightDeals.get(i);
				notFound = false;
			}
			i++;				
		}
		return temp;
	}
}
