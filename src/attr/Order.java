package attr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import activity.Customer;

public class Order {
    private int orderId;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDateTime orderTime;
    private double totalAmount;
    private String deliveryAddress;

    public Order(int orderId, Customer customer, String deliveryAddress) {
        this.orderId = orderId;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

	public void setItems(List<OrderItem> items2) {
		// TODO Auto-generated method stub
		
	}
}
