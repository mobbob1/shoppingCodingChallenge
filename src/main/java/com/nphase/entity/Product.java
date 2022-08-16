package com.nphase.entity;

import java.math.BigDecimal;

public class Product {
    
    private final String name;
    private final BigDecimal pricePerUnit;
    private final int quantity;
    private final String categoryId;

//Modified the Constructor by adding category to it
    public Product(String name, BigDecimal pricePerUnit, int quantity, String categoryId) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }
    
    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
//    public int getCategoryId() {
//        return categoryId;
//    }

    public String getCategoryId() {
        return categoryId;
    }
}
