import java.util.*;
import java.io.*;

public class PasswordPolicyTwo
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

			int one, two;
			char specialCharacter;
			String password;

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				tokens = line.split("[- :]");

				one = Integer.parseInt(tokens[0]);
				two = Integer.parseInt(tokens[1]);
				specialCharacter = tokens[2].charAt(0);
				password = tokens[4];

				if (password.charAt(one - 1) == specialCharacter ^ password.charAt(two - 1) == specialCharacter)
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