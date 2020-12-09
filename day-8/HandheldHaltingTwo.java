import java.util.*;
import java.io.*;

public class HandheldHaltingTwo
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
		int changeInstruction = 1;
		int changeCounter = 0;

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

		while (index < instructions.size())
		{
			accValue = 0;
			index = 0;
			changeCounter = 0;
			Arrays.fill(visitedInstructions, false);

			while (index < instructions.size() && visitedInstructions[index] == false)
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
						changeCounter++;
						if (changeCounter != changeInstruction)
						{
							if (sign == '+')
							{
								index += value;
							}
							else
							{
								index -= value;
							}
						}
						else
						{
							index++;
						}
						break;
					}
					default:
					{
						changeCounter++;

						if (changeCounter == changeInstruction)
						{
							if (sign == '+')
							{
								index += value;
							}
							else
							{
								index -= value;
							}
						}
						index++;
						break;
					}
				}
			}

			changeInstruction++;
		}

		return accValue;
	}
}
