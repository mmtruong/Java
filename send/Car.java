import aLibrary.*;
import java.awt.Color;

/**
 * The Car class models a graphics object on the display
 * <ul><li>an <s>enum definition</s> <b>integer</b> to manage direction: up, down, left, right</li>
 * <li>whether this Car is selected (or not)</li>
 * <li>a RoundRectangle to display the Car in the window</li>
 * <li>Car dimensions and movement increment</li>
 * <li>a reference back to the A3ButtonWindow</li></ul>
 * 
 * @author Amine Allaouchiche
 * @version CSC 142  Spring 2010
 */
public class Car
{
    /** whether this Car is selected */
    private boolean isSelected;  
    /** the graphics object displayed in the window */
    private ARoundRectangle rrect;
    /** the window where graphics are displayed */
    private A3ButtonWindow win;
    /** the court where cars are displayed */
    private Court court;
    /** the car width */
    public final int CAR_WIDTH = 60;
    /** the car height */
    public final int CAR_HEIGHT = 40;
    /** the car movement increment each time the 'Move' button is pressed */
    private final int CAR_INCREMENT = 10;
    /** stores the direction this Car is moving in */
    private int direction;
    /** constant for right direction */
    private static final int RIGHT = 0;
     /** constant for up direction */
    private static final int UP = 1;
    /** constant for left direction */
    private static final int LEFT = 2;
    /** constant for down direction */
    private static final int DOWN = 3;

    /**
     * Constructor for objects of class Car
     * <ul><li>initializes all instance variables of Car class</p>
     * <li>instantiates the RoundRectangle graphics object</p>
     * <li>initializes the color of the graphics object</p>
     * <li>sets graphics object as Filled if this is the selected Car</p>
     * <li>places the graphics object in the window container</p></ul>
     * @param upperLeftX the x coordinate of the upper left corner of this Car
     * @param upperLeftY the y coordinate of the upper left corner of this Car
     * @param newColor the desired color for this Car
     * @param newSelect true if this Car is the selected Car, false otherwise
     * @param newWin a reference variable to the A3ButtonWindow
     */
    public Car( int upperLeftX, int upperLeftY, Color newColor, boolean newSelect, A3ButtonWindow newWin, Court c )
    {
        win = newWin;
        court = c;
        isSelected = newSelect;
        direction = RIGHT;
        rrect = new ARoundRectangle( upperLeftX, upperLeftY, CAR_WIDTH, CAR_HEIGHT );  // passes the values ( size ) of this car
        if( isSelected ) rrect.setToFill();
        rrect.setColor( newColor );
        rrect.place( win );
        win.repaint();
    }

    /** @return true if this is the selected Car, false otherwise */
    public boolean isSelected(){
        return isSelected;
    }
 
    /** sets this Car as the selected Car<p>
     * also sets fill and updates the mid button text<p>
     * repaints the window
     */
    public void select(){
        isSelected = true;
        rrect.setToFill();

        switch ( direction ){
            case RIGHT:
                win.setMidText("Right");
                break;
            case UP:
                win.setMidText("Up");
                break;
            case LEFT:
                win.setMidText("Left");
                break;
            case DOWN:
                win.setMidText("Down");
            }
           
        win.repaint();
    }

    /** sets this Car as NOT selected<p>
     * also sets outline display and repaints the window
     */
    public void deSelect(){
        isSelected = false;
        rrect.setToOutline();
        win.repaint();
    }

    /** moves the selected Car in the direction
     * that is set within its direction variable
     */
    public void moveCar(){
         int stepX =0;
         int stepY=0;
         Car other = court.getOtherCar(this);
         boolean tooHighToCollide= ((this.rrect.getY()+CAR_HEIGHT)<(other.rrect.getY())) ;   // checks if this car is too high to collide if moving other than up
         boolean tooLowToCollide= (this.rrect.getY()>(other.rrect.getY()+CAR_HEIGHT)) ;      // checks if this car is too low to collide if moving other than down
         boolean farLeftToCollide=(this.rrect.getX()>other.rrect.getX()+CAR_WIDTH);          // checks if this car is too left to collide if moving other than left    
         boolean farRightToCollide = ((this.rrect.getX()+CAR_WIDTH)<other.rrect.getX());     // checks if this car is too right to collide if moving other than right
         
         
         
         switch ( direction ){
            case RIGHT:
                if ((win.getWidth( )) > ((this.rrect.getX() + CAR_WIDTH + CAR_INCREMENT)))  // tests if the next move left will be beyond the right border of the window
                    {
                    if  ( ( ((this.rrect.getX() + CAR_WIDTH + CAR_INCREMENT)< ((other.rrect.getX())))
                        ||(tooHighToCollide)
                        ||tooLowToCollide ) )                    
                        stepX = CAR_INCREMENT;
                     else if (farLeftToCollide)
                        stepX = CAR_INCREMENT;
                    }
                break;
            case UP:
                if ((0) < ((this.rrect.getY()- CAR_INCREMENT)))  // tests if the next move up will be beyond the top border of the window
                    if ((this.rrect.getY()-CAR_INCREMENT>(other.rrect.getY()+CAR_HEIGHT))
                        || (farLeftToCollide)
                        || (farRightToCollide) )
                        stepY = -CAR_INCREMENT;
                     else if (tooHighToCollide)
                            stepY = -CAR_INCREMENT;
                break;
            case LEFT:
                if ((0) < ((this.rrect.getX()- CAR_INCREMENT))) // tests if the next move left will be beyond the Left border of the window
               {
                         if(( ((this.rrect.getX() -  CAR_INCREMENT)> ((other.rrect.getX()+CAR_WIDTH)))
                    ||(tooHighToCollide)
                    ||tooLowToCollide ) )  
                stepX =-CAR_INCREMENT;
                else if (this.rrect.getX()<other.rrect.getX())
                stepX = -CAR_INCREMENT;
            }  
               
                break;
            case DOWN:
                if ((0) > ((this.rrect.getY()+CAR_HEIGHT+ CAR_INCREMENT)- court.BOTTOM_LINE)) // tests if the next move down will be beyond the BottomLine 
                  if (((this.rrect.getY()+CAR_INCREMENT+CAR_HEIGHT)<(other.rrect.getY()))
                || (farLeftToCollide)
                || (farRightToCollide) )
                stepY = CAR_INCREMENT;
                 else if (tooLowToCollide)
                 stepY = CAR_INCREMENT;
                break;
            }
        this.rrect.translate(stepX,stepY);
        win.repaint();
    }
    

        
     
    
    /** advances the stored direction of this Car
     * in the following order: right, up, left, down<p>
     * must go from down direction to right direction<p>
     * also changes displayed text in mid button and<p>
     * repaints the window
     */
    public void advanceDirection()
    {
        direction++;
        direction = direction%4;
       switch ( direction ){
            case RIGHT:
                win.setMidText("Right");
                break;
            case UP:
                win.setMidText("Up");
                break;
            case LEFT:
                win.setMidText("Left");
                break;
            case DOWN:
                win.setMidText("Down");
            }
           
        win.repaint();
        
    }
}
