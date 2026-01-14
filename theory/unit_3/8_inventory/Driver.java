import java.util.ArrayList;

class Product {
    private String ID, name;
    private int quantity, minQty;

    public Product(String ID, String name, int quantity, int minQty) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.minQty = minQty;
    }

    public String ID() { return ID; }

    public void take(int amt) { quantity-=amt; }

    public void put(int amt) { quantity+=amt; }

    public boolean checkLowInv() { return quantity<=minQty; }

    public String toString() {
        return "\nID: "+ID+"\nName: "+name+"\nQuantity: "+quantity;
    }
}

class Inventory {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProd(String ID, String name) {
        products.add(new Product(ID, name, 0, 50));
    }

    public void delProd(String ID) {
        for(Product p: products)
            if(p.ID() == ID) products.remove(p);
    }

    public void supplyIN(String ID, int batches, int batchsize) {
        int totalQty = batches*batchsize;
        for(Product p: products)
            if(p.ID() == ID) p.put(totalQty);
    }

    public void supplyOUT(String ID, int batches, int batchsize) {
        int totalQty = batches*batchsize;
        for(Product p: products)
            if(p.ID() == ID)
                if(p.checkLowInv()) System.out.println("Low inventory, can't supply out.");
                else p.take(totalQty);
    }

    public String toString() {
        String str="\nInventory----\n";
        for(Product p: products) str+=p;
        return str;
    }
}

public class Driver {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProd("AP02", "Apple");
        inv.addProd("MT94", "Mutton");
        inv.supplyIN("AP02", 93, 60);
        inv.supplyIN("MT94", 10, 100);
        System.out.println(inv);
        inv.supplyOUT("AP02", 554, 10);
        System.out.println(inv);
        inv.supplyOUT("AP02", 10, 10);
        System.out.println(inv);
        inv.delProd("AP02");
        inv.supplyOUT("MT94", 10, 20);
        System.out.println(inv);
    }
}
