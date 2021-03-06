package GUI;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

/**
 * 
 * class SetUpGame Initializes the battle monster fighting game 
 *
 */
public class SetupGame {

	/** The set up game frame. */
	private JFrame frmSetUpGame;
	
	/** The name field. */
	private JTextField nameField;
	
	/** The players name, game difficulty, and inputed name. */
	private String name, gameDifficulty, inputName;
	
	/** The game time. */
	private int gameTime;
	
	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/** The choose easy button. */
	private JButton chooseEasy;
	
	/** The choose medium button. */
	private JButton chooseMedium;
	
	/** The choose hard button. */
	private JButton chooseHard;

	/**
	 * Launch the application.
	 * 
	 * @param args The empty parameter for the main method
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupGame window = new SetupGame();
					window.frmSetUpGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupGame() {
		initialize();
	}

	/**
	 * Checks if the name is Valid
	 *
	 * @return true, if successful
	 */
	public boolean validName() {
	    return inputName.matches("[a-zA-Z]+");
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return gameDifficulty;
	}
	
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public int getTime() {
		return gameTime;
	}
	
	/**
	 * Initialize the contents of the window
	 * 
	 */
	private void initialize() {
		frmSetUpGame = new JFrame();
		frmSetUpGame.setTitle("Set up Game");
		frmSetUpGame.setBounds(100, 100, 661, 366);
		frmSetUpGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetUpGame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToMonster = new JTextArea();
		txtrWelcomeToMonster.setForeground(new Color(255, 255, 255));
		txtrWelcomeToMonster.setEditable(false);
		txtrWelcomeToMonster.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		txtrWelcomeToMonster.setText("Welcome to Monster Battles!");
		txtrWelcomeToMonster.setOpaque(false);
		txtrWelcomeToMonster.setBounds(96, 22, 491, 40);
		frmSetUpGame.getContentPane().add(txtrWelcomeToMonster);
		
		JTextArea txtrInputName = new JTextArea();
		txtrInputName.setForeground(new Color(255, 255, 255));
		txtrInputName.setEditable(false);
		txtrInputName.setFont(new Font("Dialog", Font.BOLD, 18));
		txtrInputName.setOpaque(false);
		txtrInputName.setText("Input name:");
		txtrInputName.setBounds(195, 74, 126, 29);
		frmSetUpGame.getContentPane().add(txtrInputName);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		nameField.setForeground(new Color(0, 0, 0));
		nameField.setBounds(333, 74, 159, 26);
		frmSetUpGame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JTextArea txtrHowManyDays = new JTextArea();
		txtrHowManyDays.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		txtrHowManyDays.setForeground(new Color(255, 255, 255));
		txtrHowManyDays.setEditable(false);
		txtrHowManyDays.setText("How many days do you want to play?");
		txtrHowManyDays.setOpaque(false);
		txtrHowManyDays.setBounds(132, 115, 387, 29);
		frmSetUpGame.getContentPane().add(txtrHowManyDays);
		
		JSlider daysSlider = new JSlider();
		daysSlider.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		daysSlider.setBackground(new Color(255, 255, 255));
		daysSlider.setForeground(Color.BLUE);
		daysSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gameTime = daysSlider.getValue();
			}
		});
		daysSlider.setMinorTickSpacing(1);
		daysSlider.setMajorTickSpacing(1);
		daysSlider.setMinimum(5);
		daysSlider.setMaximum(15);
		daysSlider.setPaintLabels(true);
		daysSlider.setPaintTicks(true);
		daysSlider.setSnapToTicks(true);
		daysSlider.setBounds(161, 145, 330, 39);
		frmSetUpGame.getContentPane().add(daysSlider);
		
		JTextArea txtrChooseDifficulty = new JTextArea();
		txtrChooseDifficulty.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		txtrChooseDifficulty.setForeground(new Color(255, 255, 255));
		txtrChooseDifficulty.setEditable(false);
		txtrChooseDifficulty.setText("Choose difficulty:");
		txtrChooseDifficulty.setOpaque(false);
		txtrChooseDifficulty.setBounds(232, 204, 169, 22);
		frmSetUpGame.getContentPane().add(txtrChooseDifficulty);
		
		chooseEasy = new JButton("Easy");
		chooseEasy.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Border buttonBorder = chooseEasy.getBorder();
		buttonGroup.add(chooseEasy);
		chooseEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseEasy.setBorder(BorderFactory.createLoweredBevelBorder());
				chooseEasy.setForeground(Color.WHITE);
				chooseMedium.setBorder(buttonBorder);
				chooseMedium.setForeground(Color.BLACK);
				chooseHard.setBorder(buttonBorder);
				chooseHard.setForeground(Color.BLACK);
				gameDifficulty = "1";
				
			}
		});
		chooseEasy.setBounds(132, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseEasy);
		
		chooseMedium = new JButton("Medium");
		chooseMedium.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		buttonGroup.add(chooseMedium);
		chooseMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseMedium.setBorder(BorderFactory.createLoweredBevelBorder());
				chooseMedium.setForeground(Color.WHITE);
				chooseEasy.setBorder(buttonBorder);
				chooseEasy.setForeground(Color.BLACK);
				chooseHard.setBorder(buttonBorder);
				chooseHard.setForeground(Color.BLACK);
				gameDifficulty = "2";
			}
		});
		chooseMedium.setBounds(261, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseMedium);
		
		chooseHard = new JButton("Hard");
		chooseHard.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		buttonGroup.add(chooseHard);
		chooseHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseHard.setBorder(BorderFactory.createLoweredBevelBorder());
				chooseHard.setForeground(Color.WHITE);
				chooseEasy.setBorder(buttonBorder);
				chooseEasy.setForeground(Color.BLACK);
				chooseMedium.setBorder(buttonBorder);
				chooseMedium.setForeground(Color.BLACK);
				gameDifficulty = "3";
			}
		});
		chooseHard.setBounds(390, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseHard);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputName = nameField.getText();
				if(gameDifficulty == null && inputName.length()==0 ) {
					JOptionPane.showMessageDialog(frmSetUpGame, "Please enter a name and choose a difficulty");
				} else if (inputName.length() == 0) {
					JOptionPane.showMessageDialog(frmSetUpGame, "Please enter a name");
				} else if (gameDifficulty == null) {
					JOptionPane.showMessageDialog(frmSetUpGame, "Please choose a difficulty");
				} else {
					Pattern pattern = Pattern.compile("[^a-zA-Z]");
					Matcher matcher = pattern.matcher(inputName);
					boolean correctName = matcher.find();
					if(correctName || inputName.length()<3 ||inputName.length()>15) {
						JOptionPane.showMessageDialog(frmSetUpGame,"Error: Please enter a valid name between 3-15 letters");			
						} else {
							name = inputName;
							SelectMonster selectMonster = new SelectMonster(name, gameTime, gameDifficulty);
							selectMonster.frmChooseYourMonster.setVisible(true);
							frmSetUpGame.dispose();
						}
				}
				
			}
		});
		continueButton.setBounds(261, 285, 117, 29);
		frmSetUpGame.getContentPane().add(continueButton);
		
		/** Sourced from https://www.deviantart.com/nj365/art/mobile-games-background7-434726397 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(SetupGame.class.getResource("/images/back.jpg")));
		lblNewLabel.setBounds(0, 0, 659, 409);
		frmSetUpGame.getContentPane().add(lblNewLabel);
	}
	
	
	
}

