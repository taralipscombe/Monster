package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


/**
 * The Class SellMonster.
 */
public class SellMonster {

	/** The player. */
	private Player player;
	
	/** The monsters for sale. */
	private ArrayList<Monster> monstersForSale;
	
	/** The current selected Monster . */
	private Monster currentSelected = null;
	
	/** The sell monster frame. */
	public JFrame frmSellMonster;
	
	/** The txt shop monster. */
	private JTextField txtSellMonster;
	
	/** The text displaying the currently selected Monsters name. */
	private JTextField txtName;
	
	/** The text displaying the currently selected Monsters damage. */
	private JTextField txtDamage;
	
	/** The text displaying the currently selected Monsters heal amount. */
	private JTextField txtHeal;
	
	/** The text displaying the currently selected Monsters selling price. */
	private JTextField txtSell;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The text displaying the players gold. */
	private JTextField txtCurrentGold;
	
	/** The return button. */
	private JButton btnReturn;
	
	/** The sell Monster button. */
	private JButton btnSellButton;
	

	/**
	 * Create the application. Get the players team as options of monsters to sell.
	 * 
	 * monPicOne sourced from: https://findicons.com/icon/220399/monster04
	 * monPicTwo sourced from: https://findicons.com/icon/220396/monster02
	 * monPicThree sourced from: https://findicons.com/icon/220398/monster05
	 * monPicFour sourced from: https://findicons.com/icon/220397/monster01
	 *
	 * @param ofcPlayer the official player of the game.
	 */
	public SellMonster(Player ofcPlayer) {
		player = ofcPlayer;
		monstersForSale = player.getTeam();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSellMonster = new JFrame();
		frmSellMonster.setBounds(100, 100, 650, 450);
		frmSellMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellMonster.getContentPane().setLayout(null);
		
		txtSellMonster = new JTextField();
		txtSellMonster.setEditable(false);
		txtSellMonster.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		txtSellMonster.setText("Sell Monsters:");
		txtSellMonster.setBounds(189, 35, 208, 32);
		frmSellMonster.getContentPane().add(txtSellMonster);
		txtSellMonster.setColumns(10);
		
		if (monstersForSale.size() >= 1) {
			JRadioButton rdbtnMonsterOne = new JRadioButton(monstersForSale.get(0).getName());
			rdbtnMonsterOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("One");
				}
			});
			buttonGroup.add(rdbtnMonsterOne);
			rdbtnMonsterOne.setBounds(62, 208, 87, 23);
			frmSellMonster.getContentPane().add(rdbtnMonsterOne);
		}
		
		if (monstersForSale.size() >= 2) {
			JRadioButton rdbtnMonsterTwo = new JRadioButton(monstersForSale.get(1).getName());
			rdbtnMonsterTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Two");
				}
			});
			buttonGroup.add(rdbtnMonsterTwo);
			rdbtnMonsterTwo.setBounds(233, 208, 84, 23);
			frmSellMonster.getContentPane().add(rdbtnMonsterTwo);
			}
		
		if (monstersForSale.size() >= 3) {
			JRadioButton rdbtnMonsterThree = new JRadioButton(monstersForSale.get(2).getName());
			rdbtnMonsterThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Three");
				}
			});
			buttonGroup.add(rdbtnMonsterThree);
			rdbtnMonsterThree.setBounds(62, 361, 94, 23);
			frmSellMonster.getContentPane().add(rdbtnMonsterThree);
		}
		
		if (monstersForSale.size() >= 4) {
			JRadioButton rdbtnMonsterFour = new JRadioButton(monstersForSale.get(3).getName());
			rdbtnMonsterFour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Four");
				}
			});
			buttonGroup.add(rdbtnMonsterFour);
			rdbtnMonsterFour.setBounds(233, 361, 96, 23);
			frmSellMonster.getContentPane().add(rdbtnMonsterFour);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(397, 77, 208, 193);
		frmSellMonster.getContentPane().add(panel);
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
		
		txtSell = new JTextField();
		txtSell.setHorizontalAlignment(SwingConstants.CENTER);
		txtSell.setText("Cost");
		txtSell.setBounds(6, 143, 196, 26);
		panel.add(txtSell);
		txtSell.setColumns(10);
		
		
		JLabel monPicOne = new JLabel("");
		monPicOne.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
		monPicOne.setBounds(52, 77, 122, 128);
		frmSellMonster.getContentPane().add(monPicOne);
		
		JLabel monPicFour = new JLabel("");
		monPicFour.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
		monPicFour.setBounds(207, 243, 141, 121);
		frmSellMonster.getContentPane().add(monPicFour);
		
		JLabel monPicTwo = new JLabel("");
		monPicTwo.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
		monPicTwo.setBounds(207, 77, 141, 128);
		frmSellMonster.getContentPane().add(monPicTwo);
		
		JLabel monPicThree = new JLabel("");
		monPicThree.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
		monPicThree.setBounds(50, 232, 133, 132);
		frmSellMonster.getContentPane().add(monPicThree);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(397, 332, 208, 32);
		frmSellMonster.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		btnSellButton = new JButton("Sell Selected Monster");
		btnSellButton.setVisible(false);
		btnSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellSelectedMonster();
			}
		});
		btnSellButton.setBounds(396, 282, 198, 29);
		frmSellMonster.getContentPane().add(btnSellButton);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSellMonster.dispose();
			}
		});
		btnReturn.setBounds(459, 38, 117, 29);
		frmSellMonster.getContentPane().add(btnReturn);
	}
	
	
	/**
	 * Display monster. Displays the currently selected Monster and its attributes, also displays the sell selected monster button.
	 *
	 * @param num the number of the currently selected Monster.
	 */
	public void displayMonster(String num) {
	
		btnSellButton.setVisible(true);
		
		if (num.equals("One")) {
			currentSelected = monstersForSale.get(0);
			txtName.setText(monstersForSale.get(0).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(0).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(0).getHealAmount() + " units");
			int sellBack = (monstersForSale.get(0).getLives() / 3 )* monstersForSale.get(0).getPrice();
			txtSell.setText("Sell back for " + sellBack + " gold");
			
			
		}else if (num.equals("Two")) {
			currentSelected = monstersForSale.get(1);
			txtName.setText(monstersForSale.get(1).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(1).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(1).getHealAmount() + " units");
			int sellBack = (monstersForSale.get(1).getLives() / 3 )* monstersForSale.get(1).getPrice();
			txtSell.setText("Sell back for " + sellBack + " gold");
			
		}else if (num.equals("Three")) {
			currentSelected = monstersForSale.get(2);
			txtName.setText(monstersForSale.get(2).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(2).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(2).getHealAmount() + " units");
			int sellBack = (monstersForSale.get(2).getLives() / 3 )* monstersForSale.get(2).getPrice();
			txtSell.setText("Sell back for " + sellBack + " gold");
			
		} else { // Four
			currentSelected = monstersForSale.get(3);
			txtName.setText(monstersForSale.get(3).getName()); 
			txtDamage.setText("Damage: " + monstersForSale.get(3).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monstersForSale.get(3).getHealAmount() + " units");
			int sellBack = (monstersForSale.get(3).getLives() / 3 )* monstersForSale.get(3).getPrice();
			txtSell.setText("Sell back for " + sellBack + " gold");
		}
	}
	
	
	/**
	 * Sells the currently selected monster by removing Monster from players monster team and increase their gold by the sell back price.
	 */
	public void sellSelectedMonster() {
		
		int sellBack = (currentSelected.getLives() / 3 )* currentSelected.getPrice();
		player.removeTeamMate(currentSelected);
		player.increaseGold(sellBack);
		txtCurrentGold.setText("Your current gold: " + player.getgold() + " gold");
		frmSellMonster.dispose();
		
	}
	

	
	
}
