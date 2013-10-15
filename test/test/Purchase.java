public class Purchase

{

    private String name;

    private int quantity;

    private double price;

 

    public Purchase(String n, int q, double p){

        name = n;

        quantity = q;

        price = p;}

 

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public double getPrice(){  return price;}

    public String toString() { return ("Item:" + this.name + " quantity:" + this.quantity  + "price:" + price ); }
    
    public double getPurchaseCost(Purchase c){
        double total= c.quantity * c.price;
        return total;

    }
}