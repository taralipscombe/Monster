import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MonsterGenerator {
	
	private ArrayList<Monster> returnableMonsters = new ArrayList<Monster>();
	private ArrayList<String> monsterNames = new ArrayList<String>(Arrays.asList("Ed", "Bruno", "Micheal", "Justin", "Joe", "Kevin", "Nick", "Billy", "Elton",
			"Charlie", "Shawn", "John", "Prince"));
	
	public MonsterGenerator() {
	
	}
	
	
	public ArrayList<Monster> generator(){
		int i = 0;
		while (i < 4) {
			Monster newMonster = newMonster();
			returnableMonsters.add(newMonster);
			i += 1;
		}
		return this.returnableMonsters;
	}
	
	
	
	public Monster newMonster() {
		String name = randomName();
		int damage = randomDamage();
		int heal = randomHeal();
		int price = damage + heal;
		Monster monster = new Monster(name, damage, heal, price);
		return monster;
	}
	
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
	
	public boolean checkName(String name) {
		for(Monster monster : returnableMonsters) {
	    	if (monster.getName().equals(name)) {
	    		return false;
	    	}
	    }
		return true;
	}
	
	public int randomDamage() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(50);
	    return randomInt;
	}
	
	public int randomHeal() {
		Random rndm = new Random();
	    int randomInt = rndm.nextInt(35);
	    return randomInt;
	}

}

