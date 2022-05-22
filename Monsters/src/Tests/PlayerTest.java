package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CommandLine.Monster;
import CommandLine.Player;
import CommandLine.Item;

class PlayerTest {
	/** Player to use in tests*/
	Player testPlayer;
	
	/** Two monsters to use in tests*/
	Monster startingMonster, testMonster;
	
	/** Item to use in tests*/
	Item testDamagePotion;
	
	/** creating monsters, player and item for tests*/
	@BeforeEach
	void setUp() throws Exception { 
		startingMonster = new Monster("Tester", 50, 10, 10);
		testPlayer = new Player("Emma", "Easy", startingMonster, 10);
		testDamagePotion = new Item("Magic attack potion" , "damage", 15, 3, 60);
		testMonster = new Monster("Another", 50, 10, 10);
		
	}

	/** Tests increasePoints method*/
	@Test
	void testIncreasePoints() {
		testPlayer.increasePoints(45);
		assertEquals(45, testPlayer.getPoints());
	}

	
	/** Tests decreasePoints method*/
	@Test
	void testDecreasepoints() {
		testPlayer.increasePoints(45);
		testPlayer.decreasepoints(15);
		assertEquals(30, testPlayer.getPoints());
	}

	/** Tests addItem method*/
	@Test
	void testAddItem() {
		testPlayer.addItem(testDamagePotion);
		assertEquals(1, testPlayer.getNumItems("Magic attack potion"));
	}

	/** Tests removeItem method*/
	@Test
	void testRemoveItem() {
		testPlayer.addItem(testDamagePotion);
		testPlayer.removeItem(testDamagePotion);
		assertEquals(0, testPlayer.getNumItems("Magic attack potion"));
	}

	/** Tests addTeamMate method*/
	@Test
	void testAddTeamMate() {
		testPlayer.addTeamMate(testMonster);
		assertEquals("Name: Tester\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3\nName: Another\nMax-Health: 100\nCurrent Health: 100\nDamage: 50\nHeal Amount: 10\nLives Remaining: 3\n",testPlayer.printCurrentTeam());
	}

	
	/** Tests removeTeamMate method*/
	@Test
	void testRemoveTeamMate() {
		testPlayer.removeTeamMate(startingMonster);
		assertEquals("Your team is empty. Buy a monster at the shop!", testPlayer.printCurrentTeam());
	}

	/** Tests incrementDay method*/
	@Test
	void testIncrementDay() {
		
		testPlayer.incrementDay();
		assertEquals(2, testPlayer.getDay());
	}

	
	/** Tests endGame method*/
	@Test
	void testEndGame() {
		testPlayer.endGame();
		assertEquals(testPlayer.getDay(), testPlayer.getFinishDay());
	}

	/** Tests increaseGold method*/
	@Test
	void testIncreaseGold() {
		testPlayer.increaseGold(50);
		assertEquals(250, testPlayer.getgold());
	}
	
	/** Tests decreaseGold method*/

	@Test
	void testDecreaseGold() {
		testPlayer.decreaseGold(20);
		assertEquals(180, testPlayer.getgold());
	}

}
