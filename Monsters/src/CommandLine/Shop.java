package CommandLine;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * The class Shop.
 *
 */
public class Shop {
	/**
	 * 
	 * shopItems  array list of items available in the shop
	 * player  the player of the game
	 *
	 */
	private ArrayList<Item> shopItems=new ArrayList<Item>();
	private Player player;
	
	/**
	 * Instantiates a new Shop.
	 *
	 * @param incomingPlayer the player of the game that will be buying or selling
	 */
	public Shop(Player incomingPlayer) {
		player = incomingPlayer;
		Item attackPotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		Item healingPotion = new Item("Magic healing potion" , "heal amount" , 10, 3, 45);
		Item extraLife = new Item("Extra Life", "lives", 1, 1, 70);
		Item luckyDip = new Item("Lucky Dip", "unknown", 0, 1, 44);
		shopItems.add((Item)attackPotion);
		shopItems.add((Item)healingPotion);
		shopItems.add((Item)extraLife);
		shopItems.add((Item)luckyDip);
		
	}
	/**
	 * Takes user input to buy or sell an item at the store. If the player has no items or Monsters available to sell, an error message is printed
	 */
	public void enterStore(Scanner input) {
		boolean actionRecieved = false;
		while(actionRecieved == false) {
			System.out.println("Welcome to the shop! Would you like to buy (enter 'buy') or sell (enter 'sell')? (Enter 'exit' to return to Homepage)");
			System.out.println("Your current gold: " + player.getgold());
			String action = input.nextLine();
			if(action.equals("buy")||action.equals("Buy")) {
				System.out.println("Item (enter 'item') or Monster (enter 'monster')?");
				String choice = input.nextLine();
				if(choice.equals("item")||choice.equals("Item")) {
					this.buy(input);
				} else if (choice.equals("monster")||choice.equals("Monster")) {
					this.buyMonster(input);
				} else {
					System.out.println("Please enter item or monster");
				}
				
			} else if(action.equals("sell")||action.equals("sell")) {
				System.out.println("Item (enter 'item') or Monster (enter 'monster')?");
				String choice = input.nextLine();
				if(choice.equals("item")||choice.equals("Item")) {
					if(player.getItems().size() >0) {
						this.sell(input);
					} else {
						System.out.println("You have nothing to sell - visit the Shop to purchase Items and Monsters! ");
					}
					
				} else if (choice.equals("monster")||choice.equals("Monster")) {
					if(player.getTeam().size() >0) {
						System.out.println("Warning: You can't get this monster back!");
						this.sellMonster(input);
					} else {
						System.out.println("Nothing to sell.");
					}
					
				} else {
					System.out.println("Please enter 'item' or 'monster'");
				}
			} else if(action.equals("exit")||action.equals("Exit")){
				actionRecieved = true;
			} else {
				System.out.println("Please enter 'buy' or 'sell', or 'exit' to go back.");
			}
		}
	}
	
	/**
	 * Takes user input to buy an item - items in the shop are printed to the player, and the player enters a number correlating
	 * to the item they want to buy and checks they have enough gold to buy it, then buys it and adds it to the player's inventory
	 */
	public void buy(Scanner input) {
		System.out.println("Your current gold: " + player.getgold());
		int i = 1;
		for (Item item : shopItems) {
			System.out.format("Option "+i+": "+item+"\n");
			i+=1;
		}
		System.out.println("Select the number of the item you want to buy, or enter 'exit' to go back");
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int arrlength = shopItems.size();
		if(num.length()==0||correctNum) {
			System.out.println("Error: Invalid input, returning to shop");
		}else {
			int number = Integer.parseInt(num);
			if(correctNum||number > arrlength || number < 1) {
				System.out.println("Error: Invalid input, returning to shop");
			} else {
				Item purchasedItem = shopItems.get(number-1);
				if(player.getgold() < purchasedItem.getPurchasePrice()) {
					System.out.println("You do not have enough gold to purchase this Item. You can earn more gold by battling!");
				} else {
					player.decreaseGold(purchasedItem.getPurchasePrice());
					if(purchasedItem.getName() == "Lucky Dip") {
						Random rndm = new Random();
						int randomInt = rndm.nextInt(arrlength);
						while (shopItems.get(randomInt).getName() == "Lucky Dip") {
							randomInt = rndm.nextInt(arrlength);
						}
						purchasedItem = shopItems.get(randomInt);
					}
					player.addItem(purchasedItem);
					System.out.println("You have successfully bought " + purchasedItem.getName());
				}}}
		}
	/**
	 * Takes user input to sell an item - items in the player's inventory are printed, and the player enters a number correlating
	 * to the item they want to sell and calculates the sell back price based on the items current usage, then the item is removed from the player's inventory
	 * and the player's gold is increased by the sell back price
	 */
	public void sell(Scanner input) {
		System.out.println("Your current gold: " + player.getgold());
		int i = 1;
		for (Item item:player.getItems()) {
			System.out.format("Option " + i + ": " + item+"\n");
			System.out.println("Sell for: " + item.getsellbackPrice());
			i+=1;
		}
		System.out.println("Enter the number of the item you want to sell, or enter 'exit' to go back.");
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int number = Integer.parseInt(num);
		int arrlength = player.getItems().size();
		if(num.length()==0) {
			System.out.println("Error: Invalid input, returning to shop");
		}else if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Invalid input, returning to shop");		//move????	
		} else {
			Item sellingItem = player.getItems().get(number-1);
			player.increaseGold(sellingItem.getsellbackPrice());
				shopItems.add(sellingItem);
				player.removeItem(sellingItem);
				System.out.println("You have successfully sold " + sellingItem.getName());
			}
		}
	/**
	 * Takes user input to sell a monster. Prints all the monsters in the player's team to display to the player and then takes input to chose one to sell. Sell back price
	 * is determined on how many lives the monster has left. Monster is removed from pleyer's team and gold is increased by sell back price
	 */
	public void sellMonster(Scanner input) {
		System.out.println("Your current gold: " + player.getgold());
		int i = 1;
		for (Monster monster : player.getTeam()) {
			System.out.format("Option " + i + ": " + monster.toString() + "\n");
			int sellingPrice = monster.getLives()/3 * monster.getPrice();
			System.out.println("Sell for: " + sellingPrice);
			i+=1;
		}
		System.out.println("Enter the number of the monster you want to sell, or enter 'exit' to go back.");
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		if(num.length()==0) {
			System.out.println("Error: Invalid input, returning to shop");
		}
		int number = Integer.parseInt(num);
		int arrlength = player.getTeam().size();
		if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Invalid input, returning to shop");		//move????	
		} else {
			Monster sellingMonster = player.getTeam().get(number-1);
			int sellingPrice = sellingMonster.getLives()/3 * sellingMonster.getPrice();
			player.increaseGold(sellingPrice);
			player.removeTeamMate(sellingMonster);
				System.out.println("You have successfully sold " + sellingMonster.getName());
			}
	}
	/**
	 * Takes user input to buy an monster - 4 monsters are generated randomly to show in the shop, the player inputs an integer corresponding to the monster they want 
	 * to buy, checks they have enough gold and buys it.
	 */
	public void buyMonster(Scanner input) {
		
		MonsterGenerator instanceMonster = new MonsterGenerator();
		ArrayList<Monster> monstersForSale = instanceMonster.generator();
		System.out.println("Your current gold:" + player.getgold());
		int i = 1;
		for (Monster monster:monstersForSale) {
			System.out.format("Option " + i + ": " + monster.toString() + "\n");
			i+=1;
		}
		System.out.println("Select the number of the monster you want to buy, or enter 'exit' to go back.");
		
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^1-4]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		if(num.length()==0 ||correctNum ) {
			System.out.println("Error: Invalid input, returning to shop");
		} else if(num.equals("exit") || num.equals("Exit")) {
			System.out.println("Returning to shop");
		} else {
			int number = Integer.parseInt(num);
			if(number >4) {
				System.out.println("Error: Invalid input, returning to shop");
			}else if(number<=4 && number>=1) {
				Monster purchasedMonster = monstersForSale.get(number-1);
				if(player.getgold() < purchasedMonster.getPrice()) {
					System.out.println("You do not have enough gold to purchase this Monster. You can earn more gold by battling!");
				} else {
					player.decreaseGold(purchasedMonster.getPrice());
					player.addTeamMate(purchasedMonster);
					System.out.println("You have successfully bought " + purchasedMonster.getName());
			}
		
	}
		}
		
	}
}
