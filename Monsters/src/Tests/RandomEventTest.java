import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The testing Class RandomEventTest.
 */
class RandomEventTest {
	
	/** The monsters created  */
	Monster monOne, monTwo, monThree, monFour;
	
	/**  A team of One Monster. */
	ArrayList<Monster> testMonsterTeamOne = new ArrayList<Monster>(new Monster("first monster", 30, 25, 55));
	
	/**  A team of Two Monsters. */
	ArrayList<Monster> testMonsterTeamTwo = new ArrayList<Monster>();
	
	/**  A team of Three Monsters. */
	ArrayList<Monster> testMonsterTeamThree = new ArrayList<Monster>();
	
	/** A team of Four Monsters. */
	ArrayList<Monster> testMonsterTeamFour = new ArrayList<Monster>();
	
	/** The player. */
	Player player;
	
	/**
	 * Setup. Sets the monster team variables above.
	 *
	 * @throws exception the exception
	 */
	@BeforeEach
	void Setup() throws exception{
		//public Monster(String givenName, int givenDamage, int heal, int cost) {
		
		monOne = new Monster("first monster", 30, 25, 55);
		player = new Player("Player", "2", monOne, 5)
		monTwo = new Monster("second monster", 35, 20, 55);
		monThree = new Monster("third monster", 25, 30, 55);
		monFour = new Monster("fourth monster", 20, 35, 55);
		
	}


	/**
	 * Test.
	 */
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
