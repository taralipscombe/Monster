import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop {
	private ArrayList<Item> shopItems=new ArrayList<Item>();
	Player player;
	
	public Shop(Player incomingPlayer) {
		player = incomingPlayer;
		Item attackPotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		Item healingPotion = new Item("Magic healing potion" , "heal amount" , 10, 3, 45);
		Item extraLife = new Item("Extra Life", "lives", 1, 1, 70);
		shopItems.add((Item)attackPotion);
		shopItems.add((Item)healingPotion);
		shopItems.add((Item)extraLife);
		//Item luckyDip = randomise from all the items in array;
		
	}
	
	public void enterStore() {
		boolean actionRecieved = false;
		while(actionRecieved == false) {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to the shop! Would you like to buy or sell?");
			String action = input.nextLine();
			if(action == "buy") {
				this.buy();
			} else if(action == "sell") {
				this.sell();
			} else if(action == "exit"){
				actionRecieved = true;
			} else {
				System.out.println("Please enter 'buy' or 'sell'.");
			}
		}
	}
	
	public void buy() {
		int i = 1;
		for (Item item:shopItems) {
			System.out.format("Option "+i+": "+item);
			i+=1;
		}
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^1-8]");
		Matcher matcher = pattern.matcher(num);
		boolean correctNum = matcher.find();
		int number = Integer.parseInt(num);
		int arrlength = player.getItems().size();
		if(correctNum || number > arrlength || number < 1) {
			System.out.println("Error: Please enter a number of an item");		//move????	
		} else {
			Item purchasedItem = shopItems.get(number-1);
			if(player.getgold() < purchasedItem.getPurchasePrice()) {
				System.out.println("Not enough gold");
			} else {
				player.gold -= purchasedItem.getPurchasePrice();
				player.items.add(purchasedItem);
				System.out.println("You have successfully bought "+purchasedItem.getName());
			}
		}
	}
	
	public void sell() {
		int i = 1;
		for (Item item:player.items) {
			System.out.format("Option "+i+": "+item);
			i+=1;
		}
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		Pattern pattern = Pattern.compile("[^1-8]");
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
		
	}
