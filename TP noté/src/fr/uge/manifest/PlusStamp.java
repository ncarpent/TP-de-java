package fr.uge.manifest;

public record PlusStamp (int category) implements Stamp
{
	
	public PlusStamp
	{
		if (category < 1 || category > 5)
		{
			throw new IllegalStateException ("catégorie invalide");
		}
	}
	
}
