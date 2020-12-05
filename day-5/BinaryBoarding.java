import java.util.*;
import java.io.*;

public class BinaryBoarding
{
	public static void main(String[] args)
	{
		System.out.println(findHighestID("boardingpasses.txt"));
	}

	private static int findHighestID(String filename)
	{
		int highestID = 0;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;

			String row;
			String column;
			int seatID;

			while (reader.hasNextLine())
			{
				line = reader.nextLine();

				row = line.substring(0, 7);
				column = line.substring(7);

				seatID = findBSPValue(row, 'F') * 8 + findBSPValue(column, 'L');

				if (seatID > highestID)
				{
					highestID = seatID;
				}
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return highestID;
	}

	private static int findBSPValue(String bsp, char lowerIndicator)
	{
		int high = (int) Math.pow(2, bsp.length()) - 1;
		int low = 0;
		int diff = (int) Math.pow(2, bsp.length() - 1);

		for (int i = 0; i < bsp.length(); i++)
		{
			if (bsp.charAt(i) == lowerIndicator)
			{
				high -= diff; 
			}
			else
			{
				low += diff;
			}
			diff /= 2;
		}

		return high;
	}
}