import java.util.ArrayList;

public class Battle {
	
	private static Player player;
	private static ArrayList<Monster> playersTeam;
	private static ArrayList<Monster> enemyTeam;
	
	
	public Battle(Player thePlayer, ArrayList<Monster> enemy) {
		player = thePlayer;
		enemyTeam = enemy;
		playersTeam = player.getTeam();
	}
	
	public static void fight() {
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
	
	public static void awardLoss() {
		System.out.println("Oh no! Your team was defeated and killed in Battle!");
		
	}

}
