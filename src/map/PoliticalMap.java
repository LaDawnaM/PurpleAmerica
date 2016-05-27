/*
 * Political Map Project
 * Name: LaDawna McEnhimer, Forest Kim, Jacob Lesley
 * Block: 6
 * 
 * Program Purpose: This program draws the United states, and then uses a collection of data files to color the map in based on the election data from that year.
 *
 * Algorithm: 1. Start. 2. Create files to read in the map. 3. Create files to read in the election data. 4. Decipher the election data. 5. Use the election data and determine new colors to use to draw the map. 6. Decipher the information to draw the map. 7. Fill the map in with the colors of the election data. 8. Repeat steps 4-7 until all desired states/countires are drawn. 9. Create filled in squares numbered with the election years. 10. If a user presses a button, repeat steps 4-10 using that year's election data. 11. Draw a graph plotting every year's election data for the state the user is in. 12. Repeat steps 1-11 until the user closes the program. 13. End.
 * 
 * Future/possible improvements: Making it so that the graph can plot the coordinates from the counties' election data, as well.
 *
 */
package map;
import edu.princeton.cs.introcs.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap { 
    
    public static void main(String[] args) throws Exception{      
        
        StdDraw.setCanvasSize(1275, 650);//sets the canvas size

        DataReader data = new DataReader();
        GraphingFunctionality graph = new GraphingFunctionality();
        Colors colors = new Colors();
        
        //Creates the different font sizes for the graph, and normal text
        Font graphFont = new Font("Arial", Font.PLAIN, 12);
        Font normalFont = new Font("Arial", Font.PLAIN, 16);
        Font indexFont = new Font("Arial", Font.PLAIN, 10);

        //Creates values to be increased/decreased as the program progresses.
        boolean yes = true;
        boolean reset;
        data.setHolder(data.getAbbreviations().length-1);
        data.setNewYear(1960);
        colors.setTruth(true);
        
        while(yes){//Tells the program how far back to repeat.
            
            data.setFirst(true);
            
            boolean runs = true;//Tells the program that it can run through the ending loop.

            //Causes the program to repeat until all the countries in the states have been built.
            while(data.getHolder() < data.getAbbreviations().length-1){
                                
                boolean keepGoing = true;//A variable later used to tell the program whether or not it has another country to construct.

                File file = new File("src\\data\\" + data.newCountyName());//Creates a file of the state about to be drawn.
                Scanner scan = new Scanner(file);//Makes the scanner to read from the file.            
                    
                    //makes it so that you can see the pen.
                    if(data.getHolder() == data.getAbbreviations().length-1){
                        StdDraw.setPenRadius(0.0009);//Makes the US darker than the counties
                    }//end if
                    else{
                        StdDraw.setPenRadius(0.0005);//makes the counties lighter than the US
                    }//end else
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
                        
                        int holdYear = data.getNewYear();//temporarily chooses the year to get the election data from
                        
                        File fileElec = new File("src\\data\\" + data.electionData(holdYear));//Creates a file of the state about to be drawn.
                        Scanner scanElec = new Scanner(fileElec);//Makes the scanner to read from the file.  
                                                
                        graph.decipherIntro(scanElec.nextLine());//Determines which presidents are running for which parties.
                        data.setCountryDivisor(true);
                        //gets the election results
                        
                        while(data.getCountryDivisor()){
                                                        
                            if(scanElec.hasNext()){//checks to see if the country has election data
                                //gets the initial data
                                String hold = scanElec.nextLine();//holds the full line from the .txt file
                                colors.colorChooser(data.countryDivisor(hold));//determines the colors to be drawn
                               
                            }//end if

                            else{
                                data.setCountryDivisor(false);//tells the while loop to end
                            }//end else

                        }//end while
                        
                        
                                                
                        //Sets up the data to draw the shape
                        if(keepGoing == true){

                            //Creates arrays to hold the latitude and longitude
                            double[] latitude = new double[data.getNumberTwo()];
                            double[] longitude = new double[data.getNumberTwo()];

                            double lat;
                            double longi;
                                                        
                            data.setFirst(true);
                            
                            for(int i=0; i<data.getNumberTwo(); i++){
                                /*if(data.getCleared() == true){
                                        boolean notTrue = true;
                                        double holdLat = scan.nextDouble();
                                        double holdLong = scan.nextDouble();
                                                                                     
                                        /*if(i == 0){
                                            data.setRelativeNumber(.2);
                                            data.setRelativeyNumber(.5);
                                            while(notTrue){

                                                data.setLati(Math.abs(((holdLat+50)/62)+data.getRelativeNumber()));
                                                data.setLongi(Math.abs(((holdLong+50)/25)-data.getRelativeyNumber()));
                                        
                                        
                                                if(data.getLati() < .9 && data.getLati() > .1){
                                                    notTrue = false;
                                                }
                                                else{
                                                    data.setRelativeNumber(data.getRelativeNumber() + .1);
                                                }

                                                if(data.getLongi() < .9 && data.getLongi() > .1){
                                                    if(notTrue == false){
                                                        notTrue = false;
                                                    }
                                                }
                                                else{
                                                    data.setRelativeyNumber(data.getRelativeyNumber() +.1);
                                                    notTrue = true;
                                                }

                                                //System.out.println(i + " " + data.getRelativeyNumber() + " " + data.getLongi());
                                                
                                            }
                                                                                        
                                            data.setFirst(false);
                                                    
                                        }
                                        
                                        
                                        
                                        data.setLati(Math.abs(((holdLat+50)/62)+data.getRelativeNumber()));
                                        data.setLongi(Math.abs(((holdLong+50)/25)-data.getRelativeyNumber()));
                                        
                                        //System.out.println(i + "next" + data.getRelativeyNumber() + "  "  + data.getLongi());
                                        
                                        //System.out.println(i + "one: " + data.getLati() + " " + data.getLongi());
                                        
                                        //System.out.println(i + "  " + data.getLati());
                                        //System.out.println(i + "  " + data.getLongi());
                                        //System.out.println(data.getNumberTwo());
                                        
                                }//end if
                                
                                else{*/
                                    //Puts the data into the arrays for the map, proportionate to the size
                                    data.setLati(Math.abs(((scan.nextDouble()+50)/62)+0.26));
                                    data.setLongi(Math.abs(((scan.nextDouble()+50)/25)-2.98));
                               // }//end else
                                
                                data.setLati(data.latitude(data.getLati()));//flips the map
                                //System.out.println(i + "two: " + data.getLati());
                                
                                latitude[i] = data.getLati();//Repositions latitude to a good place on the map
                                longitude[i] = data.getLongi();//Retrieves and repositions longitude on the map
                                
                            }//end for
                                                        
                            
                            
                            int republican = (int)(Math.round(colors.getColor(1)));
                            int democrat = (int)(Math.round(colors.getColor(2)));
                            int independent = (int)(Math.round(colors.getColor(3)));
                                                        
                            Color color = new Color(republican, independent, democrat);
                            StdDraw.setPenColor(color);
                            
                            colors.setColor(3, 0);
                            colors.setColor(2, 0);
                            colors.setColor(1, 0);
                            
                            if(graph.getCountries()){//checks to see if the counties are being drawn
                                if(data.getHolder() == data.getAbbreviations().length-1){
                                    
                                    //Draws the outline of the USA darker than the rest of the map
                                    StdDraw.setPenColor(StdDraw.BLACK);
                                    StdDraw.setPenRadius(0.0009);
                                    StdDraw.polygon(latitude, longitude);//Draws the shape
                                    
                                }//end if
                                                                
                                else{
                                    StdDraw.filledPolygon(latitude, longitude);//Draws the shape.
                                }//end else
                                
                            }//end if
                            
                            else{//If only the outline of the USA is being drawn
                                StdDraw.filledPolygon(latitude, longitude);//Draws the shape.
                            }//end else
                            
                            data.setNumberTwo(0);//Resets the number of states to be drawn to zero.
                            
                        }//end if

                    }//end for

                    
                    if(data.getCleared() == true){
                        data.setHolder(data.getAbbreviations().length);
                        data.setCleared(false);
                    }//end if

                }//end while
            

            
            
            
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
                year = data.getYears(i);//Chooses a different election year to be printed

                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);//Changes the color of the pen for the box.
                StdDraw.filledSquare(x, y, .03);//Creates a square at the appropriate place
                
                //Shows which button the user is on
                if(colors.getBox(1)+.033 > y && colors.getBox(1)-.033<y){
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);//Changes the color of the current button's text
                }//end if
                
                else if(colors.getTruth()){//if this is the first time the map is being drawn
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);//changes the color of the first button's text
                    colors.setTruth(false);
                }//end else if
                
                else{//makes the rest of the buttons black
                    StdDraw.setPenColor(StdDraw.BLACK);
                }//end else
                
                StdDraw.text(x, y, year);//Draws the text
                
                StdDraw.setPenColor(StdDraw.BLACK);//Resets the pen color to it's default

            }//end else

        }//end for

            //Creates holders for the different doubles the program needs to run
            double mX;
            double mY;

////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////L'sAF//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////L'sAF//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
            
                //Creates variables for the graph sizes.
                double graphX = .15;
                double graphY = .13;
                double graphSize = .125;

                

                reset = true;//Tells the program to draw the box.

                boolean firstTime = true;
                
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eL'sAF//////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
////////////////////////////////eL'sAF//////////////////////////////////////////    
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
                                data.setNewYear(Integer.parseInt(data.getYears(i)));
                                StdDraw.clear();//Clears the map
                                colors.setBox(1, mY);//tells the program which button the user is on
                                
                                runs = false;//ends the loop, so the program will redraw the map

                                if(graph.getCountries()){
                                    data.setHolder(0);
                                }//end if
                                else{
                                    data.setHolder(data.getAbbreviations().length-1);//Moves the array holding the states back so it will redraw the USA
                                }//end else

                                
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

                                    graph.setCountries(false);//Tells the program not to draw the buttons any more
                                    data.setHolder(data.getAbbreviations().length-1);//Moves the array holding the states back so it will redraw the USA

                                }//end if
                                
                                else{
                                    runs = false;//ends the loop, so the program will redraw the map

                                    graph.setCountries(true);//tells the map to draw the countries.
                                    data.setHolder(0);//Moves the array holding the states back to the beginning so it will redraw the entire map

                                }//end else

                            }//end if

                            y = y+.07;//increments the y variable

                        }//end for
                                                
                    }//end else if
                    
                    if(data.getCleared() == false && runs == true){
                        if(mX <=.935 || mX<.75 && mY>.35){
                            for(int i=0; i<50; i++){
                                if(data.getLongAbbreviations(i).equals(graph.getTrueTitle())){
                                    StdDraw.clear();
                                    data.setHolder(i);
                                    i = 60;
                                    data.setCleared(true);
                                    runs = false;

                                }//end if
                            }//end for
                        }//end if
                    }//end if     

                }//end if
               
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
                                graph.setHoldYUpper(0);
                                
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
                                
                                //Gets the names of the oddly slanted graphs.
                                if(graph.getTrueTitle().equals("California") || graph.getTrueTitle().equals("Virginia")){
                                    graph.setMaybePresent(true);//Says that if no other state claims the point, it's theirs
                                    graph.setTrueTitle(graph.getTitle());//replaces the old state name to be compared against next time
                                }//end if
                                                                                                
                                else{
                                    z = graph.getGo()+10;//ends the loop for the states
                                    
                                    //checks to see if the point is in the same state as before
                                    if(graph.getSavedTitles().equals(graph.getTrueTitle())){//if so, nothing happens

                                    }//end if

                                    else{//otherwise:
                                        graph.setSavedTitles(graph.getTrueTitle());//replaces the old state name to be compared against next time
                                        
                                        reset = true;//tells the graph to redraw itself
                                    }//end else
                                    
                                    graph.setMaybePresent(false);//Tells the graph the point wasn't in the two odd states
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
                                
                                if(graph.getMaybePresent() == true){//checks to see if it's CA/VA
                                    
                                }//end if
                                else{
                                    //checks to see if the point is in the same state as before
                                    if(graph.getSavedTitles().equals(graph.getTrueTitle())){//if so, nothing happens

                                    }//end if

                                    else{//otherwise:
                                        graph.setSavedTitles(graph.getTrueTitle());//replaces the old state name to be compared against next time
                                        reset = true;//tells the graph to redraw itself
                                    }//end else
                                }//end else
                                
                                scanIt.nextLine();//gets rid of an empty line
                                graph.setNumberTwo(scanIt.nextInt());//resets the number of incoming coordinates
                                graph.setHoldIt(0);//resets the index of the graph

                                //resets the smallest/largest points to their base forms
                                graph.setXSmallest(1);
                                graph.setXLargest(0);
                                graph.setYSmallest(1);
                                graph.setYLargest(0);

                            }//end if scan.hasNext

                        }//end for # of states

                        //Checks to see if CA/VA were already drawn
                        if(graph.getMaybePresent() == true){
                            graph.setMaybePresent(false);
                        
                            //checks to see if the point is in the same state as before
                            if(graph.getSavedTitles().equals(graph.getTrueTitle())){//if so, nothing happens

                            }//end if

                            else{//otherwise:
                                graph.setSavedTitles(graph.getTrueTitle());//replaces the old state name to be compared against next time
                                reset = true;//tells the graph to redraw itself
                            }//end else
                                    
                        }//end if
                        
                        //Checks to see if the program needs to redraw the graph
                        if(reset){ 
                            StdDraw.setFont(graphFont);//Changes to font to the graph's font
                            graph.resetGraph(graphX, graphY, graphSize);//redraws the entire graph
                            
                            //Tells the program this is the first time its drawing the graph
                            if(firstTime){
                                //Draws the graph title for the only time
                                StdDraw.setFont(graphFont);
                                StdDraw.text(graphX-.02, graphY+.133, "The Election Data vs. The Number of Voters over the Years");//Writes the name of the state
                                StdDraw.setFont(normalFont);
                                firstTime = false;
                            }//end if
                            

                        }//end if reset

                        if(reset){//checks to see if the graph was redrawn

                        int yearOne;//creates an int placeholder for the year
                        graph.setXPos(1.03);//resets the position for the points to be plotted on the graph
                        graph.setYPos(graphY-.05);//resets the position for the points to be plotted on the graph
                        
                            StdDraw.setFont(graphFont);
                            //runs through the election data for each year, looking for the proper String with election data
                            for(int q = 0; q<data.getYears().length; q++){
                                String elecs = data.getYears(q);//creates a string for the current year
                                yearOne = Integer.parseInt(elecs);//turns the string into an int

                                data.setFileName("USA.txt");//Sets the fileName to the default state
                                
                                File fileTwo = new File("src\\data\\" + data.electionData(yearOne, data.getFileName()));//Creates a file of the state about to be drawn.
                                Scanner scanElection = new Scanner(fileTwo);//Makes the scanner to read from the file.

                                boolean keepItUp = true;//creats a boolean to check if the program has found the data from the right country                                
                                graph.decipherIntro(scanElection.nextLine());//Determines which presidents are running for which parties.

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

                                if(q==13){//Tells the program it's on it's final loop & to draw the points
                                    graph.setNotFixed(true);
                                }//end if
                                
                                //Gets the points for the graph
                                graph.ratio(((double)data.getRepublican()), ((double)data.getDemocrat()), ((double)data.getIndependent()), graphX, graphY, graphSize, 1960, indexFont, graphFont);//turns the data into points to be plotted on the graph
                                graph.setNotFixed(false);//Resets notFixed
                                StdDraw.setFont(graphFont);//Changes the font
                                
                                //Sets the pen & text back to normal settings
                                StdDraw.setPenColor(StdDraw.BLACK);
                                StdDraw.setPenRadius(0.0005);

                            }//end for
                            StdDraw.setFont(normalFont);//Changes the font back to normal

                        }//end if
                    
                        reset = false;//tells the program everything is the way it should be
                    
                        }//end if  
                                        
                    }//end if runs

            }//end while
    
        }//end while
            
    }//end main
                              
}//end class
