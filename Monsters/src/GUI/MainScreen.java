package GUI;


import java.util.ArrayList;

/**
 * 
 * MainScreen class, where player chooses has different options on their next move
 *
 */
public class MainScreen {
	
	/**
	 * battles  Type BattleGenerator
	 */
	private static BattleGenerator battles;
	
	/**
	 * player  player of the game
	 */
	private static Player player;
	
	/**
	 * ArrayList of first enemy team 
	 */
	private static ArrayList<Monster> enemyTeamOne = null;
	
	/**
	 * ArrayList of second enemy team 
	 */
	private static ArrayList<Monster> enemyTeamTwo = null;
	
	/**
	 * ArrayList of third enemy team 
	 */
	private static ArrayList<Monster> enemyTeamThree = null;
	
	
	/**
	 * MainScreen, Instantiates a new MainScreen.
	 *
	 * @param thePlayer the player of the game.
	 */
	public MainScreen(Player thePlayer) {
		player = thePlayer;
		BattleGenerator battleGen = new BattleGenerator(player);
		battles = battleGen;
	}

	/**
	 * getPlayer, Gets the player.
	 *
	 * @return player the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * getEnemyTeam, Gets the enemy team
	 * 
	 * @param num number of monsters wanted in the team
	 * @return the array list of Monsters
	 */
	public ArrayList<Monster> getEnemyTeam(int num){
		if (num == 1) {
			return enemyTeamOne;
		} else if (num == 2) {
			return enemyTeamTwo;
		} else {
			return enemyTeamThree;
		}
	}
	
	
	/**
	 * 
	 *  generateNewBattles, Generates 3 new battle options
	 */
	public void generateNewBattles() {
		
		enemyTeamOne = null;
		enemyTeamTwo = null;
		enemyTeamThree = null;
		viewBattles();
		
	}
	
	/**
	 * viewBattles, Creates three random options of battles for the player and displays them to the user.
	 */
	public static void viewBattles() {

		if (enemyTeamOne == null) {
		ArrayList<Monster> firstEnemyTeam = battles.generateTeam();
		enemyTeamOne = firstEnemyTeam;
		}
		if (enemyTeamTwo == null) { 
		ArrayList<Monster> secondEnemyTeam = battles.generateTeam();
		enemyTeamTwo = secondEnemyTeam;
		}
		if (enemyTeamThree == null) {
			ArrayList<Monster> enemyTeam = battles.generateTeam();
			enemyTeamThree = enemyTeam;	
		}
		
		}
	

	}

	
