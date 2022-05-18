
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
		if(correctNum==false || Integer.parseInt(num) > 8 || Integer.parseInt(num) < 1) {
			System.out.println("Error: Please enter a valid move between 1 and 8");		//move????	
		}else {
			int number = Integer.parseInt(num);
				if (number == 1) {
					viewAttributes();
				} else if (number == 2) {
					viewTeam();
				} else if (number == 3) {
					viewInventory(input);
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
		System.out.println(player.printAttributes());
	}
	
	public static void viewTeam() {
		System.out.println("Your current Team: ");
		System.out.println(player.printCurrentTeam());
	}
	
	public static void viewInventory(Scanner input) {
		System.out.println("Your current Inventory: ");
		System.out.println(player.printInventory());
		System.out.println("Would you like to use an item on a Monster? (please enter 'yes' or 'no', or 'exit' to exit)");
		boolean selected = true;
		while (selected) {
			String yesOrNo = input.nextLine();
			Pattern pattern = Pattern.compile("[^a-zA-Z]");
			Matcher matcher = pattern.matcher(yesOrNo);
			boolean correctInput = matcher.find();
			if (yesOrNo.equals("exit")) {
				selected = false;
			} if (correctInput) {
				System.out.println("Error: Please enter 'yes' or 'no'");	
			} else if (yesOrNo.equals("yes") || yesOrNo.equals("Yes")){
				applyItem(input);
				selected = false;
				
			} else if (yesOrNo.equals("no") || yesOrNo.equals("No")) {
				selected = false;
			} else {
				System.out.println("Error: Please enter 'yes' or 'no'");	
			}
		
		}
	}
	
	public static void applyItem(Scanner input) {
		boolean selected = true;
		boolean exited = false;
		while (selected && !exited) {
			System.out.println("Please enter the number of the item you would like to apply: (or enter 'exit' to exit)");
			player.printInventory();
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^1-9]");
			Matcher matcher = pattern.matcher(num);
			boolean correctInput = matcher.find();
			if (num.equals("exit")){
				exited = true;
			} else if (correctInput || Integer.parseInt(num) < 1 || Integer.parseInt(num) > player.getItems().size() ) {
				System.out.println("Error: Please enter a number between 1 and " + player.getItems().size() + " (inclusive) (or enter 'exit' to exit). ");	
			} else {
				int numberItem = Integer.parseInt(num) - 1;
				while (selected && !exited) {
					System.out.println("Please enter the number of the Monster you would like to apply the item too: (or enter 'exit' to exit)");
					player.printCurrentTeam();
					String numTwo = input.nextLine();
					Pattern patternTwo = Pattern.compile("[^1-9]");
					Matcher matcherTwo = patternTwo.matcher(numTwo);
					boolean correctInputTwo = matcherTwo.find();
					if (num.equals("exit")){
						exited = true;
					} else if (correctInputTwo || Integer.parseInt(numTwo) < 1 || Integer.parseInt(numTwo) > player.getTeam().size() ) {
						System.out.println("Error: Please enter a number between 1 and " + player.getTeam().size() + " (inclusive) (or enter 'exit' to exit).");	
					} else {
						selected = false;
						int numberMonster = Integer.parseInt(num) - 1;
						Monster appliedMonster = player.getTeam().get(numberMonster);
						Item appliedItem = player.getItems().get(numberItem);
						appliedItem.useItem(appliedMonster);
				
			}
		}
			}
		}
		
		


		
		
		
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
				int winnings = BattleGenerator.getWinnings(enemyTeam);
				System.out.println("Winning this battle will award you with "+ winnings + " gold.");
				enemyTeamOne = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamOne) {
						System.out.println(monster.toString());
						System.out.println();
					int winnings = BattleGenerator.getWinnings(enemyTeamOne);
					System.out.println("Winning this battle will award you with "+ winnings + " gold.");
				}
				}
			} else if (i == 1 ) {
				System.out.println("Battle '2': ");
				if (enemyTeamTwo == null) { 
				ArrayList<Monster> enemyTeam = BattleGenerator.generateTeam();
				int winnings = BattleGenerator.getWinnings(enemyTeam);
				System.out.println("Winning this battle will award you with "+ winnings + " gold.");
				enemyTeamTwo = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamTwo) {
						System.out.println(monster.toString());
						System.out.println();
					int winnings = BattleGenerator.getWinnings(enemyTeamTwo);
					System.out.println("Winning this battle will award you with "+ winnings + " gold.");
				}
				}
			} else if (i == 2) {
				System.out.println("Battle '3': ");	
				if (enemyTeamThree == null) {
					ArrayList<Monster> enemyTeam = BattleGenerator.generateTeam();
					int winnings = BattleGenerator.getWinnings(enemyTeam);
					System.out.println("Winning this battle will award you with "+ winnings + " gold.");
					enemyTeamThree = enemyTeam;
				} else {
					System.out.println();
					for (Monster monster : enemyTeamThree) {
						System.out.println(monster.toString());
						System.out.println();
					int winnings = BattleGenerator.getWinnings(enemyTeamThree);
					System.out.println("Winning this battle will award you with "+ winnings + " gold.");
				}
				}
			}
		    System.out.println("");
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
		for (Monster monster : player.getTeam()) {
			monster.heal();
		}
		player.incrementDay();
		RandomEvent randomEvent = new RandomEvent(player);
		randomEvent.generate();
		
	}
	
	public static void endGame() {
		player.endGame();
		System.out.println("Congratulations you have finished the Game!");
		System.out.println("Game Stats: ");
		System.out.println("Name: " + player.getName());
		System.out.println("Game Duration: " + player.getFinishDay());
		System.out.println("Total Points Gained: " + player.getPoints());
		System.out.println("Total Gold Gained: " + player.getgold());
	
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (player.getDay() < player.getFinishDay()) {
			displayOptions();
			nextMove(input);
		}
		//finish game

	}
}
