/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kata09_v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author areebakamil
 */
public class CalcPrice{
    
    private Map<String, Item> specialPrices;
    
    
    public CalcPrice(Map<String, Item> specialPrices) {
        this.specialPrices = specialPrices;
        System.out.println("   inside CalcPrice class constrcutor");
    }

   
    public int calculateTotalPrice(Collection<String> scannedItems) {
        System.out.println("   calculating total price");
        return scannedItems.stream() 
                .collect(groupingBy(x -> x, counting())) //group items
                .entrySet().stream()
                .map(x -> totalPricePerItem(x.getKey(), x.getValue())) //map each item on to its price. Price per item is calculated 
                .mapToInt(Integer::intValue) 
                .sum(); //sum all prices-per-item
    }
    


    private int totalPricePerItem(String name, long quantity) {
        if(!specialPrices.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Unknown item found '%s'", name));
        }

        Item price = specialPrices.get(name);

        int specialBatchSize = price.getBatchSize();
        int specialPrice = price.getBatchPrice();
        int unitPrice = price.getUnitPrice();

        int batchCount = (int) (quantity / specialBatchSize);
        int remainder = (int) (quantity % specialBatchSize);
        int total = batchCount * specialPrice + remainder * unitPrice;
        
//        System.out.println(name + ":" + total);
        
        return total;
    }
}
