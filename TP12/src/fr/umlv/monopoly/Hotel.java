package fr.umlv.monopoly;

public record Hotel (int rooms, double efficiency) implements Asset
{
	public Hotel
	{
		if (rooms < 0)
		{
			throw new IllegalArgumentException("Nombre de chambre négatif");
		}
		if (efficiency < 0 || efficiency >1)
		{
			throw new IllegalArgumentException("coefficient d'efficacité non valide");
		}
	}
	
	@Override
	public String toString ()
	{
		return "Hotel " + rooms + " rooms " + efficiency;
	}
	
	@Override
	public double profitPerNight ()
	{
		return 100*rooms*efficiency;
	}
	
}
