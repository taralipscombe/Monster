import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class BuyMonster.
 */
public class BuyMonster {

	/** The player. */
	private Player player;
	
	/** The monsters for sale. */
	private ArrayList<Monster> monstersForSale;
	
	/** The currently selected. */
	private int currentlySelected;
	
	/** The frm buy monster. */
	public JFrame frmBuyMonster;
	
	/** The txt shop monster. */
	private JTextField txtShopMonster;
	
	/** The txt name. */
	private JTextField txtName;
	
	/** The txt damage. */
	private JTextField txtDamage;
	
	/** The txt heal. */
	private JTextField txtHeal;
	
	/** The txt cost. */
	private JTextField txtCost;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The txt current gold. */
	private JTextField txtCurrentGold;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyMonster window = new BuyMonster();
					window.frmBuyMonster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. Creates a monsterGenertor instance to randomly create Monsters for the player to buy
	 *
	 * @param ofcPlayer the official Player of the game
	 */
	public BuyMonster(Player ofcPlayer) {
		
		player = ofcPlayer;
		MonsterGenerator instanceMonster = new MonsterGenerator();
		ArrayList<Monster> forSale = instanceMonster.generator();
		monstersForSale = forSale;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuyMonster = new JFrame();
		frmBuyMonster.setBounds(100, 100, 650, 451);
		frmBuyMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyMonster.getContentPane().setLayout(null);
		
		txtShopMonster = new JTextField();
		txtShopMonster.setEditable(false);
		txtShopMonster.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtShopMonster.setText("Shop Monsters:");
		txtShopMonster.setBounds(233, 17, 165, 26);
		frmBuyMonster.getContentPane().add(txtShopMonster);
		txtShopMonster.setColumns(10);
		
		JRadioButton rdbtnMonsterOne = new JRadioButton(monstersForSale.get(0).getName());
		rdbtnMonsterOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 1;
				displayMonster("One");
			}
		});
		buttonGroup.add(rdbtnMonsterOne);
		rdbtnMonsterOne.setBounds(62, 208, 87, 23);
		frmBuyMonster.getContentPane().add(rdbtnMonsterOne);
		
		JRadioButton rdbtnMonsterTwo = new JRadioButton(monstersForSale.get(1).getName());
		rdbtnMonsterTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 2;
				displayMonster("Two");
			}
		});
		buttonGroup.add(rdbtnMonsterTwo);
		rdbtnMonsterTwo.setBounds(233, 208, 84, 23);
		frmBuyMonster.getContentPane().add(rdbtnMonsterTwo);
		
		JRadioButton rdbtnMonsterThree = new JRadioButton(monstersForSale.get(2).getName());
		rdbtnMonsterThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 3;
				displayMonster("Three");
			}
		});
		buttonGroup.add(rdbtnMonsterThree);
		rdbtnMonsterThree.setBounds(62, 361, 94, 23);
		frmBuyMonster.getContentPane().add(rdbtnMonsterThree);
		
		JRadioButton rdbtnMonsterFour = new JRadioButton(monstersForSale.get(3).getName());
		rdbtnMonsterFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 4;
				displayMonster("Four");
			}
		});
		buttonGroup.add(rdbtnMonsterFour);
		rdbtnMonsterFour.setBounds(233, 361, 96, 23);
		frmBuyMonster.getContentPane().add(rdbtnMonsterFour);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(397, 77, 208, 193);
		frmBuyMonster.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setBounds(6, 29, 196, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtDamage = new JTextField();
		txtDamage.setText("Damage");
		txtDamage.setHorizontalAlignment(SwingConstants.CENTER);
		txtDamage.setBounds(6, 67, 196, 26);
		panel.add(txtDamage);
		txtDamage.setColumns(10);
		
		txtHeal = new JTextField();
		txtHeal.setHorizontalAlignment(SwingConstants.CENTER);
		txtHeal.setText("Heal");
		txtHeal.setBounds(6, 105, 196, 26);
		panel.add(txtHeal);
		txtHeal.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setText("Cost");
		txtCost.setBounds(6, 143, 196, 26);
		panel.add(txtCost);
		txtCost.setColumns(10);
		
		JButton btnNewButton = new JButton("Buy Selected Monster");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buySelectedMonster();
			}
		});
		btnNewButton.setBounds(407, 282, 169, 29);
		frmBuyMonster.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
		lblNewLabel.setBounds(52, 77, 122, 128);
		frmBuyMonster.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
		lblNewLabel_1.setBounds(207, 243, 141, 121);
		frmBuyMonster.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
		lblNewLabel_2.setBounds(207, 77, 141, 128);
		frmBuyMonster.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
		lblNewLabel_3.setBounds(50, 232, 133, 132);
		frmBuyMonster.getContentPane().add(lblNewLabel_3);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(397, 341, 208, 26);
		frmBuyMonster.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuyMonster.dispose();
			}
		});
		btnReturn.setBounds(459, 19, 117, 29);
		frmBuyMonster.getContentPane().add(btnReturn);
	}
	
	

	/**
	 * Display monster. Once a monster is selected in the shop, its attributes are displayed using this method.
	 *
	 * @param num the num of the monster in the team
	 */
	public void displayMonster(String num) {
		if (num.equals("One")) {
			txtName.setText(monstersForSale.get(0).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(0).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(0).getHealAmount() + " units");
			txtCost.setText("Cost: " + monstersForSale.get(0).getPrice() + " gold");
			
		}else if (num.equals("Two")) {
			txtName.setText(monstersForSale.get(1).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(1).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(1).getHealAmount() + " units");
			txtCost.setText("Cost: " + monstersForSale.get(1).getPrice() + " gold");
			
		}else if (num.equals("Three")) {
			txtName.setText(monstersForSale.get(2).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(2).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(2).getHealAmount() + " units");
			txtCost.setText("Cost: " + monstersForSale.get(2).getPrice() + " gold");
			
		} else { // Four
			txtName.setText(monstersForSale.get(3).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(3).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(3).getHealAmount() + " units");
			txtCost.setText("Cost: " + monstersForSale.get(3).getPrice() + " gold");
		}
	}
	
	
	
	/**
	 * Buy selected monster. If the buy Montser button is selected, then the buy method is called with the currently selected monster.
	 * 
	 */
	public void buySelectedMonster() {
		if (currentlySelected == 1) {
			buy(monstersForSale.get(0));
		} else if (currentlySelected == 2) {
			buy(monstersForSale.get(1));
		} else if (currentlySelected == 3) {
			buy(monstersForSale.get(2));
		} else if (currentlySelected == 4){
			buy(monstersForSale.get(3));
		} else {
			JOptionPane.showMessageDialog(frmBuyMonster, "Please select the Monster you wish to purchase.");
		}
	}
	
	/**
	 * Buy. Checks the player has enough gold to purchase the monster and that they have room in their team.
	 * If passes all of the checks, the player then purchases the monster
	 *
	 * @param monster the monster
	 */
	public void buy(Monster monster) {
		if(player.getgold() < monster.getPrice()) {
			JOptionPane.showMessageDialog(frmBuyMonster, "You do not have enough gold to purchase this Monster. You can earn more gold by battling!");
		} else if (player.getTeam().size() == 4 ) {
			JOptionPane.showMessageDialog(frmBuyMonster, "You already have a full team! TIP: You can sell Monsters in the Shop!");
		} else {
			player.decreaseGold(monster.getPrice());
			txtCurrentGold.setText("Your current gold: " + player.getgold() + " gold"); 
			player.addTeamMate(monster);
			JOptionPane.showMessageDialog(frmBuyMonster, "You have successfully bought " + monster.getName());
}
	}
	
	

}
