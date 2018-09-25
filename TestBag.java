 import instructor.ResArrayBag;
 import java.util.Scanner;
 
public class TestBag {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numberOfNums;
		int numbersRange;
		boolean play = true;
		
		//create bag for numbers being guessed
		LinkedBag <Integer> userGuess = new LinkedBag <> ();
		
		System.out.println("How many numbers do you want to guess?");
		numberOfNums = sc.nextInt();
		
		System.out.println("Select a range from 1 to N.");
		System.out.println("N:");
		numbersRange = sc.nextInt();
		
		//while userGuess != correct bag
		while(play) {
			GuessingGame newGame = new GuessingGame(numbersRange, numberOfNums);
			
			while(!newGame.over(userGuess)) {
				userGuess.clear();
				for(int i = 0; i < numberOfNums; i++) {
					System.out.println("Enter " + numberOfNums + " integers in the range from 1 to " + numbersRange + ". Entries may be duplicate.");
			
			
					//adding guesses to bag
					for(int ii = 0; ii < numberOfNums; ii++) {
						int guess = sc.nextInt();
						userGuess.add(guess);
					}
				}
				
				newGame.compare(userGuess);
			}
			
			if(newGame.over(userGuess)) {
				String ans = sc.next();
				if(ans.equalsIgnoreCase("No")) {
					play = false;
				}
			}
			
			
		}

		
	
		
		//write all the stuff the user sees when they play the game.
		
		//compare and return correct integers
		sc.close();
	}

}
