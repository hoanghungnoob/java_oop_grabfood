package attr;
import activity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrabFoodSystem {
    private Map<Integer, Order> orders;
    private Map<String, Customer> customers;
    private Map<String, Driver> drivers;

    public GrabFoodSystem() {
        this.orders = new HashMap<>();
        this.customers = new HashMap<>();
        this.drivers = new HashMap<>();
    }
    public Customer findCustomer(String customerId) {
        return customers.get(customerId);
    }    
    public Driver findDriver(String driverId) {
        return drivers.get(driverId);
    }
    public void placeOrder(Customer customer, List<OrderItem> items, String deliveryAddress) {
        int orderId = generateOrderId();
        Order order = new Order(orderId, customer, deliveryAddress);
        for (OrderItem item : items) {
            order.addItem(item);
        }
        orders.put(orderId, order);
        System.out.println("Order placed successfully. Order ID: " + orderId);
    }

    public void assignDriver(int orderId, Driver driver) {
        Order order = orders.get(orderId);
        if (order != null) {
            // Assign driver to order
            System.out.println("Driver assigned to Order ID " + orderId + ": " + driver.getName());
        } else {
            System.out.println("Order ID " + orderId + " not found.");
        }
    }
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }
    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers.values());
    }
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        System.out.println("Customer added successfully. Customer ID: " + customer.getCustomerId());
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
        System.out.println("Driver added successfully. Driver ID: " + driver.getDriverId());
    }

    private int generateOrderId() {
        // Logic to generate unique order ID
        return orders.size() + 1;
    }

    public void displayAllOrders() {
        System.out.println("All Orders:");
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            int orderId = entry.getKey();
            Order order = entry.getValue();
            System.out.println("Order ID: " + orderId);
            System.out.println("Customer: " + order.getCustomer().getName());
            System.out.println("Items:");
            for (OrderItem item : order.getItems()) {
                System.out.println("- " + item.getItemName() + ": " + item.getPrice());
            }
            System.out.println("Total Amount: " + order.getTotalAmount());
            System.out.println("Delivery Address: " + order.getDeliveryAddress());
            System.out.println("------------------------------");
        }
    }

}

