import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class GameLogic {
	public static String playerName=null;
	public static int numDays=0;
	
	static void setName(Scanner input) {
		while (playerName == null) {
			System.out.println("Please enter a valid name:");
			String name = input.nextLine();
			Pattern pattern = Pattern.compile("[^a-zA-Z]");
			Matcher matcher = pattern.matcher(name);
			boolean correctName = matcher.find();
			if(correctName || name.length()<3 ||name.length()>15) {
				System.out.println("Please enter a valid name between 3-15 letters");			
				} else {
					playerName = name;
					
				}
		}
	}
	static void setNumDays(Scanner input) {
		while (numDays == 0) {
			System.out.println("How many days do you want to play? (between 5 and 15)");
			String num = input.nextLine();
			Pattern pattern = Pattern.compile("[^0-9]");
			Matcher matcher = pattern.matcher(num);
			boolean correctNum = matcher.find();
			if(correctNum || Integer.parseInt(num) >15 || Integer.parseInt(num)<5) {
				System.out.println("Please enter a number between 5 and 15");			
				} else {
					numDays = Integer.parseInt(num);
					System.out.println(numDays);
					
				}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Monster Game");
		setName(input);
		setNumDays(input);
		
		
	}

}
