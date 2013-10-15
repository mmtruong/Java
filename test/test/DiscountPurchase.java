
public class DiscountPurchase extends Purchase{
    public double discount;

public DiscountPurchase(String n, int q, double p, double d){
    super(n, q, p);
    discount=d/100;
   
}

public double getDiscount(){
    return discount;
}

public double getPurchaseCost(DiscountPurchase c){
    
    double total=c.getPrice()*c.getQuantity();
    double dis=c.discount*total;
    double discountTotal=total-dis;
    return discountTotal;
    
}


}