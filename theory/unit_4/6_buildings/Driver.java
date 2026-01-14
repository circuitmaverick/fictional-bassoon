class Building {
    private String address;
    private int floors;
    private double area;

    public Building(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
    }

    public double __area__() { return area; }

    public String toString() { return "Building(address="+address+",floors="+floors+",area="+area+")"; }
}

class ResidentialBuilding extends Building {
    private int apartments;
    private double rate = 500;

    public ResidentialBuilding(String address, int floors, double area, int apartments) {
        super(address, floors, area);
        this.apartments = apartments;
    }

    public double calcRent() {
        return rate*__area__();
    }

    public String toString() {
        return "ResidentialBuilding("+super.toString()+",aparments="+apartments+",rate="+rate+")";
    }
}

class CommercialBuilding extends Building {
    private int offices;
    private double rate = 450;

    public CommercialBuilding(String address, int floors, double area, int offices) {
        super(address, floors, area);
        this.offices = offices;
    }

    public double calcRent() {
        return rate*__area__();
    }

    public String toString() {
        return "CommercialBuilding("+super.toString()+",offices="+offices+",rate="+rate+")";
    }
}



public class Driver {
    public static void main(String[] args) {
        ResidentialBuilding rb = new ResidentialBuilding("123/A Oak St, New York, USA, 10012", 20, 7600, 10000);
        CommercialBuilding cb = new CommercialBuilding("893/D Birch St, New Jersey, USA, 10453", 12, 6012, 500);
        System.out.println(rb);
        System.out.println("Rent: "+rb.calcRent());
        System.out.println(cb);
        System.out.println("Rent: "+cb.calcRent());
    }
}
