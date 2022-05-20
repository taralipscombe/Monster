public class Item {
	private String name, property;
	private int propertyChange, usage;
	private int purchasePrice, sellbackPrice;
	
	public Item(String itemName, String propertyName, int change, int itemUsage, int price) {
		name = itemName;
		property = propertyName; //damage or heal or lives
		propertyChange = change; // amount by
		usage = itemUsage;
		purchasePrice = price;
		sellbackPrice = price;
	}
	
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
	

	public String getName() {
		return name;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getsellbackPrice() {
		return sellbackPrice;
	}
	
	public String getProperty() {
		return property;
	}
	
	public int getChange() {
		return propertyChange;
	}
	
	
	public int getUsage() {
		return usage;
	}
	
	public String toString() {
		if(name == "Lucky Dip") {
			return "Lucky Dip gives you a randomly generated item from the shop! Try your luck!";
		}
		return "Item: "+name+"\nIncreases "+property+" by "+propertyChange;
	}
	
	public String printAttributes() {
		String retstr = "";
		retstr+="Item name: " + name+"\n";
		retstr+="Item's Property: " + property+"\n";
		retstr+="Item's current usage: " + usage;
		return retstr;
	}
	
	
}