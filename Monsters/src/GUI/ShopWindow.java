package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * ShopWindow The class that generates the Shop Window
 *
 */
public class ShopWindow {
	
	/** player Player of game*/
	private Player player;
	
	/** frmShop window shop view*/
	public JFrame frmShop;
	
	/** btnBuy Buy button*/
	private JButton btnBuy;
	
	/** btnSell sell button*/
	private JButton btnSell;
	
	/** btnExitShop button to go back to MainScreen*/
	private JButton btnExitShop;
	
	/** btnBuyItem button to buy an item*/
	private JButton btnBuyItem;
	
	/** btnBuyMonster button to buy a monster*/
	private JButton btnBuyMonster;
	
	/** btnSellItem button for selling an item*/
	private JButton btnSellItem;
	
	/** btnSellMonster sell monster button*/
	private JButton btnSellMonster;


	/**
	 * Create the application.
	 * @param ofcPlayer player of the game
	 */
	public ShopWindow(Player ofcPlayer) {
		player = ofcPlayer;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShop = new JFrame();
		frmShop.setTitle("Shop");
		frmShop.setBounds(100, 100, 700, 450);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShop.getContentPane().setLayout(null);
		
		JTextField txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setEditable(false);
		txtWelcomeToThe.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		txtWelcomeToThe.setText("Welcome to the Shop!");
		txtWelcomeToThe.setBounds(200, 28, 293, 26);
		frmShop.getContentPane().add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		JTextField txtWouldYouLike = new JTextField();
		txtWouldYouLike.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtWouldYouLike.setEditable(false);
		txtWouldYouLike.setText("Would you like to Buy or Sell?");
		txtWouldYouLike.setBounds(230, 81, 234, 26);
		frmShop.getContentPane().add(txtWouldYouLike);
		txtWouldYouLike.setColumns(10);
		
		btnBuy = new JButton("Buy!");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyButtonSelected();
				
			}
		});
		btnBuy.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBuy.setBounds(169, 148, 117, 29);
		frmShop.getContentPane().add(btnBuy);
		
		btnSell = new JButton("Sell!");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellButtonSelected();
			}
		});
		btnSell.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSell.setBounds(361, 148, 117, 29);
		frmShop.getContentPane().add(btnSell);
		
		btnExitShop = new JButton("Exit Shop");
		btnExitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmShop.dispose();
			}
		});
		btnExitShop.setBounds(35, 371, 117, 29);
		frmShop.getContentPane().add(btnExitShop);
		
		btnBuyItem = new JButton("Buy Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmShop.dispose();
				BuyItem buyingItem = new BuyItem(player);
				buyingItem.frmBuyItem.setVisible(true);

			}
		});
		btnBuyItem.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBuyItem.setVisible(false);
		btnBuyItem.setBounds(62, 239, 124, 29);
		frmShop.getContentPane().add(btnBuyItem);
		
		btnBuyMonster = new JButton("Buy Monster");
		btnBuyMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyMonster buyingMonster = new BuyMonster(player);
				buyingMonster.frmBuyMonster.setVisible(true);
			}
		});
		btnBuyMonster.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBuyMonster.setVisible(false);
		
		btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellItem sellingItem = new SellItem(player);
				sellingItem.frmSellItem.setVisible(true);
			}
		});
		btnSellItem.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSellItem.setVisible(false);
		btnSellItem.setBounds(277, 241, 117, 29);
		frmShop.getContentPane().add(btnSellItem);
		btnBuyMonster.setBounds(243, 239, 151, 29);
		frmShop.getContentPane().add(btnBuyMonster);
		
		btnSellMonster = new JButton("Sell Monster");
		btnSellMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellMonster sellingMonster = new SellMonster(player);
				sellingMonster.frmSellMonster.setVisible(true);
			}
		});
		btnSellMonster.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSellMonster.setVisible(false);
		btnSellMonster.setBounds(454, 241, 151, 29);
		frmShop.getContentPane().add(btnSellMonster);
		
		
	}
	/** buyButtonSelected method for when buy button is pushed, sets buy item and monster buttons to visible, the others to not visible*/
	public void buyButtonSelected() {
		btnSellItem.setVisible(false);
		btnSellMonster.setVisible(false);
		btnBuyItem.setVisible(true);
		btnBuyMonster.setVisible(true);
		
	}
	/** sellButtonSelected method for when sell button is pushed, sets sell item and monster buttons to visible, the others to not visible*/
	public void sellButtonSelected() {
		btnBuyItem.setVisible(false);
		btnBuyMonster.setVisible(false);
		btnSellItem.setVisible(true);
		btnSellMonster.setVisible(true);

	}
	
	
	
}
