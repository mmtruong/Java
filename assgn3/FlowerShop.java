
 /**
  * Processes all flower orders and keeps track of inventory.
  * 
  * @author Mike Truong 
  * @version 3.0     4/24/10
  */
  public class FlowerShop{
     private static double costOfVase=3.99;//instance variables 
     private static double costOfRose=2.19; //static cost for each item
     private static double costOfCarnation=1.49; 
     private static double costOfDaisy=0.49;  
     private int stockVases, stockRoses, stockCarnations, stockDaisies, stockFertilizer;
     private double totalSales;
     private Order request;//supplier

 /**
  * Constructor for objects of class Flowershop for initial stock of 50 vases, 300 roses, 300 carnations, 500 daisies, 100 fertilizer packet(1 free fertilizer packet for every 12 flowers sold), and 0 total sales amount.
  */
  public FlowerShop(){
     stockVases=50;//items initialized
     stockRoses=300;
     stockCarnations=300;
     stockDaisies=500;
     stockFertilizer=100;
     totalSales=0;//initialized total sales
  }

 /**
  * Processes request by computing cost and updatng inventory
  * @param request is the order supplied that is to be processed
  * @return total cost of a processed request
  */
  public double processOrder(Order request){
     stockVases=stockVases - request.getVaseCount();//update inventory for each item
     stockRoses=stockRoses - request.getRoseCount();
     stockCarnations=stockCarnations - request.getCarnationCount();
     stockDaisies=stockDaisies - request.getDaisyCount();
     int fertilizerFree= (int)(request.getRoseCount() + request.getCarnationCount() + request.getDaisyCount())/12;//amount of free fertilizer using integer divide
     stockFertilizer=stockFertilizer-fertilizerFree;//update inventory for fertilizer

     double totalcostOrder=costOfVase*request.getVaseCount() +  costOfRose*request.getRoseCount() + costOfCarnation*request.getCarnationCount() + costOfDaisy*request.getDaisyCount();//cost of processed request 
     totalSales=totalSales+totalcostOrder; //update combined total sales
     return totalcostOrder;
  }

 /**
  * Retrieves the total amount of all sales combined
  * @return total sales
  */
  public double getTotalSales(){
     return totalSales;
  }
  
 /**
  * Prints the remaining inventory in stock and shows the combined total sales
  */
  public void printInventory(){
     System.out.println( "Remaining Vases in stock:  " + stockVases );//displays inventory and total combined sales
     System.out.println( "Remaining Roses in stock:  " + stockRoses );
     System.out.println( "Remaining Carnations in stock:  " + stockCarnations );
     System.out.println( "Remaining Daisies in stock:  " + stockDaisies );
     System.out.println( "Remaining Fertilizers in stock:  " + stockFertilizer );
     System.out.println( "Total Sales:  " + totalSales );
     System.out.println( "________________________________________________" );
  }
}