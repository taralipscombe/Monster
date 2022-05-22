package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import CommandLine.BattleGenerator;
import CommandLine.Monster;
import CommandLine.Player;
import CommandLine.RandomEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class BattleGeneratorTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class BattleGeneratorTest {
	
	/**  The monsters created. */
	Monster monOne, monTwo, monThree;
	
	/** The player. */
	Player player;
	
	/** The battle generator test instance. */
	BattleGenerator battleGenTest;
	
	/** The potential names (same as in the BattleGenerator class). */
	ArrayList<String> potentialNames = new ArrayList<String>(Arrays.asList("Bewarewolf", "Lunatick", "Clawcerer", "Badboon", 
			"Artichoker", "Hammer", "Assassin", "Coomba", "Bandit", "Bruiser", "Scythid", "CoffinMan", "Bubbles", "Sparkles", "Spiker"));

	/**
	 * Sets up the variables
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	void setUp() throws Exception{
		monOne = new Monster("first monster", 30, 25, 55);
		monTwo = new Monster("second monster", 35, 20, 55);
		monThree = new Monster("third monster", 25, 30, 55);
		player = new Player("Player", "2", monOne, 5);
		player.addTeamMate(monTwo);
		player.addTeamMate(monThree);
		battleGenTest = new BattleGenerator(player);
		
	}
	
	
	/**
	 * Tests get winnings.
	 */
	@Test
	void testGetWinnings() {
		
		ArrayList<Monster> playersMonsters = player.getTeam();
		int actualAnswer = battleGenTest.getWinnings(playersMonsters);
		assertEquals(actualAnswer, 30);
		
	}
	
	/**
	 * Tests random.
	 */
	@Test
	void testRandom() {
		int randomInt = RandomEvent.random(25, 60);
		assertTrue(randomInt >= 25);
		assertTrue(randomInt < 60);
	}
	
	/**
	 * Tests adjust damage medium.
	 */
	@Test
	void testAdjustDamageMedium() {
		
		int damage = BattleGenerator.adjustDamageMedium();
		assertTrue(damage >= 0);
		assertTrue(damage < 50);
		
	}
	
	/**
	 * Tests adjust heal medium.
	 */
	@Test
	void testAdjustHealMedium() {
		
		int heal = BattleGenerator.adjustHealMedium();
		assertTrue(heal >= 0);
		assertTrue(heal < 35);
		
	}
	
	/**
	 * Tests generate name.
	 */
	@Test
	void testGenerateName() {
		
		String name = BattleGenerator.generateName();
		assertTrue(potentialNames.contains(name));
		
	}
	
	
	

}
