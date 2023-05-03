import java.util.ArrayList;

public class Order {
    private int orderId;
    private Cart cart;
    private double totalPrice;
    private String shippingAddress;
    private String billingAddress;

    public Order(int orderId, Cart cart, double totalPrice, String shippingAddress, String billingAddress) {
        this.orderId = orderId;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public static Order getOrder(ArrayList<Order> orders, int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public static boolean deleteOrder(ArrayList<Order> orders, int orderId) {
        Order orderToRemove = getOrder(orders, orderId);
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
            return true;
        }
        return false;
    }

    public static void printAllItems(ArrayList<Order> orders) {
        for (Order order : orders) {
            System.out.println("Order #" + order.getOrderId() + ":");
            for (Products product : order.getCart().getAllItems()) {
                System.out.println("  " + product.getName() + " - " + product.getDescription() + " - $" + product.getPrice() + " - Quantity: " + product.getQuantity());
            }
            System.out.println("Total Price: $" + order.getTotalPrice());
            System.out.println("Shipping Address: " + order.getShippingAddress());
            System.out.println("Billing Address: " + order.getBillingAddress());
        }
    }
}