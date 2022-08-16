package com.nphase.entity;

import java.util.List;

public class ShoppingCart {
    private final List<Product> products;
    
    /**
     * Configurable properties for 
     * calculating discount 
     */
    private int discountQuantity;
    private double discount;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getDiscountQuantity() {
        return discountQuantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscountQuantity(int discountQuantity) {
        this.discountQuantity = discountQuantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
}
