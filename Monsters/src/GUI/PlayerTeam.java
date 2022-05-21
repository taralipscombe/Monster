package GUI;

import java.awt.Color;

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
	private JTextField txtYourCurrentMonster;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtDamage;
	private JTextField txtHeal;
	private JTextField txtLives;
	private JTextField txtCurrentHealth;


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
	 * 
	 * MonPicOne sourced from: https://findicons.com/icon/220399/monster04
	 * MonPicTwo sourced from: https://findicons.com/icon/220396/monster02
	 * MonPicThree sourced from: https://findicons.com/icon/220398/monster05
	 * MonPicFour sourced from: https://findicons.com/icon/220397/monster01
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
			JLabel MonPicOne = new JLabel("");
			MonPicOne.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster04.png")));
			MonPicOne.setBounds(52, 77, 122, 128);
			frmPlayerTeam.getContentPane().add(MonPicOne);
			
			JRadioButton rdbtnMonsterOne = new JRadioButton(monsterTeam.get(0).getName());
			rdbtnMonsterOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("One");
				}
			});
			buttonGroup.add(rdbtnMonsterOne);
			rdbtnMonsterOne.setBounds(62, 208, 87, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterOne);
		}
		
		if (monsterTeam.size() >= 2) {
			
			JLabel MonPicTwo = new JLabel("");
			MonPicTwo.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster02.png")));
			MonPicTwo.setBounds(207, 77, 141, 128);
			frmPlayerTeam.getContentPane().add(MonPicTwo);
			
			JRadioButton rdbtnMonsterTwo = new JRadioButton(monsterTeam.get(1).getName());
			rdbtnMonsterTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Two");
				}
			});
			buttonGroup.add(rdbtnMonsterTwo);
			rdbtnMonsterTwo.setBounds(233, 208, 84, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterTwo);
		}
		
		if (monsterTeam.size() >= 3) {
	
			JLabel MonPicThree = new JLabel("");
			MonPicThree.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster05.png")));
			MonPicThree.setBounds(50, 232, 133, 132);
			frmPlayerTeam.getContentPane().add(MonPicThree);
			
			JRadioButton rdbtnMonsterThree = new JRadioButton(monsterTeam.get(2).getName());
			rdbtnMonsterThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Three");
				}
			});
			buttonGroup.add(rdbtnMonsterThree);
			rdbtnMonsterThree.setBounds(62, 361, 94, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterThree);
		}
		
		if (monsterTeam.size() >= 4) { 
		
			JLabel MonPicFour = new JLabel("");
			MonPicFour.setIcon(new ImageIcon(BuyMonster.class.getResource("/images/monster01.png")));
			MonPicFour.setBounds(207, 243, 141, 121);
			frmPlayerTeam.getContentPane().add(MonPicFour);
			JRadioButton rdbtnMonsterFour = new JRadioButton(monsterTeam.get(3).getName());
			rdbtnMonsterFour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMonster("Four");
				}
			});
			buttonGroup.add(rdbtnMonsterFour);
			rdbtnMonsterFour.setBounds(233, 361, 96, 23);
			frmPlayerTeam.getContentPane().add(rdbtnMonsterFour);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Monster:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(398, 118, 208, 209);
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
		
		txtLives = new JTextField();
		txtLives.setEditable(false);
		txtLives.setHorizontalAlignment(SwingConstants.CENTER);
		txtLives.setText("Lives Left");
		txtLives.setBounds(6, 168, 196, 26);
		panel.add(txtLives);
		txtLives.setColumns(10);
		
		txtCurrentHealth = new JTextField();
		txtCurrentHealth.setText("Current Health:");
		txtCurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrentHealth.setEditable(false);
		txtCurrentHealth.setColumns(10);
		txtCurrentHealth.setBounds(6, 138, 196, 26);
		panel.add(txtCurrentHealth);
		
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
			txtLives.setText("Lives left: " + monsterTeam.get(0).getLives());
			txtCurrentHealth.setText("Current Health: " + monsterTeam.get(0).getCurrentHealth() + " units");
			
		}else if (num.equals("Two")) {
			txtName.setText(monsterTeam.get(1).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(1).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(1).getHealAmount() + " units");
			txtLives.setText("Lives left: " + monsterTeam.get(1).getLives());
			txtCurrentHealth.setText("Current Health: " + monsterTeam.get(1).getCurrentHealth() + " units");
			
		}else if (num.equals("Three")) {
			txtName.setText(monsterTeam.get(2).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(2).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(2).getHealAmount() + " units");
			txtLives.setText("Lives left: " + monsterTeam.get(2).getLives());
			txtCurrentHealth.setText("Current Health: " + monsterTeam.get(2).getCurrentHealth() + " units");
			
		} else { // Four
			txtName.setText(monsterTeam.get(3).getName()); 
			txtDamage.setText("Damage: " + monsterTeam.get(3).getDamage() + " units");
			txtHeal.setText("Heal Amount: " + monsterTeam.get(3).getHealAmount() + " units");
			txtLives.setText("Lives left: " + monsterTeam.get(3).getLives());
			txtCurrentHealth.setText("Current Health: " + monsterTeam.get(3).getCurrentHealth() + " units");
			
		}
		
	}
}
