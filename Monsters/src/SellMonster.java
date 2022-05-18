import java.awt.Color;
import java.awt.EventQueue;
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
import java.awt.BorderLayout;

public class SellMonster {

	private Player player;
	private ArrayList<Monster> monstersForSale;
	private Monster currentSelected = null;
	private JFrame frame;
	private JTextField txtShopMonster;
	private JTextField txtName;
	private JTextField txtDamage;
	private JTextField txtHeal;
	private JTextField txtSell;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCurrentGold;
	

	/**
	 * Launch the application.
	 */
	public static void main(Player player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellMonster window = new SellMonster(player);
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
	public SellMonster(Player ofcPlayer) {
		player = ofcPlayer;
		monstersForSale = player.getTeam();
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
		
		txtShopMonster = new JTextField();
		txtShopMonster.setEditable(false);
		txtShopMonster.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtShopMonster.setText("Shop Monsters:");
		txtShopMonster.setBounds(233, 33, 169, 32);
		frame.getContentPane().add(txtShopMonster);
		txtShopMonster.setColumns(10);
		
		if (monstersForSale.size() >= 1) {
			JRadioButton rdbtnMonsterOne = new JRadioButton(monstersForSale.get(0).getName());
			rdbtnMonsterOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("One");
				}
			});
			buttonGroup.add(rdbtnMonsterOne);
			rdbtnMonsterOne.setBounds(62, 208, 87, 23);
			frame.getContentPane().add(rdbtnMonsterOne);
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
			frame.getContentPane().add(rdbtnMonsterTwo);
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
			frame.getContentPane().add(rdbtnMonsterThree);
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
			frame.getContentPane().add(rdbtnMonsterFour);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(397, 77, 208, 193);
		frame.getContentPane().add(panel);
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
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
		lblNewLabel.setBounds(52, 77, 122, 128);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
		lblNewLabel_1.setBounds(207, 243, 141, 121);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
		lblNewLabel_2.setBounds(207, 77, 141, 128);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
		lblNewLabel_3.setBounds(50, 232, 133, 132);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(407, 332, 169, 32);
		frame.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
	}
	
	
	public void displayMonster(String num) {
		
		JButton btnNewButton = new JButton("Buy Selected Monster");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellSelectedMonster();
			}
		});
		btnNewButton.setBounds(407, 282, 169, 29);
		frame.getContentPane().add(btnNewButton);
		
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
	
	
	public void sellSelectedMonster() {
		
		int sellBack = (currentSelected.getLives() / 3 )* currentSelected.getPrice();
		player.removeTeamMate(currentSelected);
		player.increaseGold(sellBack);
		txtCurrentGold.setText("Your current gold: " + player.getgold() + " gold");
		
	}
	

	
	
}
