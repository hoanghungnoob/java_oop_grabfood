package activity;
import attr.Person;
public class Driver extends Person {
    private String driverId;

    public Driver(String name, String address, String phoneNumber, String driverId) {
        super(name, address, phoneNumber);
        this.driverId = driverId;
    }

    public String getDriverId() {
        return driverId;
    }

    
    @Override
    public void displayInfo() {
        System.out.println("Driver Name: " + getName());
        System.out.println("Driver Address: " + getAddress());
        System.out.println("Driver Phone Number: " + getPhoneNumber());
        System.out.println("Driver ID: " + driverId);
    }
}
