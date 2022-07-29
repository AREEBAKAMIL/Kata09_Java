/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kata09_v3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author areebakamil
 */
public class CheckOut {
    
    private final CalcPrice calcprice;
    private List<String> itemsScanned = new LinkedList<>();

    public CheckOut(CalcPrice calcprice) {
        this.calcprice = calcprice;
    }

    public int total() {
        return calcprice.calculateTotalPrice(itemsScanned);
    }
    
    public void scan(String s) {
        itemsScanned.add(s.toUpperCase());
    }
    
    public void scanAll(String allItems) {
        
        for(int i=0; i<allItems.length(); i++) {
            this.itemsScanned.add(String.valueOf(allItems.charAt(i)).toUpperCase());
         }
    }
    

    public String getStrItemsScanned(){
        
        return Arrays.toString(this.itemsScanned.toArray());
        
    }
    
    
    
}
