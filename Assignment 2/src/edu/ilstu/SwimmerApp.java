package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * File name:  SwimmerApp.java 
 * 
 * Programmer:  Patricia Matsuda
 *  ULID:  mpmatsu
 *
 *  Date:  Sep 4, 2017
 *
 *  Class: IT 168
 *  Lecture Section:   10
 *  Lecture Instructor:   Matsuda  
 *  Lab Section:  11, 12
 *  Lab Instructor:  Kumari
 */

/**
 * @author Patricia Matsuda
 *
 */
public class SwimmerApp
{
	private void run()
	{
		ArrayList<Swimmer> heat1 = loadArray1();
		//create the rest of the ArrayList for the other 3 heats
		ArrayList<Swimmer> heat2 = loadArray2();
		ArrayList<Swimmer> heat3 = loadArray3();
		ArrayList<Swimmer> heat4 = loadArray4();
		//display
		System.out.println("Heat 1: \n");
		displayArray(heat1);
		System.out.println("\nHeat 2: \n");
		displayArray(heat2);
		System.out.println("\nHeat 3: \n");
		displayArray(heat3);
		System.out.println("\nHeat 4: \n");
		displayArray(heat4);
		System.out.println("\nHeat Winners are:");
		System.out.println("Heat 1: "+ heat1.get(findFastestSwimmer(heat1)));
		System.out.println("Heat 2: "+ heat2.get(findFastestSwimmer(heat2)));
		System.out.println("Heat 3: "+ heat3.get(findFastestSwimmer(heat3)));
		System.out.println("Heat 4: "+ heat4.get(findFastestSwimmer(heat4)));


	}

	//update to return the reference to loaded ArrayList, return type should not be void
	//		heat 1
	private ArrayList<Swimmer> loadArray1()
	{
		ArrayList<Swimmer> tempArray = new ArrayList<Swimmer>();

		tempArray.add(new Swimmer("Emely Rose","Lee","00:27.15"));
		tempArray.add(new Swimmer("Rachel","Marion","00:45.22"));
		tempArray.add(new Swimmer("Alysson","White","00:40.00"));
		tempArray.add(new Swimmer("Marie Anne","Jameson","00:28.10"));
		tempArray.add(new Swimmer("Ardell","Artman","00:27.13"));
		tempArray.add(new Swimmer("Adella ","Aguirre","00:32.32"));
		return tempArray;
	}
		//		heat 2	
	private ArrayList<Swimmer> loadArray2()
	{
		ArrayList<Swimmer> tempArray = new ArrayList<Swimmer>();

		tempArray.add(new Swimmer("Jennifer","Judson","00:30.05"));
		tempArray.add(new Swimmer("Anna K.","Behrensmeyer","00:31.01"));
		tempArray.add(new Swimmer("Caroline","Herschel","00:27.40"));
		tempArray.add(new Swimmer("Chien-Shiung","Wu","00:30.04"));
		tempArray.add(new Swimmer("Michelle","Phelps","00:32.35"));
		tempArray.add(new Swimmer("Dorothy","Hodgkin","00:38.12"));
		return tempArray;
	}
//		heat 3		
		private ArrayList<Swimmer> loadArray3()
		{
		ArrayList<Swimmer> tempArray = new ArrayList<Swimmer>();

		tempArray.add(new Swimmer("Frieda","Robscheit-Robbins","00:45:12"));
		tempArray.add(new Swimmer("Elizabeth","Blackburn","00:37.22"));
		tempArray.add(new Swimmer("Edna","Schroedinger","00:38.01"));
		tempArray.add(new Swimmer("Geraldine","Seydoux","00:29.21"));
		tempArray.add(new Swimmer("Maria","Mitchell","00:29.21"));
		tempArray.add(new Swimmer("Ingrid","Daubechies","00:33.24"));
		return tempArray;
		}
//		heat 4
		private ArrayList<Swimmer> loadArray4()
		{
		ArrayList<Swimmer> tempArray = new ArrayList<Swimmer>();

		tempArray.add(new Swimmer("Jacqueline ","Barton","00:28.32"));
		tempArray.add(new Swimmer("Cecilia","Mason","00:27.12"));
		tempArray.add(new Swimmer("Jecelyn Bell","Burnell","00:29.11"));
		tempArray.add(new Swimmer("Lise","Meitner","00:31.33"));
		tempArray.add(new Swimmer("Maxine","Planck","00:32.23"));
		tempArray.add(new Swimmer("Anna","Cabral","00:27.02"));
		return tempArray;
		}

	//update to receiver/accept a single ArrayList object and display contents of ArrayList
	private void displayArray(ArrayList<Swimmer> heat)
	{
		for(int i=0;i<heat.size();i++) {
			System.out.println(heat.get(i));
		}
	}
	
	//update to receiver/accept a single ArrayList object and return position of Swimmer object with fastest time
	private int findFastestSwimmer(ArrayList<Swimmer> heat)
	{
		int fastestNum,fastestTime;
		fastestTime=heat.get(0).convertTime();
		fastestNum=0;
		for(int i=1;i<heat.size();i++) {
			if(fastestTime>heat.get(i).convertTime()) {
				fastestTime=heat.get(i).convertTime();
				fastestNum=i;
			}
		}
		return fastestNum;
	}
	
	//DO NOT CHANGE THIS MAIN METHOD
	public static void main(String[] args)
	{
		SwimmerApp app = new SwimmerApp();
		app.run();
	}
}
