/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kata09_v3;


import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import javax.naming.spi.DirStateFactory.Result;
import junit.framework.Assert;
 
import org.junit.jupiter.api.Test;
/**
 *
 * @author areebakamil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 
        System.out.println("Initializing special prices..."); 
        
        Map<String, Item> specialPrices = new HashMap<>(); 
        specialPrices.put("A", new Item(50, 3, 130));
        specialPrices.put("B", new Item(30, 2, 45));
        specialPrices.put("C", new Item(20));
        specialPrices.put("D", new Item(15));
        
        CalcPrice calcPrice = new CalcPrice(specialPrices);
        
        System.out.println("Initialization complete"); 

  
        //Take input from user on the options
        Scanner option_scanner  = new Scanner(System.in);  
        System.out.println("Press 1 to enter all items or press 2 to scan incrementally");

        String opt_selected = option_scanner.nextLine();  // Read user input
        

        try {
            
            int opt = Integer.parseInt(opt_selected);
            
            if (opt == 1){
            System.out.println("calculate totals..");
            
            Scanner items_ent  = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter items");
            String itemsBought = option_scanner.nextLine();  // Read user input
            items_ent.close();
            
            
            CheckOut co = new CheckOut(calcPrice);
            co.scanAll(itemsBought); 
            
            System.out.println("Total price: " + co.total());  
            
            } 
            
            else if (opt == 2) {
                
                CheckOut co = new CheckOut(calcPrice);
                System.out.println("calculating incremental..."); 


               
                while(true)
                {
                     System.out.println("Scan item or press 0 to exit");
                    String itemScanned = option_scanner.nextLine();  // Read user input
                    String item = itemScanned.toString();
                    if (!item.equals("0"))
                    {
                        if(specialPrices.containsKey(item.toUpperCase()))
                        {
                            co.scan(item);
                            System.out.println(co.getStrItemsScanned().toString()  +" - Total price: " + co.total());
                            
                        }
                        else
                        {
                            System.out.println("unknown item entered has been skipped");
                            continue;
                             
                        }
                        
                    }
                    else
                    {
                        System.out.println(co.getStrItemsScanned().toString()  +" - Total price: " + co.total()); 
                        break;
                    }

                }
              
            }
            else {
                System.out.println("invalid option entered"); 
//                 option_scanner.close();
           
            }
            
           
         
        
    } catch (final NumberFormatException e) {
        
        System.out.println("invalid option entered"); 
//        option_scanner.close();
        
    }
        
       
    }
    
            

   
    
   
    
  
}
