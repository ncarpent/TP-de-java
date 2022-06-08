package fr.umlv.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssetManager
{
	
	List<Asset> assets = new ArrayList<Asset>();
	//List<Hotel> hotels = new ArrayList<Hotel>();
	//List<Apartment> apartments = new ArrayList<Apartment>();
	
	/*
	public void add (Hotel hotel)
	{
		hotels.add(hotel);
	}
	
	public void add (Apartment apartment)
	{
		apartments.add(apartment);
	}
	*/
	
	public void add (Asset asset)
	{
		assets.add(asset);
	}
	
	public double profitPerNight ()
	{
		/*
		double profit = 0;
		for (Hotel hotel : hotels)
		{
			profit += hotel.profitPerNight();
		}
		for (Apartment apartment : apartments)
		{
			profit += apartment.profitPerNight();
		}
		for (Asset asset : assets)
		{
			profit += asset.profitPerNight();
		}
		*/
		return assets.stream().mapToDouble(Asset::profitPerNight).sum();
	}
	
	public String toString ()
	{
		return "manager :\n|-" + assets.stream().map(Asset::toString).collect(
				Collectors.joining("\n|-"));
	}
	
	public List<Asset> lowestEfficiency (double efflim)
	{
		return assets.stream().filter(a->a.efficiency() <= efflim).toList();
	}
	
	public boolean remove (double efflim)
	{
		return assets.removeIf(a->a.efficiency() <= efflim);
	}
	
}
