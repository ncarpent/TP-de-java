package fr.uge.manifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Manifest
{
	
	private ArrayList<Container> containers = new ArrayList<Container>();
	
	public void add (Container c)
	{
		Objects.requireNonNull(c);
		containers.add(c);
	}
	
	public int weight ()
	{
		int w = 0;
		for(Container c : containers)
		{
			w += c.weight();
		}
		return w;
	}
	
	public void removeAllContainersFrom (String destination)
	{
		var iter = containers.iterator();
		while (iter.hasNext())
		{
			Container c = iter.next();
			if (c.destination().equals(destination))
			{
				iter.remove();
			}
		}
	}
	
	private void valid (Map<String, Integer> dic)
	{
		for (var entry : dic.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
			Objects.requireNonNull(key);
			Objects.requireNonNull(value);
			if (value < 0) {throw new IllegalStateException("prix négatif");}
		}
	}
	
	public int price (Map<String, Integer> dic, int def)
	{
		valid(dic);
		int pay = 0;
		for (Container c : containers)
		{
			int pay_c = dic.getOrDefault(c.destination(), def);
			if (c.stamp() != null) // réduction applicable
			{
				if (c.stamp().getClass() == StarStamp.class)
				{
					pay_c = Integer.max(pay_c - 200, 0);
				}
				if (c.stamp().getClass() == PlusStamp.class)
				{
					int p_reduc = 10 * ((PlusStamp) c.stamp()).category();
					pay_c = (int) (pay_c * (1 - (double)p_reduc / 100));
				}
			}
			pay += pay_c;
		}
		return pay;
	}
	
	public Map<String, Integer> weightPerDestination ()
	{
		var dico = new HashMap<String, Integer>();
		for (Container c : containers)
		{
			int w;
			if (dico.get(c.destination()) == null)
			{
				dico.put(c.destination(), c.weight());
			}
			else
			{
				w = dico.get(c.destination()) + c.weight();
				dico.put(c.destination(), w);
			}
		}
		return dico;
	}
	
	@Override
	public String toString ()
	{
		StringBuffer aff = new StringBuffer("");
		for (int i=0 ; i < containers.size() ; i++)
		{
			aff.append(i+1).append(". ").append(containers.get(i).toString()).append("\n");
		}
		return aff.toString();
	}
}
