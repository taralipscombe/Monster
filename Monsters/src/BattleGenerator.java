import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BattleGenerator {
	
	private static ArrayList<Monster> monsterTeam;
	private static String difficulty;
	private static ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	private static ArrayList<String> potentialNames = new ArrayList<String>(Arrays.asList("Bewarewolf", "Lunatick", "Clawcerer", "Badboon", 
			"Artichoker", "Hammer", "Assassin", "Coomba", "Bandit", "Bruiser", "Scythid", "CoffinMan", "Bubbles", "Sparkles", "Spiker"));
	private static Player player;
	
	
	
	public BattleGenerator(Player newPlayer) {
		player = newPlayer;
		monsterTeam = player.getTeam(); //do i have to use getter/setter methods or no?
		difficulty = player.getDifficulty();
		}
	
	
	
	public ArrayList<Monster> generateTeam() { // generates the team, mainscreen stores the team, then generate team clears the arrayList to null
		generateEnemies();
		ArrayList<Monster> team = new ArrayList<Monster>();
		printTeam();
		for (Monster monster : enemyTeam) {
			team.add(monster);
		}
		clearTeam();
		return team;
	}
	
	public int getWinnings(ArrayList<Monster> monsters) {
		int average = 0;
		for (Monster monster : monsters) {
			average += monster.getDamage();
		}
		average = average / monsters.size();
		return average;
	}
	
	
	public static void clearTeam() {
		enemyTeam.clear();
	}
		
	
	
	public static void printTeam() {
		for (Monster monster : enemyTeam) {
			System.out.println();
			System.out.println(monster.toString());
		}
		System.out.println();
	}
	
	public static void generateEnemies() {
		for (@SuppressWarnings("unused") Monster ourMonster : monsterTeam) {  // just matching the number of enemies to current monsters so unused variable
			Monster newEnemy = createEnemy();
			enemyTeam.add(newEnemy);
		}
	}
	
	
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
	
	
	public static boolean checkName(String potentialName) {
		boolean checking = true;
		for(Monster monster : enemyTeam) {
			if (monster.getName().equals(potentialName)){
				checking = false;
			}
		}
		return checking;
		
	}
	
	// damage = 50(max)
	// heal amount = 35(max)
	
	public static int random(int min, int max) {
	    int range = (max - min) + 1;
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range) + min;
	    return randomInt;
	}
	
	
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
