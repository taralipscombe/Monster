import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Player testPlayer;
	Monster startingMonster, testMonster;
	Item testDamagePotion;

	@BeforeEach
	void setUp() throws Exception { 
		startingMonster = new Monster("Tester", 50, 10, 10);
		testPlayer = new Player("Emma", "Easy", startingMonster, 10);
		testDamagePotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		testMonster = new Monster("Another", 50, 10, 10);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIncreasePoints() {
		testPlayer.increasePoints(45);
		assertEquals(45, testPlayer.getPoints());
	}

	@Test
	void testDecreasepoints() {
		testPlayer.increasePoints(45);
		testPlayer.decreasepoints(15);
		assertEquals(30, testPlayer.getPoints());
	}

	@Test
	void testAddItem() {
		testPlayer.addItem(testDamagePotion);
		assertEquals(1, testPlayer.getNumItems("Magic attack potion"));
	}

	@Test
	void testRemoveItem() {
		testPlayer.addItem(testDamagePotion);
		testPlayer.removeItem(testDamagePotion);
		assertEquals(0, testPlayer.getNumItems("Magic attack potion"));
	}

	@Test
	void testAddTeamMate() {
		testPlayer.addTeamMate(testMonster);
		assertEquals("Name: Tester\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3\nName: Another\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3\n",testPlayer.printCurrentTeam());
	}

	@Test
	void testRemoveTeamMate() {
		testPlayer.removeTeamMate(startingMonster);
		assertEquals("Your team is empty. Buy a monster at the shop!", testPlayer.printCurrentTeam());
	}

	@Test
	void testIncrementDay() {
		testPlayer.incrementDay();
		assertEquals(2, testPlayer.getDay());
	}

	@Test
	void testEndGame() {
		testPlayer.endGame();
		assertEquals(testPlayer.getDay(), testPlayer.getFinishDay());
	}

	@Test
	void testIncreaseGold() {
		testPlayer.increaseGold(50);
		assertEquals(250, testPlayer.getgold());
	}

	@Test
	void testDecreaseGold() {
		testPlayer.decreaseGold(20);
		assertEquals(180, testPlayer.getgold());
	}

}
