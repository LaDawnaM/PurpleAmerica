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
    
    static int numberTwo;//Used to hold the number of states being used.
    static int holder = 0;//Lets the program know which state file should be read in next  
    
    public static void main(String[] args) throws Exception{
        
        ////////////////////////////////////////////////////////////////////////
        //Creates a string array holding all the abbreviation names. Used to call the different files.
        String [] abbreviations = {"AK.txt", "AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", "HI.txt", "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt"};
        
        StdDraw.setCanvasSize(1200, 600);//sets the canvas size
        
        //Causes the program to repeat until all the countries in the states have been built.
        while(holder < abbreviations.length){
        
            boolean keepGoing = true;//A variable later used to tell the program whether or not it has another country to construct.
            String fileName = abbreviations[holder];//Selects the country to be drawn.
            holder++;//Increments the number to ensure none of  the states are constantly repeated.
            
            System.out.println(fileName);//Prints the name of the state currently being drawn [[unneccessary]]
              
            File file = new File("C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\" + fileName);//Creates a file of the state about to be drawn.
            Scanner scan = new Scanner(file);//Makes the scanner to read from the file.
            
            //makes it so that you can see the pen.
            StdDraw.setPenRadius(0.0005);//changes the pen size
            StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color

            //Draws points at the highest and lowest points of the graph
            for(int i=0; i<2; i++){
                StdDraw.point(Math.abs(scan.nextDouble()/300), Math.abs(scan.nextDouble()/300));
            }//end for

                int number = scan.nextInt();//Gets the number of countries that make up the state

                

            //Plots the points of the country.
            for(int z=0; z<number; z++){    
                //Discards the name of the country, and the abbreviation of the state 

                boolean bad = true;//Tells the program there are still non-coordinites to be gotten rid of
                String next;//Used to hold the non-coordinates

                while(bad){
                    //Contingency for the odd naming in Hawaii
                    if(fileName.equals("HI.txt")){
                        //Discards the numbered name of Hawaii
                        scan.next();
                        scan.next();
                        
                        next = scan.next();//Saves the next number
                        
                        //Ensures that the next number is the one we want.
                        if((next.charAt(0)<65)){
                            
                            numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
                            bad = false;//Tells the program to move on to drawing the country.

                        }//end if

                    }//end if
                    else if(scan.hasNext()){//The settings for the normal states
                        next = scan.next();//Holds the first value on the sheet
                        
                        //Checks to see whether or not the next value is a number.
                        if((next.charAt(0)<65)){

                            numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
                            bad = false;//Tells the program to move on to drawing the country.

                        }//end if

                    }//end else if
                    else{
                        bad = false;//Tells the program to move on to drawing the country.
                        keepGoing = false;//Tells the program there's nothing to draw.
                    }//end else

                }//end while

                
                //Sets up the data to draw the shape
                if(keepGoing == true){
                    //Creates arrays to hold the latitude and longitude
                    double[] latitude = new double[numberTwo];
                    double[] longitude = new double[numberTwo];

                    for(int i=0; i<numberTwo; i++){
                        //Puts the data into the arrays for the map
                        latitude[i] = Math.abs(scan.nextDouble()/200);
                        longitude[i] = Math.abs(scan.nextDouble()/200);
                        
                    }//end for

                    StdDraw.polygon(latitude, longitude);//Draws the shape.

                    numberTwo = 0;//Resets the number of states to be drawn to zero.

                }//end if
                
            }//end for
        
        }//end while
        
    }//end main
    
}
