/**
* Counter class models a simple counter
*
* @author Dennis Schaffer
* @version 2006
*/
public class Counter
{
// this is where you store the actual count
    private int count;

/**
* Constructor for objects of class Counter
*/
public Counter()
{
// always is initialized to zero
    count = 0;
}

/**
* Constructor for objects of class Counter
* @param newCount is the initial value of the counter
*/
public Counter( int newCount )
{
// initialized to value passed by parameter
    count = newCount;
}

/**
* this method returns the actual count
* @return the count
*/
public int getCount()
{
    return count;
}

/**
* increment method adds 1 to the count
*
*/
public void increment(){
count = count + 1;
}

/**
* reset the counter back to zero
*/
public void reset(){
    count = 0;
}

/**
* setCount sets the counter to any value in parameter
* @param newCount is the value to set Counter to
*/
public void setCount(int newCount){
    count = newCount;
}

}

