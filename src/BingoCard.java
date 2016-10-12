import java.util.Random;

public class BingoCard {
	private static final int NO_OF_ROWS = 5;
	private static final int NO_OF_COLUMNS = 5;
	int[][] bingoCard;		
	String currentState;
	int[] numbersToUse;
	
	public BingoCard(int[] numbers) {
		
		numbersToUse = numbers.clone();
		bingoCard = new int[NO_OF_ROWS][NO_OF_COLUMNS];
		
		Random generator = new Random();
		
		for (int rowIndex = 0; rowIndex < bingoCard.length; rowIndex++)
		{
			for (int columnIndex = 0; columnIndex < bingoCard[rowIndex].length; columnIndex++)
			{
				
				boolean validNumber = false;
					
				while (!validNumber)
				{
					int numberIndex = (15*columnIndex) + generator.nextInt(15);
					
					if (numbersToUse[numberIndex] > 0)
					{
						bingoCard[rowIndex][columnIndex] = numbersToUse[numberIndex];
						numbersToUse[numberIndex] *= -1;
						validNumber = true;
					}
						
				}				
			}
		}		
	}
	
	public boolean checkForMatch(int calledNumber) {
		
		for (int rowIndex = 0; rowIndex < bingoCard.length; rowIndex++)
		{
			for (int columnIndex = 0; columnIndex < bingoCard[rowIndex].length; columnIndex++)
			{
				if (bingoCard[rowIndex][columnIndex] == calledNumber && bingoCard[rowIndex][columnIndex] > 0)
				{
					bingoCard[rowIndex][columnIndex] *= -1; 
					return true;
				}
			}	
		}
		
		return false;
			
	}
	
	public String checkForBingo() {
		
		String bingo = "Bingo!";
		
		for (int rowIndex=0; rowIndex < NO_OF_ROWS; rowIndex++)
		{
			for (int columnIndex=0; columnIndex < NO_OF_COLUMNS; columnIndex++)
			{
				if (bingoCard[rowIndex][columnIndex] < 0)
				{
					
					if ((columnIndex > 1 && columnIndex < NO_OF_COLUMNS-2) && (bingoCard[rowIndex][columnIndex-2] < 0) 
							&& (bingoCard[rowIndex][columnIndex-1] < 0) && (bingoCard[rowIndex][columnIndex+1] < 0) && (bingoCard[rowIndex][columnIndex+2] < 0))
					{
						
					return bingo;
					
					}
					else if((rowIndex > 1 && rowIndex < NO_OF_ROWS - 2) && (bingoCard[rowIndex-2][columnIndex] < 0)
							&& (bingoCard[rowIndex-1][columnIndex] < 0)	&& (bingoCard[rowIndex+1][columnIndex] < 0) && (bingoCard[rowIndex+2][columnIndex] < 0)) 
					{
						
					return bingo;
					
					}
					else if ((rowIndex > 1 && rowIndex < NO_OF_ROWS - 2) && (columnIndex > 1 && columnIndex < NO_OF_COLUMNS - 2)
							&& (bingoCard[rowIndex-2][columnIndex-2] < 0) && (bingoCard[rowIndex-1][columnIndex-1] < 0) && (bingoCard[rowIndex+1][columnIndex+1] < 0)
							&& (bingoCard[rowIndex+2][columnIndex+2] < 0))
					{
						
					return bingo;	
					
					}
					else if ((rowIndex > 1 && rowIndex < NO_OF_ROWS - 2) && (columnIndex > 1 && columnIndex < NO_OF_COLUMNS - 2)
					&& (bingoCard[rowIndex+2][columnIndex-2] < 0) && (bingoCard[rowIndex+1][columnIndex-1] < 0) && (bingoCard[rowIndex-1][columnIndex+1] < 0)
					&& (bingoCard[rowIndex-2][columnIndex+2] < 0))
					{
					return bingo;	
					}
				}
			}
		}
		return null;	
	}
	
	
	public String toString() {
		currentState = " | B | I | N | G | 0 | \n";
		
		for (int rowIndex=0; rowIndex < NO_OF_ROWS; rowIndex++)
		{			
			for (int columnIndex=0; columnIndex < NO_OF_COLUMNS; columnIndex++)
			{
				if (bingoCard[rowIndex][columnIndex] > 0 && bingoCard[rowIndex][columnIndex] < 10)
				{
					currentState += " | " + bingoCard[rowIndex][columnIndex];	
				}
				else if (bingoCard[rowIndex][columnIndex] > 0 && bingoCard[rowIndex][columnIndex] > 10)
				{
					currentState += " |" + bingoCard[rowIndex][columnIndex];
				}
				else
				{
					currentState += " | " + "x";
				}	
			}
			currentState += " | \n";
		}	
		return currentState;			
	}
}
