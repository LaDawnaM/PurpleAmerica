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
 * 
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
    static String countryName;
    
    public static void main(String[] args) throws Exception{
        
        ////////////////////////////////////////////////////////////////////////
        //Creates a string array holding all the abbreviation names. Used to call the different files.
        String [] abbreviations = {"AK.txt", "AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", "HI.txt", "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt"};
        
        StdDraw.setCanvasSize(1275, 650);//sets the canvas size
        
        //Causes the program to repeat until all the countries in the states have been built.
        while(holder < abbreviations.length){
        
            boolean keepGoing = true;//A variable later used to tell the program whether or not it has another country to construct.
            String fileName = abbreviations[holder];//Selects the country to be drawn.
            holder++;//Increments the number to ensure none of  the states are constantly repeated.
            
            File file = new File("C:\\Users\\hcps-lesleyjm\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\" + fileName);//Creates a file of the state about to be drawn.
            Scanner scan = new Scanner(file);//Makes the scanner to read from the file.
            
            //makes it so that you can see the pen.
            StdDraw.setPenRadius(0.0005);//changes the pen size
            StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color

            //Draws points at the highest and lowest points of the graph
            for(int i=0; i<2; i++){
                scan.nextDouble();
                scan.nextDouble();
            }//end for

                int number = scan.nextInt();//Gets the number of countries that make up the state

                

            //Plots the points of the country.
            for(int z=0; z<number; z++){    
                //Discards the name of the country, and the abbreviation of the state 

                boolean bad = true;//Tells the program there are still non-coordinites to be gotten rid of
                String next;//Used to hold the non-coordinates
                boolean notNamed = true;

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
                        else if((next.charAt(0)>=65) && notNamed){
                            countryName = next;
                            notNamed = false;
                        }

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
     ////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////

                    int holdYear = 1960;//temporarily chooses the year to get the election data from
            
                    String name = abbreviations[holder-1];//gets the full state name.
                    String nameFinal = "";//initializes the String for the name of the state

                    for(int i=0; i<2; i++){
                        nameFinal = nameFinal + name.charAt(i);//compiles the name of the state the election is in
                    }//end for

                    fileName = (nameFinal + holdYear + ".txt");//Compiles the different parts of the fileName to get the .txt file name

                    File fileElec = new File("C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\" + fileName);//Creates a file of the state about to be drawn.
                    Scanner scanElec = new Scanner(fileElec);//Makes the scanner to read from the file.                    
                    
                    boolean countryDivisor = true;//lets the program know if it needs to continue the loop to get the country election results
                    scanElec.nextLine();//gets rid of the introductory line
                    
                    //Creates Strings to hold the election results for each party
                    int republican;
                    int democratic;
                    int independent;
                    
                    //gets the election results
                    while(countryDivisor){
                        if(scanElec.hasNext()){//checks to see if the country has election data
                            //gets the initial
                            String hold = scanElec.next();//holds the full line from the .txt file
                            
                            //creates strings to hold the broken down portion of hold.
                            String holderTwo = "";
                            String holder0 = "";
                            
                            //finds the country name
                            for(int i=0; i<hold.length(); i++){
                                if(hold.charAt(i) == 44){//checks to see if the String has reached a comma
                                    //if so, it runs through the string up until the comma, and sets that as the country name
                                    for(int e=0; e<i; e++){
                                        holder0 = holder0 + hold.charAt(e);
                                    }
                                    //sets booleans to discern republican from democratic from independent.
                                    boolean repub = true;
                                    boolean demo = true;
                                    
                                    //seperates the election results by party
                                    for(int e=i+1; e<hold.length(); e++){
                                        holder0 = holder0 + hold.charAt(e);//starts reading in the numbers
                                        
                                        //the first comma becomes republican
                                        if(hold.charAt(e) == 44 && repub == true){//checks to see if it's encountered a comma
                                            republican = Integer.parseInt(holderTwo);//sets the republican value to the current answer
                                            holderTwo = "";//resets HolderTwo
                                            repub = false;//points the program towards democratic next time
                                        }//end if
                                        
                                        //the second comma becomes democratic
                                        else if(hold.charAt(e) == 44 && repub == false){
                                            democratic = Integer.parseInt(holderTwo);//sets the democratic value to the current answer
                                            holderTwo = "";//resets HolderTwo
                                            demo = false;//points the program towards independent next time
                                        }//end else if
                                        
                                        //the third comma is independent
                                        else if(hold.charAt(e) == 44 && demo == false){
                                           independent = Integer.parseInt(holderTwo);//resets HolderTwo
                                            holderTwo = "";//resets holderTwo
                                            
                                            //resets the party discerning booleans to their initial state
                                            repub = true;
                                            demo = true;
                                            e = hold.length()+1;
                                        }//end else if
                                        
                                        //no commas have been encountered thus far
                                        else{
                                            holderTwo = holderTwo + hold.charAt(e);//tacks the current number on to the end, & repeats the process
                                        }//end else
                                        
                                    }//end for
                                    
                                    i = hold.length()+1;//ends the for loop
                                
                                }//end for
                                
                            }//end for
                            
                            hold = holder0;//sets the original hold to the temporary holder value
                            holder0 = "";//resets holder
                            
                            //checks to see if the program had located the correct country.
                            if(hold.equals(countryName)){
                                countryDivisor = false;//tells the while loop to end
                            }//end if
                            
                        }//end if
                    
                        else{
                            countryDivisor = false;//tells the while loop to end
                        }//end else

                    }//end while
                    ////////////////////////////////////////////////////////////
                  ////////////////////////////////////////////////////////////
                
                //Sets up the data to draw the shape
                if(keepGoing == true){
                    
                    //This conditional repositios Alaska
                    if(fileName.equals("AK.txt")){
                        //Creates arrays to hold the latitude and longitude
                        double[] latitude = new double[numberTwo];
                        double[] longitude = new double[numberTwo];

                        for(int i=0; i<numberTwo; i++){
                            //Puts the data into the arrays for the map, proportionate to the size
                            latitude[i] = Math.abs(((scan.nextDouble()+50)/230)+1.3);
                            longitude[i] = Math.abs(((scan.nextDouble()+50)/100)-.95);

                        }//end for

                        
                        StdDraw.filledPolygon(latitude, longitude);//Draws the shape.

                        numberTwo = 0;//Resets the number of states to be drawn to zero.
                    }//end if
                    
                    //This conditional handles Hawaii
                    else if(fileName.equals("HI.txt")){
                        //Creates arrays to hold the latitude and longitude
                        double[] latitude = new double[numberTwo];
                        double[] longitude = new double[numberTwo];

                        for(int i=0; i<numberTwo; i++){
                            //Puts the data into the arrays for the map, proportionate to the size
                            latitude[i] = Math.abs(((scan.nextDouble())/80)+1.90);
                            longitude[i] = Math.abs(((scan.nextDouble())/40)-.4);

                        }//end for

                        StdDraw.filledPolygon(latitude, longitude);//Draws the shape.

                        numberTwo = 0;//Resets the number of states to be drawn to zero.
                    }//end if
                    
                    //This conditional handles the normal states.
                    else{
                        //Creates arrays to hold the latitude and longitude
                        double[] latitude = new double[numberTwo];
                        double[] longitude = new double[numberTwo];

                        for(int i=0; i<numberTwo; i++){
                            //Puts the data into the arrays for the map, proportionate to the size
                            latitude[i] = Math.abs(((scan.nextDouble()+50)/62)+.26);
                            longitude[i] = Math.abs(((scan.nextDouble()+50)/25)-2.98);

                        }//end for
                        StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledPolygon(latitude, longitude);//Draws the shape.

                        numberTwo = 0;//Resets the number of states to be drawn to zero.
                    }//end else        
                    
                }//end if
                
            }//end for
        
        }//end while
        
    }//end main
    
}
