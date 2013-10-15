/**
 * The Book class stores information about a single book for sale
 * title, price, and quantity
 * 
 * @author CSC 142
 * @version 2010
 */
public class Book
{
    /** book title */
    private String title;
    /** quantity on hand */
    private int quantity;
    /** book price */
    private double price;
    
    /**
     * Constructor for objects of class Book
     * @param title of the newly created Book
     * @param quantity of this newly created Book
     * @param price of this newly created Book
     */
    public Book( String title, int quantity, double price )
    {
        // initialise instance variables for a Book object
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /** get book title
     * @return String title of this book
     */
    public String getTitle(){
        return title;
    }
    
    /** get quantity
     * @return int quantity of this book on hand
     */
    public int getQuantity(){
        return quantity;
    }
    
    /** get book price
     * @return double price of this book
     */
    public double getPrice(){
        return price;
    }
    
    /** toString
     * @return readable one-line String representation of a book
     */
    public String toString(){
        return "$" + this.price + "\t" + this.quantity + "\t" + this.title;
    }
}
