import java.util.*;
import java.io.*;

public class HandyHaversacks
{
	public static void main(String[] args)
	{
		System.out.println(countBagsThatCanHold("bagrules.txt", "shiny gold"));
	}

	private static int countBagsThatCanHold(String filename, String colour)
	{
		Set<String> bagHolders = new HashSet<String>();
		List<String[]> allBags = new LinkedList<String[]>();

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;
			String tokens[];

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				tokens = line.split(" bags contain | bag(s)?(,|\\.| )+");
				allBags.add(tokens);
			}

			for (String[] bag : allBags) // Add direct holders
			{
				addBagHolders(bagHolders, bag, colour);
			}

			for (Object bagColour : bagHolders.toArray()) // Add indirect holders
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}
			for (Object bagColour : bagHolders.toArray())
			{
				for (String[] bag : allBags)
				{
					addBagHolders(bagHolders, bag, (String) bagColour);
				}
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return bagHolders.size();
	}

	private static void addBagHolders(Set<String> bags, String[] thisBag, String colour)
	{
		String holds;

		for (int i = 1; i < thisBag.length; i++)
		{
			holds = getBagColour(thisBag[i]);
			if (holds.equals(colour))
			{
				bags.add(thisBag[0]);
			}
		}
	}

	private static String getBagColour(String bag)
	{
		return bag.substring(2);
	}
}
