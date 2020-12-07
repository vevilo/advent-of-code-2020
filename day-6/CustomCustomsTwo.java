import java.util.*;
import java.io.*;

public class CustomCustomsTwo
{
	public static void main(String[] args)
	{
		System.out.println(countAnswers("declarationforms.txt"));
	}

	private static int countAnswers(String filename)
	{
		int numAnswers = 0;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;

			List<String> answers = new LinkedList<String>();

			while (reader.hasNextLine())
			{
				line = reader.nextLine();

				if (line.equals(""))
				{
					numAnswers += intersectionSet(answers);
					answers.clear();
				}
				else
				{
					answers.add(line);
				}
			}

			numAnswers += intersectionSet(answers);

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numAnswers;
	}

	private static int intersectionSet(List<String> answers)
	{
		Set<Character> intersection = new HashSet<Character>();
		Set<Character> temp = new HashSet<Character>();

		for (char individual : answers.get(0).toCharArray())
		{
			intersection.add(individual);
		}

		for (int i = 0; i < answers.size(); i++)
		{
			for (char individual : answers.get(i).toCharArray())
			{
				temp.add(individual);
			}

			intersection.retainAll(temp);
			temp.clear();
		}

		return intersection.size();
	}
}