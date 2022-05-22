package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;


/**
 * The Class EndScreen.
 */
public class EndScreen {

	
	/** The end screen frame. */
	public JFrame frmEndScreen;
	
	/** The player. */
	private Player player;
	
	/** The txt game ended. */
	private JTextField txtGameEnded;
	
	/** The text displaying the players name. */
	private JTextField txtName;
	
	/** The text displaying the players game length. */
	private JTextField txtDays;
	
	/** The text displaying the players points. */
	private JTextField txtPoints;
	
	/** The text displaying the players gold. */
	private JTextField txtGold;


	/**
	 * Create the application.
	 *
	 * @param ofcPlayer the official player of the game.
	 */
	public EndScreen(Player ofcPlayer) {
		
		player = ofcPlayer;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Sets the Text fields to display the final Players stats.
	 */
	private void initialize() {
		frmEndScreen = new JFrame();
		frmEndScreen.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frmEndScreen.setBounds(100, 100, 650, 449);
		frmEndScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEndScreen.getContentPane().setLayout(null);
		
		txtGameEnded = new JTextField();
		txtGameEnded.setEditable(false);
		txtGameEnded.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 30));
		txtGameEnded.setText("GAME ENDED");
		txtGameEnded.setBounds(206, 39, 239, 35);
		frmEndScreen.getContentPane().add(txtGameEnded);
		txtGameEnded.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EndScreen.class.getResource("/images/user.png")));
		lblNewLabel.setBounds(126, 64, 153, 197);
		frmEndScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EndScreen.class.getResource("/images/earscreature.png")));
		lblNewLabel_1.setBounds(29, 186, 173, 205);
		frmEndScreen.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "PLAYER STATS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(305, 106, 300, 265);
		frmEndScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Players Name: " + player.getName());
		txtName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtName.setBounds(37, 52, 232, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtDays = new JTextField();
		txtDays.setText("Game Duration: " + player.getFinishDay());
		txtDays.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtDays.setColumns(10);
		txtDays.setBounds(37, 106, 232, 26);
		panel.add(txtDays);
		
		txtPoints = new JTextField();
		txtPoints.setText("Total Points Gained: " + player.getPoints());
		txtPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtPoints.setColumns(10);
		txtPoints.setBounds(37, 164, 232, 26);
		panel.add(txtPoints);
		
		txtGold = new JTextField();
		txtGold.setText("Total Gold Gained: " + player.getgold());
		txtGold.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtGold.setColumns(10);
		txtGold.setBounds(37, 214, 232, 26);
		panel.add(txtGold);
	}

}
