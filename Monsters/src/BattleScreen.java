import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BattleScreen {

	private MainScreen mainscreen;
	public JFrame frame;
	private Player player;
	private ArrayList<Monster> currentTeam = null;
	private JTextField txtSelectATeam;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNameOne;
	private JTextField txtAttackOne;
	private JTextField txtHealOne;
	private JTextField txtNameTwo;
	private JTextField txtAttackTwo;
	private JTextField txtHealTwo;
	private JTextField txtNameThree;
	private JTextField txtAttackThree;
	private JTextField txtHealThree;
	private JButton btnBattle;
	private JButton btnExit;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtWinningsOne;
	private JTextField txtWinningsTwo;
	private JTextField txtWinningsThree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Monster monster = new Monster("Fred", 1, 2, 3);
		Player player = new Player("Emma", "1", monster, 7);
		MainScreen mainscreen = new MainScreen(player);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen(mainscreen);
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
	public BattleScreen(MainScreen ofcMainscreen) {
		mainscreen = ofcMainscreen;
		player = mainscreen.getPlayer();
		mainscreen.generateNewBattles(); // generate battles
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
		
		txtSelectATeam = new JTextField();
		txtSelectATeam.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtSelectATeam.setText("Select a Team to Battle:");
		txtSelectATeam.setEditable(false);
		txtSelectATeam.setBounds(200, 31, 234, 26);
		frame.getContentPane().add(txtSelectATeam);
		txtSelectATeam.setColumns(10);
		
		
		JRadioButton rdbtnTeamOne = new JRadioButton("Enemy Team One");
		rdbtnTeamOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Monster> monsters = mainscreen.getEnemyTeam(1);
				currentTeam = monsters;
			}
		});
		buttonGroup.add(rdbtnTeamOne);
		rdbtnTeamOne.setBounds(32, 86, 141, 23);
		frame.getContentPane().add(rdbtnTeamOne);
		
		JRadioButton rdbtnTeamTwo = new JRadioButton("Enemy Team Two");
		rdbtnTeamTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Monster> monsters = mainscreen.getEnemyTeam(2);
				currentTeam = monsters;
			}
		});
		buttonGroup.add(rdbtnTeamTwo);
		rdbtnTeamTwo.setBounds(243, 86, 141, 23);
		frame.getContentPane().add(rdbtnTeamTwo);
		
		JRadioButton rdbtnTeamThree = new JRadioButton("Enemy Team Three");
		rdbtnTeamThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Monster> monsters = mainscreen.getEnemyTeam(3);
				currentTeam = monsters;
			}
		});
		buttonGroup.add(rdbtnTeamThree);
		rdbtnTeamThree.setBounds(457, 86, 150, 23);
		frame.getContentPane().add(rdbtnTeamThree);
		
		
		JPanel panelTeamOne = new JPanel();
		panelTeamOne.setBounds(32, 150, 141, 125);
		frame.getContentPane().add(panelTeamOne);
		panelTeamOne.setLayout(null);
		
		txtNameOne = new JTextField();
		txtNameOne.setBounds(6, 6, 130, 26);
		panelTeamOne.add(txtNameOne);
		txtNameOne.setColumns(10);
		
		txtAttackOne = new JTextField();
		txtAttackOne.setBounds(6, 37, 130, 26);
		panelTeamOne.add(txtAttackOne);
		txtAttackOne.setColumns(10);
		
		txtHealOne = new JTextField();
		txtHealOne.setBounds(6, 69, 130, 26);
		panelTeamOne.add(txtHealOne);
		txtHealOne.setColumns(10);
		
		txtWinningsOne = new JTextField();
		txtWinningsOne.setColumns(10);
		txtWinningsOne.setBounds(6, 96, 130, 26);
		panelTeamOne.add(txtWinningsOne);
		
		JPanel panelTeamTwo = new JPanel();
		panelTeamTwo.setBounds(243, 150, 150, 125);
		frame.getContentPane().add(panelTeamTwo);
		panelTeamTwo.setLayout(null);
		
		txtNameTwo = new JTextField();
		txtNameTwo.setBounds(6, 6, 130, 26);
		panelTeamTwo.add(txtNameTwo);
		txtNameTwo.setColumns(10);
		
		txtAttackTwo = new JTextField();
		txtAttackTwo.setBounds(6, 34, 130, 26);
		panelTeamTwo.add(txtAttackTwo);
		txtAttackTwo.setColumns(10);
		
		txtHealTwo = new JTextField();
		txtHealTwo.setBounds(6, 65, 130, 26);
		panelTeamTwo.add(txtHealTwo);
		txtHealTwo.setColumns(10);
		
		txtWinningsTwo = new JTextField();
		txtWinningsTwo.setColumns(10);
		txtWinningsTwo.setBounds(6, 93, 130, 26);
		panelTeamTwo.add(txtWinningsTwo);
		
		JPanel panelTeamThree = new JPanel();
		panelTeamThree.setBounds(457, 150, 150, 125);
		frame.getContentPane().add(panelTeamThree);
		panelTeamThree.setLayout(null);
		
		txtNameThree = new JTextField();
		txtNameThree.setBounds(6, 6, 130, 26);
		panelTeamThree.add(txtNameThree);
		txtNameThree.setColumns(10);
		
		txtAttackThree = new JTextField();
		txtAttackThree.setBounds(6, 33, 130, 26);
		panelTeamThree.add(txtAttackThree);
		txtAttackThree.setColumns(10);
		
		txtHealThree = new JTextField();
		txtHealThree.setBounds(6, 62, 130, 26);
		panelTeamThree.add(txtHealThree);
		txtHealThree.setColumns(10);
		
		txtWinningsThree = new JTextField();
		txtWinningsThree.setColumns(10);
		txtWinningsThree.setBounds(6, 93, 130, 26);
		panelTeamThree.add(txtWinningsThree);
		
		btnBattle = new JButton("Battle!"); // call action listener and implement the fight screen with the player and the chosen enemy Team.
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTeam == null) {
					JOptionPane.showMessageDialog(null, "Please select an Enemy Team to Battle.");
				} else {
					mainscreen.generateNewBattles();
					FightScreen fighting = new FightScreen(player, currentTeam);
					
					fighting.frame.setVisible(true);
					frame.dispose();
					
				}
			}
		});
		btnBattle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnBattle.setBounds(490, 33, 117, 29);
		frame.getContentPane().add(btnBattle);
		
		btnExit = new JButton("Return");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(23, 36, 117, 29);
		frame.getContentPane().add(btnExit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/viking_helmet.png")));
		lblNewLabel.setBounds(253, 287, 141, 120);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/sword.png")));
		lblNewLabel_1.setBounds(32, 287, 155, 128);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/arrow.png")));
		lblNewLabel_2.setBounds(457, 287, 150, 120);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<Monster> cBoxTeamOne = new JComboBox<Monster>();
		cBoxTeamOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster currentMonOne = (Monster) cBoxTeamOne.getSelectedItem();
				displayOne(currentMonOne);
			}
		});
		for (Monster monster : mainscreen.getEnemyTeam(1)) {
			cBoxTeamOne.addItem(monster);
		}
		cBoxTeamOne.setBounds(32, 111, 141, 27);
		frame.getContentPane().add(cBoxTeamOne);
		
		
		JComboBox<Monster> cBoxTeamTwo = new JComboBox<Monster>();
		cBoxTeamTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster currentMonTwo = (Monster) cBoxTeamTwo.getSelectedItem();
				displayTwo(currentMonTwo);
			}
		});
		for (Monster monster : mainscreen.getEnemyTeam(2)) {
			cBoxTeamTwo.addItem(monster);
		}
		cBoxTeamTwo.setBounds(243, 111, 141, 27);
		frame.getContentPane().add(cBoxTeamTwo);

		JComboBox<Monster> cBoxTeamThree = new JComboBox<Monster>();
		cBoxTeamThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster currentMonThree = (Monster) cBoxTeamThree.getSelectedItem();
				displayThree(currentMonThree);
			}
		});
		for (Monster monster : mainscreen.getEnemyTeam(3)) {
			cBoxTeamThree.addItem(monster);
		}
		cBoxTeamThree.setBounds(457, 111, 150, 27);
		frame.getContentPane().add(cBoxTeamThree);
	}
	
	
	public void displayOne(Monster monster) {
		txtNameOne.setText("Name: " + monster.getName());
		txtAttackOne.setText("Damage: " + monster.getDamage() + " units");
		txtHealOne.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsOne.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(1)) + " gold");
	}
	
	public void displayTwo(Monster monster) {
		txtNameTwo.setText("Name: " + monster.getName());
		txtAttackTwo.setText("Damage: " + monster.getDamage() + " units");
		txtHealTwo.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsTwo.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(2)) + " gold");
	}
		
	public void displayThree(Monster monster) {
		txtNameThree.setText("Name: " + monster.getName());
		txtAttackThree.setText("Damage: " + monster.getDamage() + " units");
		txtHealThree.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsThree.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(3)) + " gold");
	}
	
	public int getWinnings(ArrayList<Monster> monsters) {
		int average = 0;
		for (Monster monster : monsters) {
			average += monster.getDamage();
		}
		average = average / monsters.size();
		return average;
	}
	
	
	
	
	
}
