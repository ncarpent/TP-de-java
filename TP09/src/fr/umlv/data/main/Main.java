package fr.umlv.data.main;

import fr.umlv.data.LinkedLink;

public class Main
{
	
	public static void main(String[] args)
	{
		// Exo 1 : Question 1 / Question 3
		LinkedLink<Integer> liste = new LinkedLink<Integer>();
		System.out.println(liste);
		liste.add(144);
		System.out.println(liste);
		liste.add(13);
		System.out.println(liste);
		liste.add(42);
		System.out.println(liste);
		
		// Exo 2 : Question 1
		System.out.println(liste.get(0));
		System.out.println(liste.get(1));
		System.out.println(liste.get(2));
		
		// Question 3
		LinkedLink<String> listech = new LinkedLink<String>();
		listech.add(" !");
		listech.add("word");
		listech.add("hello ");
		System.out.println(listech);
		int lg = listech.get(1).length();
		System.out.println("longueur du 2e item : " + lg);
		
		// Exo 3 : Question 4
		Integer testint = 666;
		String testch = "test";
		Double testdbl = 3.14;
		Integer testintin = 42;
		Double testdblin = 42.;
		System.out.println("test de contenance de " + testint + " : " + liste.contains(testint));
		System.out.println("test de contenance de " + testch + " : " + liste.contains(testch));
		System.out.println("test de contenance de " + testdbl + " : " + liste.contains(testdbl));
		System.out.println("test de contenance de " + testintin + " : " + liste.contains(testintin));
		System.out.println("test de contenance de " + testdblin + " : " + liste.contains(testdblin));
	}
	
	
	
	/* 
	 * exo 2 : 
	 * 
	 * Q1/ Si l'indice est invalide, il faut lever une exception.
	 * 
	 * Q4/ On est obligé d'utiliser un cast ici car la méthode get renvoie un objet de type
	 * 		Object. Il faut donc caster l'objet désigné dans le type voulu (ici String) pour
	 * 		pouvoir travailler dessus ensuite.
	 * 		En tant que développeur Java, on n'aime pas les casts car si l'on n'entre pas un
	 * 		type de données correct, on risque de lever une exception. Or on ne maitrise pas
	 * 		forcément l'utilisation qui sera faite de notre programme.
	 * 
	 * exo 3 : 
	 * 
	 * Q1/ L'intérêt d'utiliser un type paramétré ici est de trouver une alternative au cast
	 * 		nécessaire dans l'exercice précédent.
	 * 
	 * Q4/ o doit être de type Object car on peut demander théoriquement à tester n'importe
	 * 		quel objet. Notamment si l'on ne connaît pas le type de la liste, il faut s'attendre
	 * 		à devoir tester d'autres objets. De plus, cela s'avérerait compliqué de fixer le type
	 * 		à T du point de vue de l'héritage.
	 * 		
	 */
	
}
