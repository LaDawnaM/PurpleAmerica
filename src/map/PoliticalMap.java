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
 * THE PULL WORKED. CONGRATULATATIONS!
 *
 */
package map;
import edu.princeton.cs.introcs.*;
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
        String [] abbreviations = {/*"AK.txt",*/ "AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", /*"HI.txt",*/ "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt", "USA.txt"};
        String [] years = {"1960", "1964", "1968", "1972", "1976", "1980", "1984", "1988", "1992", "1996", "2000", "2004", "2008", "2012"};
         
        
        StdDraw.setCanvasSize(1275, 650);//sets the canvas size
        
        
        
        boolean yes = true;
        
        while(yes){
            
            boolean runs = true;
        
            //Causes the program to repeat until all the countries in the states have been built.
            while(holder < abbreviations.length){

                boolean keepGoing = true;//A variable later used to tell the program whether or not it has another country to construct.
                String fileName = abbreviations[holder];//Selects the country to be drawn.
                holder++;//Increments the number to ensure none of  the states are constantly repeated.

                File file = new File("src\\data\\" + fileName);//Creates a file of the state about to be drawn.
                Scanner scan = new Scanner(file);//Makes the scanner to read from the file.            
                    
                    //makes it so that you can see the pen.
                    StdDraw.setPenRadius(0.0005);//changes the pen size
                    StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color

                    //Gets rid of the points representing the highest and lowest points of the graph
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

                            }//end if
                            else if(scan.hasNext()){//The settings for the normal states
                                next = scan.next();//Holds the first value on the sheet

                                //Checks to see whether or not the next value is a number.
                                if((next.charAt(0)<65)){

                                    numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
                                    bad = false;//Tells the program to move on to drawing the country.

                                }//end if

                                //Saves the country name
                                else if((next.charAt(0)>=65) && notNamed){
                                    countryName = next;//sets the country name to the pre-saved value
                                    notNamed = false;//Tells the program the country has already been named.

                                }

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

                        boolean notEndOfCounty = true;//used to determine whether 
                        int c = 0;

                        //Checks for the number of letters in the state name & saves them.
                        while(notEndOfCounty){
                            char hold = name.charAt(c);//compiles the name of the state the election is in
                            c++;//increases char the program is reading in.

                            //checks to see if the program has hit the decimal in the name
                            if(hold == 46){
                               notEndOfCounty = false;//if so,it ends the loop 
                            }//end if

                            else{
                                nameFinal = nameFinal + hold;//otherwise, it saves the previously read in value as a letter in the abbreviation
                            }//end else
                        }//end for

                        fileName = (nameFinal + holdYear + ".txt");//Compiles the different parts of the fileName to get the .txt file name

                        File fileElec = new File("src\\data\\" + fileName);//Creates a file of the state about to be drawn.
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
                                String holder = "";

                                //finds the country name
                                for(int i=0; i<hold.length(); i++){
                                    if(hold.charAt(i) == 44){//checks to see if the String has reached a comma
                                        //if so, it runs through the string up until the comma, and sets that as the country name
                                        for(int e=0; e<i; e++){
                                            holder = holder + hold.charAt(e);
                                        }
                                        //sets booleans to discern republican from democratic from independent.
                                        boolean repub = true;
                                        boolean demo = true;

                                        //seperates the election results by party
                                        for(int e=i+1; e<hold.length(); e++){
                                            holder = holder + hold.charAt(e);//starts reading in the numbers

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

                                hold = holder;//sets the original hold to the temporary holder value
                                holder = "";//resets holder

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
                         double lat = Math.abs(((scan.nextDouble()+50)/62)+0.26);
                         double distance;

                         if(lat > 0.5){
                             distance = lat - 0.5;
                             lat = lat - distance - distance;
                             latitude[i] = lat;
                         }else if(lat < 0.5){
                             distance = 0.5 - lat;
                             lat = lat + distance + distance;
                             latitude[i] = lat;
                         }else{
                             latitude[i] = lat;
                         }
                          

                         latitude[i] = lat;
                         longitude[i] = Math.abs(((scan.nextDouble()+50)/25)-2.98);

                        }

                        StdDraw.polygon(latitude, longitude);//Draws the shape.

                        numberTwo = 0;//Resets the number of states to be drawn to zero.
                    }//end else        

                    }//end if

                    }//end for

                }//end while
            
            //DRAWS THE BUTTONS THE USERS CAN USE.

        //Creates holders for the different ints/String the program needs to run
        double x;
        double y;
        String year;

        //sets the base number for the x and y coordinates, to be altered later
        x=.965;
        y=1.02;

        //draws the buttons.
        for(int i=0; i<15; i++){

            //Draws the buttons for the county/state switch
            if(i==14){
                x = x-.065;//changes the x value

                for(int z=0; z<2; z++){
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);//Changes the color of the pen for the box.
                    StdDraw.filledSquare(x, y, .03);//Creates a square at the appropriate place

                    y = y+.07;//changes the y value
                }//end for

                StdDraw.setPenColor(StdDraw.BLACK);//Changes the color of the pen for the text

                StdDraw.text(x, (y-.07), "counties");//Draws the text for counties
                StdDraw.text(x, (y-.14), "states");//Draws the text for states

            }//end if

            //Draws the buttons for the election years
            else{
                y = y-.07;//Moves the place the button will be drawn to a different height
                year = years[i];//Chooses a different election year to be printed

                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);//Changes the color of the pen for the box.
                StdDraw.filledSquare(x, y, .03);//Creates a square at the appropriate place

                StdDraw.setPenColor(StdDraw.BLACK);//Changes the color of the pen for the text
                StdDraw.text(x, y, year);//Draws the text

            }//end else

        }//end for

            //Creates holders for the different doubles the program needs to run
            double mX;
            double mY;

            //Creates a neverending loop, so the program is constantly checking for user input.
            while(runs){

                //Checks to see if a button has been pressed.
                if(StdDraw.mousePressed()){

                    //Saves the values for the location the mouse is currently hovering over.
                    mX = StdDraw.mouseX();
                    mY = StdDraw.mouseY();

                    //checks to see if the user pressed an election-year button
                    if(mX>=.935 && mX<=1){

                        y=1.02;//resets y to it's base value

                        //Checks to see which button the user pressed.
                        for(int i=0; i<14; i++){
                            y = y-.07;//Decreases the value of y, so that it's in the center of the first button.

                            //Realizes that's the proper button, and prints that year
                            if(mY<= y+.033 && mY>=y-.033){
                                System.out.println(years[i]);
                            }//end if

                        }//end for

                    }//end if

                    //checks to see if the user pressed a states vs. counties button
                    else if(mX>=.87 && mX<=.93){

                        y=0.039999999999999536;//resets y to it's lowest value

                        //Checks to see which button the user pressed.
                        for(int i=0; i<14; i++){

                            //Realizes which button (if it is a button) was pressed
                            if(mY<= y+.033 && mY>=y-.033){
                                
                                StdDraw.clear();//clears the canvas
                                
                                if(y == 0.039999999999999536){//tells the user to only draw the states.
                                    runs = false;
                                    holder--;
                                }//end if
                                
                                else{
                                    runs = false;
                                    holder = 0;
                                }//end else
                            }//end if

                            y = y+.07;

                        }//end for

                    }//end else if

                }//end if

            }//end while
    
        }//end while
            
    }//end main
                              
}
