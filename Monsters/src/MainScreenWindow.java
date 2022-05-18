import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainScreenWindow {

	private JFrame frmMainscreen;
	private Player player;

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
		initialize(player);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player player) {
		frmMainscreen = new JFrame();
		frmMainscreen.setTitle("Mainscreen");
		frmMainscreen.setBounds(100, 100, 619, 354);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainscreen.getContentPane().setLayout(null);
		
		JButton viewStats = new JButton("View current Game Stats");
		viewStats.setFont(new Font("Dialog", Font.BOLD, 10));
		viewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmMainscreen, "Your current Game Stats are:\n"+ player.printAttributes());
				
			}
		});
		viewStats.setBounds(198, 12, 204, 29);
		frmMainscreen.getContentPane().add(viewStats);
		
		JButton viewTeamProperties = new JButton("View your team's properties");
		viewTeamProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmMainscreen, "Your team's properties are:\n"+ player.printCurrentTeam());
			}
		});
		viewTeamProperties.setFont(new Font("Dialog", Font.BOLD, 10));
		viewTeamProperties.setBounds(198, 47, 204, 29);
		frmMainscreen.getContentPane().add(viewTeamProperties);
		
		JButton viewInventory = new JButton("View your inventory");
		viewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmMainscreen, "The items in your inventory are:\n"+ player.printInventory());
			}
		});
		viewInventory.setBounds(198, 88, 204, 29);
		frmMainscreen.getContentPane().add(viewInventory);
		
		JButton viewBattles = new JButton("View possible battles");
		viewBattles.setBounds(198, 118, 204, 29);
		frmMainscreen.getContentPane().add(viewBattles);
		
		JButton battle = new JButton("Battle!");
		battle.setBounds(242, 159, 117, 29);
		frmMainscreen.getContentPane().add(battle);
		
		JButton visitShop = new JButton("Visit Shop");
		visitShop.setBounds(242, 200, 117, 29);
		frmMainscreen.getContentPane().add(visitShop);
		
		JButton sleep = new JButton("Go to sleep");
		sleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Monster monster : player.getTeam()) {
					monster.heal();
				}
				player.incrementDay();
				RandomEvent randomEvent = new RandomEvent(player);
				RandomEvent.generate();
				JOptionPane.showMessageDialog(frmMainscreen, "Sweet dreams!, Enjoy your sleep!");
			}
		});
		sleep.setBounds(242, 241, 117, 29);
		frmMainscreen.getContentPane().add(sleep);
		
		JButton endGame = new JButton("End Game");
		endGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player.endGame();
				frmMainscreen.dispose();
				JOptionPane.showMessageDialog(frmMainscreen, "Game over! Your game stats finish as:\n"+player.printAttributes());
			}
		});
		endGame.setBounds(242, 282, 117, 29);
		frmMainscreen.getContentPane().add(endGame);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(MainScreenWindow.class.getResource("/images/back.jpg")));
		backgroundImage.setBounds(12, -31, 594, 371);
		frmMainscreen.getContentPane().add(backgroundImage);
	}

}
