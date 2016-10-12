
public class BingoGameSimulation {
	
	public static void main(String[] args) {
		BingoGame newGame = new BingoGame();
		
		int gameNumber = 0;
		int numberCount = 0;
		int countTotal = 0;
		
		while (gameNumber < 100)
		{
			numberCount = newGame.playBingo();
			
			if (numberCount != 0)
			{
				countTotal += numberCount; 
			}
			
			gameNumber++;
		}
		
		int average = countTotal/gameNumber;
		
		System.out.println(average);
	
		
		gameNumber = 0;
		countTotal = 0;
		numberCount = 0;
		
		BingoGame[] gameList = new BingoGame[500];
		int[] numbersCount = new int[gameList.length];
		
		for (int game=0; game<gameList.length; game++) {
			
			gameList[game] = new BingoGame();
			
		}
		
		while (gameNumber < 100)
		{
			for (int indexOne=0; indexOne<gameList.length; indexOne++)
			{
				numberCount = gameList[indexOne].playBingo();
				
				numbersCount[indexOne] = numberCount;
				//countTotal += numberCount; 			
			}	
			
			int minimum = 0;
			
			for (int indexTwo=0; indexTwo<numbersCount.length-1; indexTwo++)
			{	
				
				if ((numbersCount[indexTwo] > numbersCount[indexTwo+1]) && numbersCount[indexTwo+1] > 0)
				{
					minimum = numbersCount[indexTwo+1];
				}						
				
			}
			countTotal += minimum;
			gameNumber++;
		}
			
		average = countTotal/gameNumber;
	
		System.out.println(average);
	
	}	
}
