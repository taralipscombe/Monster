import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonsterTest {
	private Monster testMonster, testOpponent;
	
	
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new Monster("Tester", 50, 10, 10);
		testOpponent = new Monster("Enemy", 50, 10, 10);
	}

	@Test
	void testRemoveLife() {
		testMonster.removeLife();
		assertEquals(2, testMonster.getLives());
	}

	@Test
	void testAddLife() {
		testMonster.addLife();
		assertEquals(4, testMonster.getLives());
		
	}

	@Test
	void testAttack() {
		testMonster.attack(testOpponent);
		assertEquals(50, testOpponent.getCurrentHealth());
		testOpponent.attack(testMonster);
		assertEquals(50, testMonster.getCurrentHealth());
	}

	@Test
	void testHeal() {
		testOpponent.attack(testMonster);
		testMonster.heal();
		assertEquals(60, testMonster.getCurrentHealth());
	}

	@Test
	void testCommandLineToString() {
		assertEquals("Name: Tester\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3", testMonster.commandLineToString());
	}

	@Test
	void testToString() {
		assertEquals("The monster's name is Tester. It attacks with 50 units of power and heals 10 units every night.",testMonster.toString());
	}

}
