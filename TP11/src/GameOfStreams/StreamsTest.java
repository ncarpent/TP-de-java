package GameOfStreams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsTest {

	/** Question 1 :
	 * Renvoie une cha�ne des caract�res contenant les entiers de la liste s�par�s par
	 * des points virgules.
	 * Par exemple, listIntegerToString(List.of(5,6,7,9)) renvoie "5;6;7;9".
	 */
	
	public static String listIntegerToString (List<Integer> list)
	{
		return list.stream().map(String::valueOf).collect(Collectors.joining(";"));
		//return null;
	}

	/** Question 2 :
	 * Renvoie la somme de toutes les longueurs des cha�nes de la liste.
	 * Par exemple, sumLength(List.of("ABC","DE","","F")) renvoie 6.
	 *
	 * Indication : la m�thode sum n'est disponible que sur les streams
	 * de types primitifs IntStream, LongStream... Vous pouvez utiliser
	 * mapToInt pour cr�er un IntStream au lieu d'un Stream<Integer>.
	 */

	public static int sumLength (List<String> list)
	{
		return list.stream().mapToInt(String::length).sum();
		//return 0;
	}

	/** Question 3 :
	 * Renvoie le nombre de cha�nes non vides du tableau
	 * Par exemple, String[] tab = {"ABC", "DE", "", "F"};
	 *              countNonEmpty(tab) renvoie 3.
	 *
	 * Indication : utilisez une des m�thodes Arrays.stream pour cr�er
	 * un stream � partir d'un tableau.
	 */

	public static long countNonEmpty (String[] array)
	{
		return Arrays.stream(array).map(Optional::ofNullable).filter(
				Optional::isPresent).map(Optional::get).filter(s->s.length()>0).count();
		/* On peut aussi retirer la m�thode 
		 * .map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
		 * si l'on consid�re que les tableaux fournis n'adm�tent pas de null.
		 */
		//return 0L;
	}

	/** Question 4 :
	 * Renvoie la somme des entiers du tableau
	 * Par exemple, sum(Array.of(5, 8, -1, 2)) renvoie 14.
	 */

	public static long sum (int[] tab)
	{
		return Arrays.stream(tab).sum();
		//return 0L;
	}

	/** Question 5 :
	 * Renvoie la liste des cha�nes mises en majuscules.
	 */
	
	public static List<String> capitalizeList (List<String> list)
	{
		return list.stream().map(s->s.toUpperCase(Locale.ROOT)).toList();
		//return null;
	}

	/** Question 6 :
	 * Renvoie une Map qui associe � chaque caract�re la liste des cha�nes
	 * commen�ant par ce caract�re.
	 * Par exemple, mapByFirstCharacter(List.of("AB", "A", "BA", "C")) renvoie
	 * une map qui associe au caract�re 'A' la liste ["AB","A"],
	 * au caract�re 'B' la liste ["BA"] et au caract�re 'C' la liste ["C"].
	 *
	 * Indication : utilisez Collectors.groupingBy. Et ausi, attention aux cha�nes vides.
	 */
	
	public static Map<Character,List<String>> mapByFirstCharacter (List<String> list)
	{
		return list.stream().map(Optional::ofNullable).filter(Optional::isPresent).map(
				Optional::get).filter(s->!s.isEmpty()).collect(
				Collectors.groupingBy(s->s.charAt(0),Collectors.toList()));
		/* On peut aussi retirer la m�thode 
		 * .map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
		 * si l'on consid�re que les tableaux fournis n'adm�tent pas de null.
		 */
		//return null;
	}

	/** Question 7 :
	 * Renvoie une map qui associe � chaque caract�re l'ensemble des cha�nes commen�ant
	 * par ce caract�re.
	 * Par exemple, mapByFirstCharacterSet(List.of("AB","A","BA","C")) renvoie une map
	 * qui associe au caract�re 'A' l'ensemble {"AB","A"}, au caract�re 'B' l'ensemble
	 * {"BA"} et au caract�re 'C' l'ensemble {"C"}.
	 */
	
	public static Map<Character, Set<String>> mapByFirstCharacterSet (List<String> list)
	{
		return list.stream().map(Optional::ofNullable).filter(Optional::isPresent).map(
				Optional::get).filter(s->!s.isEmpty()).collect(
				Collectors.groupingBy(s->s.charAt(0), Collectors.toSet()));
		/* On peut aussi retirer la m�thode 
		 * .map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
		 * si l'on consid�re que les tableaux fournis n'adm�tent pas de null.
		 */
		//return null;
	}

	/** Question 8 :
	 * Renvoie une map qui associe � chaque caract�re le nombre de cha�nes commen�ant
	 * par ce caract�re.
	 * Par exemple, countByFirstCharacter(List.of("AB","A","BA","C")) renvoie une map
	 * qui associe au caract�re 'A' la valeur 2, au caract�re 'B' la valeur 1 et au
	 * caract�re 'C' la valeur 1.
	 */
	
	public static Map<Character, Long> countByFirstCharacter (List<String> list)
	{
		return list.stream().map(Optional::ofNullable).filter(Optional::isPresent).map(
				Optional::get).filter(s->!s.isEmpty()).collect(
				Collectors.groupingBy(s->s.charAt(0), Collectors.counting()));
		/* On peut aussi retirer la m�thode 
		 * .map(Optional::ofNullable).filter(Optional::isPresent).map(Optional::get)
		 * si l'on consid�re que les tableaux fournis n'adm�tent pas de null.
		 */
		//return null;
	}

	/** Question 9 :
	 * Renvoie la liste de String priv�e de son premier �l�ment.
	 * Indication : utilisez Stream.skip.
	 */

	public static List<String> withoutFirstElement (List<String> list)
	{
		return list.stream().skip(1).toList();
		//return null;
	}

	/** Question 10 :
	 * Renvoie la liste de T priv�e de son premier �l�ment.
	 * Maintenant cette m�thode peut �tre appliqu�e � n'importe quel type de List
	 * List<Integer>, ...
	 */

	public static <T> List<T> withoutFirstElementBetter (List<T> list)
	{
		return list.stream().skip(1).toList();
		//return null;
	}

	/** Question 11 :
	 * Renvoie la liste des mots de la cha�ne prise en argument.
	 * Par exemple, words("Abc def   i") renvoie ["Abc","def","i"]
	 * Indication : utilisez String.split() et �liminez les cha�nes vides.
	 */

	public static List<String> words (String s)
	{
		return Arrays.stream(s.split(" ")).filter(c->c.length()>0).toList();
		//return null;
	}

	/** Question 12 :
	 * Renvoie l'ensemble des mots apparaissant dans la liste de cha�nes prise en argument.
	 * Par exemple, words(List.of("Abc def i","def i","Abc de")) renvoie l'ensemble
	 * {"Abc","def","i","de"}.
	 * Indication : utilisez Stream.flatmap.
	 */

	public static Set<String> words (List<String> list)
	{
		return list.stream().flatMap(s->Arrays.stream(s.split(" "))).collect(Collectors.toSet());
		//return null;
	}

	/** Question 13 :
	 * Renvoie l'ensemble des cha�nes apparaissant dans la liste d'Optional<String>
	 * prise en argument.
	 * Par exemple, unpack(List.of(Optional.empty(),Optional.of("A"),Optional.of("B"),
	 * Optional.of("A"))) renvoie l'ensemble {"A","B"}.
	 *
	 * Indication : les Optional peuvent �tre transform�s en Stream avec Optional.stream().
	 */

	public static Set<String> unpack (List<Optional<String>> list)
	{
		return list.stream().filter(Optional::isPresent).map(Optional::get).collect(
				Collectors.toSet());
		//return null;
	}

	/** Question 14 :
	 * Renvoie une Map comptant le nombre d'occurences de chaque caract�re dans la cha�ne.
	 * Par exemple, occurrences("ABBAAABBB") renvoie la map qui associe au caract�re 'A' la valeur
	 * 4 et au caract�re 'B' la valeur 5.
	 *
	 * Indication : vous pouvez utiliser s.chars().mapToObj( c-> (char) c) obtenir un
	 * Stream<Character> � partir d'une cha�ne.
	 */

	public static Map<Character,Long> occurrences (String s)
	{
		return s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
		//return null;
	}

	public static void main(String[] args) {
		// Question 1 :
		System.out.println("Question 1 :\n" + listIntegerToString(List.of(5,6,7,9)));
		// Question 2 :
		System.out.println("Question 2 :\n" + sumLength(List.of("ABC","DE","","F")));
		// Question 3 :
		String[] tab = {"ABC","DE","","F"};
		System.out.println("Question 3 :\n" + countNonEmpty(tab));
		// Question 4 :
		int[] tab2 = {2,3};
		System.out.println("Question 4 :\n" + sum(tab2));
		// Question 5 :
		System.out.println("Question 5 :\n" + capitalizeList(List.of("bonjour","aurevoir")));
		// Question 6 :
		System.out.println("Question 6 :\n" + mapByFirstCharacter(List.of("AB","A","BA","C")));
		// Question 7 :
		System.out.println("Question 7 :\n" + mapByFirstCharacterSet(List.of("AB","A","BA","C")));
		// Question 8 :
		System.out.println("Question 8 :\n" + countByFirstCharacter(List.of("AB","A","BA","C")));//
		// Question 9 :
		System.out.println("Question 9 :\n" + withoutFirstElement(List.of("A","B","C")));//
		// Question 10 :
		System.out.println("Question 10 :\n" + withoutFirstElementBetter(List.of(1,2,4)));//
		// Question 11 :
		System.out.println("Question 11 :\n" + words("Abc def   i"));//
		// Question 12 :
		System.out.println("Question 12 :\n" + words(List.of("Abc def i","def i","Abc de")));//
		// Question 13 :
		System.out.println("Question 13 :\n" + unpack(List.of(Optional.empty(),Optional.of("A"),Optional.of("B"),Optional.of("A"))));//
		// Question 14 :
		System.out.println("Question 14 :\n" + occurrences("AABBBAABB"));//
		//String s = null; boolean b = s.isEmpty();System.out.println(b);
		//HashSet<String> s = new HashSet<String>(); s.add("bonjour");System.out.println(s);
		//String[] tabs = {"hello", null, "world", ""};
		//System.out.println(List.of(tabs));
		}
}