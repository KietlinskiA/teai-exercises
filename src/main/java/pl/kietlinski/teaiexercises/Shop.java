package pl.kietlinski.teaiexercises;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Shop {
    private final List<Product> products;

    protected Shop() {
        products = new ArrayList<>();
        products.add(new Product("Jabłko", 5.0));
        products.add(new Product("Gruszka", 10.0));
        products.add(new Product("Żelazko", 15.0));
        products.add(new Product("Piłka", 20.0));
        products.add(new Product("Koszyk", 25.0));
    }

    protected void getInfo() {
        System.out.println(getClass().getSimpleName());
        products.forEach(System.out::println);
    }
}
