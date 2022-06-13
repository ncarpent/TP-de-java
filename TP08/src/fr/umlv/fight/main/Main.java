package fr.umlv.fight.main;

import fr.umlv.fight.Fighter;
import fr.umlv.fight.Robot;
import fr.umlv.fight.Arena.Fight;

public class Main
{
	
	public static void main(String[] args)
	{
		// Exercice 2 : Question 2
		System.out.println("Exercice 2 :\n\nQuestion 2 :");
		var bob = new Robot("bob");
		System.out.println(bob);  // affiche "Robot bob"
		System.out.println();
		
		// Question 4
		System.out.println("Question 4 :");
		Robot d2r2 = new Robot("D2R2");
		Robot data = new Robot("Data");
		Robot winner = Fight.fight(d2r2, data);
		System.out.println(winner + " a gagné le combat");
		System.out.println();
		
		// Exercice 3 : Question 7
		System.out.println("Exercice 3 :\n\nQuestion 7 :");
		var john = new Fighter("John", 1);
		var jane = new Fighter("Jane", 2);
		System.out.println(Fight.fight(john, jane) + " wins");
	}
	
}
