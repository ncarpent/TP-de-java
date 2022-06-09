package fr.umlv.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssetManager
{
	
	List<Asset> assets = new ArrayList<Asset>();
	
	
	
	
	public void add (Asset asset)
	{
		assets.add(asset);
	}
	
	public double profitPerNight ()
	{
		
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
