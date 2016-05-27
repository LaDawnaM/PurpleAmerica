/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;


/** 
 * LaDawna McEnhimer
 * <p>GraphingFunctionality
 * <p>Variables: <ul>someLeft - tells the graph if there's something left in the String. Used to end a loop. </ul> <ul>goAhead - tells the program if the beginning words have been discarded. Used to end a loop.</ul> <ul>holdYear - holds the year the program is currently on. Used as an index.</ul> <ul>holdTitles - holds the String for the election data. Used to sort through the election data.</ul> <ul> savedTitle - holds the previous name of the country the mouse is in. Used to determine whether or not to redraw the map. </ul> <ul>independent - holds the independent data. Used to access how many independent votes there are. </ul> <ul>republican - holds the republican data. Used to access how many republican votes there are.</ul> <ul>democrat - holds the democratic data. Used to access how many democratic votes there are.</ul> <ul>longitude - holds the longitude points. Used to draw the graph. </ul> <ul>latitude - holds the latitude points. Used to draw the graph.</ul> <ul>numberTwo - holds the number of countries to be cycled through.</ul> <ul>holdIt - holds the index of the lat/long arrays. Used as a placeholder. </ul> <ul>xLargest - holds the largest x value. Used to determine the state's bounding box.</ul> <ul>yLargest - holds the largest y value. Used to determine the state's bounding box.</ul> <ul>xSmallest - holds the smallest x value. Used to determine the state's bounding box.</ul><ul>ySmallest - holds the smallest y value. Used to determine the state's bounding box.</ul><ul>xTrueLargest - holds the largest x value closest to the point. Used to determine the state's exact border.</ul><ul>xTrueSmallest - holds the smallest x value closest to the point. Used to determine the state's exact border.</ul><ul>holdYUpper - holds the y value for the larger x closest value. Used to determine the state's exact border.</ul><ul>holdYLower - holds the y value for the smaller x closest value. Used to determine the state's exact border.</ul><ul>notPresent - whether or not a point is within a state. Used to determine if a point is in a state</ul><ul>longHalf - the longitudinal half of a state</ul><ul>ratio - returned at the end of the ratio method</ul><ul>xPos - the base lat position. Used to base the points off of.</ul><ul>yPos - the base long position. Used to base the points off of.</ul><ul>trueTitle - the new name of the state them mouse is in. Used to determine whether or not to draw a state.</ul><ul>finalRound - the final time going through a method. Used to make a loop happen.</ul><ul>countries - if the program is drawing the counties. Used to determine pen size, to fill the bordering polygons, etc.</ul><ul>title - the current name of the state. Used to hold the state until certain if the point is inside.</ul><ul>go - the total # of states in a .txt. Used to determine how many times to loop through.</ul><ul>notFixed - tells the graph it's on its last loop. Used to start a while loop.</ul><ul>relativeNumber - finds a number to divide the election data by. Used to make it fit on the graph</ul><ul>republicanElection - holds the republican data. Used when plotting the points</ul><ul>democratElection - holds the democratic data. Used when plotting the points</ul><ul>independentElection - holds the independent data. Used when plotting the points</ul><ul>holdYearNumber - holds the current year for the election. Used as an index</ul><ul>maybePresent - checks to see if it's one of the odd graphs. Tells the program whether or not to continue checking states for the point.</ul><ul>largest - gets the largest number of the data. Used to determine the graph's y-index.</ul><ul>length - the number of people voting in one place. Used to create the graph's y-index.</ul><ul>devisedNumber - the index of the graph. Used to find it.</ul>
 * <p>Methods: <ul>decipherIntro() - figures out the first line of the electionData. </ul> <ul>prepFindLocation() - deciphers lat/long data & splits it up into arrays.</ul> <ul>findLocation() - finds the specific state a point is in.</ul> <ul>ratio() - gets the election data points plotted.</ul> <ul>resetGraph() - redraws the basic features of the graph.</ul>
 */
public class GraphingFunctionality {

    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    boolean someLeft;
    boolean goAhead;
    
    String holdYear;
    String holdTitles;
    String savedTitle;
    
    String independent;
    String republican;
    String democrat;
    
    double[] longitude;
    double[] latitude;
    int numberTwo;
    int holdIt;
    
    double xLargest;
    double yLargest;
    double xSmallest;
    double ySmallest;
    
    double xTrueLargest;
    double xTrueSmallest;
    
    double holdYUpper;
    double holdYLower;

    boolean notPresent = false;
    
    double longHalf;
    double ratio;
    
    double xPos;
    double yPos;
    String trueTitle;
    boolean finalRound;    
    boolean countries;
    
    String title;
    int go;
    
    boolean notFixed;
    int relativeNumber;
    
    double[] republicanElection;
    double[] democratElection;
    double[] independentElection;
    int holdYearNumber = 0;

    boolean maybePresent;
    double largest;
    String length;
    
    String devisedNumber;

    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////CONSTRUCTOR/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    //Creates a blueprint for an instance of the graphing class.
    public GraphingFunctionality(){
        republicanElection = new double[14];
        democratElection = new double[14];
        independentElection = new double[14];
        
        notFixed = false;
        trueTitle = "Virginia";
        
        savedTitle = "";
        independent = "";
        republican = "";
        democrat = "";
    
    }//end constructor
    
        
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public String getTitle(){
        return title;
    }//end getTitle
    
    public void setTitle(String t){
        title = t;
    }//end setTitle
    
    public void setGo(int g){
        go = g;
    }//end setGo
    
    public int getGo(){
        return go;
    }//end getGo
    
    public String getIndependent(){
        return independent;
    }//end getIndependent
    
    public String getDemocrat(){
        return democrat;
    }//end getDemocrat
    
    public String getRepublican(){
        return republican;
    }//end getRepublican
    
    public void setNumberTwo(int n){
        latitude = new double[n];
        longitude = new double[n];
        numberTwo = n;
    }//end setNumberTwo
    
    public int getNumberTwo(){
        return numberTwo;
    }//end getNumberTwo
    
    public void setHoldIt(int h){
        holdIt = h;
    }//end setHoldIt
    
    public int getHoldIt(){
        return holdIt;
    }//end get holdIt
   
    public void setXSmallest(int s){
        xSmallest = s;
    }//end setXSmallest
    
    public void setYSmallest(int s){
        ySmallest = s;
    }//end setYSmallest
    
    public void setXLargest(int s){
        xLargest = s;
    }//end setXLargest
    
    public void setYLargest(int s){
        yLargest = s;
    }//end setYLargest
    
    public void setXTrueSmallest(int s){
        xTrueSmallest = s;
    }//end xTrueSmallest

    public void setXTrueLargest(int s){
        xTrueLargest = s;
    }//end setXTrueLargest
    
    public boolean getNotPresent(){
        return notPresent;
    }//end getNotPresent
    
    public void setNotPresent(boolean p){
        notPresent = p;
    }//end setNorPresent
    
    public void setSavedTitles(String s){
        savedTitle = s;
    }//end setSavedTitles
    
    public String getSavedTitles(){
        return savedTitle;
    }//end getSavedTitles
    
    public void setXPos(double s){
        xPos = Math.abs(s-.92);
    }//end setXPos
    
    public void setYPos(double y){
        yPos = y;
    }//end setYPos

    public String getTrueTitle(){
        return trueTitle;
    }//end getTrueTitle
    
    public void setTrueTitle(String t){
        trueTitle = t;
    }//end setTrueTitle
   
    public void setFinalRound(boolean d){
        finalRound = d;
    }//end setFinalRound
    
    public void setCountries(boolean c){
        countries = c;
    }//end setCountries
    
    public boolean getCountries(){
        return countries;
    }//end getCountries
    
    public void setNotFixed(boolean n){
        notFixed = n;
    }//end setNotFixed
    
    public void setMaybePresent(boolean m){
        maybePresent = m;
    }//end setMaybePresent
    
    public boolean getMaybePresent(){
        return maybePresent;
    }//end getMaybePresent
    
    public void setHoldYUpper(double h){
        holdYUpper = h;
    }//end setHoldYUpper
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Deciphers & saves the first line of the election data file. Determines which presidents were running for which party.
     * @param intro The line holding the election data
     */
    public void decipherIntro(String intro){
        
        someLeft = true;//if there is still data left in the string
        goAhead = false;//if the beginning words have been discacrded
        
        //Scrolls through the String
        for(int i=0; i<intro.length(); i++){

            //gets the election data's year
            if(intro.charAt(i) >=48 && intro.charAt(i) <= 57){
                holdYear = holdYear + intro.charAt(i);
            }//end if
            
            //Determines the program is at a unnecessary space & clears the string
            else if(intro.charAt(i) == 32){
                holdTitles = "";
            }//end else if

            //checks to see if the program has reached a comma
            else if(intro.charAt(i) == 44){

                    if(goAhead){//Checks for the second comma
                        
                        //saves the String to this point as the democratic data 
                        if(republican.length() > 0){//democratic
                            democrat = holdTitles;
                            holdTitles = "";//resets thte String
                        }//end if
                        
                        //saves the String to this point as the independent data
                        else if(democrat.length() > 0){//independent
                            independent = holdTitles;
                            holdTitles = "";//resets the string
                            someLeft = false;//tells the porgram it's reached the end of the string
                            i = intro.length()+10;
                        }//end else if

                        //saves the String to this point as republican data
                        else{//republican
                            republican = holdTitles;
                        }//end else
                    }
                    else{
                        goAhead = true;//tells the program its reached the second comma

                        holdTitles = "";//resets the string
                    }//end else

            }//end else if

            //saves the string as what's been read so far, plus the new data
            else{
                holdTitles = holdTitles + intro.charAt(i);
            }//end else

        }//end for
                            
    }//end decipherIntro
    
    
    /**
     * Repositions the latitude from the map to be in the proper place. Finds the largest and smallest x and y values (bounding box).
     * @param lats The new latitude to go in the array
     * @param longs The new longitude to go in the array
     * @param xVal The x Value of the mouse
     * @param yVal The y Value of the mouse
     * @param title The name of the state the program is currently checking
     */
    public void prepFindLocation(double lats, double longs, double xVal, double yVal, String title/*, double minLat, double maxLat, double minLong, double maxLong*/){
        
        //Puts the data into the arrays for the map, proportionate to the size
        lats = Math.abs(((lats+50)/62)+0.26);
        double distance;

        //Reverses the positioning of the dots
        if(lats > 0.5){//Checks to see which side of the map the dot is on.
            distance = lats - 0.5;//finds the dot's distance from the center of the map
            lats = lats - distance - distance;//Takes the distance away twice, placing the spot on the opposite side of the map
        }//end if

        //Reverses the positioning of the dots
        else if(lats < 0.5){//Checks to see which side of the map the dot is on.
            distance = 0.5 - lats;//finds the dot's distance from the center of the map
            lats = lats + distance + distance;//Takes the distance away twice, placing the spot on the opposite side of the map
        }//end else if

        latitude[holdIt] = lats-.0534;//Repositions latitude to a good place on the map
        longitude[holdIt] = Math.abs(((longs+50)/25)-2.98);//Retrieves and repositions longitude on the map

        
        //Checks for the bounding box of the state
        
        if(latitude[holdIt] > xLargest){//If that latitude point is the farthest to the right so far
            xLargest = latitude[holdIt];//the latitude point becomes the new farthest latitude
        }//end if
        
        else if(latitude[holdIt] < xSmallest){//If that latitude point is the farthest to the left so far
            xSmallest = latitude[holdIt];//the latitude point becomes the new smallest latitude
        }//end else if

        if(longitude[holdIt] > yLargest){//If that longitude point is the highest so far
            yLargest = longitude[holdIt];//the longitude point becomes the new highest longitude
        }//end if
        
        else if(longitude[holdIt] < ySmallest){//If that longitude point is the lowest so far
            ySmallest = longitude[holdIt];//the longitude point becomes the new lowest longitude
        }//end else if

        
    }//end prepFindLocation
    
    
    /**
     * Gets the exact center of the state. Finds the x and y values closest to the mouse. At the very end, it checks to ensure the mouse is within the bounding box, & within the closest x and y values.
     * @param xVal the mouse's x Value
     * @param yVal The mouse's y Value
     * @param title The name of the state the program is currently checking.
     */
    public void findLocation(double xVal, double yVal, String title){

        //gets the central-most longitude of the state
        longHalf = (yLargest - ySmallest)/2;
        longHalf = longHalf + ySmallest;

        if(latitude[holdIt] > xVal){//if the latitude is larger than the xVal

            if(latitude[holdIt] < xTrueLargest){//if the latitude is smaller than the point currently closest to the xVal
                xTrueLargest = latitude[holdIt];//make current latitude the new latitude closest to the xVal

                if(longitude[holdIt] > longHalf){//if the longitude is on the upper half of the state
                   holdYUpper = longitude[holdIt];//make the upper nearest longitude the new y coordniate
                }//end if

                else{
                  holdYLower = longitude[holdIt];//otherwise, make it the new lowest y coordinate
                }//end else

            }//end if

        }//end if


        else if(latitude[holdIt] < xVal){//if the latitude is smaller than the xVal

            if(latitude[holdIt] > xTrueSmallest){//if the latitude is largest than the point currently closest to the xVal
                xTrueSmallest = latitude[holdIt];//make current latitude the new latitude closest to the xVal

                if(longitude[holdIt] > longHalf){//if the longitude is on the upper half of the state
                    holdYUpper = longitude[holdIt];//make the upper nearest longitude the new y coordniate
                }//end if

                else{
                    holdYLower = longitude[holdIt];//otherwise, make it the new lowest y coordinate
                }//end else

            }//end if

        }//end else if

        
        //checks to see if the program is looping through for the final time
        if(finalRound){
           finalRound = false;//resets the final-time boolean

           //if the point is within the bounding box
            if(xSmallest<xVal && xLargest > xVal){
                if(ySmallest < yVal && yLargest > yVal){

                    if((xVal < xTrueLargest) && (xVal >xTrueSmallest)){//checks to see if the xValue is between the largest & smallest points
                        if((yVal > holdYLower && yVal < holdYUpper)){//checks to see if the yValue is between the highest & lowest points closest to it
                                trueTitle = title;
                        }//end if

                        else{
                            notPresent = true;//tells the program the mouse isn't within that state
                        }//end else

                    }//end if

                    else{
                        notPresent = true;//tells the program the mouse isn't within that state
                    }//end else

                }//end if


                else{
                    notPresent = true;//tells the program the mouse isn't within that state
                }//end else

            }//end if

            else{
                notPresent = true;//tells the program the mouse isn't within that state
            }//end else

        }//end if

    }//end findLocation
    
    
    
    /**
     * It retrieves the election data, and makes it small enough to fit within the borders of the map. It draws all of the points on the graph, as well as the years beneath them, and a map legend.
     * @param republicanData The republican election data
     * @param democratData The democratic election data
     * @param independentData The independent election data
     * @param x The latitude position of the graph.
     * @param y The longitude position of the graph
     * @param graphSize The size of the graph
     * @param elecYear The current election year
     * @param indexFont The font for the index of the graph
     * @param graphFont The font for the rest of the graph
     * @return 
     */
    public double ratio(double republicanData, double democratData, double independentData, double x, double y, double graphSize, int elecYear, Font indexFont, Font graphFont){
        devisedNumber = "";
        
        
        republicanElection[holdYearNumber] = republicanData;
        democratElection[holdYearNumber] = democratData;
        independentElection[holdYearNumber] = independentData;
        holdYearNumber++;
                        
        if(republicanData > largest){
            largest = republicanData;
        }//end if
        if(democratData > largest){
            largest = democratData;
        }//end if
        if(independentData > largest){
            largest = independentData;
        }//end if 
                
        //sets the election data to a number less than one to fit on the graph
        if(notFixed){
            
            //Resets relativeNumber & tells the graph to go
            relativeNumber = 1000000;
            goAhead = true;
            
            //Gets the numbers below a certain value
            while(goAhead){                
                if(largest/relativeNumber < .145){
                    //Ends the loops
                    notFixed = false;
                    goAhead = false;
                }//end if
                
                else{//otherwise, it increments relativeNumber
                    relativeNumber = relativeNumber+100000;
                }//end else
                
            }//end while

            devisedNumber = devisedNumber + Integer.toString(relativeNumber).charAt(0);//Finds the index of the graph 

            for(int i=0; i<republicanElection.length; i++){   

                xPos = xPos+.009;//sets the initial position of the points
                
                //increases the pen size & font
                StdDraw.setPenRadius(.005);
                StdDraw.setFont(graphFont);

                //Draws the republican point
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.point((xPos), (y-.043)+(republicanElection[i]/relativeNumber));

                //Draws the democratic point
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.point((xPos), (y-.043)+(democratElection[i]/relativeNumber));

                //draws the independent point
                StdDraw.setPenColor(0, 160, 0);
                StdDraw.point((xPos), (y-.043)+(independentElection[i]/relativeNumber));
                
                //sets the pen back to normal settings
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(.0005);

                StdDraw.text(xPos, (y-.043)-.04, String.valueOf(elecYear), 90);//writes the election years at the bottom
                elecYear = elecYear + 4;//increments the year
                
                StdDraw.setFont(indexFont);//Makes the graph font small for the index
                if((republicanElection.length - i) <= Integer.valueOf(devisedNumber)+1){//checks to see if the graph index size needs to be incremented
                    StdDraw.text(.102, yPos, (String.valueOf(Math.abs(Integer.valueOf(devisedNumber)+1-(republicanElection.length-i)))));//writes the election years at the bottom
                    if(Integer.valueOf(devisedNumber) < 8){//checks to see if the graph index size needs to be incremented
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 7){
                            yPos = yPos + .023;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 6){
                            yPos = yPos + .027;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 5){
                            yPos = yPos + .032;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 4){
                            yPos = yPos + .038;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 3){
                            yPos = yPos + .053;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 2){
                            yPos = yPos + .08;
                        }//end if
                        
                        //Finds the number of necessary points & changes the index accordingly
                        if(Integer.valueOf(devisedNumber) == 1){
                            yPos = yPos + .16;
                        }//end if
                        
                    }//end if
                    
                    else{
                        yPos = yPos + .02;//Otherwise, it increments normally
                    }//end if
                }//end if
                
            }//end for
            
            //Finds the number of people voting per city
            if(Integer.toString((int)largest).length() == 5){
                length = " ten thousands";
            }//end if
            
            //Finds the number of people voting per city
            else if(Integer.toString((int)largest).length() == 6){
                length = " hundred thousands";
            }//end else if
            
            //Finds the number of people voting per city
            else if(Integer.toString((int)largest).length() == 7){
                length = " millions";
            }//end else if
            
            //Finds the number of people voting per city
            else if(Integer.toString((int)largest).length() == 8){
                length = " ten millions";
            }//end else if
                        
            //Writes in the map legend
            StdDraw.text(x-.06, y, ("# of voters in" + length), 90);
            StdDraw.text(x+.02, y-.115, "Election year");
                                 
            //resets the largest number & the index
            holdYearNumber = 0;
            largest = 0;
            
        }//end notFixed 
                
        return ratio;
  
    }//end ratio
    
    
    
    /**
     * Draws a new box over the old graph, and redraws everything (lines, legend, etc.) The election data is re-implemented later on in the program.
     * @param graphX The central x value of the graph
     * @param graphY The central y value of the graph
     * @param graphSize The size of the graph
     */
    public void resetGraph(double graphX, double graphY, double graphSize){
        
        StdDraw.setPenRadius(0.0009);//changes the pen size
         
        //Draws the graph's box
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(graphX-.02, graphY, graphSize);//box
        StdDraw.filledSquare(graphX-.02, graphY, graphSize);//box
        
        //Draws the lines of graph
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(graphX-.04, graphX-.07, graphX+.09, graphX-.07);//lower line (x)
        StdDraw.line(graphX-.04, graphX-.07, graphX-.04, graphX+.095);//upper line (y)

        
        //DRAWS THE GRAPH LEGEND
        
        //writes republican
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(graphX-.1, graphY+.03, "Republican");
        
        //writes democratic
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(graphX-.1, graphY, "Democratic");
        
        //writes independent
        StdDraw.setPenColor(0, 160, 0);
        StdDraw.text(graphX-.1, graphY-.03, "Independent");

        //Sets the pen back to normal
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(graphX-.1, graphY+.06, trueTitle);//Writes the name of the state
        StdDraw.setPenRadius(0.0005);

    }//end reset Graph
    
}//end class
