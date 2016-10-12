import java.util.Random;

public class BingoGame {
	BingoCard bingo;
	public static final int NUMBER_LIMIT = 75;
	int[] numbersToCall;
	int calledNumberCount = 0;
	
	public BingoGame() {
			
		numbersToCall = new int[75];
		
		for (int index=0; index < NUMBER_LIMIT; index++)
		{
			numbersToCall[index] = index + 1;
		}
		
		bingo = new BingoCard(numbersToCall);
		//System.out.println(bingo.toString());
		
	}
	
	public int playBingo() {
		
		while (bingo.checkForBingo() == null && calledNumberCount <= 75)
		{
			callRandomNumber();
			//System.out.println(bingo.toString());
		}
		
		if (bingo.checkForBingo() != null)
		{
			return calledNumberCount;
		}
		else
		{
			return 0;
		}
		//System.out.println(bingo.checkForBingo());
	}

	public void callRandomNumber() {
		
		Random generator = new Random();
		
		boolean validNumber = false;
		
		//int calledNumberIndex = generator.nextInt(NUMBER_LIMIT);
		int calledNumber = 0;
		
		while (!validNumber)
		{
			int calledNumberIndex = generator.nextInt(NUMBER_LIMIT);
			if (numbersToCall[calledNumberIndex] > 0)
			{
				calledNumber = numbersToCall[calledNumberIndex];
				numbersToCall[calledNumberIndex] *= -1;
				validNumber = true;
				calledNumberCount++;
			}
		}
		
		//System.out.println("The next number is: " + calledNumber);
		
		bingo.checkForMatch(calledNumber);
		
	}
	
}
