/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nphase.entity;

/**
 *
 * @author MOB
 */
public class Discount {
    
    private int noOfItems;
    private double discount;
    private Product product;

    public Discount(int noOfItems, double discount, Product product) {
        this.noOfItems = noOfItems;
        this.discount = discount;
        this.product = product;
    }
    
    

    public int getNoOfItems() {
        return noOfItems;
    }

    public double getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }
    
    
}
