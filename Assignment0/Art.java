import java.awt.Color;
import aLibrary.*;

/**
 * A simple "abstract art" class using the aLibrary.
 * 
 * Mike Truong
 * CSC142, 4/7/2010, Assignment0 
 */

public class Art
{
    /**
     * attributes of the Art class
     * also called instance variables
     */
private    AWindow picture;
private    ARectangle rectOne, rectTwo;
private    AOval ovalOne;
private    ALine lineOne;
private    ALabel labelOne;

    /**
     * A constructor that creates a blank AWindow to draw in
     */
    public Art(){
        picture = new AWindow(10,10,300, 400);  // create window
        
       }

    /**
     * A method to create and display the abstract art
     */

    public void displayArt()
    {
         // creates a default rectangle
        rectOne = new ARectangle(100,100, 90, 90);
        rectOne.place(picture);
        rectOne.repaint();
        
        // creates a second rectangle
        rectTwo = new ARectangle(113, 113, 65, 65);
        rectTwo.setColor(Color.green);
        rectTwo.place(picture);
        rectTwo.repaint();
       
        //creates another line
        lineOne = new ALine(100, 100, 189, 189);
        lineOne.setColor(Color.red);
        lineOne.place(picture);
        lineOne.repaint();
        
        //creates a oval
        ovalOne = new AOval(100, 100, 90, 90);
        ovalOne.setColor(Color.blue);
        ovalOne.place(picture);
        ovalOne.repaint();
        
        // put a text message at the bottom
        labelOne = new ALabel(10, 300, 200, 50);
        labelOne.setText("Milkshapes.");
        labelOne.setFontSize(14);
        labelOne.place(picture);
        labelOne.repaint();

      
    }
}

