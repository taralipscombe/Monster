package GUI;

/**
 * 
 * The class Monster.
 *
 */
public class Monster {

	/**name  name of monster*/
	private String name;
	
	/**maxHealth  Maximum health a monster can reach*/
	private int maxHealth;
	
	/**damage  integer amount of damage the monster can do to another during battle*/
	private int damage;
	
	/**healAmount  how much the monster heals overnight*/
	private int healAmount;
	
	/**currentHealth  the current health of the monster*/
	private int currentHealth;
	
	/**lives  amount of lives the monster has left*/
	private int lives;
	
	/** price  price of the monster in gold*/
	private int price;
	
	
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
	 * getPrice Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * getLives Gets the lives.
	 *
	 * @return the number of lives
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * removeLife decreases the lives of the Monster by 1
	 */
	public void removeLife() {
		lives -= 1;
	}
	/**
	 * addLife , increases the lives of the Monster by 1
	 */
	public void addLife() {
		lives += 1;
	}
	/**
	 * getName , Gets the name of the Monster.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 *setName ,  Sets the name of the Monster.
	 *
	 *@param monsterName The name to be set
	 */
	public void setName(String monsterName) {
		name = monsterName;
	}
	
	/**
	 * getMaxHealth , Gets the max health
	 *
	 * @return the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	/**
	 * setMaxHealth , Sets the max health.
	 * @param monsterMaxHealth to set it with
	 */
	public void setMaxHealth(int monsterMaxHealth) {
		maxHealth = monsterMaxHealth;
	}
	/**
	 * getDamage , Gets the damage amount.
	 *
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * setDamage , Sets the damage amount
	 * @param monsterDamage integer amount
	 */
	public void setDamage(int monsterDamage) {
		damage = monsterDamage;
	}
	/**
	 * getHealAmount , Gets the heal amount.
	 *
	 * @return the healAmount
	 */
	public int getHealAmount() {
		return healAmount;
	}
	/**
	 * setHealAmount , Sets the heal amount.
	 *
	 * @param monsterHealAmount to use to set
	 */
	public void setHealAmount(int monsterHealAmount) {
		healAmount = monsterHealAmount;
	}
	/**
	 * getCurrentHealth , Gets the current health.
	 *
	 * @return the current health
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	/**
	 * setCurrentHealth , Sets the current health.
	 *
	 * @param monsterCurrentHealth to use to set with
	 */
	public void setCurrentHealth(int monsterCurrentHealth) {
		currentHealth = monsterCurrentHealth;
	}
	/**
	 * attack , decreases opponent by monster's damage 
	 * @param monsterOpponent decreases this health by the damage of the monster
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
	 * heal , Increases the current health by the heal amount
	 */
	public void heal() {
		currentHealth = currentHealth + healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	/**
	 * commandLineToString , Creates a string describing the Monster for the command line
	 * @return the string
	 */
	public String commandLineToString() {
		return "Name: " + name+"\n"+"Max-Health: " + maxHealth+"\n"+"Current Health: " + currentHealth+"\n"+"Damage: " + damage+"\n"+"Heal Amount: " + healAmount+"\n"+"Lives Remaining: " + lives;
	}
	/**
	 * toString Creates a simple string describing the Monster
	 * @return the string
	 */
	public String toString() {
		return "The monster's name is " + name + ". It attacks with "+ damage + " units of power and heals " + healAmount + " units every night.";
	}

	
	
	
}
