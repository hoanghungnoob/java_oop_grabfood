package activity;
import attr.Person;
public class Customer extends Person {
    private String customerId;

    public Customer(String name, String address, String phoneNumber, String customerId) {
        super(name, address, phoneNumber);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Name: " + getName());
        System.out.println("Customer Address: " + getAddress());
        System.out.println("Customer Phone Number: " + getPhoneNumber());
        System.out.println("Customer ID: " + customerId);
    }
}
