/*File name: Swimmer.java
 *
 *Programmer: Derek Townsend
 *ULID: djtown1
 *
 *Date: Feb 14, 2018
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
public class Swimmer {
	private String firstName,lastName,time;

	public Swimmer(String firstName, String lastName, String time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.time = time;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTime() {
		return time;
	}
	
	public int convertTime() {
		int mm,ss,ms,milliseconds;
		mm=Integer.parseInt(time.substring(0,2));
		ss=Integer.parseInt(time.substring(3,5));
		ms=Integer.parseInt(time.substring(6));
		milliseconds=(mm*60000)+(ss*1000)+ms;		
		return milliseconds;
	}


	public String toString() {
		return firstName + " " + lastName + ", " + time;
	}
	
}
