import java.util.*;

   /**
    * The BookStore class stores an array of books that are for sale
    * @author Mike Truong
    * @version 6.0    5/20/2010
    */
    public class BookStore{
       private Book[] books;
       public final static int MAX = 100;//maximum amount of book in this array
       public static int bookCount=0;//keeps tally of all book count
    
    
    
   /**
    * Instantiates a new array
    */   
    public BookStore(){
       books = new Book[MAX];//initializes array and Max amount
        }
    
  
   /**
    * User inputs a new book into the array
    */
    public void getBookRecord(){
       try{
           Scanner sc = new Scanner( System.in );//get title
           System.out.print("\nEnter title of a book: ");
           String t = sc.nextLine();
           
           if (t.equals("")){//input validation for blank title
           throw new InputMismatchException( "Invalid title. You entered a blank title" );
           }
           
           for(int i=0; i<bookCount; i++){//loop that checks for duplicate title
               if(books[i].getTitle().equalsIgnoreCase(t)){
                   throw new InputMismatchException( "Please renter. You have entered a duplicate title." );
                }
            }
           
           System.out.print("\nEnter quantity of this title: ");// get quantity
           int q = sc.nextInt();
           if(q<0 || q>100){//input validation for quantity
               throw new InputMismatchException( "Invalid quantity" );
            }

           
           System.out.print("\nEnter price of book: $");// get price
           double p = sc.nextDouble();
           if (p<0 || p>500){//input validation
               throw new InputMismatchException( "Invalid price" );
            }
          
            Book b = new Book( t, q, p );
            int insertionPoint=bookCount;//initialized insert point.
           
            for(int pos=0; pos<bookCount; pos++){//loop that finds the right place to insert
               if(p < books[pos].getPrice()){//finds insert position
                   insertionPoint=pos;//actually found a place to insert
                   break;//stops when insertion point is found so we can shift and insert below
                }
              }
            
            for(int pos=bookCount-1; pos>=insertionPoint; pos--){//loop that moves array down after finding a place to insert
                books[pos+1]=books[pos];//actual move
               }
             
              books[insertionPoint]=b;//actual insert after sort and find
              bookCount++;//update book count after each entry
              System.out.println("The book has been stored... " );
           }
        
        catch( InputMismatchException e ){
            System.out.println( "Input error... try again!" );
            System.out.println(e.getMessage());// displays each trow error message
        }
      }
 
        
   /**
    * Finds a matching title and deletes the book
    */       
    public void deleteBook(){
       boolean deleted=false;//flag
       
       System.out.println("\nWhich title do you want to delete?");
       Scanner sc = new Scanner( System.in );
       String title=sc.nextLine();
          
       for(int dup=0; dup<bookCount; dup++){//loop for deleting duplicate
           if(title.equalsIgnoreCase(books[dup].getTitle())){
               for(int i=dup; i<bookCount; i++){//found and start a loop at duplicate
                  books[i]=books[i+1];//shifts back up from duplicate
                   }
                   
                bookCount--;//change book count after delete to fill the null space
                deleted=true;//shows true if was deleted for message below
                break;//stops loop to continue
            }
        }
          if(deleted){
              System.out.println("\nJust deleted " + title);//message when deleted or not deleted
            }
       
          else {
              System.out.println("\nDidnt delete. No title of such Exist");
            }
        }
        
      
   /**
    * Displays the books in the order in which they were entered
    */       
    public void showAllBooks(){
        System.out.println("\n\nThe list of all books:\n");//loop to show all books
        for( int i=0; i <bookCount; i++)//loop through all
            System.out.println(books[i].toString() );//shows all in string form
        }
        
     
   /**
    * Displays the total price and book count of all book entries
    */       
    public void statusReport(){
        System.out.println("\nStatus report of all books is:\n");
        double totalPriceAll=0;//initialized total amount
        double Largest=books[0].getPrice();//initalize larget price book
        
        for( int i=0; i<bookCount; i++){//loop tthrough entire array
          totalPriceAll+=books[i].getPrice();// accumulater for total price of all books
        
          if(books[i].getPrice() > Largest){ //sort and through and find largest price
            Largest=books[i].getPrice();//found largest price
           }
        }
        
        System.out.println("Total count of all books is " + bookCount);//display when loop has found
        System.out.println("Total cost of all books $" + totalPriceAll);
        System.out.println("Highest priced book is $" + Largest);
        
    }
      
   /**
    * Ask for a quantity and displays all books with that quantity or below
    */       
    public void limit(){
         System.out.println("\n\nPlease enter quantity limit?");
         Scanner sc = new Scanner( System.in );
         int limits=sc.nextInt();
         System.out.println("\nHere are all books matching quantity limit of " + limits);
      
        try{
          if(limits<0 || limits>100){//input validation for limit
           throw new InputMismatchException( "Limit must be between 0-100" );
           }
           
          for(int i=0; i<bookCount; i++){//loop that finds the limit quantity
            if(limits >= books[i].getQuantity()){
                System.out.println(books[i].toString() );
              }
           }
         }
        
         catch( InputMismatchException e ){
            System.out.println( "Input error... try again!" );
            System.out.println(e.getMessage());//displays each throw error
          }
         }  
    
    
    
   /**
    * Operates the entire program via one method.
    */       
    public void manage(){
         while(true) {// while valid
            System.out.println("\nWelcome to the BookStore Manager\n"   +//display interface to the user
            "Please enter a command from the following choices:\n" +
            "Add\n" +
            "Delete\n" +
            "Display\n" +
            "Status\n" +
            "Search\n" +
            "Exit\n" +
            "<Enter Command >");
           Scanner sc = new Scanner( System.in );
           String what=sc.nextLine();
                
             if(what.equalsIgnoreCase("Add")){ //calls all the functions that have been written above
             getBookRecord();
                }
             else if(what.equalsIgnoreCase("Delete")){
             deleteBook();
                }
             else if(what.equalsIgnoreCase("Display")){
             showAllBooks();
                }
             else if(what.equalsIgnoreCase("Status")){
             statusReport();
                }
             else if(what.equalsIgnoreCase("Search")){
             limit();
                }
             else if (what.equalsIgnoreCase("Exit")){
             break;//ends program 
                }
              }
           }
           
 }
