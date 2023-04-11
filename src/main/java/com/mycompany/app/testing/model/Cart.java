package com.mycompany.app.testing.model;

import lombok.Getter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private List<Product> products = new ArrayList<>();

    public void add(Product product){
        this.products.add(product);
    }

    public float getTotalPrice(){
        return (float) this.products.stream().mapToDouble(v -> v.getPrice()).sum();
    }

    public void remove(Product product){
        this.products.remove(product);
    }

    public void emptyCart(){
        this.products.clear();
    }
}
