import aLibrary.*;
import java.awt.Color;
import java.util.*;

/**
 * The Court class provides:<ul>
 * <li>a window to contain the other graphics objects</p>
 * <li>3 buttons that send messages to the graphics objects</p>
 * <li>2 Round Rectangles that will be manipulated by user input through the buttons</p></ul>
 * @author CSC 142
 * @version 2010
 */
public class Court extends A3ButtonHandler
{
    /** the window that contains buttons and graphics objects */
    private A3ButtonWindow window;
    /** the two car objects */
    private ArrayList<Car> cars;
    /** the bottom line y coordinate */
    public static final int BOTTOM_LINE = 425;
    

    /**
     * Constructor for objects of class Court that must do the following things:
     * <ul><li> instantiate the window</li>
     * <li>instantiate two cars of different colors - only one of them should be the selected car</li>
     * <li>initialize the text on the 3 buttons</li>
     * <li>repaint the window</li></ul>
     */
    public Court()
    {
        window = new A3ButtonWindow( this );
        this.cars=new ArrayList<Car>();
        this.cars.add(new Car( 0, 0, Color.blue, true, window, this ));
        this.cars.add(new Car( 0, 0, Color.blue, true, window, this ));
        
        window.setLeftText( "Select Car ");
        window.setMidText( "Right");
        window.setRightText( "Move Car " );
        ALine line = new ALine(0, BOTTOM_LINE, 1000, BOTTOM_LINE );
        line.place( window );
        window.repaint();
    }

    /**
     * will there be overlap with the other Car or the boundaries if this Car moves by the amount (dx, dy)?<p>
     * @param movingCar Car that wants to move
     * @param dx desired movement in the x direction
     * @param dy desired movement in the y direction
     * @return true if there is no overlap with the other Car
     */
    public boolean noObstacle( Car movingCar, int dx, int dy ){
        // designate target as the other Car which is NOT the moving Car
        Car target;
       
        for(int i=0; i<cars.size(); i++){
            if( movingCar == cars.get(i) )
                target = cars.get(i+1);
            else
                target = cars.get(i);
                // major test to see if movingCar overlaps with target Car    
           if( movingCar.getX() + Car.CAR_WIDTH + dx >= target.getX() && movingCar.getX() + dx <= target.getX() + Car.CAR_WIDTH &&
                movingCar.getY() + Car.CAR_HEIGHT + dy >= target.getY() && movingCar.getY() + dy <= target.getY() + Car.CAR_HEIGHT
                // now check against the window boundaries
                || movingCar.getX() + Car.CAR_WIDTH + dx >= window.getWidth() || movingCar.getX() + dx < 0 || movingCar.getY() + dy < 0 ||
                movingCar.getY() + Car.CAR_HEIGHT + dy > BOTTOM_LINE )            
                return false;
            else
                return true;
        }
        
     }
    
    /**
     * event handler method for the left button
     * it must deselect the current car and
     * select the next car
     */
    public void leftAction(){
       for(int i=0; i<cars.size(); i++){
         if( cars.get(i).isSelected() ){
            cars.get(i).select();
            cars.get(i+1).deSelect();
         }
         else{
            cars.get(i+1).select();
            cars.get(i).deSelect();
         }
       }
    }
    
    /** event handler method for the middle button
     * it must advance the direction of the selected car
     */
    public void midAction(){
        for(int i=0; i<cars.size(); i++){
            if( cars.get(i).isSelected() )
                cars.get(i).advanceDirection();
            else
                cars.get(i+1).advanceDirection();
                break;
         }
     }
     
     
    /** event handler method for the right button
     * it must cause the selected car to move
     */
    public void rightAction(){
       for (int i=0; i<cars.size(); i++){ 
        
            if(cars.get(i).isSelected() )
                cars.get(i).moveCar();
            else
                cars.get(i+1).moveCar();
                break;
        }
    }
}
