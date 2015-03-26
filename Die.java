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
public class Die
{

	/**
	 * the x location given by the user an used
	 * in drawing the die and all of the components
	 * of it including the dots
	 */
	public final int X_LOCATION;

	/**
	 * the y location given by the user an used
	 * in drawing the die and all of the components
	 * of it including the dots
	 */
	public final int Y_LOCATION;

	/**
	 * Constant SIZE to be used in my drawings
	 */
	public final int SIZE = 100;

	/**
	 * Number will be given by the user, the face
	 *  of the die will be this number
	 */
	public int number;

	/**
	 * This is a constructor that creates an object die
	 * and has x as the x coordinate, y as the y coordinate
	 * and someNumber as the number that will be drawn on the
	 * blank face of the die
	 */
	public Die(int x, int y, int someNumber){
		number = someNumber; //Doing all my assignment statements

		X_LOCATION = x;
		Y_LOCATION = y;

	}

	/**
	 * Accessor method to get the number that is on the
	 * face of the die
	 * @return
	 */
	public int getNumber(){
		return number;
	}




	/**
	 * The following method is a case statement that takes
	 * in as information the number that is given by the user.
	 * It will continue through the switch statement
	 * until it reaches the literal that was given by the user and will
	 * then run the method associate with the case.
	 *
	 */
	public void paint(Graphics pane)
	{

		drawBlank(pane);//Draws the blank die

		if (number >=1 && number <= 6)//Making sure the number is an accurate one
			//FOr one that will be on a die
		{
			//My switch statement that goes through until it reaches the number
			//Entered by the user. If the number isn't one like (1.2) the default
			//Says to restart the program and try again
			switch(number)
			{
			case 1: drawOne(pane); break;
			case 2: drawTwo(pane); break;
			case 3: drawThree(pane); break;
			case 4: drawFour(pane); break;
			case 5: drawFive(pane); break;
			case 6: drawSix(pane); break;
			}

		}
		else
		{
			System.out.print("You didn't enter a correct number!" +
					"It either wasn't an integer, a number on the die" +
					"or not even a number to begin with. " +
					"Please restart the program and try again.");

		}
	}



	/**   The following method draws one dot
	 * on the face of the die.
	 */
	private void drawOne (Graphics pane)
	{
		drawDot(pane, X_LOCATION+SIZE/2, Y_LOCATION+SIZE/2);

	}




	/**   The following method draws two dots
	 * 		on the face of the die.
	 */
	private void drawTwo (Graphics pane)
	{
		drawDot(pane, X_LOCATION+SIZE/5,Y_LOCATION+SIZE/5);
		drawDot(pane, X_LOCATION+SIZE*4/5, Y_LOCATION+SIZE*4/5);

	}




	/**   The following method draws three dots
	 * on the face of the die.
	 */
	private void drawThree (Graphics pane)
	{
		drawOne(pane);
		drawTwo(pane);
	}




	/**   The following method draws four dots
	 * on the face of the die.
	 */
	private void drawFour (Graphics pane)
	{
		drawTwo(pane);
		drawDot(pane, X_LOCATION+SIZE/5,Y_LOCATION+SIZE*4/5);
		drawDot(pane, X_LOCATION+SIZE*4/5,Y_LOCATION+SIZE/5);
	}




	/**   The following method draws five dots
	 *  on the face of the die.
	 */
	private void drawFive (Graphics pane)
	{
		drawOne(pane);
		drawFour(pane);
	}




	/**   The following method draws six dots
	 * the face of the die.
	 */
	private void drawSix (Graphics pane)
	{
		drawFour(pane);
		drawDot(pane, X_LOCATION+SIZE/5, Y_LOCATION+SIZE/2);
		drawDot(pane, X_LOCATION+SIZE*4/5, Y_LOCATION+SIZE/2);
	}





	/**   Draws the "blank" die in a given frame.
	 */
	private void drawBlank (Graphics pane)
	{
		//Draws the face of the die
		pane.drawRect(X_LOCATION, Y_LOCATION, SIZE, SIZE);

		//Draw all subsequent lines
		pane.drawLine(X_LOCATION, Y_LOCATION+SIZE, X_LOCATION-SIZE/2,
				      Y_LOCATION+SIZE/2);

		//To make the die 3D
		pane.drawLine(X_LOCATION, Y_LOCATION, X_LOCATION-SIZE/2,
				      Y_LOCATION-SIZE/2);

		pane.drawLine(X_LOCATION-SIZE/2, Y_LOCATION+SIZE/2, X_LOCATION-SIZE/2,
				      Y_LOCATION-SIZE/2);

		pane.drawLine(X_LOCATION+SIZE, Y_LOCATION,X_LOCATION+SIZE/2,
				      Y_LOCATION-SIZE/2 );

		pane.drawLine(X_LOCATION+SIZE/2, Y_LOCATION-SIZE/2, X_LOCATION-SIZE/2,
				      Y_LOCATION-SIZE/2);
	}

	/**   Draws one dot, centered at given location.
	 */
	private void drawDot (Graphics pane, int x, int y)
	{
		pane.setColor(Color.black);			//Set the color of the dot to
											//appear black
		pane.fillOval(x-5, y-5, 10, 10);	//Filling the dot with black
		pane.drawOval(x-5, y-5, 10, 10);	//Drawing the dot
	}


}
