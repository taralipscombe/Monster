package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainScreenWindow {

	private JFrame frmMainscreen;
	private Player player;
	private MainScreen mainscreen;

	/**
	 * Launch the application.
	 */
	public static void main(Player incomingPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreenWindow window = new MainScreenWindow(incomingPlayer);
					window.frmMainscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreenWindow(Player incomingPlayer) {
		player = incomingPlayer;
		MainScreen newMainscreen =  new MainScreen(player);
		mainscreen = newMainscreen;

		initialize(player);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * image sourced from: https://findicons.com/search/cartoon-child
	 */
	private void initialize(Player player) {
		frmMainscreen = new JFrame();
		frmMainscreen.setTitle("Mainscreen");
		frmMainscreen.setBounds(100, 100, 619, 354);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainscreen.getContentPane().setLayout(null);
		
		JButton viewStats = new JButton("View current Game Stats");
		viewStats.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon(SelectMonster.class.getResource("/images/user.png"));
				JOptionPane.showMessageDialog(frmMainscreen, "Your current Game Stats are:\n"+ player.printAttributes(), "GAME STATS",JOptionPane.INFORMATION_MESSAGE, image);
				
			}
		});
		viewStats.setBounds(198, 22, 204, 29);
		frmMainscreen.getContentPane().add(viewStats);
		
		JButton viewTeamProperties = new JButton("View your team's properties");
		viewTeamProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTeam().size() <= 2 ) {
					JOptionPane.showMessageDialog(frmMainscreen, "Your Monster Team is looking empty... \n Purchase more Monsters at the Shop!");
				}
				PlayerTeam playersTeam = new PlayerTeam(player);
				playersTeam.frmPlayerTeam.setVisible(true);
			}
		});
		viewTeamProperties.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewTeamProperties.setBounds(176, 63, 245, 29);
		frmMainscreen.getContentPane().add(viewTeamProperties);
		
		JButton viewInventory = new JButton("View your inventory");
		viewInventory.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewInventory inventory = new ViewInventory(player);
				inventory.frmInventory.setVisible(true);
			}
		});
		viewInventory.setBounds(198, 104, 204, 29);
		frmMainscreen.getContentPane().add(viewInventory);
		
		JButton viewBattles = new JButton("View possible battles");
		viewBattles.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewBattles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BattleScreen newBattleScreen = new BattleScreen(mainscreen);
				newBattleScreen.frmBattle.setVisible(true);

			}
		});
		viewBattles.setBounds(198, 145, 204, 29);
		frmMainscreen.getContentPane().add(viewBattles);
		
		
		JButton visitShop = new JButton("Visit Shop");
		visitShop.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		visitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWindow shop = new ShopWindow(player);
				shop.frmShop.setVisible(true);
			}
		});
		visitShop.setBounds(242, 186, 117, 29);
		frmMainscreen.getContentPane().add(visitShop);
		
		JButton sleep = new JButton("Go to sleep");
		sleep.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Monster monster : player.getTeam()) {
					monster.heal();
				}
				player.incrementDay();
				RandomEvent randomEvent = new RandomEvent(player);
				JOptionPane.showMessageDialog(frmMainscreen, "Sweet dreams! Enjoy your sleep!");
				ArrayList<String> events = randomEvent.generate();
				for (String event : events) {
					JOptionPane.showMessageDialog(frmMainscreen, event);
				}
				events.clear();
			}
		});
		sleep.setBounds(242, 227, 117, 29);
		frmMainscreen.getContentPane().add(sleep);
		
		JButton endGame = new JButton("End Game");
		endGame.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		endGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player.endGame();
				frmMainscreen.dispose();
				EndScreen ending = new EndScreen(player);
				ending.frmEndScreen.setVisible(true);
				
			}
		});
		endGame.setBounds(242, 268, 117, 29);
		frmMainscreen.getContentPane().add(endGame);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(MainScreenWindow.class.getResource("/images/back.jpg")));
		backgroundImage.setBounds(12, -31, 594, 371);
		frmMainscreen.getContentPane().add(backgroundImage);
	}

}
