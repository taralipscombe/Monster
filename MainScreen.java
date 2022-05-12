import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainScreen {
	
	private static Player player;
	
	public MainScreen(Player thePlayer) {
		player = thePlayer;
	}
	
	public static void displayOptions() {
		System.out.println("Please select your next move:");
		System.out.println("Option (1): View your current attributes"); //not attributes but dont know other word
		System.out.println("Option (2): View your team's properties");
		System.out.println("Option (3): View your inventory");
		System.out.println("Option (4): View possible Battles");
		System.out.println("Option (5): Battle!");
		System.out.println("Option (6): Visit Shop");
		System.out.println("Option (7): Go to Sleep");
		System.out.println("Option (8): END GAME");
	}
	
	public static void nextMove(Scanner input) {
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^1-8]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		if(correctNum || Integer.parseInt(num) > 8 || Integer.parseInt(num) < 1) {
			System.out.println("Error: Please enter a valid move between 1 and 8");		//move????	
		} else {
			int number = Integer.parseInt(num);
			System.out.println(num.getClass().getName());
				if (number == 1) {
					viewAttributes();
				} else if (number == 2) {
					viewTeam();
				} else if (number == 3) {
					viewInventory();
				} else if (number == 4) {
					viewBattles();
				} else if (number == 5) {
					battle();
				} else if (number == 6) {
					visitShop();
				} else if (number == 7) {
					sleep();
				} else {
					System.out.println("game ended");
					endGame();
				}
		}
	}
	
	
	public static void viewAttributes() {
		System.out.println("Your current Attributes are: ");
		player.printAttributes();
	}
	
	public static void viewTeam() {
		System.out.println("Your current Team: ");
		player.printCurrentTeam();
	}
	
	public static void viewInventory() {
		System.out.println("Your current Inventory: ");
		player.printInventory();
	}
	
	public static void viewBattles() {
		//currently not implemented, use Battle generator class to randomise battles
		System.out.println("TO BE IMPLEMENTED");
	}
	
	public static void battle() {
		//maybe calls view battles so player can select which battle, then go to battle class and fight ig
		System.out.println("TO BE IMPLEMENTED");
	}
	
	public static void visitShop() {
		//go to shop class? print out all available items, will need to be able to purchase, or re sell current items, will need to call view inventory for that
		//have set items, potentially unlock new items with monster (i.e. buy new monster, can now get new item or maybe hard idk tbd
		System.out.println("TO BE IMPLEMENTED");
		
	}
	
	
	//Implement the overnight random events - maybe new random event class?
	public static void sleep() {
		player.incrementDay();
	}
	
	public static void endGame() {
		player.endGame();
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (player.currentDay < player.finishDay) {
			displayOptions();
			nextMove(input);
		}
		

	}
	

}
