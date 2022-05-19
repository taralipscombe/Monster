import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ApplyingItemWindow {

	public JFrame frmApplyingItem;
	private Player player;
	private Item appliedItem;
	private ArrayList<Monster> monsterTeam;
	private int currentlySelected;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtDamage;
	private JTextField txtHeal;
	private JTextField txtCost;
	private JTextField txtTitle;
	private JButton btnApply;

	/**
	 * Launch the application.
	 */
	public static void main(Player ofcPlayer, Item item) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyingItemWindow window = new ApplyingItemWindow(ofcPlayer, item);
					window.frmApplyingItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplyingItemWindow(Player ofcPlayer, Item item) {
		
		player = ofcPlayer;
		monsterTeam = player.getTeam();
		appliedItem = item;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplyingItem = new JFrame();
		frmApplyingItem.setBounds(100, 100, 650, 450);
		frmApplyingItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApplyingItem.getContentPane().setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtTitle.setText("Select Monster to Apply Item too:");
		txtTitle.setBounds(158, 24, 318, 26);
		frmApplyingItem.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		
		if (monsterTeam.size() >=1 ) {
		
			JLabel MonPicOne = new JLabel("");
			MonPicOne.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
			MonPicOne.setBounds(52, 77, 122, 128);
			frmApplyingItem.getContentPane().add(MonPicOne);
			
			JRadioButton rdbtnMonsterOne = new JRadioButton(monsterTeam.get(0).getName());
			rdbtnMonsterOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 1;
					displayMonster("One");
				}
			});
			buttonGroup.add(rdbtnMonsterOne);
			rdbtnMonsterOne.setBounds(62, 208, 87, 23);
			frmApplyingItem.getContentPane().add(rdbtnMonsterOne);
		}
		
		if (monsterTeam.size() >= 2) {
			JOptionPane.showMessageDialog(frmApplyingItem, "Your Monster Team is looking empty... Purchase more Monsters at the Shop!");
			
			JLabel MonPicTwo = new JLabel("");
			MonPicTwo.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
			MonPicTwo.setBounds(207, 77, 141, 128);
			frmApplyingItem.getContentPane().add(MonPicTwo);
			
			JRadioButton rdbtnMonsterTwo = new JRadioButton(monsterTeam.get(1).getName());
			rdbtnMonsterTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 2;
					displayMonster("Two");
				}
			});
			buttonGroup.add(rdbtnMonsterTwo);
			rdbtnMonsterTwo.setBounds(233, 208, 84, 23);
			frmApplyingItem.getContentPane().add(rdbtnMonsterTwo);
		}
		
		if (monsterTeam.size() >= 3) {
	
			
			JLabel MonPicThree = new JLabel("");
			MonPicThree.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
			MonPicThree.setBounds(50, 232, 133, 132);
			frmApplyingItem.getContentPane().add(MonPicThree);
			
			JRadioButton rdbtnMonsterThree = new JRadioButton(monsterTeam.get(2).getName());
			rdbtnMonsterThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 3;
					displayMonster("Three");
				}
			});
			buttonGroup.add(rdbtnMonsterThree);
			rdbtnMonsterThree.setBounds(62, 361, 94, 23);
			frmApplyingItem.getContentPane().add(rdbtnMonsterThree);
		}
		
		if (monsterTeam.size() >= 4) { 
			
			
			JLabel MonPicFour = new JLabel("");
			MonPicFour.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
			MonPicFour.setBounds(207, 243, 141, 121);
			frmApplyingItem.getContentPane().add(MonPicFour);
		
			JRadioButton rdbtnMonsterFour = new JRadioButton(monsterTeam.get(3).getName());
			rdbtnMonsterFour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 4;
					displayMonster("Four");
				}
			});
			buttonGroup.add(rdbtnMonsterFour);
			rdbtnMonsterFour.setBounds(233, 361, 96, 23);
			frmApplyingItem.getContentPane().add(rdbtnMonsterFour);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(398, 118, 208, 193);
		frmApplyingItem.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setBounds(6, 29, 196, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtDamage = new JTextField();
		txtDamage.setEditable(false);
		txtDamage.setText("Damage");
		txtDamage.setHorizontalAlignment(SwingConstants.CENTER);
		txtDamage.setBounds(6, 67, 196, 26);
		panel.add(txtDamage);
		txtDamage.setColumns(10);
		
		txtHeal = new JTextField();
		txtHeal.setEditable(false);
		txtHeal.setHorizontalAlignment(SwingConstants.CENTER);
		txtHeal.setText("Heal");
		txtHeal.setBounds(6, 105, 196, 26);
		panel.add(txtHeal);
		txtHeal.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setEditable(false);
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setText("Cost");
		txtCost.setBounds(6, 143, 196, 26);
		panel.add(txtCost);
		txtCost.setColumns(10);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmApplyingItem.dispose();
			}
		});
		btnReturn.setBounds(511, 21, 117, 29);
		frmApplyingItem.getContentPane().add(btnReturn);
		
		btnApply = new JButton("Apply to Monster");
		btnApply.setVisible(false);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster chosenMonster = monsterTeam.get(currentlySelected - 1);
				player.useItem(appliedItem, chosenMonster);
				JOptionPane.showMessageDialog(null, "You have successfully applied " + appliedItem.getName() + " to " + chosenMonster.getName());
				frmApplyingItem.dispose();
			}
		});
		btnApply.setBounds(425, 335, 152, 29);
		frmApplyingItem.getContentPane().add(btnApply);
		
		
	}
	
	
	public void displayMonster(String num) {
		
		btnApply.setVisible(true);
		
		if (num.equals("One")) {
			txtName.setText(monsterTeam.get(0).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(0).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(0).getHealAmount() + " units");
			txtCost.setText("Cost: " + monsterTeam.get(0).getPrice() + " gold");
			
		}else if (num.equals("Two")) {
			txtName.setText(monsterTeam.get(1).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(1).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(1).getHealAmount() + " units");
			txtCost.setText("Cost: " + monsterTeam.get(1).getPrice() + " gold");
			
		}else if (num.equals("Three")) {
			txtName.setText(monsterTeam.get(2).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(2).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(2).getHealAmount() + " units");
			txtCost.setText("Cost: " + monsterTeam.get(2).getPrice() + " gold");
			
		} else { // Four
			txtName.setText(monsterTeam.get(3).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(3).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(3).getHealAmount() + " units");
			txtCost.setText("Cost: " + monsterTeam.get(3).getPrice() + " gold");
			
		}
		
	}

}
