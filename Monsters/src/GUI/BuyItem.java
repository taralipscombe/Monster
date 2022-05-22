package GUI;

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

// TODO: Auto-generated Javadoc
/**
 * The Class BuyItem.
 */
public class BuyItem {
	
	/** The official player of the game. */
	private Player player;
	
	/** The buy item frame. */
	public JFrame frmBuyItem;
	
	/** The currently selected item. */
	private int currentlySelected;
	
	/** The txt shop buying items. */
	private JTextField txtShopBuyingItems;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The text displaying the current Items name. */
	private JTextField txtName;
	
	/** The text displaying the current Item property. */
	private JTextField txtProperty;
	
	/** The text displaying the current Item property change. */
	private JTextField txtAmount;
	
	/** The text displaying the current Item cost. */
	private JTextField txtCost;
	
	/** The text displaying how many items the player owns of the current Item. */
	private JTextField txtOwn;
	
	/** The lbl displaying item One. */
	private JLabel itemPicOne;
	
	/** The lbl displaying item Two. */
	private JLabel itemPicTwo;
	
	/** The lbl displaying item Three. */
	private JLabel itemPicThree;
	
	/** The lbl displaying item Four. */
	private JLabel itemPicFour;
	
	/** The players current gold. */
	private JTextField txtCurrentGold;


	/**
	 * Create the application. Initializes the frame of the window and sets visible
	 *
	 * @param ofcPlayer the official player of the game
	 * 
	 */
	public BuyItem(Player ofcPlayer) {
		player = ofcPlayer;
		initialize();
		frmBuyItem.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 * 
	 * itemOnePic sourced from: https://findicons.com/icon/32883/potion
	 * itemTwoPic sourced from: https://findicons.com/icon/32883/potion_2
	 * itemThreePic sourced from: https://findicons.com/icon/211681/heart
	 * itemFourPic sourced from: https://findicons.com/icon/185381/dialog_question
	 * 
	 */
	private void initialize() {
		
		frmBuyItem = new JFrame();
		frmBuyItem.setBounds(100, 100, 650, 450);
		frmBuyItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyItem.getContentPane().setLayout(null);
		
		txtShopBuyingItems = new JTextField();
		txtShopBuyingItems.setEditable(false);
		txtShopBuyingItems.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		txtShopBuyingItems.setText("Shop Items:");
		txtShopBuyingItems.setBounds(204, 19, 165, 32);
		frmBuyItem.getContentPane().add(txtShopBuyingItems);
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
		frmBuyItem.getContentPane().add(rdbtnAttackPotion);
		
		JRadioButton rdbtnHealingPotion = new JRadioButton("Magic Healing Potion");
		rdbtnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 2;
				displayItem("Heal");
			}
		});
		buttonGroup.add(rdbtnHealingPotion);
		rdbtnHealingPotion.setBounds(204, 200, 165, 23);
		frmBuyItem.getContentPane().add(rdbtnHealingPotion);
		
		JRadioButton rdbtnExtraLife = new JRadioButton("Extra Life");
		rdbtnExtraLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 3;
				displayItem("Life");
			}
		});
		buttonGroup.add(rdbtnExtraLife);
		rdbtnExtraLife.setBounds(55, 377, 120, 23);
		frmBuyItem.getContentPane().add(rdbtnExtraLife);
		
		JRadioButton rbtnLuckyDip = new JRadioButton("Lucky Dip");
		rbtnLuckyDip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlySelected = 4;
				displayItem("Lucky");
			}
		});
		buttonGroup.add(rbtnLuckyDip);
		rbtnLuckyDip.setBounds(228, 377, 141, 23);
		frmBuyItem.getContentPane().add(rbtnLuckyDip);
		
		JButton btnBuyItem = new JButton("Buy Selected Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buySelectedItem();
			}
		});
		btnBuyItem.setBounds(395, 302, 209, 29);
		frmBuyItem.getContentPane().add(btnBuyItem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Selected Item:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(381, 69, 240, 221);
		frmBuyItem.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		txtName.setText("Name: ");
		txtName.setBounds(6, 28, 228, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtProperty = new JTextField();
		txtProperty.setHorizontalAlignment(SwingConstants.CENTER);
		txtProperty.setEditable(false);
		txtProperty.setText("Affects: ");
		txtProperty.setBounds(6, 66, 228, 26);
		panel.add(txtProperty);
		txtProperty.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setEditable(false);
		txtAmount.setText("Amount: ");
		txtAmount.setBounds(6, 104, 228, 26);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setEditable(false);
		txtCost.setText("Cost : ");
		txtCost.setBounds(6, 142, 228, 26);
		panel.add(txtCost);
		txtCost.setColumns(10);
		
		txtOwn = new JTextField();
		txtOwn.setHorizontalAlignment(SwingConstants.CENTER);
		txtOwn.setEditable(false);
		txtOwn.setText("Own: ");
		txtOwn.setBounds(6, 180, 228, 26);
		panel.add(txtOwn);
		txtOwn.setColumns(10);
		
		itemPicOne = new JLabel("");
		itemPicOne.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion.png")));
		itemPicOne.setBounds(42, 60, 120, 139);
		frmBuyItem.getContentPane().add(itemPicOne);
		
		itemPicTwo = new JLabel("");
		itemPicTwo.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion_2.png")));
		itemPicTwo.setBounds(222, 67, 141, 128);
		frmBuyItem.getContentPane().add(itemPicTwo);
		
		itemPicThree = new JLabel("");
		itemPicThree.setIcon(new ImageIcon(BuyItem.class.getResource("/images/heart.png")));
		itemPicThree.setBounds(45, 211, 147, 164);
		frmBuyItem.getContentPane().add(itemPicThree);
		
		itemPicFour = new JLabel("");
		itemPicFour.setIcon(new ImageIcon(BuyItem.class.getResource("/images/dialog_question.png")));
		itemPicFour.setBounds(236, 226, 141, 139);
		frmBuyItem.getContentPane().add(itemPicFour);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(399, 353, 209, 26);
		frmBuyItem.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		JButton btnExit = new JButton("Exit Shop");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuyItem.dispose();
			}
		});
		btnExit.setBounds(491, 23, 117, 29);
		frmBuyItem.getContentPane().add(btnExit);
	}
	
	
	/**
	 * Display item. Displays the name, property, property change, cost, and the number already owned of an item.
	 *
	 * @param item the item that needs to be displayed
	 */
	public void displayItem(String item) {
		if (item.equals("Attack")) {
			txtName.setText("Magic Attack Potion");
			txtProperty.setText("Changes Monster's Attack");
			txtAmount.setText("Increases by 15 units");
			txtCost.setText("Costs 60 gold");
			int num = player.getNumItems("Magic Attack Potion");
			txtOwn.setText("You already own " + num);
			
		}else if (item.equals("Heal")) {
			txtName.setText("Magic Heal Potion");
			txtProperty.setText("Changes Monster's Heal Amount");
			txtAmount.setText("Increases by 10 units");
			txtCost.setText("Costs 45 gold");
			int num = player.getNumItems("Magic Healing Potion");
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
			txtOwn.setText("");
		}
		
	}
	
	
	/**
	 * Buy selected item. Takes the 'currently Selected' variable and creates the item it represents
	 * the player then buys the Item by calling the buy method.
	 * 
	 */
	public void buySelectedItem() {
		if (currentlySelected == 1) {
			Item attackPotion = new Item("Magic Attack Potion" , "damage", 15, 3, 60);
			buy(attackPotion);
			displayItem("Attack");
		} else if (currentlySelected == 2) {
			Item healingPotion = new Item("Magic Healing Potion" , "heal amount" , 10, 3, 45);
			buy(healingPotion);
			displayItem("Heal");
		} else if (currentlySelected == 3) {
			Item extraLife = new Item("Extra Life", "lives", 1, 1, 70);
			buy(extraLife);
			displayItem("Life");
		} else if (currentlySelected == 4){
			Item luckyDip = new Item("Lucky Dip", "unknown", 0, 1, 44);
			buy(luckyDip);
		} else {
			JOptionPane.showMessageDialog(frmBuyItem, "Please select the Item you wish to purchase.");
		}
	}
	
	/**
	 * Buy. Makes the player purchase the currently selected item, checking if they have enough gold.
	 * If the player has selected the lucky dip, another item is randomly selected and added to
	 * the players inventory.
	 *
	 * @param purchasedItem the purchased item
	 */
	public void buy(Item purchasedItem) {
		
		if(player.getgold() < purchasedItem.getPurchasePrice()) {
			JOptionPane.showMessageDialog(frmBuyItem, "You do not have enough gold to purchase this Item. You can earn more gold by battling!");
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
			JOptionPane.showMessageDialog(frmBuyItem, "You have successfully bought " + purchasedItem.getName());
			frmBuyItem.dispose();
	}
		
	}
}
