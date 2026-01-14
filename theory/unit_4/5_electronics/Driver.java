class ElectronicsProduct {
    private String productID, name;
    private double price, discountAmount;

    public ElectronicsProduct(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public void applyDiscount(float discount) {
        discountAmount = price*discount;
    }

    public double getFinalPrice() {
        return price - discountAmount;
    }

    public String toString() {
        return "ElectronicsProduct(productID="+productID+",name="+name+",price="+price+",discountAmount="+discountAmount+")";
    }
}

class WashingMachine extends ElectronicsProduct {
    private int warrantyPeriod;

    public WashingMachine(String productID, String name, double price, int warrantyPeriod) {
        super(productID, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public void extendWarranty(int extension) {
        warrantyPeriod+=extension;
    }

    public String toString() {
        return "WashingMachine("+super.toString()+",warrantyPeriod="+warrantyPeriod+")";
    }
}

public class Driver {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine("WM2301", "LG Washing Machine", 13999, 6);
        wm.applyDiscount(0.2f);
        wm.extendWarranty(2);
        System.out.println(wm);
        System.out.println("Final Price: "+wm.getFinalPrice());
    }
}
