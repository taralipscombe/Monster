package Tests;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CommandLine.Monster;
import CommandLine.Player;
import CommandLine.RandomEvent;

// TODO: Auto-generated Javadoc
/**
 * The testing Class RandomEventTest.
 */
class RandomEventTest {
	
	/** The monsters created  */
	Monster monOne, monTwo, monThree;
	
	/** The player. */
	Player player;
	
	/** The testing random event instance. */
	RandomEvent testingRandomEvent;
	
	/**
	 * Setup. Sets the monster team variables above.
	 * @throws Exception for exception
	 */
	@BeforeEach
	void Setup() throws Exception{
		//public Monster(String givenName, int givenDamage, int heal, int cost) {
		
		monOne = new Monster("first monster", 30, 25, 55);
		monTwo = new Monster("second monster", 35, 20, 55);
		monThree = new Monster("third monster", 25, 30, 55);
		player = new Player("Player", "2", monOne, 5);
		player.addTeamMate(monTwo);
		player.addTeamMate(monThree);
		testingRandomEvent = new RandomEvent(player);
		
	}
	
	/**
	 * testCreateRandom Tests the createRandom method
	 */
	@Test
	void testCreateRandom() {
		double randomDouble = RandomEvent.createRandom();
		assertTrue(randomDouble >= 0.0);
		assertTrue(randomDouble < 1.0);
		
	}
	
	/**
	 * testRandom Tests the random method
	 */
	@Test
	void testRandom() {
		int randomInt = RandomEvent.random(25, 60);
		assertTrue(randomInt >= 25);
		assertTrue(randomInt < 60);
		
	}
	

	
	



}
