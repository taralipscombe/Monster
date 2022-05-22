package CommandLine;

/**
 * 
 * The class Monster.
 *
 */
public class Monster {
	/**
	 * name  name of monster
	 * maxHealth  Maximum health a monster can reach
	 * damage  integer amount of damage the monster can do to another during battle
	 * healAmount  how much the monster heals overnight
	 * currentHealth  the current health of the monster
	 * lives  amount of lives the monster has left
	 * price  price of the monster in gold
	 */
	
	private String name;
	private int maxHealth;
	private int damage;
	private int healAmount;
	private int currentHealth;
	private int lives;
	private int price;
	
	public Monster() {
		
	}
	
	/**
	 * Instantiates a new Monster.
	 *
	 * @param givenName the name string to set as the monster's name
	 * @param givenDamage integer to set the monster's damage as
	 * @param heal amount monster should heal by
	 * @param cost amount to set as price of monster
	 */
	public Monster(String givenName, int givenDamage, int heal, int cost) {
		name = givenName;
		maxHealth = 100;
		damage = givenDamage;
		healAmount = heal;
		currentHealth = 100;
		lives = 3;
		price = cost;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Gets the lives.
	 *
	 * @return the number of lives
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * decreases the lives of the Monster by 1
	 */
	public void removeLife() {
		lives -= 1;
	}
	/**
	 * increases the lives of the Monster by 1
	 */
	public void addLife() {
		lives += 1;
	}
	/**
	 * Gets the name of the Monster.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the Monster.
	 */
	public void setName(String monsterName) {
		name = monsterName;
	}
	
	/**
	 * Gets the max health
	 *
	 * @return the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	/**
	 * Sets the max health.
	 * @param monsterMaxHealth to set it with
	 */
	public void setMaxHealth(int monsterMaxHealth) {
		maxHealth = monsterMaxHealth;
	}
	/**
	 * Gets the damage amount.
	 *
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Sets the damage amount
	 * @param monsterDamage
	 */
	public void setDamage(int monsterDamage) {
		damage = monsterDamage;
	}
	/**
	 * Gets the heal amount.
	 *
	 * @return the healAmount
	 */
	public int getHealAmount() {
		return healAmount;
	}
	/**
	 * Sets the heal amount.
	 *
	 * @param monsterHealAmount to use to set
	 */
	public void setHealAmount(int monsterHealAmount) {
		healAmount = monsterHealAmount;
	}
	/**
	 * Gets the current health.
	 *
	 * @return the current health
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	/**
	 * Sets the current health.
	 *
	 * @param monsterCurrentHealth to use to set with
	 */
	public void setCurrentHealth(int monsterCurrentHealth) {
		currentHealth = monsterCurrentHealth;
	}
	/**
	 * decreases the @param monsterOpponent 's health by the damage of the monster
	 */
	public void attack(Monster monsterOpponent) {
		int opponentHealth = monsterOpponent.getCurrentHealth();
		opponentHealth = opponentHealth - damage;
		monsterOpponent.setCurrentHealth(opponentHealth);
		if (monsterOpponent.getCurrentHealth() < 0) {
			monsterOpponent.setCurrentHealth(0);
			monsterOpponent.removeLife();
		}
	}
	/**
	 * Increases the current health by the heal amount
	 */
	public void heal() {
		currentHealth = currentHealth + healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	/**
	 * Creates a string describing the Monster for the command line
	 * @return the string
	 */
	public String commandLineToString() {
		return "Name: " + name+"\n"+"Max-Health: " + maxHealth+"\n"+"Current Health: " + currentHealth+"\n"+"Damage: " + damage+"\n"+"Heal Amount: " + healAmount+"\n"+"Lives Remaining: " + lives;
	}
	/**
	 * Creates a simple string describing the Monster
	 * @return the string
	 */
	public String toString() {
		return "The monster's name is " + name + ". It attacks with "+ damage + " units of power and heals " + healAmount + " units every night.";
	}

	
	
	
}
