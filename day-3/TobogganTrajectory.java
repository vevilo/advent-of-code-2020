import java.util.*;
import java.io.*;

public class TobogganTrajectory
{
	public static void main(String[] args)
	{
		System.out.println(countTreeCollisions("treemap.txt", 1, 2));
	}

	private static int countTreeCollisions(String filename, int right, int down)
	{
		int numTrees = 0;

		try
		{
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			String line;
			int currentX = 0;

			line = reader.nextLine();
			if (line.charAt(currentX) == '#')
			{
				numTrees++;
			}

			while (reader.hasNextLine())
			{
				for (int i = 0; i < down; i++)
				{
					line = reader.nextLine();
				}

				currentX = (currentX + right) % line.length();

				if (line.charAt(currentX) == '#')
				{
					numTrees++;
				}
			}

			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error occurred!");
		}

		return numTrees;
	}
}
