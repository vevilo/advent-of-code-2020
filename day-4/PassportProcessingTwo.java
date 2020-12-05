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
						if (validatePassport(passport))
						{
							numValidPassports++;
						}
					}
					passport.clear();
				}
			}

			if (passport.size() == 8 || passport.size() == 7 && !passport.containsKey("cid"))
			{
				if (validatePassport(passport))
				{
					numValidPassports++;
				}
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numValidPassports;
	}

	private static boolean validatePassport(Map<String, String> passport)
	{
		boolean isValid = true;

		int byr = Integer.parseInt(passport.get("byr"));
		int iyr = Integer.parseInt(passport.get("iyr"));
		int eyr = Integer.parseInt(passport.get("eyr"));
		String hgt = passport.get("hgt");
		int hgtMeasurement;
		String hgtUnit = hgt.substring(hgt.length() - 2);
		String hcl = passport.get("hcl");
		String ecl = passport.get("ecl");
		String pid = passport.get("pid");

		if (byr < 1920 || byr > 2002)
		{
			isValid = false;
		}
		if (iyr < 2010 || iyr > 2020)
		{
			isValid = false;
		}
		if (eyr < 2020 || eyr > 2030)
		{
			isValid = false;
		}
		if (hgt.substring(0, hgt.length() - 2).matches("[0-9]+"))
		{
			hgtMeasurement = Integer.parseInt(hgt.substring(0, hgt.length() - 2));

			if ((hgtUnit.equals("cm") && hgtMeasurement < 150 || hgtMeasurement > 193) ||
			    (hgtUnit.equals("in") && (hgtMeasurement < 59 || hgtMeasurement > 76)))
			{
				isValid = false;
			}
		}
		else
		{
			isValid = false;
		}
		if (!hcl.matches("#[0-9|a-f]{6}"))
		{
			isValid = false;
		}
		if (!ecl.matches("amb|blu|brn|gry|grn|hzl|oth"))
		{
			isValid = false;
		}
		if (!pid.matches("[0-9]{9}"))
		{
			isValid = false;
		}

		if (isValid)
		{
			System.out.println(byr + " " + iyr + " " + eyr + " " + hgt + " " + hcl + " " + ecl + " " + pid);
		}

		return isValid;
	}
}
