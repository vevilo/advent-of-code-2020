import java.util.*;
import java.io.*;

public class BinaryBoardingTwo
{
	public static void main(String[] args)
	{
		TreeSet<Integer> allSeats = new TreeSet<Integer>();
		storeSeats("boardingpasses.txt", allSeats);

		int realSum = 0;
		for (int id : allSeats)
		{
			realSum += id;
		}

		int sum = 0;
		for (int i = allSeats.first(); i <= allSeats.last(); i++)
		{
			sum += i;
		}

		System.out.println(sum - realSum);
	}

	private static void storeSeats(String filename, Set<Integer> allSeats)
	{
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
				allSeats.add(seatID);
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}
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