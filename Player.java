import java.util.ArrayList;

public class Player {
	
	private String playerName;
	private String chosenDifficulty;
	private int gold;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
	private int currentDay;
	private int finishDay;
	

	public Player(String playerName2, String difficulty, Monster startingMonster, int numDays) {
		playerName = playerName2;
		chosenDifficulty = difficulty;
		monsterTeam.add(startingMonster);
		finishDay = numDays;
		currentDay = 0;
		setGold();
	}
	public int getDay() {
		return this.currentDay;
	}
	public int getFinishDay() {
		return this.finishDay;
	}
	
	public String getName() {
		return playerName;
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void addItem(Item newestItem) {
		items.add(newestItem);
	}
	
	public void removeItem(Item newestItem) {
		items.remove(newestItem);
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
	
	public ArrayList<Monster> getTeam(){
		return monsterTeam;
	}
	
	public void addTeamMate(Monster newestMonster) {
		monsterTeam.add(newestMonster);
	}
	public void removeTeamMate(Monster newestMonster) {
		monsterTeam.remove(newestMonster);
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
		if(this.getTeam().size()==0) {
			System.out.println("Your team is empty. Buy a monster at the shop!");
		}
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
	public void changeGold(int num) {
		this.gold+=num;
	}
	
}
