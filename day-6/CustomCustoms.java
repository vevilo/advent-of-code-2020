import java.util.*;
import java.io.*;

public class CustomCustoms
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

			Set<Character> answers = new HashSet<Character>();

			while (reader.hasNextLine())
			{
				line = reader.nextLine();

				for (int i = 0; i < line.length(); i++)
				{
					answers.add(line.charAt(i));
				}

				if (line.equals(""))
				{
					numAnswers += answers.size();
					answers.clear();
				}
			}

			numAnswers += answers.size();

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numAnswers;
	}
}
