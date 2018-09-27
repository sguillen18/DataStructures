 //import instructor.ResArrayBag;
 import java.util.Scanner;
 
public class TestBag {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numberOfNums;
		int numbersRange;
		boolean play = true;
		
		//create bag for numbers being guessed
		LinkedBag <Integer> userGuess = new LinkedBag <Integer> ();
		
		//while userGuess != correct bag
		while(play) {
			System.out.println("How many numbers do you want to guess?");
			numberOfNums = sc.nextInt();
			
			System.out.println("Select a range from 1 to N.");
			System.out.println("N:");
			numbersRange = sc.nextInt();
			
			GuessingGame newGame = new GuessingGame(numbersRange, numberOfNums);
			newGame.newBoard();
			
			/*LinkedBag <Integer> g = newGame.getGameBoard();
			
			Object[] objArray = g.toArray();
			int[] a = new int[objArray.length];
			for (int i=0;i<a.length;i++) {
				a[i] = (int)objArray[i];
			}

			for(int k = 0; k < a.length; k++) {
				System.out.println(a[k]);
			}*/
			
			while(!newGame.gameOver(userGuess)) {
				userGuess.clear();
				System.out.println("Enter " + numberOfNums + " integers in the range from 1 to " + numbersRange + ". Entries may be duplicate.");
			
				//adding guesses to bag
				for(int ii = 0; ii < numberOfNums; ii++) {
					int guess = sc.nextInt();
					userGuess.add(guess);
				}
				LinkedBag <Integer> temp = new LinkedBag <Integer> ();
				temp = userGuess.copy();
				
				System.out.println(newGame.compare(userGuess));
				
				if(newGame.numRight(temp) == numberOfNums) {
					String ans = sc.next();
					if(ans.equalsIgnoreCase("No")) {
						play = false;
					}
					else if (!ans.equalsIgnoreCase("No")) {
						break;}
				}
			
			}
			
			
		}

		
	
		
		//write all the stuff the user sees when they play the game.
		
		//compare and return correct integers
		sc.close();
	}

}
