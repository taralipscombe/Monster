import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop {
	private ArrayList<Item> shopItems=new ArrayList<Item>();
	Player player;
	Scanner scanner;
	
	public Shop(Player incomingPlayer, Scanner incomingScanner) {
		player = incomingPlayer;
		scanner = incomingScanner;
		Item attackPotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		Item healingPotion = new Item("Magic healing potion" , "heal amount" , 10, 3, 45);
		Item extraLife = new Item("Extra Life", "lives", 1, 1, 70);
		Item luckyDip = new Item("Lucky Dip", "unknown", 0, 1, 44);
		shopItems.add((Item)attackPotion);
		shopItems.add((Item)healingPotion);
		shopItems.add((Item)extraLife);
		shopItems.add((Item)luckyDip);
		
	}
	
	public void enterStore(Scanner input) {
		boolean actionRecieved = false;
		while(actionRecieved == false) {
			System.out.println("Welcome to the shop! Would you like to buy or sell?");
			System.out.println("Your current gold:"+player.getgold());
			String action = input.nextLine();
			if(action.equals("buy")) {
				System.out.println("Item or Monster?");
				String choice = input.nextLine();
				if(choice.equals("item")) {
					this.buy();
				} else if (choice.equals("monster")) {
					this.buyMonster();
				} else {
					System.out.println("Please enter item or monster");
				}
				
			} else if(action.equals("sell")) {
				System.out.println("Item or Monster?");
				String choice = input.nextLine();
				if(choice.equals("item")) {
					this.sell();
				} else if (choice.equals("monster")) {
					System.out.println("Warning: You can't get this monster back!");
					this.sellMonster();
				} else {
					System.out.println("Please enter item or monster");
				}
			} else if(action.equals("exit")){
				actionRecieved = true;
			} else {
				System.out.println("Please enter 'buy' or 'sell'.");
			}
		}
	}
	
	public void buy(Scanner input) {
		System.out.println("Your current gold:"+player.getgold());
		int i = 1;
		for (Item item:shopItems) {
			System.out.format("Option "+i+": "+item+"\n");
			i+=1;
		}
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[0-9+]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int number = Integer.parseInt(num);
		int arrlength = shopItems.size();
		if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Please enter a number of an item");		//move????	
		} else {
			Item purchasedItem = shopItems.get(number-1);
			if(player.getgold() < purchasedItem.getPurchasePrice()) {
				System.out.println("Not enough gold");
			} else {
				player.gold -= purchasedItem.getPurchasePrice();
				if(purchasedItem.getName() == "Lucky Dip") {
					Random rndm = new Random();
					int randomInt = rndm.nextInt(arrlength);
					while (shopItems.get(randomInt).getName() == "Lucky Dip") {
						randomInt = rndm.nextInt(arrlength);
					}
					purchasedItem = shopItems.get(randomInt);
				}
				player.items.add(purchasedItem);
				
				System.out.println("You have successfully bought "+purchasedItem.getName());
			}}
		}
	
	public void sell(Scanner input) {
		System.out.println("Your current gold:"+player.getgold());
		int i = 1;
		for (Item item:player.items) {
			System.out.format("Option "+i+": "+item+"\n");
			i+=1;
		}
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[0-9+]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int number = Integer.parseInt(num);
		int arrlength = player.getItems().size();
		if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Please enter a number of an item");		//move????	
		} else {
			Item sellingItem = player.items.get(number-1);
			player.gold += sellingItem.getsellbackPrice();
				shopItems.add(sellingItem);
				System.out.println("You have successfully sold "+sellingItem.getName());
			}
		}
	
	public void sellMonster(Scanner input) {
		System.out.println("Your current gold:"+player.getgold());
		int i = 1;
		for (Monster monster:player.getTeam()) {
			System.out.format("Option "+i+": "+monster.toString()+"\n");
			i+=1;
		}
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[0-9+]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int number = Integer.parseInt(num);
		int arrlength = player.getTeam().size();
		if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Please enter a number of an item");		//move????	
		} else {
			Monster sellingMonster = player.getTeam().get(number-1);
			int sellingPrice = sellingMonster.getLives()/3 * sellingMonster.getPrice();
			player.gold += sellingPrice;
				System.out.println("You have successfully sold "+sellingMonster.getName());
			}
	}
	
	public void buyMonster(Scanner input) {
		System.out.println("Your current gold:"+player.getgold());
		Monster monsterOptionOne = new Monster("Harry", 33, 20, 60);
		Monster monsterOptionTwo = new Monster("Louis", 45, 4, 45);
		Monster monsterOptionThree = new Monster("Niall", 19, 35, 52);
		Monster monsterOptionFour = new Monster("Liam", 13, 10, 10);
		if(player.currentDay>=10) {
			Monster monsterOptionFive = new Monster("Zayn", 52, 50, 80);
		}
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[0-9+]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		if(correctNum && Integer.parseInt(num)<=4 && Integer.parseInt(num)>=1) {
			//Monster purchasedMonster = randommonsterarray(number-1);
			//if(player.getgold() < purchasedMonster.getPurchasePrice()) {
				//System.out.println("Not enough gold");
			//} else {
				//player.gold -= purchasedMonster.getPurchasePrice();
				//player.monsterTeam.add(purchasedMonster);
				//System.out.println("You have successfully bought "+purchasedMonster.getName());
		}
		
	}
		
	}

