

package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Product;

public class CalorieImpl implements Calorie {

    // List to store products
    private List<Product> productList;

    // Constructor initializes the product list
    public CalorieImpl() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        // Add a product to the product list
        productList.add(product);
    }

    @Override
    public void listProducts() {
        // Print out the list of products
        System.out.println("Your list of products:");
        productList.forEach(System.out::println);
    }

    @Override
    public void removeProduct(String productName) {
        // Remove a product from the list by its name
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(productName)) {
                iterator.remove();
                System.out.println("Product removed: " + productName);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    @Override
    public void saveProducts(String filename) {
        // Save the list of products to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(productList);
            System.out.println("Products saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadProducts(String filename) {
        // Load the list of products from a file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            productList = (List<Product>) ois.readObject();
            System.out.println("Products loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> productListCSV() {
        // Load the list of products from a CSV file
        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\galin\\OneDrive\\Desktop\\calorie__tracker\\src\\product.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 2) {
                    String name = data[0].trim();
                    int calories = Integer.parseInt(data[1].trim());
                    productList.add(new Product(name, calories));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    // Getter for productList
    public List<Product> getProductList() {
        return productList;
    }
}



