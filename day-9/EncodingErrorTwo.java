import java.util.*;
import java.io.*;

public class EncodingErrorTwo
{
	public static void main(String[] args)
	{
		System.out.println(sumXMASFault("numbers.txt", 144381670));
	}

	private static int sumXMASFault(String filename, int target)
	{
		int sum = 0;
		int lowIndex = 0;
		int highIndex = lowIndex + 1;
		int smallest = target;
		int largest = 0;
		int number = 0;
		List<Integer> numbers = new LinkedList<Integer>();

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;

			while (reader.hasNextLine() && number != target)
			{
				line = reader.nextLine();
				number = Integer.parseInt(line);
				numbers.add(number);
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		while (sumList(numbers, lowIndex, highIndex) != target)
		{
			if (sumList(numbers, lowIndex, highIndex) > target)
			{
				lowIndex++;
				highIndex = lowIndex + 1;
			}

			highIndex++;
		}

		for (int i = lowIndex; i <= highIndex; i++)
		{
			number = numbers.get(i);

			if (number < smallest)
			{
				smallest = number;
			}
			else if (number > largest)
			{
				largest = number;
			}
		}

		sum = smallest + largest;
		return sum;
	}

	private static int sumList(List<Integer> numbers, int low, int high)
	{
		int sum = 0;

		for (int i = low; i <= high; i++)
		{
			sum += numbers.get(i);
		}

		return sum;
	}
}
