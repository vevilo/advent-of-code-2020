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
		List<Bag> bagHolders = new LinkedList<Bag>();
		List<Bag> allBags = new LinkedList<Bag>();

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
				allBags.add(new Bag(tokens));
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}
		
		for (Bag bag : allBags) // Add bags that contain 'shiny gold'
		{
			if (bag.containsBag(colour))
			{
				bagHolders.add(bag);
			}
		}

		for (int i = 0; i < bagHolders.size(); i++) // Add bags that contain bags that contain 'shiny gold'
		{
			for (Bag bag : allBags)
			{
				if (bag.containsBag(bagHolders.get(i).getColour()))
				{
					bagHolders.add(bag);
				}
			}

			for (Bag usedBag : bagHolders) // Remove used bags
			{
				allBags.remove(usedBag);
			}
		}

		return bagHolders.size();
	}
}
