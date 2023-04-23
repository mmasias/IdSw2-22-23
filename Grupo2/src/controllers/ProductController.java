package controllers;

import java.util.ArrayList;
import java.util.List;

import models.ProductModel;

public class ProductController {
    public List<ProductModel> createProductList() {
        List<ProductModel> products = new ArrayList<ProductModel>();
        products.add(new ProductModel("Galletas", 1.50, 10));
        products.add(new ProductModel("Chocolates", 1.10, 10));
        products.add(new ProductModel("Bebida", 1.05, 10));
        products.add(new ProductModel("Bocadillo", 1.75, 10));
        return products;
    }
}
