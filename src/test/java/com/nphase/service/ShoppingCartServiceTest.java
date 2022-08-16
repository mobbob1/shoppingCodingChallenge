package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;


public class ShoppingCartServiceTest {
    
   
    private final ShoppingCartService service = new ShoppingCartService();

    @Test
    public void calculatesPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 2, ""),
                new Product("Coffee", BigDecimal.valueOf(6.5), 1, "")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(16.5));
    }

    /**
     *
     */
    @Test
    public void calculatesDiscountPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 5, ""),
                //                new Product("Cocoa", BigDecimal.valueOf(7.0), 4),
                new Product("Coffee", BigDecimal.valueOf(3.5), 3, "")
        ));

        BigDecimal result = service.calculateBulkDiscount(cart);
        Assertions.assertEquals(new BigDecimal("33.00"), result);
    }

    @Test
    public void calculatesDiscountCategoryPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
                new Product("Cheese", BigDecimal.valueOf(8), 2, "foods")
        ));
        BigDecimal resultt = service.calculateBulkDiscountOnCategory(cart);
        System.out.println("total after applying discount " + resultt);
        Assertions.assertEquals(resultt, new BigDecimal("31.84"));
    }
    
    @Test
    public void calculatesConfigurableDiscount() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
                new Product("Cheese", BigDecimal.valueOf(8), 2, "foods")
        ));
        cart.setDiscountQuantity(2);
        cart.setDiscount(20);
        
        Assertions.assertEquals(cart.getDiscount(), 20);
    }

}
