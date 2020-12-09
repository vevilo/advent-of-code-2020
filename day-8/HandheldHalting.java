import java.util.*;
import java.io.*;

public class HandheldHalting
{
	public static void main(String[] args)
	{
		System.out.println(findAccumulatorValue("instructions.txt"));
	}

	private static int findAccumulatorValue(String filename)
	{
		int accValue = 0;
		int index = 0;
		List<String> instructions = new ArrayList<String>();
		boolean[] visitedInstructions;

		String code;
		char sign;
		int value;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;

			while (reader.hasNextLine())
			{
				line = reader.nextLine();
				instructions.add(line);
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		visitedInstructions = new boolean[instructions.size()];
		Arrays.fill(visitedInstructions, false);

		while (visitedInstructions[index] == false)
		{
			visitedInstructions[index] = true;

			code = instructions.get(index).substring(0,3);
			sign = instructions.get(index).charAt(4);
			value = Integer.parseInt(instructions.get(index).substring(5));

			switch (code)
			{
				case "acc":
				{
					if (sign == '+')
					{
						accValue += value;
					}
					else
					{
						accValue -= value;
					}

					index++;
					break;
				}
				case "jmp":
				{
					if (sign == '+')
					{
						index += value;
					}
					else
					{
						index -= value;
					}
					break;
				}
				default:
				{
					index++;
					break;
				}
			}
		}

		return accValue;
	}
}
