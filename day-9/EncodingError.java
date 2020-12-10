import java.util.*;
import java.io.*;

public class EncodingError
{
	public static void main(String[] args)
	{
		System.out.println(findXMASFault("numbers.txt"));
	}

	private static int findXMASFault(String filename)
	{
		int fault = 0;
		LinkedList<Integer> preamble = new LinkedList<Integer>();

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;
			int number;

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				number = Integer.parseInt(line);

				if (preamble.size() == 25)
				{
					if (!verifyNumber(preamble, number))
					{
						fault = number;
						break;
					}
					preamble.removeFirst();
				}

				preamble.add(number);
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return fault;
	}

	private static boolean verifyNumber(List<Integer> preamble, int number)
	{
		boolean isValid = false;

		for (int i = 0; i < preamble.size() - 1; i++)
		{
			for (int j = i + 1; j < preamble.size(); j++)
			{
				if (preamble.get(i) + preamble.get(j) == number)
				{
					isValid = true;
				}
			}
		}

		return isValid;
	}
}
