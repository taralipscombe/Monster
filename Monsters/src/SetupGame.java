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
import java.awt.Font;

public class SetupGame {

	private JFrame frmSetUpGame;
	private JTextField nameField;
	private String name, gameDifficulty, inputName;
	private int gameTime;

	/**
	 * Launch the application.
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
	 * Initialize the contents of the frame.
	 */
	public boolean validName() {
	    return inputName.matches("[a-zA-Z]+");
	}
	public String getName() {
		return name;
	}
	public String getDifficulty() {
		return gameDifficulty;
	}
	public int getTime() {
		return gameTime;
	}
	
	private void initialize() {
		frmSetUpGame = new JFrame();
		frmSetUpGame.setTitle("Set up Game");
		frmSetUpGame.setBounds(100, 100, 661, 366);
		frmSetUpGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetUpGame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToMonster = new JTextArea();
		txtrWelcomeToMonster.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		txtrWelcomeToMonster.setText("Welcome to Monster Battles!");
		txtrWelcomeToMonster.setBounds(197, 12, 268, 16);
		frmSetUpGame.getContentPane().add(txtrWelcomeToMonster);
		
		JTextArea txtrInputName = new JTextArea();
		txtrInputName.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrInputName.setText("Input name:");
		txtrInputName.setBounds(225, 58, 98, 16);
		frmSetUpGame.getContentPane().add(txtrInputName);
		
		nameField = new JTextField();
		nameField.setBounds(335, 53, 130, 26);
		frmSetUpGame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JTextArea txtrHowManyDays = new JTextArea();
		txtrHowManyDays.setText("How many days do you want to play?");
		txtrHowManyDays.setBounds(214, 116, 239, 16);
		frmSetUpGame.getContentPane().add(txtrHowManyDays);
		
		JSlider daysSlider = new JSlider();
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
		daysSlider.setBounds(171, 135, 330, 39);
		frmSetUpGame.getContentPane().add(daysSlider);
		
		JTextArea txtrChooseDifficulty = new JTextArea();
		txtrChooseDifficulty.setText("Choose difficulty");
		txtrChooseDifficulty.setBounds(295, 216, 119, 16);
		frmSetUpGame.getContentPane().add(txtrChooseDifficulty);
		
		JButton chooseEasy = new JButton("Easy");
		chooseEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "1";
				
			}
		});
		chooseEasy.setBounds(146, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseEasy);
		
		JButton chooseMedium = new JButton("Medium");
		chooseMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "2";
			}
		});
		chooseMedium.setBounds(275, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseMedium);
		
		JButton chooseHard = new JButton("Hard");
		chooseHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "3";
			}
		});
		chooseHard.setBounds(404, 244, 117, 29);
		frmSetUpGame.getContentPane().add(chooseHard);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputName = nameField.getText();
				if(gameDifficulty == null || inputName.length()==0 ) {
					JOptionPane.showMessageDialog(frmSetUpGame, "Please enter a name and choose a difficulty");
				}
				Pattern pattern = Pattern.compile("[^a-zA-Z]");
				Matcher matcher = pattern.matcher(inputName);
				boolean correctName = matcher.find();
				if(correctName || inputName.length()<3 ||inputName.length()>15) {
					JOptionPane.showMessageDialog(null,"Error: Please enter a valid name between 3-15 letters");			
					} else {
						name = inputName;
						frmSetUpGame.dispose();
						SelectMonster.main(name, gameTime, gameDifficulty);
					}
				
			}
		});
		continueButton.setBounds(285, 285, 117, 29);
		frmSetUpGame.getContentPane().add(continueButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(SetupGame.class.getResource("/images/back.jpg")));
		lblNewLabel.setBounds(0, 0, 659, 409);
		frmSetUpGame.getContentPane().add(lblNewLabel);
	}
}

