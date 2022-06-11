package fr.umlv.data;

public class LinkedLink<E>
{
	private Link<E> first = null;
	private int size = 0;
	
	
	
	public void add (E value)
	{
		first = new Link<E>(value, first);
		size++;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder retour = new StringBuilder("[");
		Link<E> l = first;
		if (l == null)
		{
			retour.append(" ]");
		}
		else
		{
			while (l.next() != null)
			{
				retour.append(l.value() + ", ");
				l = l.next();
			}
			retour.append(l.value() + "]");
		}
		return retour.toString();
	}
	
	public E get (int index)
	{
		if (index < 0) {throw new IndexOutOfBoundsException("indice négatif");}
		if (index >= size) {throw new IndexOutOfBoundsException("indice supérieur à la taille de la liste");}
		Link<E> linkit = first;
		for (int i=0 ; i<index ; i++)
		{
			linkit = linkit.next();
		}
		return linkit.value();
	}
	
	public boolean contains (Object o) //o doit être de type Object ??? car on peut demander
	// théoriquement pour n'importe quel objet ?? à tester...
	// si l'on ne connaît pas exactement le type de la liste ?...
	{
		Link<E> linkit = first;
		for (int i=0 ; i<size ; i++, linkit = linkit.next())
		{
			if (linkit.value().equals(o))
			{
				return true;
			}
		}
		return false;
	}
	
}

/*
public class LinkedLink
{
	private Link first = null;
	private int size = 0;
	
	
	
	public void add (Object value)
	{
		first = new Link(value, first);
		size++;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder retour = new StringBuilder("[");
		Link l = first;
		if (l == null)
		{
			retour.append(" ]");
		}
		else
		{
			while (l.next() != null)
			{
				retour.append(l.value() + ", ");
				l = l.next();
			}
			retour.append(l.value() + "]");
		}
		return retour.toString();
	}
	
	public Object get (int index)
	{
		if (index < 0) {throw new IndexOutOfBoundsException("indice négatif");}
		if (index >= size) {throw new IndexOutOfBoundsException("indice supérieur à la taille de la liste");}
		Link linkit = first;
		for (int i=0 ; i<index ; i++)
		{
			linkit = linkit.next();
		}
		return linkit.value();
	}
	
}
*/
