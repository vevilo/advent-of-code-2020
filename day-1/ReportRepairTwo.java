import java.util.*;
import java.io.*;

public class ReportRepairTwo
{
	public static void main(String[] args)
	{
		final int SUM = 2020;
		int[] expenses = new int[200];

		readFileToIntArray("report.txt", expenses);

		for (int i = 0; i < expenses.length; i++)
		{
			for (int j = i + 1; j < expenses.length; j++)
			{
				for (int k = j + 1; k < expenses.length; k++)
				{
					if (expenses[i] + expenses[j] + expenses[k] == SUM)
					{
						System.out.println(expenses[i] * expenses[j] * expenses[k]);
					}
				}
			}
		}
	}

	private static void readFileToIntArray(String filename, int[] array)
	{
		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			int lineNum = 0;

			while (reader.hasNextLine())
			{
				array[lineNum] = Integer.parseInt(reader.nextLine());
				lineNum++;
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}
	}
}