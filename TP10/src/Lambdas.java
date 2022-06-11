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
	
	/* version limit�e aux String
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
		System.out.println("_ m�thode actorGroupByFirstName :");
		List<Actor> actors = List.of(new Actor("bob", "de niro"), new Actor("willy", "cat"), 
				new Actor("bob", "cat"));
		System.out.println("liste d'acteurs : " + actors);
		var dicoActor = Lambdas.actorGroupByFirstName(actors);
		System.out.println("dico d'acteurs group�s : " + dicoActor);
		System.out.println();
		
		System.out.println("_ m�thode actorGroupBy :");
		var group1 = actorGroupBy(actors, Actor::firstName);  // groupe par pr�nom
		var group2 = actorGroupBy(actors, Actor::lastName);   // groupe par nom
		System.out.println("dico d'acteurs group�s par pr�nom : " + group1);
		System.out.println("dico d'acteurs group�s par nom : " + group2);
		System.out.println();
		
		System.out.println("_ m�thode groupBy :");
		var listint = List.of(42, 5, 666, 37, -65, 2, -26, -255, 256, -9, -72);
		System.out.println("liste d'entiers sign�s :" + listint);
		var dicoint = Lambdas.groupBy(listint, i->i>=0);
		System.out.println("dico d'entiers sign�s group�s par positivit�s :" + dicoint);
		System.out.println();
	}
	
}

/* Exercice 1 :
 * 
 * Q1/ Pour mettre une cha�ne en majuscules (ind�pendament de la langue dans laquelle l'OS est
 * 		configur�), on utilise la m�thode toUpperCase(Locale.ROOT()).
 * 
 * Q2/ L'interface fonctionnelle utilis�e par la m�thode list.replaceAll est unaryOperator.
 * 
 * Q3/ Cela correspond au type de fonction (T)->T (c'est un op�rateur unaire...).
 * 
 * Q4/ La m�thode replaceAll �tant appel�e sur une liste de String, le param�tre de la lambda est de
 * 		type String et son type de retour est aussi String.
 * 
 * 
 * Exercice 2 :
 * 
 * Q1/ Le param�tre de la m�thode occurences est de type List<String>.
 * 		La valeur de retour de la m�thode occurences est de type Map<Sring,int> // Integer ?
 * 
 * Q2/ Ici, on pourra choisir une HashMap comme implantation de la valeur de retour. L'ordre n'a �
 * 		priori pas d'int�r�t.
 * 
 * Q3/ La m�thode foreach prend un Consumer en param�tre. Cela correspond � un type fonction
 * 		(T)->void. Ici, les types de la lambda correspondant sont (String)->void.
 * 
 * Q4/ La m�thode merge prend une Bifunction en param�tre. Le type fonction correspondant est
 * 		(T,U)->V. Ici, les types de la lambda correspondants que l'on va utiliser sont
 * 		(Integer, Integer)->Integer.
 * 
 * Exercice 3 :
 * 
 * Q1/ Le param�tre de actorGroupByFirstName est de type List<Actor>.
 * 		La valeur de retour de actorGroupByFirstName est de type Map<String, List<Actor>>.
 * 
 * Q2/ La m�thode Map.computeIfAbsent ajoute une valeur � la Map si la cl� associ�e n'est pas encore
 * 		pr�sente (ne fais rien sinon). Elle utilise une Interface fonctionnelle (lambda) pour
 * 		calculer la nouvelle valeur. Dans tous les cas, elle renvoie la valeur associ�e � la cl�
 * 		(qu'elle soit pr�existante ou nouvellement calcul�e par la lambda).
 * 		Son second param�tre est une interface fonctionnelle de type Function. Cela correspond au
 * 		type fonctionnel (T)->U. Ici, T doit �tre un sur-type du type des cl�s. Et U doit �tre un
 * 		type d�riv� du type des valeurs.
 * 		Le premier param�tre est la cl� dont on doit tester la pr�sence. En cas d'abscence de
 * 		celle-ci, le second param�tre est une lambda qui calcule une valeur � partir de la cl� donn�e
 * 		en premier param�tre. Le couple (cl�, valeur) obtenu est alors ajout� � la Map (� moins que
 * 		la valeur ne soit null).
 * 		Dans notre cas, le premier param�tre sera le pr�nom des acteurs (cl�s) et le deuxi�me sera
 * 		une lambda qui � un pr�nom associe (et renvoie) la liste des acteurs portant ce pr�nom.
 * 
 * Q3/ Dans notre cas, la lambda pass�e en second param�tre doit �tre de type (String)->List<Actor>.
 * 
 * Q4/ ok normalement (� tester)
 * 
 * Q5/ Le type fonction du second param�tre doit �tre (T)->U. Et ici plus pr�cis�ment
 * 		(Actor)->String.
 * 		L'interface fonctionnelle correspondante est Function<T, U>.
 * 		Le type du second param�tre de actorGroupBy doit �tre Function<Actor, String>.
 */