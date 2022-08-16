package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class ShoppingCartService {
    
    public static final double ITEM_DISCOUNT = 0.1;
    

    //Calculate the Total Price Task 1
    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
    
    //Calculate the discount   Task 2
    public BigDecimal calculateBulkDiscount(ShoppingCart shoppingCart) {    
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        for(Product product : shoppingCart.getProducts()){
            if(product.getQuantity() > 3){
                discount = discount.add(product.getPricePerUnit().subtract(product.getPricePerUnit().multiply(BigDecimal.valueOf(ITEM_DISCOUNT)), MathContext.DECIMAL128)
                        .multiply(BigDecimal.valueOf(product.getQuantity())));
            }else {
                total = discount.add(product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())));
                
            }
           
        }
                return total;
    }
    
    //Calculate the category discount Task 3
    public BigDecimal calculateBulkDiscountOnCategory(ShoppingCart shoppingCart) {    
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        List<Product> products = shoppingCart.getProducts();
        
        Map<String, List<Product>> map = products.stream()
                .collect(groupingBy(Product::getCategoryId));
        
        System.out.println(map);
       
        Set<String> keys = map.keySet();
        for(String key : keys){
            if(map.get(key).size() > 1){
                for(Product item : map.get(key)){
                    BigDecimal cost = item.getPricePerUnit().multiply(BigDecimal.valueOf(item.getQuantity()));
                    cost = cost.subtract(cost.multiply(BigDecimal.valueOf(ITEM_DISCOUNT)));
                 
                    discount = discount.add(cost);
                }
            }else{
                for(Product item : map.get(key)){
                    total = item.getPricePerUnit() .multiply(BigDecimal.valueOf(item.getQuantity()));
                }
                 
            }
        }
        
        total = total.add(discount);
       
        System.out.println("discounts applied " + discount);
        System.out.println("total after applying discount " + total);
        return total;
    }
    
    //Calculate the discount   Task 4
    public BigDecimal calculateConfigurableBulkDiscount(ShoppingCart shoppingCart) {    
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        for(Product product : shoppingCart.getProducts()){
            if(product.getQuantity() > shoppingCart.getDiscountQuantity()){
                discount = discount.add(product.getPricePerUnit().subtract(product.getPricePerUnit().multiply(BigDecimal.valueOf(shoppingCart.getDiscount()/100.00)), MathContext.DECIMAL128)
                        .multiply(BigDecimal.valueOf(product.getQuantity())));
            }else {
                total = discount.add(product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())));
                
            }
           
        }
        return total;
    }
}
