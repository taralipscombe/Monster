package CommandLine;

import java.util.ArrayList;


/** 
 * 
 * class Battle
 *
 */
public class Battle {
	
	/** The player of the game. */
	private static Player player;
	
	/** The players team of Monsters. */
	private static ArrayList<Monster> playersTeam;
	
	/** The enemy team of Monsters. */
	private static ArrayList<Monster> enemyTeam;
	
	
	/**
	 * Instantiates a new battle.
	 *
	 * @param thePlayer the player of the game
	 * @param enemy the Array List of Monsters that the player will battle
	 */
	public Battle(Player thePlayer, ArrayList<Monster> enemy) {
		player = thePlayer;
		enemyTeam = enemy;
		playersTeam = player.getTeam();
	}
	
	/**
	 * Fight.
	 * The Players team will "fight" the enemy team, until all Monsters in one team are killed (reach 0 health)
	 * At which stage the battle is either won or lost
	 */
	public void fight() {
		int numPlayerMonster = 0;
		int numEnemyMonster = 0;
		while  (numPlayerMonster < playersTeam.size() && numEnemyMonster < enemyTeam.size()) {
			Monster playerMonster = playersTeam.get(numPlayerMonster);
			Monster enemyMonster = enemyTeam.get(numEnemyMonster);
			while (playerMonster.getCurrentHealth() > 0 && enemyMonster.getCurrentHealth() > 0 ) {
				playerMonster.attack(enemyMonster);
				if (enemyMonster.getCurrentHealth() > 0) {
					enemyMonster.attack(playerMonster);
				} 
			}
			if  (playerMonster.getCurrentHealth() <= 0) {
				// reduce playermonster lives
				System.out.println("Owwwww!");
				System.out.println("Oh no! " + playerMonster.getName() + " has just died!");
				numPlayerMonster += 1;
			} 
			if (enemyMonster.getCurrentHealth() <= 0) {
				// reduce enemymonster lives nvm cause never used again
				System.out.println("Wapow!");
				System.out.println("Yay! " + playerMonster.getName() + " has just killed the enemy monster " + enemyMonster.getName() + " - you gained 25 points");
				player.increasePoints(25);
				numEnemyMonster += 1;
			}
		}
		if (numPlayerMonster >= playersTeam.size() ) {
			awardLoss();
		} else {
			//enemy team lost
			awardWin();
		}
		for(Monster monster:player.getTeam()) {
			if(monster.getLives()==0) {
				player.removeTeamMate(monster);
			}
		}
		
	}
	
	/**
	 * Award win.
	 * If Players Monster team won the above battle, the awardWin method is called to increase the players gold and points.
	 * Prints the gold won by the player.
	 */
	public static void awardWin() {
		System.out.println("Congratulations on Winning the Battle!");
		int average = 0;
		for (Monster monster : enemyTeam) {
			average += monster.getDamage();
		}
		average = average / enemyTeam.size();
		player.increaseGold(average);
		player.increasePoints(50);
		System.out.println("You have been awarded with " + average + " gold and 50 extra points!");
		// could just be awarded the average power in enemy team - more enemy power = more reward
		
	}
	
	/**
	 * Award loss.
	 * If Players Monster team lost the above battle, the awardLoss method is called.
	 * Prints the loss of the battle.
	 */
	public static void awardLoss() {
		System.out.println("Oh no! Your team was defeated and killed in Battle!");
		
	}

}
