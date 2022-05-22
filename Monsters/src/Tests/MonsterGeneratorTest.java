
package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CommandLine.Item;
import CommandLine.Monster;


class MonsterGeneratorTest {
	/**New monster generator*/
	MonsterGenerator gen;
	
	/** Creates instance of monster generator to use in tests*/
	@BeforeEach
	void setUp() throws Exception {
		gen = new MonsterGenerator();
	}

	/** Tests generator method returns array list of monsters of the right size*/
	@Test
	void testGenerator() {
		assertEquals(4, gen.generator().size());
	}

	/** Tests randomName method returns a name from the given list of possibilities*/
	@Test
	void testRandomName() {
		assertTrue(gen.getPossibleNamesList().contains(gen.randomName()));
	}

	/** Tests randomDamage method returns integer in the given range*/
	@Test
	void testRandomDamage() {
		assertTrue(gen.randomDamage()>0 && gen.randomDamage()<=50);
	}

	/** Tests randomHeal method returns integer in the given range*/
	@Test
	void testRandomHeal() {
		assertTrue(gen.randomDamage()>0 && gen.randomDamage()<=35);
	}

}
