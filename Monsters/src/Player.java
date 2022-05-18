import java.util.ArrayList;

public class Player {
	
	private String playerName;
	private String chosenDifficulty;
	private int gold;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
	private int currentDay;
	private int finishDay;
	private int points;
	

	public Player(String playerName2, String difficulty, Monster startingMonster, int numDays) {
		playerName = playerName2;
		chosenDifficulty = difficulty;
		monsterTeam.add(startingMonster);
		finishDay = numDays;
		currentDay = 1;
		points = 0;
		setGold();
	}
	
	public String getDifficulty() {
		return chosenDifficulty;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void increasePoints(int morePoints) {
		points += morePoints;
	}
	
	public void decreasepoints(int lessPoints) {
		points -= lessPoints;
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
	public int getNumItems(String itemName) {
		int i=0;
		for(Item item : items) {
			if(item.getName().equals(itemName)) {
				i+=1;
			}
		}
		return i;
	}
	
	public String printAttributes() {
		String goldStr = "Current gold: " + gold +"\n";
		String pointsStr = "Current points: " + points +"\n";
		String dayStr = "Current Day: " + currentDay+"\n";
		String remainStr = "Days Remaining: " + (finishDay - currentDay)+"\n";
		return goldStr+pointsStr+dayStr+remainStr;
		
		
	}
	
	public String printCurrentTeam() {
		if(this.getTeam().size()==0) {
			return "Your team is empty. Buy a monster at the shop!";
		}
		String retstr = "";
		for(Monster monster : monsterTeam) {
			retstr+=monster.commandLineToString();
			retstr+="\n";
		}
		return retstr;
	}
	
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
				retstr+= "Item number " + i + ": ";
				retstr+= item.printAttributes();
				i += 1;
			}
			return retstr;
		}
		
	}
	
	public void increaseGold(int num) {
		gold += num;
	}
	
	public void decreaseGold(int num) {
		gold -= num;
	}
	
	
	
}
