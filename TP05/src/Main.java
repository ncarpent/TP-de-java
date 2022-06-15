
public class Main {

	public static void main(String[] args) {
		// Exercice 1
		// Question 2
		System.out.println("Exercice 1 :");
		System.out.println();
		System.out.println("Question 2 :");
		System.out.println("shelter 1 :");
		var shelter = new Shelter();
		System.out.println(shelter);
		shelter.add(new Dog("scooby doo", 21));
		System.out.println(shelter);
		var renvoyes = shelter.removeAll("scooby doo");
		System.out.println(shelter);
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		Shelter.afficher(renvoyes);
		//System.out.println(renvoyes);
		System.out.println();
		
		// Question 4
		System.out.println("Question 4 :");
		System.out.println("shelter 2 :");
		var shelter2 = new Shelter();
		//var scooby = new Dog("scooby doo", 21);
		//System.out.println(scooby.shelt);
		shelter2.add(new Dog("scooby doo", 21));
		//System.out.println(scooby.shelt);
		shelter2.add(new Dog("idefix", 2));
		System.out.println(shelter2);
		System.out.println("biscuits : " + shelter2.biscuits());
		System.out.println();
		
		// Exercice 2
		// Question 1
		System.out.println("Exercice 2 :");
		System.out.println();
		System.out.println("Question 1 :");
		System.out.println("shelter 3 :");
		var shelter3 = new Shelter();
		shelter3.add(new Dog("pongo", 15));
		shelter3.add(new Cat("garfield", 120));
		System.out.println(shelter3);
		System.out.println("biscuits : " + shelter3.biscuits());
		var garfields = shelter3.removeAll("garfield");
		System.out.println(garfields);
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		System.out.println("shelter 4 :");
		var shelter4 = new Shelter();
		System.out.println(shelter4);
		var tramp = new Dog("tramp", 12);
		shelter4.add(tramp);
		System.out.println(shelter4);
		System.out.println("trampshelt : " + tramp.shelt());
		var shelter5 = new Shelter();
		//shelter5.add(tramp);   // exception !
		System.out.println();
		
		// Question 4
		System.out.println("Question 4 :");
		System.out.println("shelter 6 :");
		var beethoven = new Dog("beethoven", 30);
		System.out.println(beethoven);
		// beethoven.isNowKing();  // exception !
		var shelter6 = new Shelter();
		shelter6.add(beethoven);
		beethoven.isNowKing();
		System.out.println(shelter6);
		System.out.println();
		
	}

}
