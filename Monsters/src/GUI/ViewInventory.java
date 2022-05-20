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
import javax.swing.border.TitledBorder;

/**
 * The Class ViewInventory.
 */
public class ViewInventory {

	/** The frame of the class */
	public JFrame frmInventory;
	
	/** The player of the game */
	private Player player;
	
	/** The text of the title, sell items */
	private JTextField txtSellItems;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The txt name of item. */
	private JTextField txtName;
	
	/** The txt of how many items the player owns. */
	private JTextField txtOwn;
	
	/** The lbl of item one. */
	private JLabel lblItemOne;
	
	/** The lbl of item two. */
	private JLabel lblItemTwo;
	
	/** The lbl of item three. */
	private JLabel lblItemThree;
	
	/** The panel. */
	private JPanel panel;
	
	/** The apply item to a monster button. */
	private JButton btnApplyItem;
	
	/** The currently selected item. */
	private Item currentItem = null;
	
	/** The button to return to the mainscreen. */
	private JButton btnReturn;
	
	/** The text of "Effect on Monster:". */
	private JTextField txtEffectOnMonster;
	
	/** The text of the effect of the currently selected item on the monster. */
	private JTextField txtEffect;
	
	/** The text of how much usage of an item is left. */
	private JTextField txtUsageLeft;
	
	/** The second text of the effect of the currently selected item on the monster. */
	private JTextField txtEffectTwo;

	/**
	 * Launch the application.
	 *
	 * @param ofcPlayer the official player of the team
	 */
	public static void main(Player ofcPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInventory window = new ViewInventory(ofcPlayer);
					window.frmInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	 * @param ofcplayer the official player
	 */
	public ViewInventory(Player ofcplayer) {
		player = ofcplayer;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 650, 450);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		
		txtSellItems = new JTextField();
		txtSellItems.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		txtSellItems.setEditable(false);
		txtSellItems.setText("View Inventory:");
		txtSellItems.setBounds(197, 20, 157, 26);
		frmInventory.getContentPane().add(txtSellItems);
		txtSellItems.setColumns(10);
		
		JRadioButton rdbtnAttackPotion = new JRadioButton("Magic Attack Potion");
		rdbtnAttackPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Magic Attack Potion");
			}
		});
		buttonGroup.add(rdbtnAttackPotion);
		rdbtnAttackPotion.setBounds(24, 200, 168, 23);
		frmInventory.getContentPane().add(rdbtnAttackPotion);
		
		JRadioButton rdbtnHealingPotion = new JRadioButton("Magic Healing Potion");
		rdbtnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Magic Healing Potion");
			}
		});
		buttonGroup.add(rdbtnHealingPotion);
		rdbtnHealingPotion.setBounds(204, 200, 165, 23);
		frmInventory.getContentPane().add(rdbtnHealingPotion);
		
		JRadioButton rdbtnExtraLife = new JRadioButton("Extra Life");
		rdbtnExtraLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItem("Extra Life");
			}
		});
		buttonGroup.add(rdbtnExtraLife);
		rdbtnExtraLife.setBounds(139, 377, 120, 23);
		frmInventory.getContentPane().add(rdbtnExtraLife);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Selected Item:", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(381, 117, 250, 207);
		frmInventory.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		txtName.setText("Name: ");
		txtName.setBounds(6, 21, 238, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtOwn = new JTextField();
		txtOwn.setHorizontalAlignment(SwingConstants.CENTER);
		txtOwn.setEditable(false);
		txtOwn.setText("You Own: ");
		txtOwn.setBounds(6, 51, 238, 26);
		panel.add(txtOwn);
		txtOwn.setColumns(10);
		
		txtEffectOnMonster = new JTextField();
		txtEffectOnMonster.setEditable(false);
		txtEffectOnMonster.setHorizontalAlignment(SwingConstants.CENTER);
		txtEffectOnMonster.setText("Effect on Monster:");
		txtEffectOnMonster.setBounds(6, 113, 238, 26);
		panel.add(txtEffectOnMonster);
		txtEffectOnMonster.setColumns(10);
		
		txtEffect = new JTextField();
		txtEffect.setHorizontalAlignment(SwingConstants.CENTER);
		txtEffect.setEditable(false);
		txtEffect.setBounds(6, 142, 238, 26);
		panel.add(txtEffect);
		txtEffect.setColumns(10);
		
		txtUsageLeft = new JTextField();
		txtUsageLeft.setText("Usage:");
		txtUsageLeft.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsageLeft.setEditable(false);
		txtUsageLeft.setColumns(10);
		txtUsageLeft.setBounds(6, 83, 238, 26);
		panel.add(txtUsageLeft);
		
		txtEffectTwo = new JTextField();
		txtEffectTwo.setHorizontalAlignment(SwingConstants.CENTER);
		txtEffectTwo.setEditable(false);
		txtEffectTwo.setColumns(10);
		txtEffectTwo.setBounds(6, 173, 238, 26);
		panel.add(txtEffectTwo);
		
		lblItemOne = new JLabel("");
		lblItemOne.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion.png")));
		lblItemOne.setBounds(42, 60, 120, 139);
		frmInventory.getContentPane().add(lblItemOne);
		
		lblItemTwo = new JLabel("");
		lblItemTwo.setIcon(new ImageIcon(BuyItem.class.getResource("/images/potion_2.png")));
		lblItemTwo.setBounds(222, 67, 141, 128);
		frmInventory.getContentPane().add(lblItemTwo);
		
		lblItemThree = new JLabel("");
		lblItemThree.setIcon(new ImageIcon(BuyItem.class.getResource("/images/heart.png")));
		lblItemThree.setBounds(129, 211, 147, 164);
		frmInventory.getContentPane().add(lblItemThree);
		
		btnApplyItem = new JButton("Apply Item to a Monster:");
		btnApplyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyCurrentItem();
			}
		});
		btnApplyItem.setVisible(false);
		btnApplyItem.setBounds(411, 346, 188, 29);
		frmInventory.getContentPane().add(btnApplyItem);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInventory.dispose();
			}
		});
		btnReturn.setBounds(484, 22, 117, 29);
		frmInventory.getContentPane().add(btnReturn);
		
		
	}
	
	
	/**
	 * Display item. Display the attributes of the currently selected item.
	 *
	 * @param item the currently selected item
	 */
	public void displayItem(String item) {
		int num = 0;
		if (item.equals("Magic Attack Potion")) {
			txtName.setText("Magic Attack Potion");
			num = player.getNumItems("Magic Attack Potion");
			txtOwn.setText("You own " + num);
			txtEffect.setText("Increases Monsters' Damage");
			txtEffectTwo.setText("by 15 units");
			if (num > 0) {
				displayButton();
			} else {
				nothingToDisplay();
			}

		}else if (item.equals("Magic Healing Potion")) {
			txtName.setText("Magic Healing Potion");
			num = player.getNumItems("Magic Healing Potion");
			txtOwn.setText("You own " + num);
			txtEffect.setText("Increases Monsters' Heal");
			txtEffectTwo.setText("Amount by 10 units");
			if (num > 0) {
				displayButton();
			} else {
				nothingToDisplay();
			}

		}else if (item.equals("Extra Life")) {
			txtName.setText("Extra Life");
			num = player.getNumItems("Extra Life");
			txtOwn.setText("You own " + num);	
			txtEffect.setText("Increases Monsters'");
			txtEffectTwo.setText("Lives by one life");
			if (num > 0) {
				displayButton();
			} else {
				nothingToDisplay();
			}
			
		} 
		
	}
	
	
	/**
	 * Gets the latest item.
	 *
	 * sets current item as the most recent selected item 
	 */
	public void getLatestItem() {
		
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
	}
	
	/**
	 * Display button.
	 */
	public void displayButton() {
		getLatestItem();
		txtUsageLeft.setText("Uses left: " + currentItem.getUsage());
		btnApplyItem.setVisible(true);
	}
	
	/**
	 * Nothing to display.
	 */
	public void nothingToDisplay() {
		currentItem = null;
		txtUsageLeft.setText("Uses left: ");
		btnApplyItem.setVisible(false);
		
	}
	
	/**
	 * Apply current item.
	 */
	public void applyCurrentItem() {
		
		ApplyingItemWindow applying = new ApplyingItemWindow(player, currentItem);
		applying.frmApplyingItem.setVisible(true);
		buttonGroup.clearSelection();
		btnApplyItem.setVisible(false);
		String item = currentItem.getName();
		displayItem(item);

	}
	
	
	

}
