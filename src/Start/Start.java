package Start;

import attr.*;
import activity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        GrabFoodSystem grabFoodSystem = new GrabFoodSystem();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 8) {
            System.out.println("Welcome to GrabFoodSystem:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Driver");
            System.out.println("3. Place Order");
            System.out.println("4. Assign Driver to Order");
            System.out.println("5. Display All Orders");
            System.out.println("6. Display Customers");
            System.out.println("7. Display Drivers");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after nextInt()

                switch (choice) {
                    case 1:
                        addCustomer(grabFoodSystem, scanner);
                        break;
                    case 2:
                        addDriver(grabFoodSystem, scanner);
                        break;
                    case 3:
                        placeOrder(grabFoodSystem, scanner);
                        break;
                    case 4:
                        assignDriver(grabFoodSystem, scanner);
                        break;
                    case 5:
                        grabFoodSystem.displayAllOrders();
                        break;
                    case 6:
                        displayCustomers(grabFoodSystem);
                        break;
                    case 7:
                        displayDrivers(grabFoodSystem);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void addCustomer(GrabFoodSystem grabFoodSystem, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = new Customer(name, address, phoneNumber, customerId);
        grabFoodSystem.addCustomer(customer);
    }

    private static void addDriver(GrabFoodSystem grabFoodSystem, Scanner scanner) {
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter driver address: ");
        String address = scanner.nextLine();
        System.out.print("Enter driver phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter driver ID: ");
        String driverId = scanner.nextLine();

        Driver driver = new Driver(name, address, phoneNumber, driverId);
        grabFoodSystem.addDriver(driver);
    }

    private static void placeOrder(GrabFoodSystem grabFoodSystem, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = grabFoodSystem.findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        List<OrderItem> items = new ArrayList<>();
        int itemId = 1;
        while (true) {
            System.out.print("Enter item name (type 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter price per item: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character after nextDouble()

            OrderItem item = new OrderItem(itemId++, itemName, quantity, price);
            items.add(item);
        }

        System.out.print("Enter delivery address: ");
        String deliveryAddress = scanner.nextLine();

        grabFoodSystem.placeOrder(customer, items, deliveryAddress);
    }

    private static void assignDriver(GrabFoodSystem grabFoodSystem, Scanner scanner) {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        System.out.print("Enter driver ID: ");
        String driverId = scanner.nextLine();
        Driver driver = grabFoodSystem.findDriver(driverId);

        if (driver == null) {
            System.out.println("Driver not found.");
            return;
        }

        grabFoodSystem.assignDriver(orderId, driver);
    }
    

    private static void displayCustomers(GrabFoodSystem grabFoodSystem) {
        List<Customer> customers = grabFoodSystem.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("List of Customers:");
            for (Customer customer : customers) {
                System.out.println("Customer ID: " + customer.getCustomerId());
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone Number: " + customer.getPhoneNumber());
                System.out.println("-------------------------");
            }
        }
    }

    private static void displayDrivers(GrabFoodSystem grabFoodSystem) {
        List<Driver> drivers = grabFoodSystem.getDrivers();
        if (drivers.isEmpty()) {
            System.out.println("No drivers found.");
        } else {
            System.out.println("List of Drivers:");
            for (Driver driver : drivers) {
                System.out.println("Driver ID: " + driver.getDriverId());
                System.out.println("Name: " + driver.getName());
                System.out.println("Address: " + driver.getAddress());
                System.out.println("Phone Number: " + driver.getPhoneNumber());
                System.out.println("-------------------------");
            }
        }
    }
}
