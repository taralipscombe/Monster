import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frmMainscreen.setBounds(100, 100, 464, 423);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainscreen.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View current Game Stats");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmMainscreen, "Your current Game Stats are:\n"+ player.printAttributes());
				
			}
		});
		btnNewButton.setBounds(112, 23, 204, 29);
		frmMainscreen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View your team's properties");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1.setBounds(112, 59, 204, 29);
		frmMainscreen.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View your inventory");
		btnNewButton_2.setBounds(112, 100, 204, 29);
		frmMainscreen.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View possible battles");
		btnNewButton_3.setBounds(112, 141, 204, 29);
		frmMainscreen.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Battle!");
		btnNewButton_4.setBounds(154, 182, 117, 29);
		frmMainscreen.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Visit Shop");
		btnNewButton_5.setBounds(154, 223, 117, 29);
		frmMainscreen.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Go to sleep");
		btnNewButton_6.setBounds(154, 264, 117, 29);
		frmMainscreen.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("End Game");
		btnNewButton_7.setBounds(154, 305, 117, 29);
		frmMainscreen.getContentPane().add(btnNewButton_7);
	}

}
