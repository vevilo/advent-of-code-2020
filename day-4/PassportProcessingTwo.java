import java.util.*;
import java.io.*;

public class PassportProcessingTwo
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

			Set<String> requiredFields = new HashSet<String>();
			Set<String> presentFields = new HashSet<String>();

			requiredFields.add("byr");
			requiredFields.add("iyr");
			requiredFields.add("eyr");
			requiredFields.add("hgt");
			requiredFields.add("hcl");
			requiredFields.add("ecl");
			requiredFields.add("pid");
			requiredFields.add("cid");

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				tokens = line.split("[: ]");

				for (int i = 0; i < tokens.length; i += 2)
				{
					if (requiredFields.contains(tokens[i]))
					{
						presentFields.add(tokens[i]);
					}
				}

				if (line.equals(""))
				{
					if (validatePassport(presentFields))
					{
						numValidPassports++;
					}
					presentFields.clear();
				}
			}

			if (validatePassport(presentFields))
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

	private static boolean validatePassport(Set<String> passport)
	{
		boolean isValid = false;
		if (passport.size() == 8 || passport.size() == 7 && !passport.contains("cid"))
		{
			isValid = true;
		}

		return isValid;
	}
}
