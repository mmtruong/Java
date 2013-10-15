import java.util.*;
import java.io.*;

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
          if (t.equals("")){
          throw new InputMismatchException( "Invalid title. You entered a blank title" );
          }

          for(int i=0; i<bookCount; i++){//loop that checks for duplicate title
              if(books[i].getTitle().equalsIgnoreCase(t)){
                  throw new InputMismatchException( "Please renter. You have entered a duplicate title." );
               }
           }

          System.out.print("\nEnter quantity of this title: ");// get quantity
          int q = sc.nextInt();
          if(q<0 || q>1000){
              throw new InputMismatchException( "Invalid quantity" );
           }


          System.out.print("\nEnter price of book: $");// get quantity
          double p = sc.nextDouble();
          if (p<0 || p>500){
              throw new InputMismatchException( "Invalid price" );
           }

           Book b = new Book( t, q, p );

            addBook(b);
            System.out.println("The book has been stored... " );
          }


       catch( InputMismatchException e ){
           System.out.println( "Input error... try again!" );
           System.out.println(e.getMessage());//method from the string.lang throwing that displays each message
       }
     }

   
   /**
    * Finds a matching title and deletes the book
    * @param b is book being inserted into array
    */
    private void addBook(Book b){//I created this method so that I can call from two different places
        int insertionPoint=bookCount;//initialized insert point.
        for(int pos=0; pos<bookCount; pos++){//loop that finds the right place to insert
              if(b.getPrice()<books[pos].getPrice()){
                  insertionPoint=pos;//actually found a place to insert
                  break;
               }
        }

        for(int pos=bookCount-1; pos>=insertionPoint; pos--){//loop that moves array down after finding position to insert
               books[pos+1]=books[pos];
         }

             books[insertionPoint]=b;//actual insert after sort and find
             bookCount++;
    }


  /**
   * Finds a matching title and deletes the book
   */
   public void deleteBook(){
      boolean deleted=false;

      System.out.println("\nWhich title do you want to delete?");
      Scanner sc = new Scanner( System.in );
      String title=sc.nextLine();

      for(int dup=0; dup<bookCount; dup++){//loop for deleting duplicate
          if(title.equalsIgnoreCase(books[dup].getTitle())){
              for(int i=dup; i<bookCount; i++){//found and start a loop at duplicate
                 books[i]=books[i+1];//shifts back up from duplicate
               }

               bookCount--;//change book count after delete to fill the null space
               deleted=true;
               break;//stops loop
           }
       }
         if(deleted){
             System.out.println("\nJust deleted "+title);//message when deleted or not deleted
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
       for( int i = 0; i < bookCount; i++)
           System.out.println(books[i].toString() );
    }


  /**
   * Displays the total price and book count of all book entries
   */
   public void statusReport(){
       System.out.println("\nStatus report of all books is:\n");
       double totalPriceAll=0;//initialized total amount
       String info="";
       double Largest=books[0].getPrice();
       for( int i = 0; i < bookCount; i++){//loop tthrough entire array
         totalPriceAll+=books[i].getQuantity()*books[i].getPrice();// accumulater for total price of all books

         if(books[i].getPrice()>Largest){//find largest priced book
            info=books[i].toString();//Found the largest priced book
          }
       }

       System.out.println("Total count of all books is " + bookCount);//prints
       System.out.println("Total cost of all books $" + totalPriceAll);
       System.out.println("Highest priced book's info is: " + info);
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

         for(int i=0;i<bookCount;i++){//loop that finds the limit quantity
           if(limits>=books[i].getQuantity()){
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
   * Sort quantity through selection sort method in descending order
   */
   public void quantityDescending(){

       System.out.println("\nBooks displayed by Descending Quantity:");
       for ( int idx = 0; idx < bookCount; idx++ ) {//runs through the entire array the first time
           int idxGreatest = idx;//initialize a value to compare
           for ( int i = idx + 1; i < bookCount; i++ ) {//runs through the array from another index starting point
                if ( books[i].getQuantity() > books[idxGreatest].getQuantity() )//compares first run with second run
                    idxGreatest = i;//finds a greater value after being compared
           } 
            Book temp = books[idx]; //swaps the two variables after found from comparison
            books[idx] = books[idxGreatest];
            books[idxGreatest] = temp;
            System.out.println(books[idx].toString());//prints
       }
   }


   /**
   * Sort price through insertion sort method in ascending order
   */
   public void priceAscending(){
     int i;//iniitlize variable to be used
     System.out.println("\nBooks displayed by Ascending Price:");
     for ( int idx = 1; idx < bookCount; idx++ ) {//starts from the second number of the array and runs through
         Book temp=books[idx];//place all books from the first run out to a temp place
        for ( i =idx; i>0 && temp.getPrice()< books[i-1].getPrice(); i-- ){//second run and compares if less than
            books[i]=books[i-1]; // if found then we shift upward to higher index
        }
         books[i]=temp;//put into right place after shift
     }
      for( int idx = 0; idx < bookCount; idx++ ){//another run though to print out
       System.out.println( books[idx].toString());
      }
   }



  /**
   * Sorts title lexicographically in ascending order
   */
   public void titleAscending(){

       System.out.println("\nBooks displayed by Ascending Title:");
       for ( int idx = 0; idx < bookCount; idx++ ) {//run through the entire array for the first time
           int idxSmall = idx;//initializ a smallest 
           for ( int i = idx + 1; i < bookCount; i++ ) { //runs through a second time starting from an index above the first run
              if (( books[i].getTitle().compareTo(books[idxSmall].getTitle() ))  < 0)//toCompare() shows -1 if it is less than
                idxSmall = i;//if toCompare() method is negative then it is the smallest index
           }

        Book temp = books[idx];//swap the two if there is a negative number
        books[idx] = books[idxSmall];
        books[idxSmall] = temp;
        System.out.println( books[idx].toString());//prints out
       }
   }


  /**
   * Makes a single file
   */
   public void makeFile(){
       try{
           System.out.println("What do you want to name your file?");//promts the user for file name
           Scanner sc=new Scanner(System.in);
           FileWriter fw = new FileWriter( sc.nextLine()); //this creates the file name and file itself

           for(int i=0;i<bookCount;i++){//loops through all the existing books
               String t=books[i].getTitle();//gets title
               int q=books[i].getQuantity();//gets quantity
               double p=books[i].getPrice();// gets price 
               fw.write( t + "\t" + q  + "\t" + p  + "\n");//writes it all into the file
           }
            fw.close();//closes the file after writing all books into file
            System.out.println("\nJust created a file**");
       } 
       catch( IOException e ){
        System.out.println("Something wrong with file path" );
       }
   }

  /**
   * Reads a single book
   */
   public void readFile(){
       try{
           System.out.println("Which file do you want to read?");//promts the user for file they want to read
           Scanner k = new Scanner( System.in);
           Scanner inputFile = new Scanner( new File(k.nextLine()));//file created is inputter here to read
           System.out.println("\nAll the books from the file are:");
           
           while(inputFile.hasNextLine()){
               Scanner line=new Scanner(inputFile.nextLine());//reads all the data 
               line.useDelimiter("\t");//since default is white space we need to change to tab
               String t = line.next();//reads title             
               int q = line.nextInt();//reads quantity
               double p = line.nextDouble();//reads price
               
               Book v=new Book( t, q, p );//all books need to be added before read so we creat a new book to add
               addBook(v);//call add function
               System.out.println( "\nBook: " + t + " Title: " + p + " Price: " + q );//prints out what is read
           }
       }

       catch( FileNotFoundException e ){
           System.out.println( "File was not found");
       }
    }




  /**
   * Operates the entire program via one method.
   */
   public void manage(){
        while(true) {// while input is true
           System.out.println("\nWelcome to the BookStore Manager\n"   +//display interface to the user
           "Please enter a command from the following choices:\n" +
           "Add\n" +
           "Delete\n" +
           "Display\n" +
           "Status\n" +
           "Search\n" +
           "AscendP\n" +
           "DescendQ\n" +
           "AscendT\n" +
           "Make\n" +
           "Read\n" +
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
            else if(what.equalsIgnoreCase("AscendP")){
                priceAscending();
            }
            else if(what.equalsIgnoreCase("DescendQ")){ 
                quantityDescending();
            }
            else if(what.equalsIgnoreCase("AscendT")){
                titleAscending();
            }
            else if(what.equalsIgnoreCase("Make")){
                makeFile();
            }
            else if(what.equalsIgnoreCase("Read")){
                readFile();
            }
            else if (what.equalsIgnoreCase("Exit")){
                break;//ends program
            }
          }
     }

 
  /**
   * Main program.
   */
   public static void main(String[] args){//program starts from here
       BookStore mainer = new BookStore();
       mainer.manage();//call the manage function
   }


}
