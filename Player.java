import java.util.ArrayList;

public class Player {
	
	public String playerName;
	public String chosenDifficulty;
	public int gold;
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
	public int currentDay;
	public int finishDay;
	public int points=0;
	

	public Player(String playerName2, String difficulty, Monster startingMonster, int numDays) {
		playerName = playerName2;
		chosenDifficulty = difficulty;
		monsterTeam.add(startingMonster);
		finishDay = numDays;
		currentDay = 0;
		setGold();
	}

	
	public int getPoints() {
		return points;
	}
	
	public void increasePoints(int number) {
		points += number;
	}
	
	
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void addItem(Item newestItem) {
		items.add(newestItem);
	}
	
	public void setGold() {
		if (chosenDifficulty == "Easy") {
			gold = 200;
		} else if (chosenDifficulty == "Medium") {
			gold = 150;
		} else {
			gold = 100;
		}
	}
	
	public int getgold() {
		return gold;
	}
	
	
	public void increaseGold(int increase) {
		gold += increase;
	}
	
	public ArrayList<Monster> getTeam(){
		return monsterTeam;
	}
	
	public void addTeamMate(Monster newestMonster) {
		monsterTeam.add(newestMonster);
	}
	
	// same as sleeping so will need to add how the monsters heal over night
	public void incrementDay() {
		currentDay = currentDay + 1;
		for (Monster monster : monsterTeam) {
			monster.heal();
		}
	}
	
	public void endGame() {
		currentDay = finishDay;
	}
	
	public void printAttributes() {
		System.out.println("Current gold: "+gold);
		System.out.println("Current Day: "+currentDay);
		System.out.println("Days Remaining: "+(finishDay -currentDay));
		
	}
	
	public void printCurrentTeam() {
		for(Monster monster : monsterTeam) {
			System.out.println();
			monster.commandLineToString();
		}
	}
	
	public void printInventory() {
		for(Item item : items) {
			System.out.println();
			item.printAttributes();
		}
	}
	
	

}
