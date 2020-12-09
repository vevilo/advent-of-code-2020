import java.util.*;

public class Bag
{
	private String colour;
	private TreeMap<String, Integer> internalBags;

	public Bag(String[] details)
	{
		colour = details[0];

		internalBags = new TreeMap<String, Integer>();
		for (int i = 1; i < details.length; i++)
		{
			if (details[i].substring(0,1).matches("[0-9]"))
			{
				internalBags.put(details[i].substring(2), Integer.parseInt(details[i].substring(0,1)));
			}
			else
			{
				internalBags.put("none", 0);
			}
		}
	}

	public String getColour()
	{
		return colour;
	}

	public boolean containsBag(String colour)
	{
		return internalBags.containsKey(colour);
	}

	public Map<String, Integer> pullBag()
	{
		return internalBags.pollFirstEntry();
	}

	public boolean isEmpty()
	{
		boolean isEmpty = true;

		if (!internalBags.containsValue(0))
		{
			isEmpty = false;
		}

		return isEmpty;
	}

	public String toString()
	{
		String out = colour + " |";

		for (String bagColour : internalBags.keySet())
		{
			out += " " + bagColour;
		}

		return out;
	}
}
