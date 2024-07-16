package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dao.CalorieImpl;
import java.util.List;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalorieImplTest {

  // Declare a variable for testing
  private CalorieImpl calorie;

  @BeforeEach
  void setUp() {
    // Create a new instance of CalorieImpl before each test
    calorie = new CalorieImpl();
  }

  @Test
  void addProduct() {
    // Create a new product
    Product apple = new Product("Apple", 50);
    // Add the product to the calorie manager
    calorie.addProduct(apple);

    // Get the list of products
    List<Product> productList = calorie.getProductList();
    // Check that the product list is not empty
    assertFalse(productList.isEmpty(), "The list of products should not be empty");
    // Check that there is one product in the list
    assertEquals(1, productList.size(), "There should be one product in the list");
    // Check that the product in the list is the one that was added
    assertEquals(apple, productList.get(0), "The product in the list should be the one added");
  }

  @Test
  void listProducts() {
    // Create a new product
    Product apple = new Product("Apple", 50);
    // Add the product to the calorie manager
    calorie.addProduct(apple);
    // List the products
    calorie.listProducts();
  }

  @Test
  void removeProduct() {
    // Create a new product
    Product apple = new Product("Apple", 50);
    // Add the product to the calorie manager
    calorie.addProduct(apple);

    // Remove the product from the calorie manager
    calorie.removeProduct("Apple");
    // Get the list of products
    List<Product> productList = calorie.getProductList();
    // Check that the product list is empty after removal
    assertTrue(productList.isEmpty(), "The list of products should be empty after removal");
  }

  @Test
  void saveAndLoadProducts() {
    // Create new products
    Product apple = new Product("Apple", 50);
    Product banana = new Product("Banana", 80);
    // Add the products to the calorie manager
    calorie.addProduct(apple);
    calorie.addProduct(banana);

    // Save the products to a file
    calorie.saveProducts("products.dat");

    // Load the products from the file
    calorie.loadProducts("products.dat");

    // Get the list of products
    List<Product> productList = calorie.getProductList();
    // Check that the product list is not empty after loading
    assertFalse(productList.isEmpty(), "The list of products should not be empty after loading");
    // Check that there are two products in the list
    assertEquals(2, productList.size(), "There should be two products in the list");
    // Check that the list contains the apple product
    assertTrue(productList.contains(apple), "The list should contain the apple product");
    // Check that the list contains the banana product
    assertTrue(productList.contains(banana), "The list should contain the banana product");
  }

  @Test
  void productListCSV() {
    // Load products from the CSV file
    List<Product> products = calorie.productListCSV();
    // Check that the product list is not null
    assertNotNull(products, "The product list should not be null");
    // Check that the product list is not empty
    assertFalse(products.isEmpty(), "The product list should not be empty");

    // Additional checks for specific products
    assertTrue(products.contains(new Product("Apple", 95)),
        "The product list should contain an Apple with 95 calories");
  }
}