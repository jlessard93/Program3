/**   
 * AUTHOR: JOSHUA LESSARD
 * CLASS: CSC 211
 * LAB: THURSDAY
 * 
 * 								PROGRAM #3-Playing Dice
 * 					===============================================
 * The following methods draw the right number 
 *        
 */ 

//Importing all necessary libraries 
import java.awt.*;
import java.util.Scanner;


public class Game extends Frame{

	/**
	 * I am creating my two die objects to be use throughout the program
	 */
	private Die myDie, theComputerDie;

	
	/**
	 * The main method which creates a new game environment
	 * @param args
	 */
	public static void main(String[] args){
		new Game();	//Creating out new object in a constructor

	}


	/**
	 * The game method which does all the work in the program and
	 * calls the die class and gets input from the user 
	 * for creating the die
	 * 
	 */
	public Game(){

		//Info from the user through the keyboard
		Scanner keyboard = new Scanner(System.in);

		//Initializing the number entered as zero
		int number = 0;

		//Initializing if the input from the user as false
		boolean goodInput = false;

		setTitle("Program #3 - Playing Dice");    //The title of the program frame
		setSize(500, 500);	   	   //Size of the program frame
		setLocation(350, 350); 	   //Location where the frame will appear
		setBackground(Color.GRAY);//Set the background color to be white


		CloseWindow myWindow = new CloseWindow();//to allow for window closing
		addWindowListener(myWindow);//A must for AWT to close the window
	

		//A method to examine that the input was accurate, if not
		//You will have to try again with your input
		while (!goodInput)
		{

			//Asking user for a number to display on die
			System.out.println("What is the number on the face of the die (an int" +
					           "eger between 1 and 6): ");
			//Assigning what was entered by the user into the variable constant,
			//NUMBER
			number = keyboard.nextInt();

			//The if statement for the test
			if(number >= 1 && number <= 6)
			{
				goodInput = true;
			}
			else
			{
				System.out.println("That is not between 1 and 6, try again.");
			}
		}


		//Asking the user where to display the die
		System.out.println("Enter the location of the die in the format," +
				           " x-coordinate y-coordinate---Ex) 100 100:");
		int x = keyboard.nextInt();//The next number typed will be the X coordinate
		int y = keyboard.nextInt();//The following number will be the Y coordinate

		//Creating my new Die object for my die
		myDie = new Die(x, y, number);

		//Creating the new computer die and setting the
		//number to a random integer between 1 and 6
		//which will be the number drawn on the face of the die
		theComputerDie = new Die((int)(Math.random()*200+300), 
				         (int)(Math.random()*200+300), (int)(Math.random()*6+1));


		// The entire set of if statements to test who wins


		//The first test sees if the sum is an even number
		//But calls the getNumber method to see the number
		//On the die, if it is 0 that is because mod will be
		//0 because it is an even number
		if ((myDie.getNumber() + theComputerDie.getNumber()) % 2 == 0)
		{
			if (myDie.getNumber() > theComputerDie.getNumber())
			{ 

				//This is how to pause before the answer shows up
				try {
					Thread.sleep(1000);//waits 1000 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("You win!!!!");
			}

			else if (theComputerDie.getNumber() > myDie.getNumber())
			{

				//This is how to pause before the answer shows up
				try {
					Thread.sleep(1000);//waits 1000 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("The computer wins!!!");
			}
			else
			{

				//This is how to pause before the answer shows up
				try {
					Thread.sleep(1000);//waits 1000 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("It is a tie!!!");
			}

		}

		//This is the rest of the if statements if the sum of the two numbers are 
		//odd and I use != because it will be anything that isn't 0.
		//Then if the computer die is greater than your number you win
		//Otherwise the computer wins. If your number is less than 
		//The computer number you win otherwise the computer wins
		if ((myDie.getNumber() + theComputerDie.getNumber()) % 2 != 0)
		{
			if (myDie.getNumber() < theComputerDie.getNumber())
			{ 

				//This is how to pause before the answer die shows up
				try {
					Thread.sleep(1000);//waits 1000 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("You win!!!!");

			}
			else
			{
				//This is how to pause before the answer shows up
				try {
					Thread.sleep(1000);//waits 1000 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("The computer wins!!!");
			}
		}

		setVisible(true);	   	   //The frame will be visible
		repaint();

	}

	/**
	 * This is the method to paint the die
	 */
	public void paint(Graphics pane){

		//Paints my die
		myDie.paint(pane);

		//This is how to pause before the computer die shows up
		try {
			Thread.sleep(1000);//waits 1000 ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Then paints the computer die
		theComputerDie.paint(pane);
	}

}
