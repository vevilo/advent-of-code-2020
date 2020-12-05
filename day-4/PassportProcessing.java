import java.util.*;
import java.io.*;

public class PassportProcessing
{
	public static void main(String[] args)
	{
		System.out.println(countValidPassports("passports.txt"));
	}

	private static int countValidPassports(String filename)
	{
		int numValidPassports = 0;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;
			String[] tokens;

			Map<String, String> passport = new HashMap<String, String>();

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				tokens = line.split("[: ]");

				if (!line.equals(""))
				{
					for (int i = 0; i < tokens.length; i += 2)
					{
						passport.put(tokens[i], tokens[i + 1]);
					}
				}
				else
				{
					if (passport.size() == 8 || passport.size() == 7 && !passport.containsKey("cid"))
					{
						numValidPassports++;
					}
					passport.clear();
				}
			}

			if (passport.size() == 8 || passport.size() == 7 && !passport.containsKey("cid"))
			{
				numValidPassports++;
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numValidPassports;
	}
}
