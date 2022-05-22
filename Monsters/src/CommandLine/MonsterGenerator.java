import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 *MonsterGenerator Class.
 *
 */
public class MonsterGenerator {
	
	/** Array list of randomly generated monsters*/
	private ArrayList<Monster> returnableMonsters = new ArrayList<Monster>();
	
	/** Array list of possible names monsters can be generated with*/
	private ArrayList<String> monsterNames = new ArrayList<String>(Arrays.asList("Ed", "Bruno", "Micheal", "Justin", "Joe", "Kevin", "Nick", "Billy", "Elton",
			"Charlie", "Shawn", "John", "Prince"));
	
	public MonsterGenerator() {
	
	}
	
	/**
	 * gets the monsterNames array list
	 * @return monsterNames 
	 */
	public ArrayList<String> getPossibleNamesList() {
		return monsterNames;
	}
	
	/**
	 * generates a random monster 4 times and adds it to the returnableMonsters array list.
	 * @return the array list after having added the 4 monsters 
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
	 * generates a monster with a ranom name, random damage, random heal amount and sets the price to the sum of the damage and heal amounts.
	 * @return monster
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
	 * Randomly chooses a name from the list monsterNames
	 * @return a name
	 */
	public String randomName() {
		int range = monsterNames.size();
	    Random rndm = new Random();
	    int randomInt = rndm.nextInt(range);
	    return monsterNames.get(randomInt);
		
	}
	
	/**
	 * Randomly chooses an integer in the range (0,50)
	 * @return integer
	 */
	public int randomDamage() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(50);
	    return randomInt;
	}
	
	/**
	 * Randomly chooses an integer in the range (0, 35)
	 * @return integer
	 */
	public int randomHeal() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(35);
	    return randomInt;
	}

}
