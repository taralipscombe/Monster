package CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * The Class MonsterGenerator.
 */
public class MonsterGenerator {
	
	/** The array list of Monsters to be returned after generated. */
	private ArrayList<Monster> returnableMonsters = new ArrayList<Monster>();
	
	/** The array list of potential monster names. */
	private ArrayList<String> monsterNames = new ArrayList<String>(Arrays.asList("Ed", "Bruno", "Micheal", "Justin", "Joe", "Kevin", "Nick", "Billy", "Elton",
			"Charlie", "Shawn", "John", "Prince"));
	
	/**
	 * Instantiates a new monster generator.
	 */
	public MonsterGenerator() {
	
	}
	
	
	/**
	 * Generator. Generates the array list of Monsters
	 *
	 * @return the array list of returnable monsters
	 */
	public ArrayList<Monster> generator(){
		int i = 0;
		while (i < 4) {
			Monster newMonster = newMonster();
			returnableMonsters.add(newMonster);
			i += 1;
		}
		return this.returnableMonsters;
	}
	
	
	
	/**
	 * New monster. Creates a single randomised Monster.
	 *
	 * @return the monster created 
	 */
	public Monster newMonster() {
		String name = randomName();
		int damage = randomDamage();
		int heal = randomHeal();
		int price = damage + heal;
		Monster monster = new Monster(name, damage, heal, price);
		return monster;
	}
	
	/**
	 * Random name. Selects a random name from the given array list of potential Names
	 *
	 * @return the string of the name chosen
	 */
	public String randomName() {
		int range = monsterNames.size();
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range);
	    String name = monsterNames.get(randomInt);
	    while (!checkName(name)) {
		    int nextRandomInt = rndm.nextInt(range);
		    name = monsterNames.get(nextRandomInt);
	    }
	    return name;
		
	}
	
	/**
	 * Check name. Checks the name chosen wasnt already a name of another Monster in the returnable team
	 *
	 * @param name the name chosen 
	 * @return true, if successful
	 */
	public boolean checkName(String name) {
		for(Monster monster : returnableMonsters) {
	    	if (monster.getName().equals(name)) {
	    		return false;
	    	}
	    }
		return true;
	}
	
	/**
	 * Random damage. Generates a random damage between 0 and 50 (max Damage initially given to a Monster)
	 *
	 * @return the int of the damage given to monster
	 */
	public int randomDamage() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(50);
	    return randomInt;
	}
	
	/**
	 * Random heal. Generates a random heal amount between 0 and 35 (max heal amount initially given to a Monster)
	 *
	 * @return the int of the heal amount given to a monster
	 */
	public int randomHeal() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(35);
	    return randomInt;
	}
	/**
	 * gets the monsterNames array list
	 * @return monsterNames 
	 */
	public ArrayList<String> getPossibleNamesList() {
		return monsterNames;
	}
}

	
	
