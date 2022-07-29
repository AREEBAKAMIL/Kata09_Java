/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kata09_v3;

/**
 *
 * @author areebakamil
 */
public class Item {
    
    private int unitPrice;
    private int batchSize;
    private int batchPrice;

    public Item(int unitPrice, int batchSize, int batchPrice) {
        this.unitPrice = unitPrice;
        this.batchSize = batchSize;
        this.batchPrice = batchPrice;
    }

    public Item(int unitPrice) {
        this.unitPrice = unitPrice;
        this.batchSize = 1;
        this.batchPrice = unitPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public int getBatchPrice() {
        return batchPrice;
    }

 
}
