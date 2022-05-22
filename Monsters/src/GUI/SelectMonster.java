package GUI;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;


public class SelectMonster {
	/** The set up game frame */
	public JFrame frmChooseYourMonster;
	/** Monster name field*/
	private JTextField chooseName;
	/** Players name, difficulty and the Monster's name, if not default*/
	private String playerName, gameDifficulty, monsterName;
	/** Number of days for game*/
	private int time;
	/** Boolean - true if player is using the monster's default name, false if they have inputted a chosen name*/
	private boolean defaultName = true;
	
	/**
	 * Create the application.
	 */
	public SelectMonster(String name, int gameTime, String difficulty) {
		playerName = name;
		gameDifficulty = difficulty;
		time = gameTime;
		initialize(playerName, time, gameDifficulty);
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
		
		Monster monsterOptionOne = new Monster("Harry", 30, 20, 50);
		Monster monsterOptionTwo = new Monster("Louis", 45, 5, 50);
		Monster monsterOptionThree = new Monster("Niall", 40, 10, 50);
		Monster monsterOptionFour = new Monster("Liam", 23, 27, 50);
		
		JButton chooseOne = new JButton("1");
		chooseOne.setForeground(new Color(0, 0, 0));
		chooseOne.setBackground(new Color(255, 255, 255));
		chooseOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!defaultName) {
					monsterOptionOne.setName(monsterName);
				}
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
				if(!defaultName) {
					monsterOptionTwo.setName(monsterName);
				}
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
				if(!defaultName) {
					monsterOptionThree.setName(monsterName);
				}
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
				if(!defaultName) {
					monsterOptionFour.setName(monsterName);
				}
				Player player = new Player(name, difficulty, monsterOptionFour, gameTime);
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(player);
			}
		});
		chooseFour.setBounds(70, 379, 92, 77);
		frmChooseYourMonster.getContentPane().add(chooseFour);
		
		String optionOneString = monsterOptionOne.commandLineToString();
		
		JTextArea txtroptionalNameYour = new JTextArea();
		txtroptionalNameYour.setEditable(false);
		txtroptionalNameYour.setBackground(Color.RED);
		txtroptionalNameYour.setForeground(Color.WHITE);
		txtroptionalNameYour.setFont(new Font("Dialog", Font.BOLD, 10));
		txtroptionalNameYour.setText("(Optional) Name your starting monster and hit enter:");
		txtroptionalNameYour.setBounds(23, 485, 302, 16);
		frmChooseYourMonster.getContentPane().add(txtroptionalNameYour);
		JTextArea optionOneDescription = new JTextArea(optionOneString);
		optionOneDescription.setOpaque(false);
		optionOneDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionOneDescription.setBounds(175, 55, 150, 90);
		frmChooseYourMonster.getContentPane().add(optionOneDescription);
		
		String optionTwoString = monsterOptionTwo.commandLineToString();
		JTextArea optionTwoDescription = new JTextArea(optionTwoString);
		optionTwoDescription.setOpaque(false);
		optionTwoDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionTwoDescription.setBounds(175, 157, 150, 89);
		frmChooseYourMonster.getContentPane().add(optionTwoDescription);
		
		String optionThreeString = monsterOptionThree.commandLineToString();
		JTextArea optionThreeDescription = new JTextArea(optionThreeString);
		optionThreeDescription.setOpaque(false);
		optionThreeDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionThreeDescription.setBounds(174, 258, 151, 94);
		frmChooseYourMonster.getContentPane().add(optionThreeDescription);
		
		String optionFourString = monsterOptionFour.commandLineToString();
		JTextArea optionFourDescription = new JTextArea(optionFourString);
		optionFourDescription.setOpaque(false);
		optionFourDescription.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		optionFourDescription.setBounds(174, 379, 151, 94);
		frmChooseYourMonster.getContentPane().add(optionFourDescription);
		
		chooseName = new JTextField();
		chooseName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				monsterName = chooseName.getText();
				defaultName = false;
			}
		});
		chooseName.setBounds(337, 481, 119, 19);
		frmChooseYourMonster.getContentPane().add(chooseName);
		chooseName.setColumns(10);
		
		JLabel monsterOnePic = new JLabel("");
		monsterOnePic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster1.png")));
		monsterOnePic.setBounds(337, 35, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterOnePic);
		
		JLabel monsterTwoPic = new JLabel("");
		monsterTwoPic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster2.png")));
		monsterTwoPic.setBounds(328, 142, 128, 104);
		frmChooseYourMonster.getContentPane().add(monsterTwoPic);
		
		JLabel monsterThreePic = new JLabel("");
		monsterThreePic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster3.png")));
		monsterThreePic.setBounds(337, 258, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterThreePic);
		
		JLabel monsterfourPic = new JLabel("");
		monsterfourPic.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/monster4.png")));
		monsterfourPic.setBounds(325, 369, 119, 104);
		frmChooseYourMonster.getContentPane().add(monsterfourPic);
		
		/** Sourced from https://www.shutterstock.com/image-vector/retail-store-shelves-red-awning-grocery-503246452 */
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(SelectMonster.class.getResource("/images/shopshelf.png")));
		background.setBounds(12, -11, 463, 549);
		frmChooseYourMonster.getContentPane().add(background);
	}
}
