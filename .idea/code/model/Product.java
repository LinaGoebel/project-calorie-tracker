package model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private String name;
    private int calories;

    public Product(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product product)) {
            return false;
        }
        return calories == product.calories && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}