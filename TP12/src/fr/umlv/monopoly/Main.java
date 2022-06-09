package fr.umlv.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	
	public static void main (String[] args)
	{
		
		// Question 1
		System.out.println("Question 1 :");
		var hotel = new Hotel(5, 0.75);
		System.out.println(hotel);  // Hotel 5 rooms 0.75
		System.out.println();
		
		// Question 2
		System.out.println("Question 2 :");
		var apartment = new Apartment(30, List.of("Bony", "Clyde"));
		System.out.println(apartment); // Apartment 30 m2 with Bony, Clyde 1.0
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		var list = new ArrayList<String>();
		list.add("Bob");
		var apartment2 = new Apartment(50, list);
		list.remove("Bob");
		System.out.println(apartment2);  // Apartment 50 m2 with Bob 0.5
		System.out.println();
		
		// Question 4
		System.out.println("Question 4 :");
		var manager = new AssetManager();
		manager.add(hotel);
		manager.add(apartment);
		System.out.println(manager.profitPerNight());  // 415
		System.out.println();
		
		// Question 6
		System.out.println("Question 6 :");
		System.out.println(manager);
		System.out.println();
		
		// Question 7
		System.out.println("Question 7 :");
		System.out.println(manager.lowestEfficiency(0.8));  // [Hotel 5 rooms 0.75]
		System.out.println();
		
		// Question 8
		System.out.println("Question 8 :");
		manager.remove(0.8);
		System.out.println(manager);
		System.out.println();
		
	}
	
}
