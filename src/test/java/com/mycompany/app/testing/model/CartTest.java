package com.mycompany.app.testing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InitialContext;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        fillCart(cart);
    }

    private void fillCart(Cart cart){
        this.cart.getProducts().add(new Product("Table", 100));
        this.cart.getProducts().add(new Product("Chaise", 100));
        this.cart.getProducts().add(new Product("Horloge", 150));
    }

    @Test
    void add() {
        int initialSize = this.cart.getProducts().size();

        this.cart.add(new Product("Canape", 200));

        Assertions.assertTrue(this.cart.getProducts().size() - initialSize == 1);
    }

    @Test
    void getTotalPrice() {
        double total = this.cart.getProducts().stream().mapToDouble( v -> v.getPrice()).sum();

        float totalPrice = cart.getTotalPrice();

        Assertions.assertEquals(totalPrice, total);
    }

    @Test
    void remove() {
        int initialSize = this.cart.getProducts().size();
        Product p = this.cart.getProducts().get(0);

        this.cart.remove(p);

        Assertions.assertTrue(this.cart.getProducts().size() == initialSize - 1);
    }

    @Test
    void emptyCart() {
        this.cart.emptyCart();

        Assertions.assertTrue(this.cart.getProducts().isEmpty());
    }
}
