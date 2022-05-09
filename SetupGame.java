import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SetupGame {

	private JFrame frmSetUpGame;
	private JTextField textField;
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
		frmSetUpGame.setBounds(100, 100, 429, 510);
		frmSetUpGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetUpGame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToMonster = new JTextArea();
		txtrWelcomeToMonster.setText("Welcome to Monster Battles!");
		txtrWelcomeToMonster.setBounds(26, 29, 186, 16);
		frmSetUpGame.getContentPane().add(txtrWelcomeToMonster);
		
		JTextArea txtrInputName = new JTextArea();
		txtrInputName.setText("Input name:");
		txtrInputName.setBounds(50, 73, 98, 16);
		frmSetUpGame.getContentPane().add(txtrInputName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputName = textField.getText();
			}
		});
		textField.setBounds(157, 68, 130, 26);
		frmSetUpGame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrHowManyDays = new JTextArea();
		txtrHowManyDays.setText("How many days do you want to play?");
		txtrHowManyDays.setBounds(101, 101, 239, 16);
		frmSetUpGame.getContentPane().add(txtrHowManyDays);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gameTime = slider.getValue();
			}
		});
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setBounds(59, 129, 330, 39);
		frmSetUpGame.getContentPane().add(slider);
		
		JTextArea txtrChooseDifficulty = new JTextArea();
		txtrChooseDifficulty.setText("Choose difficulty");
		txtrChooseDifficulty.setBounds(157, 249, 119, 16);
		frmSetUpGame.getContentPane().add(txtrChooseDifficulty);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "Easy";
				
			}
		});
		btnNewButton.setBounds(26, 304, 117, 29);
		frmSetUpGame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Medium");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "Medium";
			}
		});
		btnNewButton_1.setBounds(157, 304, 117, 29);
		frmSetUpGame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hard");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = "Hard";
			}
		});
		btnNewButton_2.setBounds(287, 304, 117, 29);
		frmSetUpGame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Continue");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(gameDifficulty == null || inputName == null) {
					JOptionPane.showMessageDialog(frmSetUpGame, "Please enter a name and choose a difficulty");
				}
				if(inputName.length()>3 && inputName.length()<15) {
					if(validName() == true) {
						name = inputName;
					}
					} else {
						JOptionPane.showMessageDialog(frmSetUpGame, "Please enter a valid name between 3-15 letters");
					}
				//continue
			}
		});
		btnNewButton_3.setBounds(159, 401, 117, 29);
		frmSetUpGame.getContentPane().add(btnNewButton_3);
	}
}
