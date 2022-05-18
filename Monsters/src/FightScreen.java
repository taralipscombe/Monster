
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

public class FightScreen {


	public JFrame frame;
	private Player player;
	private Monster playerCurrent;
	private int numPlayerCurrent = 0;
	private ArrayList<Monster> enemyTeam;
	private Monster enemyCurrent;
	private int numEnemyCurrent = 0;
	private boolean battling = true;
	private JTextField txtTimeToBattle;
	private JTextField txtPlayersCurrent;
	private JTextField txtEnemysCurrent;
	private JLabel lblEnemyMon;
	private JLabel lblPlayerMon;
	private JButton btnAttack;
	private JButton btnHeal;
	private JTextField txtPlayersRemaining;
	private JTextField txtEnemysRemaining;

	/**
	 * Launch the application.
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
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
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTimeToBattle = new JTextField();
		txtTimeToBattle.setEditable(false);
		txtTimeToBattle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtTimeToBattle.setText("TIME TO BATTLE!");
		txtTimeToBattle.setBounds(234, 16, 171, 26);
		frame.getContentPane().add(txtTimeToBattle);
		txtTimeToBattle.setColumns(10);
		
		txtPlayersCurrent = new JTextField();
		txtPlayersCurrent.setText(playerCurrent.getName() + "'s health: " + playerCurrent.getCurrentHealth());
		txtPlayersCurrent.setBounds(54, 347, 171, 26);
		frame.getContentPane().add(txtPlayersCurrent);
		txtPlayersCurrent.setColumns(10);
		
		txtEnemysCurrent = new JTextField();
		txtEnemysCurrent.setText(enemyCurrent.getName() + "'s health: " + enemyCurrent.getCurrentHealth());
		txtEnemysCurrent.setBounds(414, 347, 171, 26);
		frame.getContentPane().add(txtEnemysCurrent);
		txtEnemysCurrent.setColumns(10);
		
		lblEnemyMon = new JLabel("");
		lblEnemyMon.setIcon(new ImageIcon(FightScreen.class.getResource("/images/monster (1).png")));
		lblEnemyMon.setBounds(373, 76, 260, 248);
		frame.getContentPane().add(lblEnemyMon);
		
		lblPlayerMon = new JLabel("New label");
		lblPlayerMon.setIcon(new ImageIcon(FightScreen.class.getResource("/images/monster.png")));
		lblPlayerMon.setBounds(18, 66, 260, 269);
		frame.getContentPane().add(lblPlayerMon);
	
		
		btnAttack = new JButton("Attack!"); // change visible to false when battling is false
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack();
			}
		});
		btnAttack.setBounds(273, 187, 100, 29);
		frame.getContentPane().add(btnAttack);
		
		btnHeal = new JButton("Heal!"); // change visible to false when battling is false
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heal();
			}
		});
		btnHeal.setBounds(273, 228, 100, 29);
		frame.getContentPane().add(btnHeal);
		
		txtPlayersRemaining = new JTextField();
		txtPlayersRemaining.setText("Monsters left: " + (player.getTeam().size() - numPlayerCurrent - 1));
		txtPlayersRemaining.setBounds(54, 378, 171, 26);
		frame.getContentPane().add(txtPlayersRemaining);
		txtPlayersRemaining.setColumns(10);
		
		txtEnemysRemaining = new JTextField();
		txtEnemysRemaining.setText("Enemies left: " + (enemyTeam.size() - numEnemyCurrent - 1));
		txtEnemysRemaining.setBounds(414, 378, 171, 26);
		frame.getContentPane().add(txtEnemysRemaining);
		txtEnemysRemaining.setColumns(10);
	}
	
	
	
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
	
	public void heal() {
		playerCurrent.heal();
		enemyCurrent.heal();
		txtPlayersCurrent.setText(playerCurrent.getName() + "'s health: " + playerCurrent.getCurrentHealth());
		txtEnemysCurrent.setText(enemyCurrent.getName() + "'s health: " + enemyCurrent.getCurrentHealth());
	}
	
	
	public void nextPlayerMonster() {
		JOptionPane.showMessageDialog(null, "Owwww! " + "\n" + "Oh no! " + playerCurrent.getName() + " has just died!");
		numPlayerCurrent += 1;
		if (numPlayerCurrent < player.getTeam().size()) {
			playerCurrent = player.getTeam().get(numPlayerCurrent);
		} else {
			battleLost();
		}
		txtPlayersRemaining.setText("Monsters left: " + (player.getTeam().size() - numPlayerCurrent - 1));
		
	}
	
	public void nextEnemyMonster() {
		JOptionPane.showMessageDialog(null, "Wapow! " + "\n" + "Yay!" + playerCurrent.getName() + " has just killed the enemy monster " + enemyCurrent.getName() + " - you gained 25 points");
		player.increasePoints(25);
		numEnemyCurrent += 1;
		if (numEnemyCurrent < enemyTeam.size()) {
			enemyCurrent = enemyTeam.get(numEnemyCurrent);
		} else {
			battleWon();
		}
		txtEnemysRemaining.setText("Enemies left: " + (enemyTeam.size() - numEnemyCurrent - 1));
	}
	
	public void battleWon() {
		int average = 0;
		for (Monster monster : enemyTeam) {
			average += monster.getDamage();
		}
		average = average / enemyTeam.size();
		player.increaseGold(average);
		player.increasePoints(50);
		JOptionPane.showMessageDialog(null, "Congratulations on Winning the Battle!" + "\n" + "You have been awarded with " + average + " gold and 50 extra points!");
		battling = false;
		btnAttack.setVisible(false);
		btnHeal.setVisible(false);
		frame.dispose();
		
	}
	
	public void battleLost() {
		battling = false;
		JOptionPane.showMessageDialog(null, "Oh no! Your team was defeated and killed in Battle! " + "\n" + "Better luck next time!");
		btnAttack.setVisible(false);
		btnHeal.setVisible(false);
		frame.dispose();
	}
	
		

}
