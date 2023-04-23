package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductController {
    public List<Product> createProductList() {
        List<Product> productos = new ArrayList<Product>();
        productos.add(new Product("Galletas", 1.50, 10));
        productos.add(new Product("Chocolates", 1.10, 10));
        productos.add(new Product("Bebida", 1.05, 10));
        productos.add(new Product("Bocadillo", 1.75, 10));
        return productos;
    }
}
