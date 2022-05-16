import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainScreen {
	
	private static Player player;
	private static Shop shop;
	private static ArrayList<Monster> enemyTeamOne = null;
	private static ArrayList<Monster> enemyTeamTwo = null;
	private static ArrayList<Monster> enemyTeamThree = null;
	
	public MainScreen(Player thePlayer) {
		player = thePlayer;
		shop = new Shop(player);
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
				if (number == 1) {
					viewAttributes();
				} else if (number == 2) {
					viewTeam();
				} else if (number == 3) {
					viewInventory();
				} else if (number == 4) {
					viewBattles();
				} else if (number == 5) {
					battle(input);
				} else if (number == 6) {
					visitShop(input);
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
		BattleGenerator battles = new BattleGenerator(player);
		int i = 0;
		while (i < 3) {
			if (i == 0 ) {
				System.out.println("Battle '1': ");
				if (enemyTeamOne == null) {
				ArrayList<Monster> enemyTeam = BattleGenerator.generateTeam();
				enemyTeamOne = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamOne) {
						System.out.println(monster.toString());
						System.out.println();
				}
				}
			} else if (i == 1 ) {
				System.out.println("Battle '2': ");
				if (enemyTeamTwo == null) { 
				ArrayList<Monster> enemyTeam = BattleGenerator.generateTeam();
				enemyTeamTwo = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamTwo) {
						System.out.println(monster.toString());
						System.out.println();
				}
				}
			} else if (i == 2) {
				System.out.println("Battle '3': ");	
				if (enemyTeamThree == null) {
					ArrayList<Monster> enemyTeam = BattleGenerator.generateTeam();
					enemyTeamThree = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamThree) {
						System.out.println(monster.toString());
						System.out.println();
				}
				}
			}
			i += 1;
		}

	}
	
	public static void battle(Scanner input) {
		// first check if teams have been generated, if not generate that team so there is at three options
		// once selected, remove the team from the attribute - battles can only be played once - consider the heal feature?
		// will have to generate while loop so continues to ask if not correct input
		
		
		System.out.println("Select Enemy Team to Battle: ");
		boolean selected = true;
		while (selected) {
			System.out.println();
			viewBattles();
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^1-3]");
			Matcher matcher = pattern.matcher(num);
			boolean correctNum = matcher.find();
			if (correctNum || Integer.parseInt(num) > 3 || Integer.parseInt(num) < 1) {
				System.out.println("Error: Please enter a valid move between 1 and 3");	
			} else {
				selected = false;
				System.out.println("TIME TO BATTLE!");
				if (num.equals("1")) {
					ArrayList<Monster> battlingTeam = enemyTeamOne;
					Battle battle = new Battle(player, battlingTeam);
					Battle.fight();
					enemyTeamOne = null;
				} else if (num.equals("2")) {
					ArrayList<Monster> battlingTeam = enemyTeamTwo;
					Battle battle = new Battle(player, battlingTeam);
					Battle.fight();
					enemyTeamTwo = null;
				} else {
					ArrayList<Monster> battlingTeam = enemyTeamThree;
					Battle battle = new Battle(player, battlingTeam);
					Battle.fight();
					enemyTeamThree = null;
				}
			}
			}
		
	}
	
	public static void visitShop(Scanner input) {
		//go to shop class? print out all available items, will need to be able to purchase, or re sell current items, will need to call view inventory for that
		//have set items, potentially unlock new items with monster (i.e. buy new monster, can now get new item or maybe hard idk tbd
		shop.enterStore(input);
		
	}
	
	
	//Implement the overnight random events - maybe new random event class?
	public static void sleep() {
		for (Monster monster : player.monsterTeam) {
			monster.heal();
		}
		player.incrementDay();
		RandomEvent randomEvent = new RandomEvent(player);
		RandomEvent.generate();
		
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
		//finish game

	}
}
