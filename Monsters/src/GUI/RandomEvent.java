import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * The Class RandomEvent.
 */
public class RandomEvent {
	
	/** The players monster team. */
	private static ArrayList<Monster> monsterTeam;
	
	/** The official player of the game. */
	private static Player player;
	
	/** List of strings stating what (if any) random events occured  */
	private static ArrayList<String> randomOccured = new ArrayList<String>();
	
	//a monster levels up overnight - one gains 15 attack, 40% (
	// a monster level down overnight - one loses 15 attack, 30% chance
	// a mosnter leaves, should increase with low lives, still quite low
	// above average 1.5 lives, only 5% chance, below average 1.5 lives, 20% chance
	// new monster joins - coudl include zayne, even if not day ten (only once a game), easy = 15%, medium = 10% , hard = 5%
	
	/**
	 * Instantiates a new random event. Sets the player and monster Team attributes
	 *
	 * @param thePlayer the official player
	 */
	public RandomEvent(Player thePlayer) {
		player = thePlayer;
		monsterTeam = player.getTeam();

	}
	
	/**
	 * Generate. Calls all methods of possible random events
	 *
	 * @return the array list of strings stating what events occured.
	 */
	public ArrayList<String> generate() {
		levelsUp();
		levelsDown();
		leavesOvernight();
		return randomOccured;
	}
	
	/**
	 * Random. Generates a random int between the min and the max
	 *
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the int generated
	 */
	public static int random(int min, int max) {
	    int range = (max - min) + 1;
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range) + min;
	    return randomInt;
	}
	
	
	/**
	 * Creates the random. Creates a random double between 0 and 1.
	 *
	 * @return the double generated
	 */
	public static double createRandom() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
		return range;
	}
	
	
	/**
	 * Levels up. First clears the random occured attribute so only the most recent events are added.
	 * If the random integer generated is between 0 and 0.3 (inclusive, a 40% chance), a random monster is selected from
	 *  the monster team and leveled up - its damage increase by 15 units.
	 */
	public static void levelsUp() {
		randomOccured.clear();
		double randomInt = createRandom();
		if (randomInt < 0.4) {
			int range = monsterTeam.size();
			Random rndm = new Random();
			int rndmInt = rndm.nextInt(range);
			Monster levelUpMonster = monsterTeam.get(rndmInt);
			int initialDamage = levelUpMonster.getDamage();
			levelUpMonster.setDamage(initialDamage + 15);
			randomOccured.add("Congratulations " + levelUpMonster.getName() + " has leveled up! Their damage is now " + levelUpMonster.getDamage()+ " units.");
			System.out.println("Congratulations " + levelUpMonster.getName() + " has leveled up! Their damage is now " + levelUpMonster.getDamage()+ " units.");
		}
		
	}
	
	/**
	 * Levels down.
	 * If the random integer generated is between 0 and 0.2 (inclusive, a 30% chance), a random monster is selected from
	 *  the monster team and leveled down - its damage reduced by 15 units.
	 */
	public static void levelsDown() {
		double randomInt = createRandom();
		if (randomInt < 0.3) {
			int range = monsterTeam.size();
			Random rndm = new Random();
			int rndmInt = rndm.nextInt(range);
			Monster levelDownMonster = monsterTeam.get(rndmInt);
			int initialDamage = levelDownMonster.getDamage();
			levelDownMonster.setDamage(initialDamage -15);
			randomOccured.add("Oh no " + levelDownMonster.getName() + " has gotten sick overnight! Their damage is now " + levelDownMonster.getDamage()+ " units.");
			System.out.println("Oh no " + levelDownMonster.getName() + " has gotten sick overnight! Their damage is now " + levelDownMonster.getDamage()+ " units.");
		}
	}
	
	
	/**
	 * Leaves overnight. Gets the average lives of Monsters in the monster team
	 * If the average lives is greater than or equal to 1.5, there is a 10% chance a player dies overnight and is removed from the team
	 * If the average lives is instead less than 1.5, there is a 20% chance a player dies overnight and is removed from the team
	 */
	public static void leavesOvernight() {
		double averageLives = 0;
		for (Monster monster : monsterTeam) {
			averageLives += monster.getLives();
		}
		averageLives = averageLives / monsterTeam.size();
		double randomInt = createRandom();
		if (averageLives >= 1.5 && randomInt <= 0) {
			Monster leftMonster = monsterLeaves();
			randomOccured.add("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");
			System.out.println("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");	
		} else if (averageLives < 1.5 && randomInt <= 0.1) {
			Monster leftMonster = monsterLeaves();
			randomOccured.add("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");
			System.out.println("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");
		}
		
	}
	
	/**
	 * Monster leaves. A randomly chosen Monster selected when the above method is called and requirements for a monster leaving are met.
	 *
	 * @return the monster that is removed from the team.
	 */
	public static Monster monsterLeaves() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(monsterTeam.size());
	    Monster leftMonster = monsterTeam.get(randomInt);
	    monsterTeam.remove(randomInt);
	    return leftMonster;
	}
	
	
	/**
	 * Joins overnight. Based on the players difficulty, a new monster can join over night
	 * Generates an array list of possible Monsters to join the team
	 * If difficulty is easy, there is a 30% chance a random monster joins
	 * If difficulty is medium, there is a 20% chance a random monster joins
	 * If difficulty is hard, there is a 10% chance a random monster joins
	 */
	public static void joinsOvernight() {
		String difficulty = player.getDifficulty();
		MonsterGenerator monGenerator = new MonsterGenerator();
		ArrayList<Monster> newMonsters = monGenerator.generator();
		double randomInt = createRandom();
		if (difficulty.equals("1") && randomInt <= 0.2) {
			Random rndm = new Random();
		    int randomInteger = rndm.nextInt(newMonsters.size());
			monsterTeam.add(newMonsters.get(randomInteger));
		} else if (difficulty.equals("2") && randomInt <= 0.1) {
			Random rndm = new Random();
		    int randomInteger = rndm.nextInt(newMonsters.size());
			monsterTeam.add(newMonsters.get(randomInteger));
		} else if (difficulty.equals("3") && randomInt <= 0.0) {
			Random rndm = new Random();
		    int randomInteger = rndm.nextInt(newMonsters.size());
			monsterTeam.add(newMonsters.get(randomInteger));
		}
		
		
	}
	

}