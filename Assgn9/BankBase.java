    import java.util.*;

    import java.io.*;

    /**

     * BankBase will manage a database of BankAcocunts

     * it reads them from a data file whose name is specified by the user

     * it will report rudimentary errors, particularly:

     * file not found

     * input formatting errors


     * @author CSC 142

     * @version 2010

     */

    public class BankBase{

        // the array where we will eventually store all BankAccount records

        private BankAccount [] accounts;
        private ArrayList<BankAccount> info=new ArrayList<BankAccount>();

        /**

         * Constructor for objects of class BankBase

         * contains test code to make sure that readOneAccount()

         * method works correctly

         * also traps exceptions if invalid file name is entered

         * or there is a format error in the data

         */


        public BankBase(){

            // get file name from user and attempt to open the file

            BankAccount ba = null;

            Scanner kbd = new Scanner( System.in );

            System.out.println( "Enter the name of the file you want to open > " );

            String fName = kbd.next();

            try{

                Scanner in = new Scanner( new File( fName ) );

                // we attempt to read data from the file, line by line
                // display to user as verification that all is well - added 12/2
                // YOU WILL NEED TO CHANGE THIS TO STORE THE DATA FOR LATER USE

                while( in.hasNext() ){

                    ba = readOneAccount( in );
                    info.add(ba);
                    System.out.println( ba.toString() );

                }
                accounts=new BankAccount[info.size()];
                for(int i=0;i<info.size();i++){
                    accounts[i]=info.get(i);
                }
                System.out.println( accounts.length );
                System.out.println( info.size() );
                in.close(); // close the input stream, which closes the file - added 12/2
            }

            // program control flows here if there is an error during the creation of a new File object

            catch( FileNotFoundException e ){

                System.out.println( "Cannot find that file!" );

            }

            // program control flows here if there is a a formatting error while reading data from one line

            catch( InputMismatchException e ){

                System.out.println( "Invalid data was encountered" );

            }


            // now that you have properly read all data into a data structure, WRITE CODE HERE TO DO SOMETHING WITH IT!

            // like sorts and searches
            Scanner number = new Scanner( System.in );
            System.out.println( "Enter the Account number of the Bank Account you want to find > " );
            String aName = number.nextLine();

            for(int i=0;i<accounts.length;i++){
                if(aName.equals(accounts[i].getID())){
                    String person= accounts[i].toString();
                    System.out.println( person  );
                }
            }
 
       quicksort(info, 0, 29);
    
        }


    
   
        
    /**
	 * Quicksorts the list with first element at first and last element at first + length - 1.
	 * @param list The array to quicksort.
	 * @param first The first element in the part of the array to quicksort.
	 * @param last The last element in the part of the array to quicksort.
	 */
	private static void quicksort(ArrayList<BankAccount> list, int first, int last) {
		// recursive base case; already sorted
		if(first >= last) return;
		// arbitrarily choose the first element as the pivot
		int pivot = partition(list, first, last, first);
		quicksort(list, first, pivot - 1);
		quicksort(list, pivot + 1, last);

}

	/**
	 * Partitions a portion of the array.
	 * @param list Array.
	 * @param first The first element to consider.
	 * @param last The last element to consider.
	 * @param pivotIndex Where the pivot is (must lie on the range [first, last]).
	 * @return The index of the pivot after partitioning (will lie on the range [first, last]).
	 */
	private static int partition(ArrayList<BankAccount>  list, int first, int last, int pivotIndex) {
		BankAccount pivot = list.get(pivotIndex);
		// Delete the pivot from the array and replace it with the last element.
		// Only consider [first, last-1] as the array now and ignore the last element.
		list.get(pivotIndex)=list.get(list.size());
		// Loop invariant: [first, end) is the range of elements that are less than the pivot.
		int end = first;
		for(int i = first; i < last; i++) {
			if(list.get(i).getID() < pivot.getID()) {
				swap(list, i, end++);
			}
		}
		// list[last] is greater than the pivot. Move it to the end and put the 
		// pivot where it belongs.
		list.get(last)= list.get(end);
		list.get(end) = pivot;
		// return position of the pivot.
		return end;
	}

	
	
	
	
	/**

	 * readOneAccount

	 * must be called from code using try-catch because there can be

	 * input formatting errors during the conversions.

	 * @param in is the Scanner attached to the data file

	 * @return a reference to the newly-created BankAccount object

	 */
	 public BankAccount readOneAccount( Scanner in ){

	     // get fields from data file

	     String acct = in.next();

	     String aName = in.next();

	     double bal = in.nextDouble();

	     // create and return an object of type BankAccount

	     return new BankAccount( aName, acct, bal ); // changed Tues 12/2 9am

	   }

	   
	   /**

	    * starting point for this class

	    * creates object of type BankBase */

	    public static void main( String[] args){

	        BankBase bb = new BankBase();

	       }

}