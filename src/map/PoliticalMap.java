/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;
import edu.princeton.cs.introcs.*;
//import data.AK;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap {
    
    static int numberTwo;
    static int holder = 0;
    
    public static void main(String[] args) throws Exception{
        
        ////////////////////////////////////////////////////////////////////////
        
        /*String text = "C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\map\\Abbreviations.txt";

        System.setIn(new FileInputStream(text));
        for(int i=0; i<=holder; i++){
            System.out.println(StdIn.readString());
            
        }
        */
        String [] abbreviations = {"AK.txt", "AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", /*"HI.txt",*/ "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt"};
        while(holder < abbreviations.length){
        
        
        String fileName = abbreviations[holder];
        holder++;
        System.out.println(fileName);
        
        /*String textTwo = "C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\" + fileName;
        System.setIn(new FileInputStream(textTwo));
        */File file = new File("C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\" + fileName);
        Scanner scan = new Scanner(file);
        /*
        System.out.println("hu" + StdIn.readString());
        
        System.out.println(("C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\AK.txt"));
        */
        
        //makes it so that you can see the pen.
        StdDraw.setPenRadius(0.0005);//changes the pen size
        StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color
        
        //Draws points at the highest and lowest points of the graph
        for(int i=0; i<2; i++){
            StdDraw.point(Math.abs(scan.nextDouble()/300), Math.abs(scan.nextDouble()/300));//scan.nextInt(), scan.nextInt());
        }//end for
        
            int number = scan.nextInt();//Gets the number of countries that make up the state
                        
            boolean keepGoing;
        
        //Plots the points of the country.
        for(int z=0; z<number; z++){    
            //Discards the name of the country, and the abbreviation of the state 
            
            boolean bad = true;
            String next;
            
            while(bad){
                if(scan.hasNext()){
                    next = scan.next();
                    
                    //System.out.println("next: " +  next);
                    
                    
                    if((next.charAt(0)<65)){

                        for(int i=0; i<next.length(); i++){
                            
                            numberTwo = Integer.parseInt(next);
                        }
                        
                        
                        bad = false;
                    }
                    
                }
                else{
                    bad = false;
                    keepGoing = false;
                }
                
            }
        
                               
        ////////////////////////////////////////////////////////////////////////
                    
        if(keepGoing = true){
            double[] x = new double[numberTwo+10];
            double[] y = new double[numberTwo+10];

            for(int i=0; i<numberTwo; i++){
                    StdDraw.point(Math.abs(scan.nextDouble()/200), Math.abs(scan.nextDouble()/200));
                    /*x[i] = Math.abs(StdIn.readDouble()/300);
                    y[i] = Math.abs(StdIn.readDouble()/300);
                }

                StdDraw.polygon(x, y);*/
            }
                numberTwo = 0;
                
                
                
            }
            
        
        
        }
        
    }
    }
}
