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
import java.awt.Font;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap {
        
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
    //static int holder = 0;//Lets the program know which state file should be read in next 
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////    
    
    public static void main(String[] args) throws Exception{

////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////    
        //Creates a string array holding all the abbreviation names. Used to call the different files.
       /* String [] abbreviations = {/*"AK.txt",*//* "AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", /*"HI.txt",*//* "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt", "USA.txt"};*/
     //   String [] years = {"1960", "1964", "1968", "1972", "1976", "1980", "1984", "1988", "1992", "1996", "2000", "2004", "2008", "2012"};
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////         
        
        StdDraw.setCanvasSize(1275, 650);//sets the canvas size
        
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
        DataReader data = new DataReader();
        GraphingFunctionality graph = new GraphingFunctionality();
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
        
        boolean yes = true;
        boolean reset;
        data.setHolder(data.getAbbreviations().length-1);
        
        while(yes){
            
            boolean runs = true;

            //Causes the program to repeat until all the countries in the states have been built.
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
            while(data.getHolder() < data.getAbbreviations().length-1){
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                boolean keepGoing = true;//A variable later used to tell the program whether or not it has another country to construct.
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                //String fileName = abbreviations[holder];//Selects the country to be drawn.
                //holder++;//Increments the number to ensure none of  the states are constantly repeated.
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE/////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////

                File file = new File("src\\data\\" + data.newCountyName());//Creates a file of the state about to be drawn.
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
                           
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                            /* //Contingency for the odd naming in Hawaii
                            if(data.getFileName().equals("HI.txt")){

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
                            else*/
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////                     
                            
                            if(scan.hasNext()){//The settings for the normal states
                                next = scan.next();//Holds the first value on the sheet

                                //Checks to see whether or not the next value is a number.
                                if((next.charAt(0)<65)){

                                    data.setNumberTwo(Integer.parseInt(next));//Saves the number of points to be plotted.
                                    bad = false;//Tells the program to move on to drawing the country.

                                }//end if

                                //Saves the country name
                                else if((next.charAt(0)>=65) && notNamed){
                                    data.setCountryName(next);//sets the country name to the pre-saved value
                                    notNamed = false;//Tells the program the country has already been named.

                                }//end else if

                            }//end else if
                            else{
                                bad = false;//Tells the program to move on to drawing the country.
                                keepGoing = false;//Tells the program there's nothing to draw.
                            }//end else

                        }//end while

                        ////////////////////////////////////////////////////////////
                        ////////////////////////////////////////////////////////////
    
////////////////////////////////////////////////////////////////////////////////    
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                        
                        int holdYear = 1960;//temporarily chooses the year to get the election data from
                        
                        File fileElec = new File("src\\data\\" + data.electionData(holdYear));//Creates a file of the state about to be drawn.
                        Scanner scanElec = new Scanner(fileElec);//Makes the scanner to read from the file.  
                                                
                        
                        graph.decipherIntro(scanElec.nextLine());//Determines which presidents are running for which parties.
                        data.setCountryDivisor(true);

                        //gets the election results
                        while(data.getCountryDivisor()){
                                                        
                            if(scanElec.hasNext()){//checks to see if the country has election data
                                //gets the initial
                                String hold = scanElec.next();//holds the full line from the .txt file
                                data.countryDivisor(hold);
                                
                            }//end if

                            else{
                                data.setCountryDivisor(false);//tells the while loop to end
                            }//end else

                        }//end while

////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                        
                        //Sets up the data to draw the shape
                    if(keepGoing == true){

                        //This conditional repositions Alaska
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                        /*if(data.getFileName().equals("AK.txt")){
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

                        else if(data.getFileName().equals("HI.txt")){

                            //Creates arrays to hold the latitude and longitude
                            double[] latitude = new double[numberTwo];
                            double[] longitude = new double[numberTwo];

                            for(int i=0; i<numberTwo; i++){
                                //Puts the data into the arrays for the map, proportionate to the size
                                latitude[i] = Math.abs((((scan.nextDouble())/80)+1.90));
                                longitude[i] = Math.abs((((scan.nextDouble())/40)-.4));

                            }//end for

                            StdDraw.filledPolygon(latitude, longitude);//Draws the shape.

                            numberTwo = 0;//Resets the number of states to be drawn to zero.
                        }//end if
                        
                        //This conditional handles the normal states.
                        else{*/
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                            
                            //Creates arrays to hold the latitude and longitude
                            double[] latitude = new double[data.getNumberTwo()];
                            double[] longitude = new double[data.getNumberTwo()];

                            for(int i=0; i<data.getNumberTwo(); i++){
                                //Puts the data into the arrays for the map, proportionate to the size
                                double lat = Math.abs(((scan.nextDouble()+50)/62)+0.26);

////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                
                            //double distance;
                             //   System.out.println("Lat: " + lat);
                                
                                lat = data.latitude(lat);
                                /*
                                //Reverses the positioning of the dots
                                if(lat > 0.5){//Checks to see which side of the map the dot is on.
                                    distance = lat - 0.5;//finds the dot's distance from the center of the map
                                    lat = lat - distance - distance;//Takes the distance away twice, placing the spot on the opposite side of the map
                                }//end if

                                //Reverses the positioning of the dots
                                else if(lat < 0.5){//Checks to see which side of the map the dot is on.
                                    distance = 0.5 - lat;//finds the dot's distance from the center of the map
                                    lat = lat + distance + distance;//Takes the distance away twice, placing the spot on the opposite side of the map
                                }//end else if

*/

                                latitude[i] = lat;//Repositions latitude to a good place on the map
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                longitude[i] = Math.abs(((scan.nextDouble()+50)/25)-2.98);//Retrieves and repositions longitude on the map
                                
                              //  System.out.println("new Lat:" + latitude[i] + " new Long:" + longitude[i]);
                                
                            }//end for

                            StdDraw.polygon(latitude, longitude);//Draws the shape.
                            

                            data.setNumberTwo(0);//Resets the number of states to be drawn to zero.
                            
                            //System.out.println(data.getFileName());
                       // }//end else        

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
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                year = data.getYears(i);//Chooses a different election year to be printed
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);//Changes the color of the pen for the box.
                StdDraw.filledSquare(x, y, .03);//Creates a square at the appropriate place

                StdDraw.setPenColor(StdDraw.BLACK);//Changes the color of the pen for the text
                StdDraw.text(x, y, year);//Draws the text

            }//end else

        }//end for

            //Creates holders for the different doubles the program needs to run
            double mX;
            double mY;
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
            
                //Creates variables for the graph sizes.
                double graphX = .13;
                double graphY = .13;
                double graphSize = .125;
                
                //Creates the different font sizes for the graph, and normal text
                Font graphFont = new Font("Arial", Font.PLAIN, 12);
                Font normalFont = new Font("Arial", Font.PLAIN, 16);
                

                reset = true;//Tells the program to draw the box.

////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                
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

                            //Realizes that's the proper button
                            if(mY<= y+.033 && mY>=y-.033){
                                //System.out.println(years[i]);//Prints the year (extraneous)
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
                                    runs = false;//ends the loop, so the program will redraw the map
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                    graph.setCountries(false);
                                    data.setHolder(data.getAbbreviations().length-1);//Moves the array holding the states back so it will redraw the USA
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                }//end if
                                
                                else{
                                    runs = false;//ends the loop, so the program will redraw the map
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                    graph.setCountries(true);
                                    data.setHolder(0);//Moves the array holding the states back to the beginning so it will redraw the entire map
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
                                }//end else
                            }//end if

                            y = y+.07;

                        }//end for
                                                
                    }//end else if

                }//end if
                
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////CHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
               
                if(runs){//Makes sure the program isn't being told to redraw the map.
                    
                    //Gets the current lat/long values of the mouse
                    mX = StdDraw.mouseX();
                    mY = StdDraw.mouseY();

                    if(mX <=.935 || mX<.75 && mY>.35){//Ensures the mouse is closer to the map than the buttons

                        File file = new File("src\\data\\" + "USA.txt");//Creates a file of the state about to be drawn.
                        Scanner scanIt = new Scanner(file);//Makes the scanner to read from the file.

                        //Takes care of the first 7 lines of code in the .txt (before the lat/long)
                        for(int i=0; i<7; i++){
                            
                            //Gets the name of the state
                            if(i==5){
                                graph.setTitle(scanIt.nextLine());
                            }//end if
                            
                            //gets the number of states to be drawn
                            else if(i==2){
                                graph.setGo(scanIt.nextInt());
                            }//end else if

                            //gets rid of extraneous lines
                            else{
                                scanIt.nextLine();
                            }//end else
                            
                        }//end for

                        graph.setNumberTwo(scanIt.nextInt());//sets the number of lat/long coordinates to be cycled through for a certain state
                        boolean start;//tells the program whether or not this is the first time its cycling through the state

                        //Tells the graph to cycle through each state
                        for(int z=0; z<graph.getGo(); z++){

                            start = true;//tells the program this is the first time its cycling through the states
                            
                            //Makes the largest & smallest numbers as large/small as they can be.
                            graph.setXTrueLargest(1);
                            graph.setXTrueSmallest(0);

                            //Makes each state cycle through itself twice
                            for(int l=0; l<2; l++){
                                
                                //cycles through each lat/long point for each state
                                for(int i=0; i<graph.getNumberTwo(); i++){
                                    
                                    //the states are cycling for the first time.
                                    if(start == true){
                                        
                                        //saves the x & y coordinates of the graph
                                        double x1 = scanIt.nextDouble();
                                        double y1 = scanIt.nextDouble();

                                        graph.prepFindLocation(x1, y1, mX, mY, graph.getTitle());//puts all of the lat/longs into an array & gets the largest/smallest numbers
                                        graph.setHoldIt(i);//increments the index of the arrays.

                                    }//end if

                                    else{

                                        //tells the program it's on it's last run-through of the program.
                                        if(i == graph.getNumberTwo()-1){
                                            graph.setFinalRound(true);
                                        }//end if

                                        graph.findLocation(mX, mY, graph.getTitle());//gets the precise location of the mouse
                                        graph.setHoldIt(graph.getHoldIt()+1);//increments the index of the lat/long arrays

                                        //checks to see if the point exists within the graph.
                                        if(graph.getNotPresent() == true){//If so, ends the loops for the state
                                            l = 5;
                                            i = graph.getNumberTwo() + 20;
                                        }//end if

                                    }//end else

                                }//end for

                                start = false;//tells the graph its starting it's second run-through
                                graph.setHoldIt(0);//resets the lat/long array's index

                            }//end for

                            //checks to see if the point is present in the graph
                            if(graph.getNotPresent() == false){//if so:
                                z = graph.getGo()+10;//ends the loop for the states
                                
                                //checks to see if the point is in the same state as before
                                if(graph.getSavedTitles().equals(graph.getTrueTitle())){//if so, nothing happens

                                }//end if
                                
                                else{//otherwise:
                                    graph.setSavedTitles(graph.getTrueTitle());//replaces the old state name to be compared against next time
                                    reset = true;//tells the graph to redraw itself
                                }//end else

                            }//end if
                            
                            else{
                                graph.setNotPresent(false);//resets the notPresent variable
                            }//end else

                        
                            //checks to see if there are still states left
                            if(scanIt.hasNext()){
                                
                                //skips the next two lines
                                scanIt.nextLine();
                                scanIt.nextLine();
                                
                                graph.setTitle(scanIt.nextLine());//sets the new title for the new state
                                
                                
                                //checks to see if the point is in the same state as before
                                if(graph.getSavedTitles().equals(graph.getTrueTitle())){//if so, nothing happens

                                }//end if
                                
                                else{//otherwise:
                                    graph.setSavedTitles(graph.getTrueTitle());//replaces the old state name to be compared against next time
                                    reset = true;//tells the graph to redraw itself
                                }//end else

                                
                                scanIt.nextLine();//discards the sect line
                                graph.setNumberTwo(scanIt.nextInt());//resets the number of incoming coordinates
                                graph.setHoldIt(0);//resets the index of the graph

                                //resets the smallest/largest points to their base forms
                                graph.setXSmallest(1);
                                graph.setXLargest(0);
                                graph.setYSmallest(1);
                                graph.setYLargest(0);

                            }//end if scan.hasNext

                        }//end for # of states


                        //Checks to see if the program needs to redraw the graph
                        if(reset){ 
                            StdDraw.setFont(graphFont);//Changes to font to the graph's font
                            graph.resetGraph(graphX, graphY, graphSize);//redraws the entire graph
                            StdDraw.setFont(normalFont);//Changes the font back to normal

                        }//end if reset

                        int yearOne;//creates an int placeholder for the year
                        graph.setXPos(1);//resets the position for the points to be plotted on the graph

                        
                        if(reset){//checks to see if the graph was redrawn
                            
                            //runs through the election data for each year, looking for the proper String with election data
                            for(int q = 0; q<data.getYears().length; q++){
                                String elecs = data.getYears(q);//creates a string for the current year
                                yearOne = Integer.parseInt(elecs);//turns the string into an int

                                File fileTwo = new File("src\\data\\" + data.electionData(yearOne, "USA.txt"));//Creates a file of the state about to be drawn.
                                Scanner scanElection = new Scanner(fileTwo);//Makes the scanner to read from the file.

                                boolean keepItUp = true;//creats a boolean to check if the program has found the data from the right country
                                scanElection.nextLine();//discards the first line

                                //ensures the data has another line & the correct data hasn't been found
                                while(scanElection.hasNext() && keepItUp){

                                    data.setFoundTheData("");//resets foundTheData
                                    data.countrySearch(scanElection.nextLine(), graph.getTitle());//searches through the data for the correct String

                                    //checks to see if the proper data string was found
                                    if(data.getFounded() == false){//if so
                                        keepItUp = false;//ends the loop
                                        data.setFounded(true);//resets the founded boolean to it's original form
                                    }//end if
                                }//end while

                                StdDraw.setFont(graphFont);//sets the text style to fit the graph
                                graph.ratio(((double)data.getRepublican()), ((double)data.getDemocrat()), ((double)data.getIndependent()), graphX, graphY, graphSize, elecs);//turns the data into points to be plotted on the graph

                                //Sets the pen & text back to normal settings
                                StdDraw.setPenColor(StdDraw.BLACK);
                                StdDraw.setPenRadius(0.0005);
                                StdDraw.setFont(normalFont);
                            }//end for


                        }//end if
                    
                        reset = false;//tells the program everything is the way it should be
                    
                        }//end if  
                    
                    }//end if runs
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eCHANGE//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
               
            }//end while
    
        }//end while
            
    }//end main
                              
}//end class
