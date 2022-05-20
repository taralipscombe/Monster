package GUI;


import java.util.ArrayList;


public class MainScreen {
	
	private static BattleGenerator battles;
	private static Player player;
	private static ArrayList<Monster> enemyTeamOne = null;
	private static ArrayList<Monster> enemyTeamTwo = null;
	private static ArrayList<Monster> enemyTeamThree = null;
	
	public MainScreen(Player thePlayer) {
		player = thePlayer;
		BattleGenerator battleGen = new BattleGenerator(player);
		battles = battleGen;
	}

	public Player getPlayer() {
		return player;
	}
	
	public ArrayList<Monster> getEnemyTeam(int num){
		if (num == 1) {
			return enemyTeamOne;
		} else if (num == 2) {
			return enemyTeamTwo;
		} else {
			return enemyTeamThree;
		}
	}
	
	public void generateNewBattles() {
		
		enemyTeamOne = null;
		enemyTeamTwo = null;
		enemyTeamThree = null;
		viewBattles();
		
	}
	
	public static void viewBattles() {
		//currently not implemented, use Battle generator class to randomise battles

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

	
