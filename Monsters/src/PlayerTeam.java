import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PlayerTeam {

	public JFrame frmPlayerTeam;
	private Player player;
	private ArrayList<Monster> monsterTeam;
	private int currentlySelected;
	private JTextField txtYourCurrentMonster;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtDamage;
	private JTextField txtHeal;
	private JTextField txtCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerTeam window = new PlayerTeam();
					window.frmPlayerTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerTeam(Player ofcPlayer) {
		
		player = ofcPlayer;
		monsterTeam = player.getTeam();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerTeam = new JFrame();
		frmPlayerTeam.setBounds(100, 100, 650, 449);
		frmPlayerTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerTeam.getContentPane().setLayout(null);
		
		txtYourCurrentMonster = new JTextField();
		txtYourCurrentMonster.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		txtYourCurrentMonster.setEditable(false);
		txtYourCurrentMonster.setText("Your Current Monster Team:");
		txtYourCurrentMonster.setBounds(145, 34, 340, 31);
		frmPlayerTeam.getContentPane().add(txtYourCurrentMonster);
		txtYourCurrentMonster.setColumns(10);
		
		if (monsterTeam.size() >=1 ) {
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
			lblNewLabel.setBounds(52, 77, 122, 128);
			frmPlayerTeam.getContentPane().add(lblNewLabel);
			
			JRadioButton rdbtnMonsterOne = new JRadioButton(monsterTeam.get(0).getName());
			rdbtnMonsterOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 1;
					displayMonster("One");
				}
			});
			buttonGroup.add(rdbtnMonsterOne);
			rdbtnMonsterOne.setBounds(62, 208, 87, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterOne);
		}
		
		if (monsterTeam.size() >= 2) {
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
			lblNewLabel_1.setBounds(207, 243, 141, 121);
			frmPlayerTeam.getContentPane().add(lblNewLabel_1);
			
			JRadioButton rdbtnMonsterTwo = new JRadioButton(monsterTeam.get(1).getName());
			rdbtnMonsterTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 2;
					displayMonster("Two");
				}
			});
			buttonGroup.add(rdbtnMonsterTwo);
			rdbtnMonsterTwo.setBounds(233, 208, 84, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterTwo);
		}
		
		if (monsterTeam.size() >= 3) {
		
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
			lblNewLabel_2.setBounds(207, 77, 141, 128);
			frmPlayerTeam.getContentPane().add(lblNewLabel_2);
			
			JRadioButton rdbtnMonsterThree = new JRadioButton(monsterTeam.get(2).getName());
			rdbtnMonsterThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 3;
					displayMonster("Three");
				}
			});
			buttonGroup.add(rdbtnMonsterThree);
			rdbtnMonsterThree.setBounds(62, 361, 94, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterThree);
		}
		
		if (monsterTeam.size() >= 4) { 
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
			lblNewLabel_3.setBounds(50, 232, 133, 132);
			frmPlayerTeam.getContentPane().add(lblNewLabel_3);
		
			JRadioButton rdbtnMonsterFour = new JRadioButton(monsterTeam.get(3).getName());
			rdbtnMonsterFour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentlySelected = 4;
					displayMonster("Four");
				}
			});
			buttonGroup.add(rdbtnMonsterFour);
			rdbtnMonsterFour.setBounds(233, 361, 96, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterFour);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(398, 118, 208, 193);
		frmPlayerTeam.getContentPane().add(panel);
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
				frmPlayerTeam.dispose();
			}
		});
		btnReturn.setBounds(511, 21, 117, 29);
		frmPlayerTeam.getContentPane().add(btnReturn);
		
	}
	
	
	
	
public void displayMonster(String num) {
		
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
