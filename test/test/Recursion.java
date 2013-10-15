
/**
 * Write a description of class Recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion
{
    public int rec(int x){
        if(x==1)
            return 1;
        else if(x%2==0)
            return 1+ rec(x/2);
        else
        return 1+rec(3*x+1);
    }
} 
                