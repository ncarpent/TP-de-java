package AdultFilterStream;

//import java.util.ArrayList;
import java.util.List;

public class AdultFilter
{
	public record Person (String name, int age) {}
	
	/* ancienne version
	public static List<String> namesOfTheAdults (List<Person> persons)
	{
		var names = new ArrayList<String>();
		for (var person: persons)
		{
			if (person.age() >= 18)
			{
				names.add(person.name());
			}
		}
		return names;
	}
	*/
	
	public static List<String> namesOfTheAdults (List<Person> persons)
	{
		return persons.stream().filter(p -> p.age>=18).map(Person::name).toList();
	}
	
	public static void main (String[] args)
	{
		var persons = List.of(
				new Person("Ana", 21),
				new Person("John", 17),
				new Person("Liv", 29));
		var names = namesOfTheAdults(persons);
		System.out.println(names);
	}
	
}

/*
 * Exercice 1 :
 * 
 * Q1/ L'interface fonctionnelle prise en paramètre de filter est Predicate.
 * 		Elle modélise la situation E->boolean.
 * 		Ici le type de paramètre de la lambda est Person et son type de retour est boolean.
 * 
 * Q2/ L'interface fonctionnelle prise en paramètre de map est Function.
 * 		Elle modélise la situation T->U.
 * 		Ici le type de paramètre de la lambda est Person et son type de retour est String.
 */
