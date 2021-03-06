package GUI;

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


/**
 * The Class SellItem.
 */
public class SellItem {

	/** The player of the game. */
	private Player player;
	
	/** The sell item frame. */
	public JFrame frmSellItem;
	
	/** The txt sell items. */
	private JTextField txtSellItems;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The text displaying the item's name. */
	private JTextField txtName;
	
	/** The text displaying how many of those items the player already owns. */
	private JTextField txtOwn;
	
	/** The text displaying the item's selling price. */
	private JTextField txtSell;
	
	/** The picture of item one. */
	private JLabel lblItemOne;
	
	/** The picture of item two. */
	private JLabel lblItemTwo;
	
	/** The picture of item three. */
	private JLabel lblItemThree;
	
	/** The txt displaying the players' current gold. */
	private JTextField txtCurrentGold;
	
	/** The panel to the side diaplying the information . */
	private JPanel panel;
	
	/** The sell item button. */
	private JButton btnSellItem;
	
	/** The current item. */
	private Item currentItem = null;
	
	/** The return button. */
	private JButton btnReturn;


	/**
	 * Create the application.
	 *
	 * @param ofcPlayer the official player of the game.
	 */
	public SellItem(Player ofcPlayer) {
		
		player = ofcPlayer;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * lblItemOne sourced from: https://findicons.com/icon/32954/potion
	 * lblItemTwo sourced from: https://findicons.com/icon/32954/potion_2
	 * lblItemThree sourced from: https://findicons.com/icon/211681/heart
	 */
	private void initialize() {
		frmSellItem = new JFrame();
		frmSellItem.setBounds(100, 100, 649, 450);
		frmSellItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellItem.getContentPane().setLayout(null);
		
		txtSellItems = new JTextField();
		txtSellItems.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		txtSellItems.setEditable(false);
		txtSellItems.setText("Sell Items:");
		txtSellItems.setBounds(222, 20, 147, 26);
		frmSellItem.getContentPane().add(txtSellItems);
		txtSellItems.setColumns(10);
		
		JRadioButton rdbtnAttackPotion = new JRadioButton("Magic Attack Potion");
		rdbtnAttackPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Attack");
			}
		});
		buttonGroup.add(rdbtnAttackPotion);
		rdbtnAttackPotion.setBounds(24, 200, 168, 23);
		frmSellItem.getContentPane().add(rdbtnAttackPotion);
		
		JRadioButton rdbtnHealingPotion = new JRadioButton("Magic Healing Potion");
		rdbtnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Heal");
			}
		});
		buttonGroup.add(rdbtnHealingPotion);
		rdbtnHealingPotion.setBounds(196, 200, 195, 23);
		frmSellItem.getContentPane().add(rdbtnHealingPotion);
		
		JRadioButton rdbtnExtraLife = new JRadioButton("Extra Life");
		rdbtnExtraLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Life");
			}
		});
		buttonGroup.add(rdbtnExtraLife);
		rdbtnExtraLife.setBounds(137, 375, 120, 23);
		frmSellItem.getContentPane().add(rdbtnExtraLife);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Selected Item:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(399, 69, 209, 221);
		frmSellItem.getContentPane().add(panel);
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
		frmSellItem.getContentPane().add(lblItemOne);
		
		lblItemTwo = new JLabel("");
		lblItemTwo.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion_2.png")));
		lblItemTwo.setBounds(222, 67, 141, 128);
		frmSellItem.getContentPane().add(lblItemTwo);
		
		lblItemThree = new JLabel("");
		lblItemThree.setIcon(new ImageIcon(BuyItem.class.getResource("/images/heart.png")));
		lblItemThree.setBounds(127, 215, 147, 164);
		frmSellItem.getContentPane().add(lblItemThree);
		
		txtCurrentGold = new JTextField("Your current gold: " + player.getgold() + " gold");
		txtCurrentGold.setEditable(false);
		txtCurrentGold.setBounds(399, 353, 209, 26);
		frmSellItem.getContentPane().add(txtCurrentGold);
		txtCurrentGold.setColumns(10);
		
		btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellCurrentItem();
			}
		});
		btnSellItem.setVisible(false);
		btnSellItem.setBounds(446, 302, 117, 29);
		frmSellItem.getContentPane().add(btnSellItem);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSellItem.dispose();
			}
		});
		btnReturn.setBounds(446, 22, 117, 29);
		frmSellItem.getContentPane().add(btnReturn);
		
		
	}
	
	
	/**
	 * Display item. Once an item is selected the displayItem method displays the attributes of the item to the player.
	 *
	 * @param item the item the players wishes to display
	 */
	public void displayItem(String item) {
		int num = 0;
		if (item.equals("Attack")) {
			txtName.setText("Magic Attack Potion");
			num = player.getNumItems("Magic Attack Potion");
			txtOwn.setText("You own " + num);
			if (num > 0) {
				displaySaleItem();
			} else {
				nothingToDisplay();
			}

		}else if (item.equals("Heal")) {
			txtName.setText("Magic Healing Potion");
			num = player.getNumItems("Magic Healing Potion");
			txtOwn.setText("You own " + num);
			if (num > 0) {
				displaySaleItem();
			} else {
				nothingToDisplay();
			}

		}else if (item.equals("Life")) {
			txtName.setText("Extra Life");
			num = player.getNumItems("Extra Life");
			txtOwn.setText("You own " + num);	
			if (num > 0) {
				displaySaleItem();
			} else {
				nothingToDisplay();
			}
			
		}
		
	}
	
	/**
	 * Display sale item.  If the player owns at least one item sort of what they selected, this method finds the most recent occurence of the 
	 * item in the players inventory and gets its sell back price.
	 * The button to sell the item is then displayed.
	 */
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
	
	/**
	 * Nothing to display. Called when the player does not own any occurences of the selected Item.
	 */
	public void nothingToDisplay() {
		currentItem = null;
		txtSell.setVisible(false);
		btnSellItem.setVisible(false);
		
	}
	
	/**
	 * Sell current item. If sell Item button is selected this method is called to remove the item from the players inventory
	 * and increase their gold by the sell back price.
	 */
	public void sellCurrentItem() {
		
		int sellBackPrice = currentItem.getsellbackPrice();
		player.increaseGold(sellBackPrice);
		player.getItems().remove(currentItem);
		currentItem = null;
		frmSellItem.dispose();
		
	}
	
	
	

}
