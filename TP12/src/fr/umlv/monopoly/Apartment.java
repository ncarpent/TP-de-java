package fr.umlv.monopoly;

import java.util.List;
import java.util.stream.Collectors;

public record Apartment (int area, List<String> persons) implements Asset
{
	
	public Apartment (int area, List<String> persons)
	{
		if (area <= 0)
		{
			throw new IllegalArgumentException("aire négative ou nulle");
		}
		if (persons.size() == 0)
		{
			throw new IllegalArgumentException("aucune personne dans l'appartement");
		}
		this.area = area;
		this.persons = List.copyOf(persons);
	}
	
	private String listPersons ()
	{
		return persons.stream().collect(Collectors.joining(", "));
	}
	
	public double efficiency ()
	{
		if (persons.size() == 1)
		{
			return 0.5;
		}
		else
		{
			return 1;
		}
	}
	
	@Override
	public String toString ()
	{
		return "Apartment " + area + " m2 with " + listPersons() + " " + efficiency();
	}
	
	@Override
	public double profitPerNight ()
	{
		return 20*persons.size()*efficiency();
	}
	
}
