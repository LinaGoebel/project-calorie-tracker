package calorieTracker;

import static model.Menu.ADD;
import static model.Menu.EXIT;
import static model.Menu.LIST;
import static model.Menu.LOAD;
import static model.Menu.REMOVE;
import static model.Menu.SAVE;

import dao.Calorie;
import dao.CalorieImpl;
import java.util.Scanner;
import model.Menu;
import model.Product;

public class CalcCalorieAppl {

  public static void main(String[] args) {
    // Create a Scanner object for reading user input
    Scanner scanner = new Scanner(System.in);
    // Create an instance of CalorieImpl to manage products
    Calorie calorieManager = new CalorieImpl();
    // Boolean to keep track of whether the application is running
    boolean running = true;

    // Main loop for the application
    while (running) {
      // Print menu options
      System.out.println("Choose an option:");
      for (Menu menu : Menu.values()) {
        System.out.println(menu.getValue() + ". " + menu.getDescription());
      }

      // Read user's choice
      int choice = scanner.nextInt();
      // Consume newline character
      scanner.nextLine();

      try {
        // Get the menu option based on the user's choice
        Menu menuOption = Menu.fromValue(choice);

        // Perform action based on the selected menu option
        switch (menuOption) {
          case ADD:
            // Prompt for product name and calories, then add the product
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            System.out.println("Enter product calories:");
            int calorie = scanner.nextInt();
            scanner.nextLine();  // consume newline
            calorieManager.addProduct(new Product(name, calorie));
            break;
          case LIST:
            // List all products
            calorieManager.listProducts();
            break;
          case REMOVE:
            // Prompt for product name to remove, then remove the product
            System.out.println("Enter product name to remove:");
            String removeName = scanner.nextLine();
            calorieManager.removeProduct(removeName);
            break;
          case SAVE:
            // Prompt for filename and save products to the file
            System.out.println("Enter filename to save:");
            String saveFilename = scanner.nextLine();
            calorieManager.saveProducts(saveFilename);
            break;
          case LOAD:
            // Prompt for filename and load products from the file
            System.out.println("Enter filename to load:");
            String loadFilename = scanner.nextLine();
            calorieManager.loadProducts(loadFilename);
            break;
          case EXIT:
            // Exit the application
            running = false;
            break;
        }
      } catch (IllegalArgumentException e) {
        // Handle invalid menu choice
        System.out.println("Invalid choice. Please try again.");
      }
    }

    // Close the scanner
    scanner.close();
  }
}
