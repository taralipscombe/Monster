import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	private static ArrayList<Monster> monsterTeam;
	private static Player player;
	
	//a monster levels up overnight - one gains 15 attack, 40% (
	// a monster level down overnight - one loses 15 attack, 30% chance
	// a mosnter leaves, should increase with low lives, still quite low
	// above average 1.5 lives, only 5% chance, below average 1.5 lives, 20% chance
	// new monster joins - coudl include zayne, even if not day ten (only once a game), easy = 15%, medium = 10% , hard = 5%
	
	public RandomEvent(Player thePlayer) {
		player = thePlayer;
		monsterTeam = player.getTeam();

	}
	
	public void generate() {
		levelsUp();
		levelsDown();
		leavesOvernight();
	}
	
	public static int random(int min, int max) {
	    int range = (max - min) + 1;
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range) + min;
	    return randomInt;
	}
	
	
	public static double createRandom() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
		return range;
	}
	
	
	public static void levelsUp() {
		
		double randomInt = createRandom();
		if (randomInt < 0.4) {
			int range = monsterTeam.size();
			Random rndm = new Random();
			int rndmInt = rndm.nextInt(range);
			Monster levelUpMonster = monsterTeam.get(rndmInt);
			int initialDamage = levelUpMonster.getDamage();
			levelUpMonster.setDamage(initialDamage + 15);
			System.out.println("Congratulations " + levelUpMonster.getName() + " has leveled up! It's damage is now " + levelUpMonster.getDamage()+ " units.");
		}
		
	}
	
	public static void levelsDown() {
		double randomInt = createRandom();
		if (randomInt < 0.3) {
			int range = monsterTeam.size();
			Random rndm = new Random();
			int rndmInt = rndm.nextInt(range);
			Monster levelDownMonster = monsterTeam.get(rndmInt);
			int initialDamage = levelDownMonster.getDamage();
			levelDownMonster.setDamage(initialDamage -15);
			System.out.println("Oh no " + levelDownMonster.getName() + " has gotten sick overnight! It's damage is now " + levelDownMonster.getDamage()+ " units.");
		}
	}
	
	
	public static void leavesOvernight() {
		double averageLives = 0;
		for (Monster monster : monsterTeam) {
			averageLives += monster.getLives();
		}
		averageLives = averageLives / monsterTeam.size();
		double randomInt = createRandom();
		if (averageLives >= 1.5 && randomInt <= 0) {
			Monster leftMonster = monsterLeaves();
			System.out.println("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");	
		} else if (averageLives < 1.5 && randomInt <= 0.1) {
			Monster leftMonster = monsterLeaves();
			System.out.println("RIP " +  leftMonster.getName() + " has gotten COVID and died! You know have only " + monsterTeam.size() + " monsters left.");
		}
		
	}
	
	public static Monster monsterLeaves() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(monsterTeam.size());
	    Monster leftMonster = monsterTeam.get(randomInt);
	    monsterTeam.remove(randomInt);
	    return leftMonster;
	}
	
	
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
