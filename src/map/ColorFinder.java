/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Scanner;



/**
 *
 * @author hcps-lesleyjm
 */
public class ColorFinder{
    String[] state = {"AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
        /*"HI.txt",*/ "", "ID", "IL", "IN",  "KS", "KY", "LA", "MA", "MD", "ME", "MI", 
        "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", 
        "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
        "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY", "USA"};
    public /*static int[]*/ void colorFind(int year, Scanner scan){ 
        int numOn = 0;
        int total = 0;
        int rtotal = 0;
        int dtotal = 0;
        scan.nextInt();
        for(int o = 0; o < 49; o++){
            scan.nextInt();
            if(scan.hasNextInt()){
                numOn ++;
                int h = scan.nextInt();
                total = total + h;
                if(numOn % 3 == 0){
                    rtotal = rtotal + h;
                }
                else{
                    dtotal = dtotal + h;
                }
            }
            
        }
   
    
    }
}
