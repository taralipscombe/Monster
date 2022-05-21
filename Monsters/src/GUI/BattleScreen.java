package GUI;


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


/**
 * The Class BattleScreen.
 */
public class BattleScreen {

	/** The mainscreen instance passed through. */
	private MainScreen mainscreen;
	
	/** The battle frame. */
	public JFrame frmBattle;
	
	/** The player. */
	private Player player;
	
	/** The current team selected. */
	private ArrayList<Monster> currentTeam = null;
	
	/** The txt select a team. */
	private JTextField txtSelectATeam;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The text displaying the currently selected Monster in team one's name. */
	private JTextField txtNameOne;
	
	/** The text displaying the currently selected Monster in team one's attack. */
	private JTextField txtAttackOne;
	
	/** The text displaying the currently selected Monster in team one's heal amount. */
	private JTextField txtHealOne;
	
	/** The text displaying the currently selected Monster in team two's name. */
	private JTextField txtNameTwo;
	
	/** The text displaying the currently selected Monster in team two's attack. */
	private JTextField txtAttackTwo;
	
	/** The text displaying the currently selected Monster in team two's heal amount. */
	private JTextField txtHealTwo;
	
	/** The text displaying the currently selected Monster in team three's name.*/
	private JTextField txtNameThree;
	
	/** The text displaying the currently selected Monster in team three's attack. */
	private JTextField txtAttackThree;
	
	/** The text displaying the currently selected Monster in team three's heal amount. */
	private JTextField txtHealThree;
	
	/** The battle button. */
	private JButton btnBattle;
	
	/** The exit button. */
	private JButton btnExit;
	
	/** The first picture. */
	private JLabel picTwo;
	
	/** The second picture. */
	private JLabel picOne;
	
	/** The third picture. */
	private JLabel picThree;
	
	/** The text displaying gold won for battling team One. */
	private JTextField txtWinningsOne;
	
	/** The text displaying gold won for battling team Two. */
	private JTextField txtWinningsTwo;
	
	/** The text displaying gold won for battling team Three. */
	private JTextField txtWinningsThree;


	/**
	 * Create the application. Calls the generate battles method of the main screen to initialize possible battles.
	 *
	 * @param ofcMainscreen the ofc mainscreen
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
		frmBattle = new JFrame();
		frmBattle.setBounds(100, 100, 650, 450);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattle.getContentPane().setLayout(null);
		
		txtSelectATeam = new JTextField();
		txtSelectATeam.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtSelectATeam.setText("Select a Team to Battle:");
		txtSelectATeam.setEditable(false);
		txtSelectATeam.setBounds(200, 31, 234, 26);
		frmBattle.getContentPane().add(txtSelectATeam);
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
		frmBattle.getContentPane().add(rdbtnTeamOne);
		
		JRadioButton rdbtnTeamTwo = new JRadioButton("Enemy Team Two");
		rdbtnTeamTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Monster> monsters = mainscreen.getEnemyTeam(2);
				currentTeam = monsters;
			}
		});
		buttonGroup.add(rdbtnTeamTwo);
		rdbtnTeamTwo.setBounds(243, 86, 141, 23);
		frmBattle.getContentPane().add(rdbtnTeamTwo);
		
		JRadioButton rdbtnTeamThree = new JRadioButton("Enemy Team Three");
		rdbtnTeamThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Monster> monsters = mainscreen.getEnemyTeam(3);
				currentTeam = monsters;
			}
		});
		buttonGroup.add(rdbtnTeamThree);
		rdbtnTeamThree.setBounds(457, 86, 150, 23);
		frmBattle.getContentPane().add(rdbtnTeamThree);
		
		
		JPanel panelTeamOne = new JPanel();
		panelTeamOne.setBounds(32, 150, 141, 125);
		frmBattle.getContentPane().add(panelTeamOne);
		panelTeamOne.setLayout(null);
		
		txtNameOne = new JTextField();
		txtNameOne.setEditable(false);
		txtNameOne.setBounds(6, 6, 130, 26);
		panelTeamOne.add(txtNameOne);
		txtNameOne.setColumns(10);
		
		txtAttackOne = new JTextField();
		txtAttackOne.setEditable(false);
		txtAttackOne.setBounds(6, 37, 130, 26);
		panelTeamOne.add(txtAttackOne);
		txtAttackOne.setColumns(10);
		
		txtHealOne = new JTextField();
		txtHealOne.setEditable(false);
		txtHealOne.setBounds(6, 69, 130, 26);
		panelTeamOne.add(txtHealOne);
		txtHealOne.setColumns(10);
		
		txtWinningsOne = new JTextField();
		txtWinningsOne.setEditable(false);
		txtWinningsOne.setColumns(10);
		txtWinningsOne.setBounds(6, 96, 130, 26);
		panelTeamOne.add(txtWinningsOne);
		
		JPanel panelTeamTwo = new JPanel();
		panelTeamTwo.setBounds(243, 150, 150, 125);
		frmBattle.getContentPane().add(panelTeamTwo);
		panelTeamTwo.setLayout(null);
		
		txtNameTwo = new JTextField();
		txtNameTwo.setEditable(false);
		txtNameTwo.setBounds(6, 6, 130, 26);
		panelTeamTwo.add(txtNameTwo);
		txtNameTwo.setColumns(10);
		
		txtAttackTwo = new JTextField();
		txtAttackTwo.setEditable(false);
		txtAttackTwo.setBounds(6, 34, 130, 26);
		panelTeamTwo.add(txtAttackTwo);
		txtAttackTwo.setColumns(10);
		
		txtHealTwo = new JTextField();
		txtHealTwo.setEditable(false);
		txtHealTwo.setBounds(6, 65, 130, 26);
		panelTeamTwo.add(txtHealTwo);
		txtHealTwo.setColumns(10);
		
		txtWinningsTwo = new JTextField();
		txtWinningsTwo.setEditable(false);
		txtWinningsTwo.setColumns(10);
		txtWinningsTwo.setBounds(6, 93, 130, 26);
		panelTeamTwo.add(txtWinningsTwo);
		
		JPanel panelTeamThree = new JPanel();
		panelTeamThree.setBounds(457, 150, 150, 125);
		frmBattle.getContentPane().add(panelTeamThree);
		panelTeamThree.setLayout(null);
		
		txtNameThree = new JTextField();
		txtNameThree.setEditable(false);
		txtNameThree.setBounds(6, 6, 130, 26);
		panelTeamThree.add(txtNameThree);
		txtNameThree.setColumns(10);
		
		txtAttackThree = new JTextField();
		txtAttackThree.setEditable(false);
		txtAttackThree.setBounds(6, 33, 130, 26);
		panelTeamThree.add(txtAttackThree);
		txtAttackThree.setColumns(10);
		
		txtHealThree = new JTextField();
		txtHealThree.setEditable(false);
		txtHealThree.setBounds(6, 62, 130, 26);
		panelTeamThree.add(txtHealThree);
		txtHealThree.setColumns(10);
		
		txtWinningsThree = new JTextField();
		txtWinningsThree.setEditable(false);
		txtWinningsThree.setColumns(10);
		txtWinningsThree.setBounds(6, 93, 130, 26);
		panelTeamThree.add(txtWinningsThree);
		
		btnBattle = new JButton("Battle!"); 
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTeam == null) {
					JOptionPane.showMessageDialog(null, "Please select an Enemy Team to Battle.");
				} else {
					mainscreen.generateNewBattles();
					FightScreen fighting = new FightScreen(player, currentTeam);
					fighting.frmFight.setVisible(true);
					frmBattle.dispose();
					
				}
			}
		});
		btnBattle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnBattle.setBounds(490, 33, 117, 29);
		frmBattle.getContentPane().add(btnBattle);
		
		btnExit = new JButton("Return");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBattle.dispose();
			}
		});
		btnExit.setBounds(23, 36, 117, 29);
		frmBattle.getContentPane().add(btnExit);
		
		picTwo = new JLabel("");
		picTwo.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/viking_helmet.png")));
		picTwo.setBounds(253, 287, 141, 120);
		frmBattle.getContentPane().add(picTwo);
		
		picOne = new JLabel("");
		picOne.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/sword.png")));
		picOne.setBounds(32, 287, 155, 128);
		frmBattle.getContentPane().add(picOne);
		
		picThree = new JLabel("");
		picThree.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/arrow.png")));
		picThree.setBounds(457, 287, 150, 120);
		frmBattle.getContentPane().add(picThree);
		
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
		frmBattle.getContentPane().add(cBoxTeamOne);
		
		
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
		frmBattle.getContentPane().add(cBoxTeamTwo);

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
		frmBattle.getContentPane().add(cBoxTeamThree);
	}
	
	
	/**
	 * Display one. Displays the attributes of the currently selected Monster in the first battle team
	 *
	 * @param monster the currently selected monster in the first team
	 */
	public void displayOne(Monster monster) {
		txtNameOne.setText("Name: " + monster.getName());
		txtAttackOne.setText("Damage: " + monster.getDamage() + " units");
		txtHealOne.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsOne.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(1)) + " gold");
	}
	
	/**
	 * Display two. Displays the attributes of the currently selected Monster in the second battle team
	 *
	 * @param monster the currently selected monster in the second team
	 */
	public void displayTwo(Monster monster) {
		txtNameTwo.setText("Name: " + monster.getName());
		txtAttackTwo.setText("Damage: " + monster.getDamage() + " units");
		txtHealTwo.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsTwo.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(2)) + " gold");
	}
		
	/**
	 * Display three. Displays the attributes of the currently selected Monster in the third battle team
	 *
	 * @param monster the currently selected monster in the third team
	 */
	public void displayThree(Monster monster) {
		txtNameThree.setText("Name: " + monster.getName());
		txtAttackThree.setText("Damage: " + monster.getDamage() + " units");
		txtHealThree.setText("Heal: " + monster.getHealAmount() + " units");
		txtWinningsThree.setText("Reward: " + getWinnings(mainscreen.getEnemyTeam(3)) + " gold");
	}
	
	/**
	 * Gets the winnings. 
	 *
	 * @param monsters the potential enemy battle team
	 * @return the winnings, the gold awarded to the player if the battle with the team is won.
	 */
	public int getWinnings(ArrayList<Monster> monsters) {
		int average = 0;
		for (Monster monster : monsters) {
			average += monster.getDamage();
		}
		average = average / monsters.size();
		return average;
	}
	
	
	
	
	
}
