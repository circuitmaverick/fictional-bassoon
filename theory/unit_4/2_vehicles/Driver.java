class Vehicle {
    private String make, model, year;

    public Vehicle(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return "Model: "+model+"\nMake: "+make+"Year"+year;
    }
}

class Truck extends Vehicle {
    private float payloadCapacity;

    public Truck(String make, String model, String year, float payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    public String toString() {
        return super.toString()+"\nPayload Capacity: "+payloadCapacity;
    }
}

class Car extends Vehicle {
    private float trunkSize;

    public Car(String make, String model, String year, float trunkSize) {
        super(make, model, year);
        this.trunkSize = trunkSize;
    }

    public String toString() {
        return super.toString()+"\nTrunk Size: "+trunkSize;
    }
}

public class Driver {
    public static void main(String[] args) {
        Car car = new Car("Hyundai", "i20", "2018", 75);
        System.out.println(car);
        Truck truck = new Truck("Ashish Leyland", "Eicher", "2010", 180);
        System.out.println(truck);
    }
}
