package fr.umlv.monopoly;

public sealed interface Asset permits Hotel, Apartment 
{
	public double profitPerNight ();
	public double efficiency ();
}
