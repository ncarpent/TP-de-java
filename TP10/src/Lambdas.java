import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class Lambdas
{
	
	public static void upperCaseAll (List<String> liste)
	{
		liste.replaceAll(s -> s.toUpperCase(Locale.ROOT));
	}
	
	/* version limitée aux String
	public static Map<String, Integer> occurences (List<String> liste)
	{
		var dico = new HashMap<String, Integer>();
		//liste.forEach(s->dico.merge(s, 1, (u,v)->u+v));
		liste.forEach(s->dico.merge(s, 1, Integer::sum));
		return dico;
	}
	*/
	
	public static <T> Map<T, Integer> occurences (List<T> liste)
	{
		var dico = new HashMap<T, Integer>();
		//liste.forEach(s->dico.merge(s, 1, (u,v)->u+v));
		liste.forEach(s->dico.merge(s, 1, Integer::sum));
		return dico;
	}
	
	public static Map<String, List<Actor>> actorGroupByFirstName (List<Actor> liste)
	{
		HashMap<String, List<Actor>> dico = new HashMap<String, List<Actor>>();
		liste.forEach(a->dico.computeIfAbsent(a.firstName(), s->new ArrayList<>()).add(a));
		return dico;
	}
	
	public static Map<String, List<Actor>> actorGroupBy (List<Actor> liste,
			Function<Actor, String> typeDeGroupe)
	{
		var dico = new HashMap<String, List<Actor>>();
		liste.forEach(a->dico.computeIfAbsent(typeDeGroupe.apply(a), s->new ArrayList<>()).add(a));
		return dico;
	}
	
	public static <T, U> Map<U, List<T>> groupBy (List<T> liste,
			Function<T, U> typeDeGroupe)
	{
		var dico = new HashMap<U, List<T>>();
		liste.forEach(e->dico.computeIfAbsent(typeDeGroupe.apply(e), u->new ArrayList<>()).add(e));
		return dico;
	}
	
	public static void main (String[] args)
	{
		// Exercice 1
		System.out.println("Exercice 1 :");
		List<String> liste = Arrays.asList("tout", "le", "bonjour", "tout", "le", "monde", "!");
		System.out.println("message dans une liste :" + liste);
		Lambdas.upperCaseAll(liste);
		System.out.println("message dans une liste en Majuscules : " + liste);
		System.out.println();
		
		// Exercice 2
		System.out.println("Exercice 2 :");
		var dico = Lambdas.occurences(liste);
		System.out.println("Occurences du message dans une liste : " + dico);
		List<Double> dbllist = Arrays.asList(1.,5.,42.,4.,2.,8.,1.,3.,6.,1.,5.,9.,4.,1.,5.);
		System.out.println("liste de doubles : " + dbllist);
		var dbldico = Lambdas.occurences(dbllist);
		System.out.println("Occurences de la liste de doubles : " + dbldico);
		System.out.println();
		
		// Exercice 3
		System.out.println("Exercice 3 :");
		System.out.println("_ méthode actorGroupByFirstName :");
		List<Actor> actors = List.of(new Actor("bob", "de niro"), new Actor("willy", "cat"), 
				new Actor("bob", "cat"));
		System.out.println("liste d'acteurs : " + actors);
		var dicoActor = Lambdas.actorGroupByFirstName(actors);
		System.out.println("dico d'acteurs groupés : " + dicoActor);
		System.out.println();
		
		System.out.println("_ méthode actorGroupBy :");
		var group1 = actorGroupBy(actors, Actor::firstName);  // groupe par prénom
		var group2 = actorGroupBy(actors, Actor::lastName);   // groupe par nom
		System.out.println("dico d'acteurs groupés par prénom : " + group1);
		System.out.println("dico d'acteurs groupés par nom : " + group2);
		System.out.println();
		
		System.out.println("_ méthode groupBy :");
		var listint = List.of(42, 5, 666, 37, -65, 2, -26, -255, 256, -9, -72);
		System.out.println("liste d'entiers signés :" + listint);
		var dicoint = Lambdas.groupBy(listint, i->i>=0);
		System.out.println("dico d'entiers signés groupés par positivités :" + dicoint);
		System.out.println();
	}
	
}

/* Exercice 1 :
 * 
 * Q1/ Pour mettre une chaîne en majuscules (indépendament de la langue dans laquelle l'OS est
 * 		configuré), on utilise la méthode toUpperCase(Locale.ROOT()).
 * 
 * Q2/ L'interface fonctionnelle utilisée par la méthode list.replaceAll est UnaryOperator.
 * 
 * Q3/ Cela correspond au type de fonction (T)->T (c'est un opérateur unaire...).
 * 
 * Q4/ La méthode replaceAll étant appelée sur une liste de String, le paramètre de la lambda est de
 * 		type String et son type de retour est aussi String.
 * 
 * 
 * Exercice 2 :
 * 
 * Q1/ Le paramètre de la méthode occurences est de type List<String>.
 * 		La valeur de retour de la méthode occurences est de type Map<Sring,Integer>
 * 
 * Q2/ Ici, on pourra choisir une HashMap comme implantation de la valeur de retour. L'ordre n'a à
 * 		priori pas d'intérêt.
 * 
 * Q3/ La méthode foreach prend un Consumer en paramètre. Cela correspond à un type fonction
 * 		(T)->void. Ici, les types de la lambda correspondant sont (String)->void.
 * 
 * Q4/ La méthode merge prend une Bifunction en paramètre. Le type fonction correspondant est
 * 		(T,U)->V. Ici, les types de la lambda correspondants que l'on va utiliser sont
 * 		(Integer, Integer)->Integer.
 * 
 * Exercice 3 :
 * 
 * Q1/ Le paramètre de actorGroupByFirstName est de type List<Actor>.
 * 		La valeur de retour de actorGroupByFirstName est de type Map<String, List<Actor>>.
 * 
 * Q2/ La méthode Map.computeIfAbsent ajoute une valeur à la Map si la clé associée n'est pas encore
 * 		présente (ne fais rien sinon). Elle utilise une Interface fonctionnelle (lambda) pour
 * 		calculer la nouvelle valeur. Dans tous les cas, elle renvoie la valeur associée à la clé
 * 		(qu'elle soit préexistante ou nouvellement calculée par la lambda).
 * 		Son second paramètre est une interface fonctionnelle de type Function. Cela correspond au
 * 		type fonctionnel (T)->U. Ici, T doit être un sur-type du type des clés. Et U doit être un
 * 		type dérivé du type des valeurs.
 * 		Le premier paramètre est la clé dont on doit tester la présence. En cas d'abscence de
 * 		celle-ci, le second paramètre est une lambda qui calcule une valeur à partir de la clé donnée
 * 		en premier paramètre. Le couple (clé, valeur) obtenu est alors ajouté à la Map (à moins que
 * 		la valeur ne soit null).
 * 		Dans notre cas, le premier paramètre sera le prénom des acteurs (clés) et le deuxième sera
 * 		une lambda qui à un prénom associe (et renvoie) la liste des acteurs portant ce prénom.
 * 
 * Q3/ Dans notre cas, la lambda passée en second paramètre doit être de type (String)->List<Actor>.
 * 
 * Q5/ Le type fonction du second paramètre doit être (T)->U. Et ici plus précisément
 * 		(Actor)->String.
 * 		L'interface fonctionnelle correspondante est Function<T, U>.
 * 		Le type du second paramètre de actorGroupBy doit être Function<Actor, String>.
 */
