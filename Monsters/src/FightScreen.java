
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class FightScreen.
 */
public class FightScreen {


	/** The frm fight. */
	public JFrame frmFight;
	
	/** The player. */
	private Player player;
	
	/** The player current. */
	private Monster playerCurrent;
	
	/** The num player current. */
	private int numPlayerCurrent = 0;
	
	/** The enemy team. */
	private ArrayList<Monster> enemyTeam;
	
	/** The enemy current. */
	private Monster enemyCurrent;
	
	/** The num enemy current. */
	private int numEnemyCurrent = 0;
	
	/** The battling. */
	private boolean battling = true;
	
	/** The txt time to battle. */
	private JTextField txtTimeToBattle;
	
	/** The txt players current. */
	private JTextField txtPlayersCurrent;
	
	/** The txt enemys current. */
	private JTextField txtEnemysCurrent;
	
	/** The lbl enemy mon. */
	private JLabel lblEnemyMon;
	
	/** The lbl player mon. */
	private JLabel lblPlayerMon;
	
	/** The btn attack. */
	private JButton btnAttack;
	
	/** The btn heal. */
	private JButton btnHeal;
	
	/** The txt players remaining. */
	private JTextField txtPlayersRemaining;
	
	/** The txt enemys remaining. */
	private JTextField txtEnemysRemaining;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Monster monster = new Monster("Fred", 1, 2, 3);
		Player playerOne = new Player("Emma", "1", monster, 7);
		BattleGenerator battles = new BattleGenerator(playerOne);
		ArrayList<Monster> enemies = battles.generateTeam();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FightScreen window = new FightScreen(playerOne, enemies);
					window.frmFight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. Gets the players first Monster. 
	 *
	 * @param ofcPlayer the official player of the Game
	 * @param enemies the Array list of the enemy Monsters the players has selected to battle.
	 */
	public FightScreen(Player ofcPlayer, ArrayList<Monster> enemies) {
		
		player = ofcPlayer;
		enemyTeam = enemies;
		playerCurrent = player.getTeam().get(0);
		enemyCurrent = enemyTeam.get(0);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFight = new JFrame();
		frmFight.setBounds(100, 100, 650, 450);
		frmFight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFight.getContentPane().setLayout(null);
		
		txtTimeToBattle = new JTextField();
		txtTimeToBattle.setEditable(false);
		txtTimeToBattle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtTimeToBattle.setText("TIME TO BATTLE!");
		txtTimeToBattle.setBounds(234, 16, 171, 26);
		frmFight.getContentPane().add(txtTimeToBattle);
		txtTimeToBattle.setColumns(10);
		
		txtPlayersCurrent = new JTextField();
		txtPlayersCurrent.setText(playerCurrent.getName() + "'s health: " + playerCurrent.getCurrentHealth());
		txtPlayersCurrent.setBounds(54, 347, 171, 26);
		frmFight.getContentPane().add(txtPlayersCurrent);
		txtPlayersCurrent.setColumns(10);
		
		txtEnemysCurrent = new JTextField();
		txtEnemysCurrent.setText(enemyCurrent.getName() + "'s health: " + enemyCurrent.getCurrentHealth());
		txtEnemysCurrent.setBounds(414, 347, 171, 26);
		frmFight.getContentPane().add(txtEnemysCurrent);
		txtEnemysCurrent.setColumns(10);
		
		lblEnemyMon = new JLabel("");
		lblEnemyMon.setIcon(new ImageIcon(FightScreen.class.getResource("/images/monster (1).png")));
		lblEnemyMon.setBounds(373, 76, 260, 248);
		frmFight.getContentPane().add(lblEnemyMon);
		
		lblPlayerMon = new JLabel("New label");
		lblPlayerMon.setIcon(new ImageIcon(FightScreen.class.getResource("/images/monster.png")));
		lblPlayerMon.setBounds(18, 66, 260, 269);
		frmFight.getContentPane().add(lblPlayerMon);
	
		
		btnAttack = new JButton("Attack!"); // change visible to false when battling is false
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack();
			}
		});
		btnAttack.setBounds(273, 187, 100, 29);
		frmFight.getContentPane().add(btnAttack);
		
		btnHeal = new JButton("Heal!"); // change visible to false when battling is false
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heal();
			}
		});
		btnHeal.setBounds(273, 228, 100, 29);
		frmFight.getContentPane().add(btnHeal);
		
		txtPlayersRemaining = new JTextField();
		txtPlayersRemaining.setText("Monsters left: " + (player.getTeam().size() - numPlayerCurrent - 1));
		txtPlayersRemaining.setBounds(54, 378, 171, 26);
		frmFight.getContentPane().add(txtPlayersRemaining);
		txtPlayersRemaining.setColumns(10);
		
		txtEnemysRemaining = new JTextField();
		txtEnemysRemaining.setText("Enemies left: " + (enemyTeam.size() - numEnemyCurrent - 1));
		txtEnemysRemaining.setBounds(414, 378, 171, 26);
		frmFight.getContentPane().add(txtEnemysRemaining);
		txtEnemysRemaining.setColumns(10);
	}
	
	
	
	/**
	 * Attack. Called when the attack button is selected, the Players monster first attacks the enemy Monster and if the enemy Monster has health greater 
	 * than zero, the enemy Monster can attack back. When either monster dies (health goes below zero), the next Monster method is called.
	 */
	public void attack() {
		playerCurrent.attack(enemyCurrent);
		if (enemyCurrent.getCurrentHealth() > 0) {
			enemyCurrent.attack(playerCurrent);
		} else {
			nextEnemyMonster();
			if (battling) {
			enemyCurrent.attack(playerCurrent);
			}
		}
		if (playerCurrent.getCurrentHealth() <= 0 ) {
			nextPlayerMonster();
		}
		txtPlayersCurrent.setText(playerCurrent.getName() + "'s health: " + playerCurrent.getCurrentHealth());
		txtEnemysCurrent.setText(enemyCurrent.getName() + "'s health: " + enemyCurrent.getCurrentHealth());
		
	}
	
	/**
	 * Heal. If heal button is selected the heal method is called, both the player's monster and the enemy monster increase their health
	 * by their heal amount, their current health displayed is also updated.
	 */
	public void heal() {
		playerCurrent.heal();
		enemyCurrent.heal();
		txtPlayersCurrent.setText(playerCurrent.getName() + "'s health: " + playerCurrent.getCurrentHealth());
		txtEnemysCurrent.setText(enemyCurrent.getName() + "'s health: " + enemyCurrent.getCurrentHealth());
	}
	
	
	/**
	 * Next player monster. If a players monster dies, the current Player Monster moves to the next Monster in the array list (if any).
	 */
	public void nextPlayerMonster() {
		JOptionPane.showMessageDialog(frmFight, "Owwww! " + "\n" + "Oh no! " + playerCurrent.getName() + " has just died!");
		playerCurrent.setCurrentHealth(100);
		numPlayerCurrent += 1;
		if (numPlayerCurrent < player.getTeam().size()) {
			playerCurrent = player.getTeam().get(numPlayerCurrent);
		} else {
			battleLost();
		}
		txtPlayersRemaining.setText("Monsters left: " + (player.getTeam().size() - numPlayerCurrent - 1));
		
	}
	
	/**
	 * Next enemy monster. If an enemy monster dies, the current enemy Monster moves to the next Monster in the array list (if any).
	 */
	public void nextEnemyMonster() {
		JOptionPane.showMessageDialog(frmFight, "Wapow! " + "\n" + "Yay! " + playerCurrent.getName() + " has just killed the enemy monster " + enemyCurrent.getName() + " - you gained 25 points");
		player.increasePoints(25);
		numEnemyCurrent += 1;
		if (numEnemyCurrent < enemyTeam.size()) {
			enemyCurrent = enemyTeam.get(numEnemyCurrent);
		} else {
			battleWon();
		}
		txtEnemysRemaining.setText("Enemies left: " + (enemyTeam.size() - numEnemyCurrent - 1));
	}
	
	/**
	 * Battle won. Displays any monsters in the players team that had died (reached zero lives) during the battle, then 
	 * calculates and awards the gold won for winning the battle.
	 */
	public void battleWon() {
		
		for (Monster monster : player.getTeam()) {
			if (monster.getLives() == 0) {
				JOptionPane.showMessageDialog(frmFight, "RIP: " + monster.getName() + " has died in action...");
				player.removeTeamMate(monster);
			}
		}
		
		int average = 0;
		for (Monster monster : enemyTeam) {
			average += monster.getDamage();
		}
		average = average / enemyTeam.size();
		player.increaseGold(average);
		player.increasePoints(50);
		JOptionPane.showMessageDialog(frmFight, "Congratulations on Winning the Battle!" + "\n" + "You have been awarded with " + average + " gold and 50 extra points!");
		battling = false;
		btnAttack.setVisible(false);
		btnHeal.setVisible(false);
		frmFight.dispose();
		
	}
	
	/**
	 * Battle lost. Displays any monsters in the players team that had died (reached zero lives) during the battle, and announces the loss of the
	 * battle to the Player.
	 */
	public void battleLost() {
		
		for (Monster monster : player.getTeam()) {
			if (monster.getLives() == 0) {
				JOptionPane.showMessageDialog(frmFight, "RIP: " + monster.getName() + " has died in action...");
				player.removeTeamMate(monster);
			}
		}
		
		battling = false;
		JOptionPane.showMessageDialog(frmFight, "Oh no! Your team was defeated and killed in Battle! " + "\n" + "Better luck next time!");
		btnAttack.setVisible(false);
		btnHeal.setVisible(false);
		frmFight.dispose();
	}
	
		

}
