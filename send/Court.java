import aLibrary.*;
import java.awt.Color;
/**
 * The Court class provides:<ul>
 * <li>a window to contain the other graphics objects</p>
 * <li>3 buttons that send messages to the graphics objects</p>
 * <li>2 Round Rectangles that will be manipulated by user input through the buttons</p></ul>
 * @author  Amine Allaouchiche
 * @version CSC 142 SPRNG 2010
 */
public class Court extends A3ButtonHandler
{
    /** the window that contains buttons and graphics objects */
    private A3ButtonWindow window;
    /** the two car objects */
    private Car carA, carB;
    /** the bottom line y coordinate */
    public final int BOTTOM_LINE = 425;  // delares and gives the value off the bottom line

    /**
     * Constructor for objects of class Court that  does the following things:
     * <ul><li> instantiate the window</li>
     * <li>instantiate two cars of different colors - only one of them should be the selected car</li>
     * <li>initialize the text on the 3 buttons</li>
     * <li>repaint the window</li></ul>
     */
    public Court()
    {
        window = new A3ButtonWindow( this );
        carA = new Car( 0, 0, Color.blue, true, window, this );
        carB = new Car( 100, 100, Color.red, false, window, this );
        
        window.setLeftText( "Select Car ");
        window.setMidText( "Right");
        window.setRightText( "Move Car " );
        window.setTitle("Bumping Cars");
        ALine line = new ALine(0, BOTTOM_LINE, 1000, BOTTOM_LINE );
        line.place( window );
        window.repaint();
    }

    /**
     * gets the other Car object
     * used for collision detection
     * @param movingCar Car that wants to move
     * @return the other Car we do not want to hit!
     */
    public Car getOtherCar( Car movingCar)
        {
         if(carA.isSelected() )
            return carB;
        else
            return carA;     
        }
    
    
    
    /**
     * event handler method for the left button
     * it deselects the current car and
     * selects the next car
     */
    public void leftAction(){
        if( carA.isSelected() ){
            carB.select();
            carA.deSelect();
        }
        else{
            carA.select();
            carB.deSelect();
        }
    }
    
    /** event handler method for the middle button
     * it advances the direction of the selected car
     */
    public void midAction(){
 
       if(carA.isSelected() )
            carA.advanceDirection();
        else
            carB.advanceDirection(); 
        
    }
    
    /** event handler method for the right button
     * it causes the selected car to move
     */
    public void rightAction(){
        if(carA.isSelected() )
           
            carA.moveCar();
           
             
         else
            carB.moveCar();
    }
   
    
}
