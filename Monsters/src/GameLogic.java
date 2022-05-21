
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * The class Gamelogic. Takes input from the user to set up the game.
 *
 */

public class GameLogic {
	/**
	 * playerName  the string name the user sets in the game.
	 * numDays  the integer number of days the user wants to play. Between 5 and 15
	 * difficulty  the string 'easy', 'medium', 'hard'
	 * startingMonster  Type Monster, the first monster in the players team.
	 * player  Type Player, initialized with the data received from the user input, used to play the game.
	 */
	private static String playerName=null;
	private static int numDays=0;
	private static String difficulty=null;
	private static Monster startingMonster=null;
	private static Player player;
	
	/** Method to take user input and set the player's name with 3-15 characters. */
	
	static void setName(Scanner input) {
		while (playerName == null) {
			System.out.println("Please enter a valid name:");
			String name = input.nextLine();
			Pattern pattern = Pattern.compile("[^a-zA-Z]");
			Matcher matcher = pattern.matcher(name);
			boolean correctName = matcher.find();
			if(correctName || name.length()<3 ||name.length()>15) {
				System.out.println("Error: Please enter a valid name between 3-15 letters");			
				} else {
					playerName = name;
					
				}
		}
	}
	
	/** Method to take user input and set the number of days the player wants to play (integer between 5 and 15) */
	static void setNumDays(Scanner input) {
		while (numDays == 0) {
			System.out.println("How many days do you want to play? (between 5 and 15)");
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^0-9]");
			Matcher matcher = pattern.matcher(num);
			boolean correctNum = matcher.find();
			if(num.length()==0) {
				System.out.println("Error: Please enter a number between 5 and 15");
			} else if(correctNum || Integer.parseInt(num) >15 || Integer.parseInt(num)<5) {
				System.out.println("Error: Please enter a number between 5 and 15");			
			} else {
					numDays = Integer.parseInt(num);	
			}
		}
		
	}
	
	/** Method to take user input and sets the difficulty of the game - 1 for Easy, 2 for Medium, 3 for Hard. */
	static void setDifficulty(Scanner input) {
		while (difficulty == null) {
			System.out.println("Please enter your desired difficulty:");
			System.out.println("Enter '1' for Easy or ");
			System.out.println("Enter '2' for Medium or ");
			System.out.println("Enter '3' for Hard");
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^1-3]");
			Matcher matcher = pattern.matcher(num);
			boolean correctNum = matcher.find();
			if(num.length()==0) {
				System.out.println("Error: Please enter a number between 1 and 3");
			} else if(correctNum || Integer.parseInt(num) > 3 || Integer.parseInt(num) < 1) {
				System.out.println("Error: Please enter a valid difficulty level between 1 and 3");			
			} else {
					difficulty = num;
			}
		}
	}
	
	/** Method to take user input and set the player's starting monster from the options provided. */
	static void setStartingMonster(Scanner input) {
		while (startingMonster == null) {
			Monster monsterOptionOne = new Monster("Harry", 33, 20, 53);
			Monster monsterOptionTwo = new Monster("Louis", 45, 4, 49);
			Monster monsterOptionThree = new Monster("Niall", 19, 35, 54);
			Monster monsterOptionFour = new Monster("Liam", 13, 10, 23);
			System.out.println("Please select your Starting Monster:");
			System.out.println("Option '1': ");
			System.out.println(monsterOptionOne.commandLineToString());
			System.out.println();
			System.out.println("Option '2': ");
			System.out.println(monsterOptionTwo.commandLineToString());
			System.out.println();
			System.out.println("Option '3': ");
			System.out.println(monsterOptionThree.commandLineToString());
			System.out.println();
			System.out.println("Option '4': ");
			System.out.println(monsterOptionFour.commandLineToString());
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^1-4]");
			Matcher matcher = pattern.matcher(num);
			boolean correctNum = matcher.find();
			if(num.length()==0) {
				System.out.println("Error: Please enter a valid monster option number");
			}else if(correctNum || Integer.parseInt(num) > 4 || Integer.parseInt(num) < 1||num.length()==0) {
				System.out.println("Error: Please enter a valid Monster between 1 and 4");			
			} else {
				if (Integer.parseInt(num) == 1) {
					startingMonster = monsterOptionOne;
				}else if(Integer.parseInt(num) == 2) {
					startingMonster = monsterOptionTwo;
				}else if(Integer.parseInt(num) == 3) {
					startingMonster = monsterOptionThree;
				}
				else {
					startingMonster = monsterOptionFour;
				}
			}	
			}
	}
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Monster Game");
		setName(input);
		setNumDays(input);
		setDifficulty(input);
		setStartingMonster(input);
		System.out.println("Awesome work " + playerName +"! Looks like you are all set up to play - Enjoy the Game!");
		player = new Player(playerName, difficulty, startingMonster, numDays);
		MainScreen mainScreen = new MainScreen(player); // need tho
		mainScreen.commence();
		
		
		
	}

}
