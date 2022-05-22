package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CommandLine.Monster;


/**
 * Test for the Monster class
 *
 */
class MonsterTest {
	/**
	 * testMonster Monster to use in tests
	 * testOpponent Monster to use in tests
	 *
	 */
	private Monster testMonster, testOpponent;
	
	/**
	 * Creates 2 monsters 'Tester' and 'Enemy' to use in the tests
	 * @throws Exception for exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new Monster("Tester", 50, 10, 10);
		testOpponent = new Monster("Enemy", 50, 10, 10);
	}
	
	/**
	 * Tests the removeLife() method
	 */
	@Test
	void testRemoveLife() {
		testMonster.removeLife();
		assertEquals(2, testMonster.getLives());
	}
	/**
	 * Tests the addLife() method
	 */
	@Test
	void testAddLife() {
		testMonster.addLife();
		assertEquals(4, testMonster.getLives());
		
	}
	/**
	 * Tests the testAttack() method
	 */
	@Test
	void testAttack() {
		testMonster.attack(testOpponent);
		assertEquals(50, testOpponent.getCurrentHealth());
		testOpponent.attack(testMonster);
		assertEquals(50, testMonster.getCurrentHealth());
	}
	/**
	 * Tests the testHeal() method
	 */
	@Test
	void testHeal() {
		testOpponent.attack(testMonster);
		testMonster.heal();
		assertEquals(60, testMonster.getCurrentHealth());
	}
	/**
	 * Tests the commandLineToString() method
	 */
	@Test
	void testCommandLineToString() {
		assertEquals("Name: Tester\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3", testMonster.commandLineToString());
	}

	/**
	 * Tests the toString() method
	 */
	@Test
	void testToString() {
		assertEquals("The monster's name is Tester. It attacks with 50 units of power and heals 10 units every night.",testMonster.toString());
	}

}
