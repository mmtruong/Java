import java.util.*;


/**
 * The BookStore class stores an array of books that are for sale
 * @author CSC 142
 * @version 2010
 */
public class BookStore
{
    // define the data structure
    private Book[] books, tempBook;
    public final static int MAX = 5;
    public static int numbBooks=0;
    public int  i, j;
    
    public BookStore()
    {
        // create the data structure to store the books
       books = new Book[MAX];
    }
    
  
    /**
     * get one Book record from user and enter it into array
     * must manage an InputMismatchException if the user doesn't enter 
     * matching data type.
     */
        public void getBookRecord(){
            
            // attempt to successfully read 3 valid responses from user via keyboard
            try{
            // create Scanner to read keyboard
           Scanner sc = new Scanner( System.in );
           
           // get title
           System.out.print("Enter title of a book: ");
           String t = sc.nextLine();
           
           // get quantity
           System.out.print("\nEnter quantity of this title: ");
           int q = sc.nextInt();
           
           // get price
           System.out.print("\nEnter price of book: $");
           double p = sc.nextDouble();
           
           if ( t=="" || q<0 || q>1000 || p<0 || p>500) {
      
           throw new InputMismatchException( "Amount must be greater than 0" );
  
            }
           
          for(i = 0; i < books.length; i++) {
		  for(j = 0; j < books.length; j++) {
			if (books[i].getPrice() < books[j].getPrice()) {
				tempBook = books[i];
				books[i] = books[j];
				books[j] = tempBook;
          

        System.out.println("The book has been stored... " );
        }}}
           
        
    
        // what to do if there is an error on any of the inputs
        catch( InputMismatchException e ){
            System.out.println( "Input error... try again!" );
        }
}
 
        /**
         * showAllBooks displays the books in the order in which they were entered
         */       
        public void showAllBooks(){
        System.out.println("The list of all books\n\n");
        for( int i = 0; i < books.length; i++)
            System.out.println(books[i].toString() );
        }
        
}
