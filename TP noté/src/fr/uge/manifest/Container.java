package fr.uge.manifest;

import java.util.Objects;

public record Container(String destination, int weight, Stamp stamp)
{
	
	public Container
	{
		Objects.requireNonNull(destination);
		if (weight < 0)
		{
			throw new IllegalArgumentException("poids négatif");
		}
	}
	
	public Container (String destination, int weight)
	{
		this(destination, weight, null);
	}
	
	
	
	@Override
	public String toString ()
	{
		String aff = destination + " " + Integer.toString(weight);
		if (stamp != null)
		{
			if (stamp.getClass() == StarStamp.class) {aff += " *";}
			if (stamp.getClass() == PlusStamp.class) {aff += " " + "+".repeat(((PlusStamp) stamp).category());}
		}
		return aff;
	}
	
}
