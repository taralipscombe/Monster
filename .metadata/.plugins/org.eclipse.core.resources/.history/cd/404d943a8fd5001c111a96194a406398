import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectMonster {

	private JFrame frmChooseYourMonster;
	private Monster startingMonster;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMonster window = new SelectMonster();
					window.frmChooseYourMonster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectMonster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChooseYourMonster = new JFrame();
		frmChooseYourMonster.setTitle("Choose your monster");
		frmChooseYourMonster.setBounds(100, 100, 450, 300);
		frmChooseYourMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseYourMonster.getContentPane().setLayout(null);
		
		Monster monsterOptionOne = new Monster("Harry", 33, 20, 53);
		Monster monsterOptionTwo = new Monster("Louis", 45, 4, 49);
		Monster monsterOptionThree = new Monster("Niall", 19, 35, 54);
		Monster monsterOptionFour = new Monster("Liam", 13, 10, 23);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startingMonster = monsterOptionOne;
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(null);
			}
		});
		btnNewButton.setBounds(23, 18, 39, 23);
		frmChooseYourMonster.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startingMonster = monsterOptionTwo;
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(null);
			}
		});
		btnNewButton_1.setBounds(23, 53, 39, 29);
		frmChooseYourMonster.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startingMonster = monsterOptionThree;
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(null);
			}
		});
		btnNewButton_2.setBounds(23, 95, 39, 29);
		frmChooseYourMonster.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startingMonster = monsterOptionFour;
				frmChooseYourMonster.dispose();
				MainScreenWindow.main(null);
			}
		});
		btnNewButton_3.setBounds(17, 142, 45, 35);
		frmChooseYourMonster.getContentPane().add(btnNewButton_3);
		
		String optionOneString = monsterOptionOne.commandLineToString();
		JTextArea optionOneDescription = new JTextArea(optionOneString);
		optionOneDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		optionOneDescription.setBounds(74, 20, 370, 21);
		frmChooseYourMonster.getContentPane().add(optionOneDescription);
		
		String optionTwoString = monsterOptionTwo.commandLineToString();
		JTextArea optionTwoDescription = new JTextArea(optionTwoString);
		optionTwoDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		optionTwoDescription.setBounds(74, 58, 370, 24);
		frmChooseYourMonster.getContentPane().add(optionTwoDescription);
		
		String optionThreeString = monsterOptionThree.commandLineToString();
		JTextArea optionThreeDescription = new JTextArea(optionThreeString);
		optionThreeDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		optionThreeDescription.setBounds(74, 95, 370, 29);
		frmChooseYourMonster.getContentPane().add(optionThreeDescription);
		
		String optionFourString = monsterOptionFour.commandLineToString();
		JTextArea optionFourDescription = new JTextArea(optionFourString);
		optionFourDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		optionFourDescription.setBounds(74, 150, 370, 23);
		frmChooseYourMonster.getContentPane().add(optionFourDescription);
	}
}
