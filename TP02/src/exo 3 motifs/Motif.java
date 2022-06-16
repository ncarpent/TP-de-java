import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Motif 
{
	public static void main (String[] args)
	{
		/*
		Pattern pat = Pattern.compile("[0-9]+");
		for (String elem : args)
		{
			Matcher mat = pat.matcher(elem);
			if (mat.find() && mat.end() == elem.length())
			{
				System.out.println(elem);
				System.out.println(mat.start() + " " + mat.end() + " " + mat.group());
				System.out.println();
			}			
		}
		*/
		byte[] tab = extraireIPv4(args[0]);
		Motif.afficheTab(tab);
	}
	
	public static byte[] extraireIPv4 (String text)
	{
		Pattern pat = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
		Matcher mat = pat.matcher(text);
		if (! mat.find())
		{
			throw new IllegalArgumentException("Le paramètre ne contient pas d'adresse IPv4.");
		}
		
		String adresse = mat.group();
		System.out.print("adresse : ");
		System.out.println(adresse);
		System.out.println();
		
		byte[] tab = new byte[4];
		String[] stab = adresse.split("\\.");
		Motif.afficheTab(stab);
		
		for (int i=0 ; i<4 ; i++)
		{
			int k = Integer.parseInt(stab[i]);
			if (k>255)
			{
				throw new IllegalArgumentException("L'adresse IPv4 est invalide : contient un nombre supérieur à 255.");
			}
			tab[i] = (byte) k;
		}
		return tab;
	}
	
	
	public static void afficheTab (String[] tab)
	{
		System.out.println("Tableau de String : ");
		for (int k=0 ; k<tab.length ; k++)
		{
			System.out.println(tab[k]);
		}
		System.out.println();
	}
	
	
	public static void afficheTab (byte[] tab)
	{
		System.out.println("Tableau de byte : ");
		for (int k=0 ; k<tab.length ; k++)
		{
			System.out.println(tab[k]);
		}
		System.out.println();
	}
}