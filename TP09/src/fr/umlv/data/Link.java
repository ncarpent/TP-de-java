package fr.umlv.data;


record Link<E> (E value, Link<E> next)
{
	
}

/*
record Link(Object value, Link next)
{
	
	public static void main(String[] args)
	{
		Link l1 = new Link(144, null);
		Link l2 = new Link(13, l1);
		System.out.println(l2);
	}
	
}
*/

/* 
 * Exercice 1 :
 * 
 * Q1/ Le record Link doit garder une visibilité par défaut.
 * 		Il sera disponible dans les fichiers du même package.
 * 
 * Q2/ javac fr.umlv.data.Link.java
 * 		java fr.umlv.data.Link
 * 		ok ???
 */