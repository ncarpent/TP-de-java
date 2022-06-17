package fr.uge.manifest.main;

import java.util.Map;

import fr.uge.manifest.Container;
import fr.uge.manifest.Manifest;
import fr.uge.manifest.PlusStamp;
import fr.uge.manifest.StarStamp;

public class Main {

	public static void main (String[] args)
	{
		// Question 1
		System.out.println("Question 1 :");
		var container = new Container("Germany", 500);
		System.out.println(container.destination());  // Germany
		System.out.println(container.weight());  // 500
		System.out.println();
		
		// Question 2
		System.out.println("Question 2 :");
		var container2 = new Container("Italy", 400);
		var container3 = new Container("Austria", 200);
		var manifest = new Manifest();
		manifest.add(container2);
		manifest.add(container3);
		System.out.println(manifest.weight());  // 600
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		var container4 = new Container("Spain", 250);
		var container5 = new Container("Swiss", 200);
		var manifest2 = new Manifest();
		manifest2.add(container4);
		manifest2.add(container5);
		System.out.println(manifest2);
		// 1. Spain 250
		// 2. Swiss 200
		
		// Question 4
		System.out.println("Question 4 :");
		var stamp = new StarStamp();
		var container6 = new Container("France", 550, stamp);
		var manifest3 = new Manifest();
		manifest3.add(container6);
		System.out.println(manifest3);
		// 1. France 550 *
		
		// Question 5
		System.out.println("Question 5 :");
		var container7 = new Container("Venezuela", 150, new PlusStamp(1));
		var container8 = new Container("Liberia", 200, new StarStamp());
		var container9 = new Container("Alaska", 250, new PlusStamp(3));
		var manifest4 = new Manifest();
		manifest4.add(container7);
		manifest4.add(container8);
		manifest4.add(container9);
		System.out.println(manifest4);
		// 1. Venezuela 150 +
		// 2. Liberia 200 *
		// 3. Alaska 250 +++
		
		// Question 6
		System.out.println("Question 6 :");
		var container10 = new Container("Portugal", 450);
		var container11 = new Container("China", 200);
		var container12 = new Container("Portugal", 125);
		var manifest5 = new Manifest();
		manifest5.add(container10);
		manifest5.add(container11);
		manifest5.add(container12);
		manifest5.removeAllContainersFrom("Portugal");
		System.out.println(manifest5);
		// 1. China 200
		
		// Question 7
		System.out.println("Question 7 :");
		var container13 = new Container("Scotland", 200);
		var container14 = new Container("Ireland", 100);
		var container15 = new Container("Russia", 200);
		var manifest6 = new Manifest();
		manifest6.add(container13);
		manifest6.add(container14);
		manifest6.add(container15);
		var price = manifest6.price(Map.of("Scotland", 40, "Ireland", 50), 100);
		System.out.println(price);   // 190
		System.out.println();
		
		// Question 8
		System.out.println("Question 8 :");
		var container16 = new Container("Laos", 120);
		var container17 = new Container("Vietnam", 120, new StarStamp());
		var container18 = new Container("Thailand", 120, new PlusStamp(2));
		var manifest7 = new Manifest();
		manifest7.add(container16);
		manifest7.add(container17);
		manifest7.add(container18);
		var price7 = manifest7.price(Map.of("Thailand", 100), 400);
		System.out.println(price7);  // 680
		System.out.println();
		
		// Question 9
		System.out.println("Question 9 :");
		var container19 = new Container("Monaco", 100);
		var container20 = new Container("Luxembourg", 200);
		var container21 = new Container("Monaco", 300);
		var manifest8 = new Manifest();
		manifest8.add(container19);
		manifest8.add(container20);
		manifest8.add(container21);
		System.out.println(manifest8.weightPerDestination());
		// {Monaco=400, Luxembourg=200}
	}

}
