package GUI;

/**
 * 
 * The class Item.
 *
 */

public class Item {
	/**
	 * name  name of item
	 * property  property of monster that the item enhances - damage or heal amount or number of lives
	 * propertyChange  amount the property is increased by
	 * usage  how many times the item can be used
	 * purchasePrice  how much gold it costs the player to buy the item
	 * sellbackPrice  starts as the same as the purchasePrice, decreases proportionaly as item is used.
	 */
	private String name, property;
	private int propertyChange, usage;
	private int purchasePrice, sellbackPrice;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param itemName the name of the item
	 * @param propertyName the property which the item changes
	 * @param change the amount property changes by
	 * @param itemUsage the number times item can be used
	 * @param price cost of item in gold
	 */
	
	public Item(String itemName, String propertyName, int change, int itemUsage, int price) {
		name = itemName;
		property = propertyName;
		propertyChange = change;
		usage = itemUsage;
		purchasePrice = price;
		sellbackPrice = price;
	}
	
	/**
	 * Uses an item on a monster.
	 *
	 * @param monster the monster to use the item on
	 */
	public void useItem(Monster monster) {
		if (property.equals("damage")) {
			int damage = monster.getDamage();
			monster.setDamage(damage + propertyChange);

		}else if (property.equals("heal amount")) {
			int healAmount = monster.getHealAmount();
			monster.setHealAmount(healAmount + propertyChange);
			
		}else if (property.equals("lives")) {
			monster.addLife();
		}
		int decrease = sellbackPrice / usage;
		usage = usage - 1;
		sellbackPrice = sellbackPrice - decrease;
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the purchasePrice.
	 *
	 * @return the purchasePrice
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}
	/**
	 * Gets the sellbackPrice.
	 *
	 * @return the sellbackPrice
	 */
	public int getsellbackPrice() {
		return sellbackPrice;
	}
	/**
	 * Gets the property.
	 *
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * Gets the change amount.
	 *
	 * @return the change
	 */
	public int getChange() {
		return propertyChange;
	}
	
	/**
	 * Gets the usage.
	 *
	 * @return the usage
	 */
	public int getUsage() {
		return usage;
	}
	/**
	 * set the string of the item
	 * @return the string
	 */
	public String toString() {
		if(name == "Lucky Dip") {
			return "Lucky Dip gives you a randomly generated item from the shop! Try your luck!";
		}
		return "Item: "+name+"\nIncreases "+property+" by "+propertyChange;
	}
	/**
	 * Creates a string describing the attributes of the item.
	 *
	 * @return the string
	 */
	public String printAttributes() {
		String retstr = "";
		retstr+="Item name: " + name+"\n";
		retstr+="Item's Property: " + property+"\n";
		retstr+="Item's current usage: " + usage;
		return retstr;
	}
	
	
}
