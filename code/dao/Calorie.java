package dao;

import java.util.List;
import model.Product;

    public interface Calorie {

        void addProduct(Product product);

        void listProducts();

        void removeProduct(String productName);

        void saveProducts(String filename);

        void loadProducts(String filename);

        List<Product> productListCSV();
    }
}
