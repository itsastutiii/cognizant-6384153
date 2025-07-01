// Exercise 1: Inventory Management System

import java.util.*;

class Product {
    public int productId;
    public String productName;
    public int quantity;
    public double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Store {
    private HashMap<Integer, Product> products;

    public Store() {
        products = new HashMap<>();
    }

    public void addProduct(Product p) {
        products.put(p.productId, p);
    }

    public void updateProduct(int productId, int newQty, double newPrice) {
        Product p = products.get(productId);
        if (p != null) {
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void search(String query) {
        System.out.println("Search results for: " + query);
        boolean found = false;

        for (Product p : products.values()) {
            if (p.productName.toLowerCase().contains(query.toLowerCase())) {
                System.out.println(p.productId + " - " + p.productName + " - Qty: " + p.quantity + " - ₹" + p.price);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No product found.");
        }
    }

    public void displayAll() {
        System.out.println("All products:");
        for (Product p : products.values()) {
            System.out.println(p.productId + ". " + p.productName + " - Qty: " + p.quantity + " - ₹" + p.price);
        }
    }
}

public class StoreManagement {
    public static void main(String[] args) {
        Store s = new Store();

        s.addProduct(new Product(1, "Tata - Salt", 100, 20.0));
        s.addProduct(new Product(2, "ToothBrush", 50, 15.5));
        s.addProduct(new Product(3, "Water Bottle", 30, 25.0));
        s.addProduct(new Product(4, "Towel", 20, 100.0));

        Scanner scanner = new Scanner(System.in);
        String searchItem;

        System.out.println("....STORE....");
        s.displayAll();

        System.out.print("\nEnter product name to search: ");
        searchItem = scanner.nextLine();
        s.search(searchItem);

        // Example update
        System.out.print("\nEnter product ID to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter new quantity: ");
        int newQty = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        s.updateProduct(updateId, newQty, newPrice);

        // Example delete
        System.out.print("\nEnter product ID to delete: ");
        int deleteId = scanner.nextInt();
        s.deleteProduct(deleteId);

        System.out.println("\nUpdated product list:");
        s.displayAll();

        scanner.close();
    }
}
