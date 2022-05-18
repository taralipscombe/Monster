import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class SellItem {

	private Player player;
	private JFrame frame;
	private JTextField txtSellItems;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtOwn;
	private JTextField txtSell;
	private JLabel lblItemOne;
	private JLabel lblItemTwo;
	private JLabel lblItemThree;
	private JLabel lblItemFour;
	private JTextField txtCurrentGold;
	private JPanel panel;
	private JButton btnSellItem;
	private Item currentItem = null;

	/**
	 * Launch the application.
	 */
	public static void main(Player player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellItem window = new SellItem(player);
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
	public SellItem(Player ofcPlayer) {
		
		player = ofcPlayer;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtSellItems = new JTextField();
		txtSellItems.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtSellItems.setEditable(false);
		txtSellItems.setText("Sell Items:");
		txtSellItems.setBounds(254, 20, 109, 26);
		frame.getContentPane().add(txtSellItems);
		txtSellItems.setColumns(10);
		
		JRadioButton rdbtnAttackPotion = new JRadioButton("Magic Attack Potion");
		rdbtnAttackPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Attack");
			}
		});
		buttonGroup.add(rdbtnAttackPotion);
		rdbtnAttackPotion.setBounds(24, 200, 168, 23);
		frame.getContentPane().add(rdbtnAttackPotion);
		
		JRadioButton rdbtnHealingPotion = new JRadioButton("Magic Healing Potion");
		rdbtnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Heal");
			}
		});
		buttonGroup.add(rdbtnHealingPotion);
		rdbtnHealingPotion.setBounds(204, 200, 165, 23);
		frame.getContentPane().add(rdbtnHealingPotion);
		
		JRadioButton rdbtnExtraLife = new JRadioButton("Extra Life");
		rdbtnExtraLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Life");
			}
		});
		buttonGroup.add(rdbtnExtraLife);
		rdbtnExtraLife.setBounds(55, 377, 120, 23);
		frame.getContentPane().add(rdbtnExtraLife);
		
		JRadioButton rbtnLuckyDip = new JRadioButton("Lucky Dip");
		rbtnLuckyDip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Lucky");
			}
		});
		buttonGroup.add(rbtnLuckyDip);
		rbtnLuckyDip.setBounds(228, 377, 141, 23);
		frame.getContentPane().add(rbtnLuckyDip);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Selected Item:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(399, 69, 209, 221);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		txtName.setText("Name: ");
		txtName.setBounds(6, 28, 197, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtOwn = new JTextField();
		txtOwn.setHorizontalAlignment(SwingConstants.CENTER);
		txtOwn.setEditable(false);
		txtOwn.setText("You Own: ");
		txtOwn.setBounds(6, 66, 197, 26);
		panel.add(txtOwn);
		txtOwn.setColumns(10);
		
		txtSell = new JTextField();
		txtSell.setVisible(false);
		txtSell.setHorizontalAlignment(SwingConstants.CENTER);
		txtSell.setEditable(false);
		txtSell.setBounds(6, 142, 197, 26);
		panel.add(txtSell);
		txtSell.setColumns(10);

		lblItemOne = new JLabel("");
		lblItemOne.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion.png")));
		lblItemOne.setBounds(42, 60, 120, 139);
		frame.getContentPane().add(lblItemOne);
		
		lblItemTwo = new JLabel("");
		lblItemTwo.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion_2.png")));
		lblItemTwo.setBounds(222, 67, 141, 128);
		frame.getContentPane().add(lblItemTwo);
		
		lblItemThree = new JLabel("");
		lblItemThree.setIcon(new ImageIcon(BuyItem.class.getResource("/images/heart.png")));
		lblItemThree.setBounds(45, 211, 147, 164);
		frame.getContentPane().add(lblItemThree);
		
		lblItemFour = new JLabel("");
		lblItemFour.setIcon(new ImageIcon(BuyItem.class.getResource("/images/dialog_question.png")));
		lblItemFour.setBounds(236, 226, 141, 139);
		frame.getContentPane().add(lblItemFour);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(399, 353, 209, 26);
		frame.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellCurrentItem();
			}
		});
		btnSellItem.setVisible(false);
		btnSellItem.setBounds(446, 302, 117, 29);
		frame.getContentPane().add(btnSellItem);
		
		
	}
	
	
	public void displayItem(String item) {
		int num = 0;
		if (item.equals("Attack")) {
			txtName.setText("Magic Attack Potion");
			num = player.getNumItems("Magic attack potion");
			txtOwn.setText("You own " + num);

		}else if (item.equals("Heal")) {
			txtName.setText("Magic Heal Potion");
			num = player.getNumItems("Magic healing potion");
			txtOwn.setText("You own " + num);

		}else if (item.equals("Life")) {
			txtName.setText("Extra Life");
			num = player.getNumItems("Extra Life");
			txtOwn.setText("You own " + num);	
			
		} else { // lucky
			txtName.setText("Lucky Dip");
			num = player.getNumItems("Lucky Dip");
			txtOwn.setText("You own " + num);
			
		}
		if (num > 0) {
			displaySaleItem();
		} else {
			nothingToDisplay();
		}
		
	}
	
	public void displaySaleItem() {
		
		ArrayList<Item> items = player.getItems();
		int i = 0;
		while (i < items.size()) {
			Item currentTestItem = items.get(i);
			if (currentTestItem.getName().equals(txtName.getText())) {
				currentItem = currentTestItem;
				i = items.size();
			} else {
				i += 1;
			}
		}
		
		txtSell.setText("Sell one back for: " + currentItem.getsellbackPrice() + " gold");
		txtSell.setVisible(true);
		btnSellItem.setVisible(true);
	}
	
	public void nothingToDisplay() {
		currentItem = null;
		txtSell.setVisible(false);
		btnSellItem.setVisible(false);
		
	}
	
	public void sellCurrentItem() {
		
		int sellBackPrice = currentItem.getsellbackPrice();
		player.increaseGold(sellBackPrice);
		player.getItems().remove(currentItem);
		currentItem = null;
		
	}
	
	
	

}
