
public class Monster {
	
	private String name;
	private int maxHealth;
	private int damage;
	private int healAmount;
	private int currentHealth;
	private int lives;
	private int price;
	
	public Monster() {
		
	}
	
	public Monster(String givenName, int givenDamage, int heal, int cost) {
		name = givenName;
		maxHealth = 100;
		damage = givenDamage;
		healAmount = heal;
		currentHealth = 100;
		lives = 3;
		price = cost;
	}
	
	
	public int getPrice() {
		return price;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void removeLife() {
		lives -= 1;
	}
	
	public void addLife() {
		lives += 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String monsterName) {
		name = monsterName;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int monsterMaxHealth) {
		maxHealth = monsterMaxHealth;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int monsterDamage) {
		damage = monsterDamage;
	}
	
	public int getHealAmount() {
		return healAmount;
	}
	
	public void setHealAmount(int monsterHealAmount) {
		healAmount = monsterHealAmount;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentHealth(int monsterCurrentHealth) {
		currentHealth = monsterCurrentHealth;
	}
	
	public void attack(Monster monsterOpponent) {
		int opponentHealth = monsterOpponent.getCurrentHealth();
		opponentHealth = opponentHealth - damage;
		monsterOpponent.setCurrentHealth(opponentHealth);
		if (monsterOpponent.getCurrentHealth() < 0) {
			monsterOpponent.setCurrentHealth(0);
			monsterOpponent.removeLife();
		}
	}
	
	public void heal() {
		currentHealth = currentHealth + healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	
	public String commandLineToString() {
		return "Name: " + name+"\n"+"Max-Health: " + maxHealth+"\n"+"Current Health: " + currentHealth+"\n"+"Damage: " + damage+"\n"+"Heal Amount: " + healAmount+"\n"+"Lives Remaining: " + lives;
	}
	
	public String toString() {
		return "The monster's name is " + name + ". It attacks with "+ damage + " units of power and heals " + healAmount + " units every night.";
	}

	
	
	
}

