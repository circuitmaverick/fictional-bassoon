import java.util.ArrayList;
import java.util.List;

class Product {
    private String productID, description;
    private double price;

    public Product(String productID, String description, double price) {
        this.productID = productID;
        this.description = description;
        this.price = price;
    }

    public String toString() {
        return "Product(\n\t\tproductID:"+productID+",\n\t\tdescription:"+description+",\n\t\tprice:"+price+"\n\t\t)";
    }
}

class Supplier {
    private String supplierID, name;
    private ArrayList<Long> phoneNo = new ArrayList<Long>();
    private Product product;
    private Address address;

    public Supplier(String supplierID, String name, ArrayList<Long> phoneNo, Address address, Product product) {
        this.supplierID = supplierID;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.product = product;
    }

    public String toString() {
        return "Supplier(\n\tsupplierID:"+supplierID+",\n\tname:"+name+",\n\tphoneNo:"+phoneNo+",\n\t"+address+",\n\t"+product+"\n\t)";
    }
}

class Address {
    private String streetAddress, city;
    private long postcode;

    public Address(String streetAddress, String city, long postcode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
    }

    public String toString() {
        return "Address(\n\t\tstreetAddress:"+streetAddress+",\n\t\tcity:"+city+",\n\t\tpostcode:"+postcode+"\n\t\t)";
    }
}

public class Driver {
    public static void main(String[] args) {
        Product p = new Product("EGG200", "Pure organic white eggs", 120);
        ArrayList<Long> phones = new ArrayList<>();
        phones.add(8101895990l);
        phones.add(9883185384l);
        Address address = new Address("KIIT Rd, Patia", "Bhubaneswar", 751024);
        Supplier s = new Supplier("KNKEG", "Kenko Eggs", phones, address, p);
        System.out.println(s);
    }
}