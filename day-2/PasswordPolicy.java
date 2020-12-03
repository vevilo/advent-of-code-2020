import java.util.*;
import java.io.*;

public class PasswordPolicy
{
	public static void main(String[] args)
	{
		System.out.println(validatePasswords("passwords.txt"));
	}

	private static int validatePasswords(String filename)
	{
		int numValidPasswords = 0;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String[] tokens;
			String line;

			int min, max, total;
			char specialCharacter;

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				tokens = line.split("[- :]");

				min = Integer.parseInt(tokens[0]);
				max = Integer.parseInt(tokens[1]);
				specialCharacter = tokens[2].charAt(0);
				total = 0;

				for (int i = 0; i < tokens[4].length(); i++)
				{
					if (tokens[4].charAt(i) == specialCharacter)
					{
						total++;
					}
				}

				if (total >= min && total <= max)
				{
					numValidPasswords++;
				}
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numValidPasswords;
	}
}