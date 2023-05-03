import java.util.ArrayList;

public class Cart implements CartInterface {
    private ArrayList<Products> items;

    public Cart() {
        items = new ArrayList<Products>();
    }

    @Override
    public void addItem(Products product) {
        items.add(product);
    }

    @Override
    public void removeItem(Products product) {
        items.remove(product);
    }

    @Override
    public ArrayList<Products> getAllItems() {
        return items;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Products product : items) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }
}

interface CartInterface {
    void addItem(Products product);

    void removeItem(Products product);

    ArrayList<Products> getAllItems();

    double getTotalPrice();
}
