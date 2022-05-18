import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SelectMonster {

	private JFrame frmChooseYourMonster;

	/**
	 * Launch the application.
	 */
	public static void main(String name, int gameTime, String difficulty) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMonster window = new SelectMonster(name, gameTime, difficulty);
					window.frmChooseYourMonster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectMonster(String name, int gameTime, String difficulty) {
		initialize(name, gameTime, difficulty);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, int gameTime, String difficulty) {
		frmChooseYourMonster = new JFrame();
		frmChooseYourMonster.setTitle("Choose your monster (click a number)");
		frmChooseYourMonster.setBounds(100, 100, 471, 555);
		frmChooseYourMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseYourMonster.getContentPane().setLayout(null);
		
		Monster monsterOptionOne = new Monster("Harry", 33, 20, 53);
		Monster monsterOptionTwo = new Monster("Louis", 45, 4, 49);
		Monster monsterOptionThree = new Monster("Niall", 19, 35, 54);
		Monster monsterOptionFour = new Monster("Liam", 13, 10, 23);
		
		JButton chooseOne = new JButton("1");
		chooseOne.setForeground(new Color(0, 0, 0));
		chooseOne.setBackground(new Color(255, 255, 255));
		chooseOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(name, difficulty, monsterOptionOne, gameTime);
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(player);
			}
		});
		chooseOne.setBounds(70, 55, 92, 84);
		frmChooseYourMonster.getContentPane().add(chooseOne);
		
		JButton chooseTwo = new JButton("2");
		chooseTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(name, difficulty, monsterOptionTwo, gameTime);
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(player);
			}
		});
		chooseTwo.setBounds(70, 171, 92, 75);
		frmChooseYourMonster.getContentPane().add(chooseTwo);
		
		JButton chooseThree = new JButton("3");
		chooseThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(name, difficulty, monsterOptionThree, gameTime);
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(player);
			}
		});
		chooseThree.setBounds(70, 273, 92, 72);
		frmChooseYourMonster.getContentPane().add(chooseThree);
		
		JButton chooseFour = new JButton("4");
		chooseFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(name, difficulty, monsterOptionFour, gameTime);
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(player);
			}
		});
		chooseFour.setBounds(70, 379, 92, 77);
		frmChooseYourMonster.getContentPane().add(chooseFour);
		
		String optionOneString = monsterOptionOne.commandLineToString();
		JTextArea optionOneDescription = new JTextArea(optionOneString);
		optionOneDescription.setOpaque(false);
		optionOneDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionOneDescription.setBounds(175, 55, 130, 90);
		frmChooseYourMonster.getContentPane().add(optionOneDescription);
		
		String optionTwoString = monsterOptionTwo.commandLineToString();
		JTextArea optionTwoDescription = new JTextArea(optionTwoString);
		optionTwoDescription.setOpaque(false);
		optionTwoDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionTwoDescription.setBounds(175, 157, 130, 89);
		frmChooseYourMonster.getContentPane().add(optionTwoDescription);
		
		String optionThreeString = monsterOptionThree.commandLineToString();
		JTextArea optionThreeDescription = new JTextArea(optionThreeString);
		optionThreeDescription.setOpaque(false);
		optionThreeDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionThreeDescription.setBounds(174, 258, 130, 94);
		frmChooseYourMonster.getContentPane().add(optionThreeDescription);
		
		String optionFourString = monsterOptionFour.commandLineToString();
		JTextArea optionFourDescription = new JTextArea(optionFourString);
		optionFourDescription.setOpaque(false);
		optionFourDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionFourDescription.setBounds(174, 379, 131, 94);
		frmChooseYourMonster.getContentPane().add(optionFourDescription);
		
		JLabel monsterOnePic = new JLabel("");
		monsterOnePic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster1.png")));
		monsterOnePic.setBounds(309, 35, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterOnePic);
		
		JLabel monsterTwoPic = new JLabel("");
		monsterTwoPic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster2.png")));
		monsterTwoPic.setBounds(305, 143, 128, 104);
		frmChooseYourMonster.getContentPane().add(monsterTwoPic);
		
		JLabel monsterThreePic = new JLabel("");
		monsterThreePic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster3.png")));
		monsterThreePic.setBounds(309, 258, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterThreePic);
		
		JLabel monsterfourPic = new JLabel("");
		monsterfourPic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster4.png")));
		monsterfourPic.setBounds(314, 376, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterfourPic);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/shopshelf.png")));
		background.setBounds(12, 0, 463, 549);
		frmChooseYourMonster.getContentPane().add(background);
	}
}
