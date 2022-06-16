//import java.util.ArrayList;
import java.util.Objects;
//import java.util.HashMap;
import java.util.LinkedHashMap;

public class Library {
	
	public static void main (String[] args) {
		var book = new Book("Da Vinci Code", "Dan Brown");
		var library = new Library();
		library.add(book);
		System.out.println(library.findByTitle("Da Vinci Code"));
		
		var library2 = new Library();
		library2.add(new Book("Da Vinci Code", "Dan Brown"));
		library2.add(new Book("Angels & Demons", "Dan Brown"));
		System.out.println(library2);
		library2.removeAllBooksFromAuthor("Dan Brown");
		System.out.println(library2);
	}
	
	
	// Exercice 3 :
	
	// Question 3 :
	
	public LinkedHashMap<String, Book> books;
	
	public Library () {
		books = new LinkedHashMap<String, Book>();
	}
	
	public void add (Book book) {
		Objects.requireNonNull(book);
		books.put(book.title(), book);
	}
	
	public Book findByTitle (String title) {
		return books.get(title);
	}
	
	// Question 5 :
	
	@Override
	public String toString ( ) {
		StringBuilder chaine = new StringBuilder("Bibliothèque :\n");
		for (var element : books.values()) {
			chaine.append(element).append("\n");
		}
		return chaine.toString();
	}
	
	// Questions 7 et 8 :
	
	public void removeAllBooksFromAuthor (String author) {
		/*// méthode erronnée
		for (var element : books.values()) {
			if (element.author().equals(author)) {
				books.remove(element.title());
			}
		}
		*/
		// bonne méthode
		var iter = books.values().iterator();
		while (iter.hasNext()) {
			var val = iter.next();
			if (val.author().equals(author)) {
				iter.remove();
			}
		}
	}
	
	// Question 9 :
	
	public void removeAllBooksFromAuthor2 (String author) {
		books.values().removeIf(b->b.author().equals(author));
	}
}

/*
 * Exercice 2 :
 * 
 * Q4/ Le compilateur compile une boucle foreach avec un Iterator.
 * 			foreach (Element e : liste) {doSomething(e);}
 * 		se traduit alors par :
 * 			iter = liste.iterator()
 * 			while (iter.hasNext())
 * 			{
 * 				Element e = iter.next();
 * 				doSometing(e);
 * 			}
 * Q5/ Si la méthode findByTitle levait une exception et dans le cas où on ne sait pas si l'élément
 * 		recherché est présent dans la liste, il faudrait parcourir une première fois la liste pour
 * 		savoir si l'élément est présent (auquel cas on peut utiliser findByTitle) et une deuxième
 * 		fois au travers de la méthode findByTitle.
 * 		En renvoyant null à la place, on parcourt au maximum une fois la liste complète.
 * 
 * Exercice 3 :
 * 
 * Q1/ La méthode findByTitle a une complexité en O(n).
 * 
 * Q2/ HashMap est une implantation d'une table de hashage.
 * 		On peut utiliser la classe HashMap à la place de ArrayList, de telle sorte que la recherche
 * 		se fasse avec la méthode get au lieu de parcourir toute une liste.
 * 		La méthode findByTitle devrait avoir une complexité en O(1).
 * 
 * Q4/ Les objets de type Library utilisent des données qui peuvent varier au cours du temps. On
 * 		devra donc utiliser une Class et non un Record.
 * 
 * Q5/ On doit utiliser la méthode values() pour obtenir l'ensemble des valeurs stockées dans
 * 		l'implantation de toString.
 * 
 * Q6/ Si l'on utilise la classe LinkedHashMap au lieu de HashMap, les éléments seront fournis dans
 * 		l'ordre d'insertion (notamment pour la méthode toString).
 * 
 * Q7/ L'implantation lève une exception avec l'exemple fourni car on supprime des éléments en
 * 		plein parcours. La taille est donc réduite au fur et à mesure, alors même que l'on tentera
 * 		d'accéder aux derniers éléments dans tous les cas.
 */





/*
public class Library {

	// Exercice 2 :
	
	// Question 1 :
	
	public ArrayList<Book> books;

	public Library () {
		books = new ArrayList<Book>();
	}

	// Question 2 :
	
	public void add (Book book) {
		Objects.requireNonNull(book);
		books.add(book);
	}

	// Question 3 :
	
	public Book findByTitle (String title) {
		for (var element : books) {
			if (element.title().equals(title)) {
				return element;
			}
		}
		return null;
	}

	// Question 6 :
	
	@Override
	public String toString ( ) {
		StringBuilder chaine = new StringBuilder("Bibliothèque :\n");
		for (var element : books) {
			chaine.append(element).append("\n");
		}
		return chaine.toString();
	}
}
 */
