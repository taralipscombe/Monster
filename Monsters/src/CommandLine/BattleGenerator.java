package CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/** 
 * 
 * class BattleGenerator
 *
 */
public class BattleGenerator {
	
	/** The players monster team. */
	private static ArrayList<Monster> monsterTeam;
	
	/** The difficulty chosen by the player. */
	private static String difficulty;
	
	/** The enemy team of Monsters. */
	private static ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	
	/** The potential names of Monsters. */
	private static ArrayList<String> potentialNames = new ArrayList<String>(Arrays.asList("Bewarewolf", "Lunatick", "Clawcerer", "Badboon", 
			"Artichoker", "Hammer", "Assassin", "Coomba", "Bandit", "Bruiser", "Scythid", "CoffinMan", "Bubbles", "Sparkles", "Spiker"));
	
	/** The offical player of the game. */
	private static Player player;
	
	
	
	/**
	 * Instantiates a new battle generator.
	 *
	 * @param newPlayer the new player
	 * Sets the local static variables, monsterTeam and difficulty.
	 * 
	 */
	public BattleGenerator(Player newPlayer) {
		player = newPlayer;
		monsterTeam = player.getTeam(); //do i have to use getter/setter methods or no?
		difficulty = player.getDifficulty();
		}
	
	
	
	/**
	 * Generate team. The method generates the team, and returns it for mainscreen to store, and then clears the arrayList.
	 *
	 * @return team an array list of Monsters 
	 * 
	 */
	public ArrayList<Monster> generateTeam() { // generates the team, mainscreen stores the team, then generate team clears the arrayList to null
		generateEnemies();
		ArrayList<Monster> team = new ArrayList<Monster>();
		printTeam();
		for (Monster monster : enemyTeam) {
			team.add(monster);
		}
		enemyTeam.clear();
		return team;
	}
	
	/**
	 * Gets the winnings.
	 *
	 * @param monsters the enemy Team of monsters, set to battle the player
	 * @return average the winnings the amount of gold awarded to player if battle is won
	 */
	public int getWinnings(ArrayList<Monster> monsters) {
		int average = 0;
		for (Monster monster : monsters) {
			average += monster.getDamage();
		}
		average = average / monsters.size();
		return average;
	}
	
	
	/**
	 * Prints the Player's Monster team.
	 */
	public static void printTeam() {
		for (Monster monster : enemyTeam) {
			System.out.println();
			System.out.println(monster.toString());
		}
		System.out.println();
	}
	
	/**
	 * Generate enemies. Matches the number of monsters in the players Monster Team to get even teams.
	 * Calls create enemy and adds the Monster to the enemyTeam
	 */
	public static void generateEnemies() {
		for (@SuppressWarnings("unused") Monster ourMonster : monsterTeam) {  // just matching the number of enemies to current monsters so unused variable
			Monster newEnemy = createEnemy();
			enemyTeam.add(newEnemy);
		}
	}
	
	
	/**
	 * Creates the enemy. Based on the difficulty chosen by the player, an enemy Monster is randomly generated using helper methods.
	 * 
	 *
	 * @return enemy the monster
	 */
	public static Monster createEnemy() {
		if (difficulty.equals("1")){
			// if easy, enemy has low damage, low heal amount
			int damage = adjustDamageEasy();
			int heal = adjustHealEasy();
			String name = generateName();
			Monster enemy = new Monster(name, damage, heal, 0);
			return enemy;
		} else if (difficulty.equals("2")) {
			int damage = adjustDamageMedium();
			int heal = adjustHealMedium();
			String name = generateName();
			Monster enemy = new Monster(name, damage, heal, 0);
			return enemy;	
		} else {
			int damage = adjustDamageHard();
			int heal = adjustHealHard();
			String name = generateName();
			Monster enemy = new Monster(name, damage, heal, 0);
			return enemy;
		}
	}
	
	/**
	 * Generate name. Chooses the name of the Monster from the local ArrayList of potential Monster names.
	 *
	 * @return the string
	 */
	public static String generateName() {
	    Random rndm = new Random();
	    String potentialName = "";
	    Boolean generated = false;
	    while(! generated) {
	    	int randomInt = rndm.nextInt(15);
	    	potentialName = potentialNames.get(randomInt);
	    	if (checkName(potentialName)) {
	    		generated = true;
	    	} 
	    }
	    return potentialName;
	}
	
	
	/**
	 * Check name. Checks the given potentialName and returns false if already given to another Monster in the same team or true if name can 
	 * be given to the Monster
	 *
	 * @param potentialName the potential name
	 * @return true , if successful
	 */
	public static boolean checkName(String potentialName) {
		for(Monster monster : enemyTeam) {
			if (monster.getName().equals(potentialName)){
				return false;
			}
		}
		return true;
	}
	

	
	/**
	 * Random. Generates a random number between the given minimum and maximum integers.
	 *
	 * @param min the minimum integer
	 * @param max the maximum integer
	 * @return randomInt the int the randomly generated integer
	 */
	public static int random(int min, int max) {
	    int range = (max - min) + 1;
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range) + min;
	    return randomInt;
	}
	
	
	/**
	 * Adjust damage easy. Randomly creates the damage of a Monster based on an easy difficulty
	 *
	 * @return the int the damage given to the Monster
	 */
	public static int adjustDamageEasy() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.8) {
	        return random(0, 15); // the random range
	    } else if (range <= 0.9) {
	        return random(16, 35);
	    } else {
	        return random(36, 50);
	    }
	}
	
	/**
	 * Adjust heal easy. Randomly creates the heal amount of a Monster based on an easy difficulty
	 *
	 * @return the int the heal amount given to the monster
	 */
	public static int adjustHealEasy() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.7) {
	        return random(0, 10); // the random range
	    } else if (range <= 0.9) {
	        return random(11, 25);
	    } else {
	        return random(26, 35);
	    }
	}
	
	/**
	 * Adjust damage medium. Randomly creates the damage of a Monster based on a medium difficulty
	 *
	 * @return the int the damage given to the monster
	 */
	public static int adjustDamageMedium() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.1) {
	        return random(0, 10); // the random range
	    } else if (range <= 0.8) {
	        return random(11, 32);
	    } else {
	        return random(33, 50);
	    }
	}
	
	/**
	 * Adjust heal medium. Randomly creates the heal amount of a Monster based on a medium difficulty
	 *
	 * @return the int the heal amount given to the monster
	 */
	public static int adjustHealMedium() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.1) {
	        return random(0, 10); // the random range
	    } else if (range <= 0.8) {
	        return random(11, 28);
	    } else {
	        return random(29, 35);
	    }
	}

	/**
	 * Adjust damage hard. Randomly creates the damage of a Monster based on a hard difficulty
	 *
	 * @return the int the damage given to the monster
	 */
	public static int adjustDamageHard() {
	
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.1) {
	        return random(0, 10); // the random range
	    } else if (range <= 0.2) {
	        return random(11, 30);
	    } else if (range < 0.7) {
	    	return random(31, 40);
	    } else {
	        return random(41, 50);
	    }
		}
		
	/**
	 * Adjust heal hard. Randomly creates the heal amount of a Monster based on a hard difficulty
	 *
	 * @return the int the heal amount given to a monster
	 */
	public static int adjustHealHard() {
		
		Random rndm = new Random();
		double range = rndm.nextDouble();
	    if (range <= 0.1) {
	        return random(0, 7); // the random range
	    } else if (range <= 0.2) {
	    	return random(8, 17);
	    } else if (range <= 0.7) {
	        return random(18, 23);
	    } else {
	        return random(24, 35);
	    }
	}
	
	//public static void main(String[] args) {
	//}

	

}
