package GUI;

import java.util.ArrayList;

/**
 * The Class Player.
 */
public class Player {
	
	/** The player name. */
	private String playerName;
	
	/** The player's chosen difficulty. */
	private String chosenDifficulty;
	
	/** The player's gold. */
	private int gold;
	
	/** The player's items. */
	private ArrayList<Item> items = new ArrayList<Item>();
	
	/** The player's monster team. */
	private ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
	
	/** The current day. */
	private int currentDay;
	
	/** The finish day. */
	private int finishDay;
	
	/** The player's points. */
	private int points;
	

	/**
	 * Instantiates a new player.
	 *
	 * @param playerName2 the player name 2
	 * @param difficulty the difficulty
	 * @param startingMonster the starting monster
	 * @param numDays the num days
	 */
	public Player(String playerName2, String difficulty, Monster startingMonster, int numDays) {
		playerName = playerName2;
		chosenDifficulty = difficulty;
		monsterTeam.add(startingMonster);
		finishDay = numDays;
		currentDay = 1;
		points = 0;
		setGold();
	}
	
	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return chosenDifficulty;
	}
	
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Increase points.
	 *
	 * @param morePoints the points to increase by
	 */
	public void increasePoints(int morePoints) {
		points += morePoints;
	}
	
	/**
	 * Decrease points.
	 *
	 * @param lessPoints the points to decrease by
	 */
	public void decreasepoints(int lessPoints) {
		points -= lessPoints;
	}
	
	
	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return this.currentDay;
	}
	
	/**
	 * Gets the finish day.
	 *
	 * @return the finish day
	 */
	public int getFinishDay() {
		return this.finishDay;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return playerName;
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public ArrayList<Item> getItems(){
		return items;
	}
	
	/**
	 * Adds the item.
	 *
	 * @param newestItem the item to be added
	 */
	public void addItem(Item newestItem) {
		items.add(newestItem);
	}
	
	/**
	 * Removes the item.
	 *
	 * @param newestItem the item to be removed
	 */
	public void removeItem(Item newestItem) {
		items.remove(newestItem);
	}
	
	/**
	 * Use item.
	 *
	 * @param usingItem the item being used
	 * @param onMonster the monster that the item is being used on
	 */
	public void useItem(Item usingItem, Monster onMonster) {
		usingItem.useItem(onMonster);
		if (usingItem.getUsage() == 0) {
			removeItem(usingItem);
		}
		
	}
	
	/**
	 * Sets the gold. Sets gold based on the players chosen difficulty
	 */
	public void setGold() {
		if (chosenDifficulty == "Easy") {
			gold = 200;
		} else if (chosenDifficulty == "Medium") {
			gold = 150;
		} else {
			gold = 100;
		}
	}
	
	/**
	 * Gets the gold.
	 *
	 * @return the gold
	 */
	public int getgold() {
		return gold;
	}
	
	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public ArrayList<Monster> getTeam(){
		return monsterTeam;
	}
	
	/**
	 * Adds the team mate.
	 *
	 * @param newestMonster the Monster to be added
	 */
	public void addTeamMate(Monster newestMonster) {
		monsterTeam.add(newestMonster);
	}
	
	/**
	 * Removes the team mate.
	 *
	 * @param newestMonster the Monster to be removed
	 */
	public void removeTeamMate(Monster newestMonster) {
		monsterTeam.remove(newestMonster);
	}
	
	/**
	 * Increment day. Heals all monsters by their heal amount
	 */
	public void incrementDay() {
		currentDay = currentDay + 1;
		for (Monster monster : monsterTeam) {
			monster.heal();
		}
	}
	
	/**
	 * End game.
	 */
	public void endGame() {
		currentDay = finishDay;
	}
	
	/**
	 * Gets the number of a particular type of item that the player owns
	 *
	 * @param itemName the name of the item
	 * @return the number of items
	 */
	public int getNumItems(String itemName) {
		int i = 0;
		for(Item item : items) {
			if(item.getName().equals(itemName)) {
				i+=1;
			}
		}
		return i;
	}
	
	
	/**
	 * Prints the players attributes.
	 *
	 * @return the string
	 */
	public String printAttributes() {
		String goldStr = "Current gold: " + gold +"\n";
		String pointsStr = "Current points: " + points +"\n";
		String dayStr = "Current Day: " + currentDay+"\n";
		String remainStr = "Days Remaining: " + (finishDay - currentDay)+"\n";
		return goldStr+ pointsStr + dayStr + remainStr;
		
		
	}
	
	/**
	 * Prints the players Monster team.
	 *
	 * @return the string
	 */
	public String printCurrentTeam() {
		if(this.getTeam().size()==0) {
			return "Your team is empty. Buy a monster at the shop!";
		}
		String retstr = "";
		for(Monster monster : monsterTeam) {
			retstr += monster.commandLineToString();
			retstr += "\n";
		}
		return retstr;
	}
	
	/**
	 * Prints the inventory.
	 *
	 * @return the string
	 */
	public String printInventory() {
		if (items.size() == 0) {
			return "Your inventory is empty. Buy an item at the shop!";
		} else {
			String retstr = "";
			int i = 1;
			for(Item item : items) {
				if (item.getUsage() == 0) {
					this.removeItem(item);
				}
				System.out.println();
				retstr += "Item number " + i + ": ";
				retstr += item.printAttributes();
				i += 1;
			}
			return retstr;
		}
		
	}
	
	/**
	 * Increase gold.
	 *
	 * @param num the amount to increase the players gold by
	 */
	public void increaseGold(int num) {
		gold += num;
	}
	
	/**
	 * Decrease gold.
	 *
	 * @param num the amount to decrease the players gold by 
	 */
	public void decreaseGold(int num) {
		gold -= num;
	}
	
	
	
}
