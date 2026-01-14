import java.util.ArrayList;

class Purchase {
    private String itemName;
    private float price;
    private int qty;

    public Purchase(String itemName, int qty, float price) {
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
    }

    public float getTotalCost() {
        return qty*price;
    }
}

class Customer {
    private String name, email;
    private ArrayList<Purchase> purchaseHistory = new ArrayList<Purchase>();

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addPurchase(String itemName, int qty, float price) {
        purchaseHistory.add(
            new Purchase(itemName, qty, price)
        );
    }

    public float calcTotalExpense() {
        float total=0.0f;
        for (Purchase p: purchaseHistory)
            total+=p.getTotalCost();
        return total;
    }
}

class LoyalCustomer extends Customer {
    private float discountRate, discountAmount;

    public LoyalCustomer(String name, String email, float discountRate) {
        super(name, email);
        this.discountRate = discountRate;
    }

    public void applyDiscount() {
        discountAmount = discountRate*calcTotalExpense();
    }

    public float getFinalExpense() {
        return calcTotalExpense() - discountAmount;
    }
}

public class Driver {
    public static void main(String[] args) {
        Customer c = new Customer("Akash Maity", "am.akashmaity@flash.co");
        c.addPurchase("Eggs", 12, 10);
        c.addPurchase("Chicken 250g", 1, 55);
        System.out.println(c.calcTotalExpense());
        LoyalCustomer lc = new LoyalCustomer("Ananya Roy", "roy.ananay20026@gmail.com", 0.15f);
        lc.addPurchase("Eggs", 12, 10);
        lc.addPurchase("Chicken 250g", 1, 55);
        lc.applyDiscount();
        System.out.println(lc.getFinalExpense());
    }
}
