import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BuyItem {
	
	private Player player;
	private JFrame frame;
	private int currentlySelected;
	private JTextField txtShopBuyingItems;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtProperty;
	private JTextField txtAmount;
	private JTextField txtCost;
	private JTextField txtOwn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCurrentGold;

	/**
	 * Launch the application.
	 */
	public static void main(Player player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyItem window = new BuyItem(player);
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
	public BuyItem(Player ofcPlayer) {
		player = ofcPlayer;
		initialize();
		frame.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtShopBuyingItems = new JTextField();
		txtShopBuyingItems.setEditable(false);
		txtShopBuyingItems.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtShopBuyingItems.setText("Shop Items:");
		txtShopBuyingItems.setBounds(242, 23, 127, 32);
		frame.getContentPane().add(txtShopBuyingItems);
		txtShopBuyingItems.setColumns(10);

		
		JRadioButton rdbtnAttackPotion = new JRadioButton("Magic Attack Potion");
		rdbtnAttackPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 1;
				displayItem("Attack");
			}
		});
		buttonGroup.add(rdbtnAttackPotion);
		rdbtnAttackPotion.setBounds(24, 200, 168, 23);
		frame.getContentPane().add(rdbtnAttackPotion);
		
		JRadioButton rdbtnHealingPotion = new JRadioButton("Magic Healing Potion");
		rdbtnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 2;
				displayItem("Heal");
			}
		});
		buttonGroup.add(rdbtnHealingPotion);
		rdbtnHealingPotion.setBounds(204, 200, 165, 23);
		frame.getContentPane().add(rdbtnHealingPotion);
		
		JRadioButton rdbtnExtraLife = new JRadioButton("Extra Life");
		rdbtnExtraLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 3;
				displayItem("Life");
			}
		});
		buttonGroup.add(rdbtnExtraLife);
		rdbtnExtraLife.setBounds(55, 377, 120, 23);
		frame.getContentPane().add(rdbtnExtraLife);
		
		JRadioButton rbtnLuckyDip = new JRadioButton("Lucky Dip");
		rbtnLuckyDip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 4;
				displayItem("Lucky");
			}
		});
		buttonGroup.add(rbtnLuckyDip);
		rbtnLuckyDip.setBounds(228, 377, 141, 23);
		frame.getContentPane().add(rbtnLuckyDip);
		
		JButton btnBuyItem = new JButton("Buy Selected Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buySelectedItem();
			}
		});
		btnBuyItem.setBounds(429, 302, 147, 29);
		frame.getContentPane().add(btnBuyItem);
		
		JPanel panel = new JPanel();
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
		
		txtProperty = new JTextField();
		txtProperty.setHorizontalAlignment(SwingConstants.CENTER);
		txtProperty.setEditable(false);
		txtProperty.setText("Affects: ");
		txtProperty.setBounds(6, 66, 197, 26);
		panel.add(txtProperty);
		txtProperty.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setEditable(false);
		txtAmount.setText("Amount: ");
		txtAmount.setBounds(6, 104, 197, 26);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setEditable(false);
		txtCost.setText("Cost : ");
		txtCost.setBounds(6, 142, 197, 26);
		panel.add(txtCost);
		txtCost.setColumns(10);
		
		txtOwn = new JTextField();
		txtOwn.setHorizontalAlignment(SwingConstants.CENTER);
		txtOwn.setEditable(false);
		txtOwn.setText("Own: ");
		txtOwn.setBounds(6, 180, 197, 26);
		panel.add(txtOwn);
		txtOwn.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion.png")));
		lblNewLabel.setBounds(42, 60, 120, 139);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion_2.png")));
		lblNewLabel_1.setBounds(222, 67, 141, 128);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BuyItem.class.getResource("/images/heart.png")));
		lblNewLabel_2.setBounds(45, 211, 147, 164);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BuyItem.class.getResource("/images/dialog_question.png")));
		lblNewLabel_3.setBounds(236, 226, 141, 139);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(399, 353, 209, 26);
		frame.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		JButton btnExit = new JButton("Exit Shop");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(491, 23, 117, 29);
		frame.getContentPane().add(btnExit);
	}
	
	
	public void displayItem(String item) {
		if (item.equals("Attack")) {
			txtName.setText("Magic Attack Potion");
			txtProperty.setText("Changes Monster's Attack");
			txtAmount.setText("Increases by 15 units");
			txtCost.setText("Costs 60 gold");
			int num = player.getNumItems("Magic attack potion");
			txtOwn.setText("You already own " + num);
			
		}else if (item.equals("Heal")) {
			txtName.setText("Magic Heal Potion");
			txtProperty.setText("Changes Monster's Heal Amount");
			txtAmount.setText("Increases by 10 units");
			txtCost.setText("Costs 45 gold");
			int num = player.getNumItems("Magic healing potion");
			txtOwn.setText("You already own " + num);
			
		}else if (item.equals("Life")) {
			txtName.setText("Extra Life");
			txtProperty.setText("Changes Monster's Lives");
			txtAmount.setText("Increases by 1 life");
			txtCost.setText("Costs 70 gold");
			int num = player.getNumItems("Extra Life");
			txtOwn.setText("You already own " + num);
			
		} else { // lucky
			txtName.setText("Lucky Dip");
			txtProperty.setText("Randomly Selects");
			txtAmount.setText("Another Item");
			txtCost.setText("Costs 44 gold");
			int num = player.getNumItems("Lucky Dip");
			txtOwn.setText("You already own " + num);
		}
		
	}
	
	
	public void buySelectedItem() {
		if (currentlySelected == 1) {
			Item attackPotion = new Item("Magic Attack Potion" , "damage", 15, 3, 60);
			buy(attackPotion);
		} else if (currentlySelected == 2) {
			Item healingPotion = new Item("Magic Healing Potion" , "heal amount" , 10, 3, 45);
			buy(healingPotion);
		} else if (currentlySelected == 3) {
			Item extraLife = new Item("Extra Life", "lives", 1, 1, 70);
			buy(extraLife);
		} else if (currentlySelected == 4){
			Item luckyDip = new Item("Lucky Dip", "unknown", 0, 1, 44);
			buy(luckyDip);
		} else {
			JOptionPane.showMessageDialog(null, "Please select the Item you wish to purchase.");
		}
	}
	
	public void buy(Item purchasedItem) {
		
		if(player.getgold() < purchasedItem.getPurchasePrice()) {
			JOptionPane.showMessageDialog(null, "You do not have enough gold to purchase this Item. You can earn more gold by battling!");
		} else {
			player.decreaseGold(purchasedItem.getPurchasePrice());
			txtCurrentGold.setText("Your current gold: " + player.getgold() + " gold"); 
			if(purchasedItem.getName() == "Lucky Dip") {
				ArrayList<Item> shopItems = new ArrayList<Item>();
				shopItems.add(new Item("Magic Attack Potion" , "damage", 15, 3, 60));
				shopItems.add(new Item("Magic Healing Potion" , "heal amount" , 10, 3, 45));
				shopItems.add(new Item("Extra Life", "lives", 1, 1, 70));
				Random rndm = new Random();
				int randomInt = rndm.nextInt(shopItems.size());
				while (shopItems.get(randomInt).getName() == "Lucky Dip") {
					randomInt = rndm.nextInt(shopItems.size());
				}
				purchasedItem = shopItems.get(randomInt);
			}
			player.addItem(purchasedItem);
			JOptionPane.showMessageDialog(null, "You have successfully bought " + purchasedItem.getName());
	}
		
	}
}
