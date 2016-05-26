/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package map;

import java.io.File;
import java.util.*;



/**
 *
 * @author hcps-lesleyjm
 */
public class DistrictColorFinder{
    
    String[] state = {"AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
        /*"HI.txt",*/ "ID", "IL", "IN",  "KS", "KY", "LA", "MA", "MD", "ME", "MI", 
        "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", 
        "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
        "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY", "USA"};
    public int[][][] stateColorFind(int year) throws Exception{ //takes in the year based on the button pressed
        int[][][] rgbInOrderOfStates = new int[48][200][3];
        int p = 0;
        for(int i = 0; i < 48; i ++){ //loops through the inland state name abbreviations
            File file = new File(state[i] + "" + year + ".txt"); //finds a new file each loop
            Scanner scan = new Scanner(file);// creates a scanner of the new file each loop
            int rTotal = 0;
            int dTotal = 0; //sets the total votes to zero each new state
            int iTotal = 0;
            
            scan.nextInt();
            int d = 0;
            d = 0;
            while(scan.hasNextInt()){
                d++;
               scan.nextInt();
               rgbInOrderOfStates[i][d][0] = scan.nextInt();
               rgbInOrderOfStates[i][d][1] = scan.nextInt();
               rgbInOrderOfStates[i][d][2] = scan.nextInt();//adds the next number of votes to the parties total
                
            }
            
        }
        return rgbInOrderOfStates;
    
    }
}
