
/**
 * Puts an order into the flower shop
 * 
 * @author Mike Truong
 * @version 3.0     4/19/10
 */
public class Order{
    // instance variables
    public int vase, rose, carnation, daisy;

    /**
     * Constructor for a standard initalized order count of a Spring Special (1 vase, 3 rose, 6 carnation, and 4 daisy)
     */
    public Order(){
        vase=1;//initialized count
        rose=3;
        carnation=6;
        daisy=4;
     }
     
    /**
     * Constructor that gives a specified request for each individual flower from customer
     * @param vaseCount is amount of vases a customer wants
     * @param roseCount is amount of roses a customer wants
     * @param carnationCount is amount of carnation a customer wants
     * @param daisyCount is amount of daisy a customer wants
     */
    public Order(int vaseCount, int roseCount, int carnationCount, int daisyCount){
        vase=vaseCount;//customer's specified amount
        rose=roseCount;
        carnation=carnationCount;
        daisy=daisyCount;
    }

    /**
     * Constructor How many Spring Special and dozen Roses?
     * @param specialCount consists of 1 vase, 3 rose, 6 carnation, and 4 daisy
     * @param dozenCount consists of a 12 roses
     */
    public Order(int specialCount, int dozenCount){
      vase=1*specialCount; //items as a function of specialCount and dozenCount
      rose=3*specialCount + 12*dozenCount;;
      carnation=6*specialCount;
      daisy=4*specialCount;
     }

    //Query Methods
    /**
     * Retreives order amount for roses
     * @return rose count
     */
    public int getRoseCount( ){
        return rose;
    }

    /**
     * Retreives order amount for carnation
     * @return carnation count
     */
    public int getCarnationCount( ){
        return carnation;
    }
    
    /**
     * Retreives order amount for daisy
     * @return daisy count
     */
    public int getDaisyCount( ){
        return daisy;
    }

    /**
     * Retreives order amount for vase
     * @return vase count
     */
    public int getVaseCount( ){
        return vase;
    }





}