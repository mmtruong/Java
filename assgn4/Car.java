import aLibrary.*;
import java.awt.Color;

/**
 * The Car class models a graphics object on the display
 * it must store:
 * <ul><li>an <s>enum definition</s> <b>integer</b> to manage direction: up, down, left, right</li>
 * <li>whether this Car is selected (or not)</li>
 * <li>a RoundRectangle to display the Car in the window</li>
 * <li>Car dimensions and movement increment</li>
 * <li>a reference back to the A3ButtonWindow</li></ul>
 *
 * @author Mike Truong CSC 142
 * @version 4.0      5/7/2010
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
   private static final int BACK = 4;

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
       rrect = new ARoundRectangle( upperLeftX, upperLeftY, CAR_WIDTH, CAR_HEIGHT );
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
        int xtobe=this.rrect.getX();
        int ytobe=this.rrect.getY();
        Car other=court.getOtherCar(this);
        int bottomLine=court.BOTTOM_LINE;//bottom line defined in the court class



         switch ( direction ){
         
         case RIGHT:
         if ((xtobe + CAR_WIDTH + CAR_INCREMENT) < (win.getWidth())){//right window boundary
         if ((((xtobe + CAR_WIDTH + CAR_INCREMENT) < ((other.rrect.getX())))) || ((ytobe + CAR_HEIGHT) < (other.rrect.getY()))|| (ytobe) > (other.rrect.getY() + CAR_HEIGHT) || ((xtobe) > (other.rrect.getX()+CAR_WIDTH)))//overlap condition in right direction
               rrect.translate(CAR_INCREMENT,0);//moves car if condition is met
         
            }
         break;
           
               
         case UP:
         if ((ytobe - CAR_INCREMENT) > (0)){//up window boundary
         if ((ytobe - CAR_INCREMENT) > (other.rrect.getY() + CAR_HEIGHT)  || (( xtobe ) > (other.rrect.getX() + CAR_WIDTH))|| ((xtobe + CAR_WIDTH) < (other.rrect.getX())) ||  ((ytobe + CAR_HEIGHT) < (other.rrect.getY()))   )//overlap condition in up direction
              rrect.translate(0,-CAR_INCREMENT);//moves car if condition is met
       
            }
          break;
             
            
          case LEFT:
          if ((xtobe - CAR_INCREMENT) > (0)){//left window boudary
          if (((xtobe - CAR_INCREMENT) > (other.rrect.getX() + CAR_WIDTH )) || ((ytobe + CAR_HEIGHT)< (other.rrect.getY()))|| (ytobe) > (other.rrect.getY()+CAR_HEIGHT) || ((xtobe) < (other.rrect.getX())))//overlap condition in left direction
               rrect.translate(-CAR_INCREMENT,0);//moves car if condition is met
          
             }
         break;
          
               
          case DOWN:
          if ((ytobe + CAR_INCREMENT + CAR_HEIGHT - bottomLine)<(0)){// down window boundary
          if ((ytobe + CAR_HEIGHT + CAR_INCREMENT) < (other.rrect.getY()) || ((xtobe) > (other.rrect.getX() + CAR_WIDTH))|| ((xtobe + CAR_WIDTH) < (other.rrect.getX())) || ((ytobe) > (other.rrect.getY()+CAR_HEIGHT)))//overlap condition in down direction
               rrect.translate(0,CAR_INCREMENT);//moves car if condition is met
           
            }
          break; 
           
            }
            win.repaint();
            }



   /** advances the stored direction of this Car
    * in the following order: right, up, left, down<p>
    * must go from down direction to right direction<p>
    * also changes displayed text in mid button and<p>
    * repaints the window
    */
   public void advanceDirection() {

               isSelected = true;
               direction++;
               direction%=4;//brings us back from down to right
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
               break;
            }
       win.repaint();

    }}






