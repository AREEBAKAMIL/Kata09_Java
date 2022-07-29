/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kata09_v3;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author areebakamil
 */
public class CheckOutTest {
    
     CalcPrice calcPriceinstance = null;
     CheckOut co = null;
    
    public CheckOutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calcPriceinstance = new CalcPrice(initializeSpecialPrices());
        
    }
    
    @After
    public void tearDown() {
        
        calcPriceinstance = null;
        co = null;

    }


    /**
     * Test of total method, of class CheckOut.
     */
    @Test
    public void test_Totals() {
        
        System.out.println("Testing total ...");
        
        assertEquals(0, price(""));
        assertEquals(50, price("A"));
        assertEquals(80, price("AB"));
        assertEquals(115, price("CDBA"));
                
        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));
        
        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }
    
    @Test
    public void testincremental() {
        co = new CheckOut(calcPriceinstance);
        assertEquals(  0, co.total());
        co.scan("A");  assertEquals( 50, co.total());
        co.scan("B");  assertEquals( 80, co.total());
        co.scan("A");  assertEquals(130, co.total());
        co.scan("A");  assertEquals(160, co.total());
        co.scan("B");  assertEquals(175, co.total());
    }
    
    public Map<String, Item> initializeSpecialPrices() {
        System.out.println("inside initializeSpecialPrices");
        Map<String, Item> specialPrices = new HashMap<>(); 
        specialPrices.put("A", new Item(50, 3, 130));
        specialPrices.put("B", new Item(30, 2, 45));
        specialPrices.put("C", new Item(20));
        specialPrices.put("D", new Item(15));
        return specialPrices;
     
    }
    
      private int price(String strItemsScanned) {
          
          co = new CheckOut(calcPriceinstance);
          co.scanAll(strItemsScanned);
          return co.total();
            
    }
    
    
}
