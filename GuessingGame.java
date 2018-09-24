/*
 * user input: must pick n, as to guess from 0 -> n. Also must pick amount of entries in the linkedbag
 * after user inputs n, they must start guessing the numbers in the bag
 * 
 * generate list of numbers using the users parameters
 * 
 * take in a users guess, make it a linked bag.
 * 
 * run equals() to see if it matches. if so, then they won.
 * if not, must tell them how many they got correct
 */
public class GuessingGame {
	
	private int range;
	private int inputs;
	private LinkedBag <Integer> gameBoard;
	
	public GuessingGame(int r, int i) {
		range = r;
		inputs = i;
		gameBoard = new LinkedBag <>();
		}
	
	public GuessingGame() {
		this(0,0);
	}
	
	//makes random number bag
	public void newBoard(int r){
		for(int idx = 0; idx < inputs; idx++) {
			int randNum  = (int) (Math.random()* range);
			gameBoard.add(randNum);
		}
	}
	
	
	
	

}
