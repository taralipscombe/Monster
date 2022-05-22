import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test for the item class
 *
 */
class ItemTest {
	Item testDamagePotion, testLuckyDip, testHealPotion, testExtraLife;
	Monster testMonster;
	
	/**
	 * Creates a monster and the 4 different items to be used in each method
	 */
	@BeforeEach
	void setUp() throws Exception {
		testMonster= new Monster("Tester", 100, 100, 12);
		testDamagePotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		testLuckyDip = new Item("Lucky Dip", "unknown", 0, 1, 44);
		testHealPotion= new Item("Magic healing potion" , "heal amount" , 10, 3, 45);
		testExtraLife = new Item("Extra Life", "lives", 1, 1, 70);
	}
	/**
	 * Tests the useItem method
	 */
	@Test
	void testUseItem() {
		testDamagePotion.useItem(testMonster);
		assertEquals(115, testMonster.getDamage());
		assertEquals(40, testDamagePotion.getsellbackPrice());
		
		testHealPotion.useItem(testMonster);
		assertEquals(110, testMonster.getHealAmount());

		testExtraLife.useItem(testMonster);
		assertEquals(4, testMonster.getLives());
	}

	/**
	 * Tests the printAttributes method
	 */
	@Test
	void testPrintAttributes() {
		testDamagePotion.useItem(testMonster);
		assertEquals("Item name: Magic attack potion\nItem's Property: damage\nItem's current usage: 2", testDamagePotion.printAttributes());
	}
	
	/**
	 * Tests the toStringMethod
	 */
	@Test
	void testToString() {
		assertEquals("Lucky Dip gives you a randomly generated item from the shop! Try your luck!", testLuckyDip.toString());
		assertEquals("Item: Extra Life\nIncreases lives by 1", testExtraLife.toString());
		
	}

}
