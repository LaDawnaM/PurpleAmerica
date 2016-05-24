/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

//import edu.princeton.cs.introcs.StdDraw;

import edu.princeton.cs.introcs.StdDraw;


/** 
 * LaDawna McEnhimer
 * <p>GraphingFunctionality
 * <p>Variables: <ul></ul>
 * <p>Methods: <ul></ul>
 */
public class GraphingFunctionality {

    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    boolean someLeft;
    boolean goAhead;
    
    String holdYear;
    String holdTitles;
    static String savedTitle = "";
    
    String independent = "";
    String republican = "";
    String democrat = "";
    
    static double[] longitude;
    static double[] latitude;
    static int numberTwo;
    static int holdIt;
    
    static double xLargest;
    static double yLargest;
    static double xSmallest;
    static double ySmallest;
    
    static double xTrueLargest;
    static double yTrueLargest;
    static double xTrueSmallest;
    static double yTrueSmallest;
    
    static double holdYUpper;
    static double holdYLower;

    static boolean notPresent = false;
    
    double latHalf;
    double longHalf;
    
    double ratio;
    double total;
    
    double republicanFixed;
    double democratFixed;
    double independentFixed;
    
    static double xPos;
    static String trueTitle = "Alabama";
    static boolean finalRound;    
    static boolean countries;
    
    static String title;
    static int go;
    
    boolean notFixed = false;
    int relativeNumber;
    
    static double[] republicanElection = new double[14];
    static double[] democratElection = new double[14];
    static double[] independentElection = new double[14];
    int holdYearNumber = 0;

    static boolean maybePresent;
    
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
    }

    public void setXTrueLargest(int s){
        xTrueLargest = s;
    }
    
    public boolean getNotPresent(){
        return notPresent;
    }
    
    public void setNotPresent(boolean p){
        notPresent = p;
    }
    
    public void setSavedTitles(String s){
        savedTitle = s;
    }
    
    public String getSavedTitles(){
        return savedTitle;
    }
    
    public void setXPos(double s){
        xPos = Math.abs(s-.92);
    }

    public String getTrueTitle(){
        return trueTitle;
    }
    
    public void setTrueTitle(String t){
        trueTitle = t;
    }
   
    public void setFinalRound(boolean d){
        finalRound = d;
    }
    
    public void setCountries(boolean c){
        countries = c;
    }
    
    public boolean getCountries(){
        return countries;
    }
    
    public void setHoldYearNumber(int h){
        holdYearNumber = h;
    }
    
    public void setNotFixed(boolean n){
        notFixed = n;
    }
    
    public void setMaybePresent(boolean m){
        maybePresent = m;
    }
    
    public boolean getMaybePresent(){
        return maybePresent;
    }
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Deciphers the first line of the election data file. Determines which presidents were running for which party.
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

        //gets the central-most latitude of the state
        latHalf = (xLargest - xSmallest)/2;
        latHalf = latHalf + xSmallest;

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
     * @param republican The republican election data
     * @param democrat The democratic election data
     * @param independent The independent election data
     * @param x The latitude position of the graph.
     * @param y The longitude position of the graph
     * @param graphSize The size of the graph
     * @param elecYear The current election year
     * @return 
     */
    public double ratio(double republican, double democrat, double independent, double x, double y, double graphSize, String elecYear){
        total = republican+democrat+independent;//gets the total number of votes
        
        republicanFixed = republican/40000000;
        democratFixed = democrat/40000000;
        independentFixed = independent/40000000;
        
        xPos = xPos+.009;//sets the initial position of the points
                 
        StdDraw.setPenRadius(.005);//increases the pen size
        
        //Draws the republican point
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point((xPos), (y-.043)+republicanFixed);
        
        //Draws the democratic point
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point((xPos), (y-.043)+democratFixed);
        
        //draws the independent point
        StdDraw.setPenColor(0, 160, 0);
        StdDraw.point((xPos), (y-.043)+independentFixed);
        
        //sets the pen back to normal settings
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.0005);
        
        StdDraw.text(xPos, (y-.043)-.04, elecYear, 90);//writes the election years at the bottom

        return ratio;//??? Breaks without it...
  
    }//end ratio
    
    
    
    /**
     * It retrieves the election data, and makes it small enough to fit within the borders of the map. It draws all of the points on the graph, as well as the years beneath them, and a map legend.
     * @param republican The republican election data
     * @param democrat The democratic election data
     * @param independent The independent election data
     * @param x The latitude position of the graph.
     * @param y The longitude position of the graph
     * @param graphSize The size of the graph
     * @param elecYear The current election year
     * @return 
     */
    public double ratioTest(double republican, double democrat, double independent, double x, double y, double graphSize, int elecYear){
        total = republican+democrat+independent;//gets the total number of votes
        
        republicanElection[holdYearNumber] = republican;
        democratElection[holdYearNumber] = democrat;
        independentElection[holdYearNumber] = independent;

        relativeNumber = 4000000;
        
        //sets the election data to a number less than one to fit on the graph
        if(notFixed){
            for(int i=0; i<republicanElection.length; i++){
                republicanFixed = republicanElection[holdYearNumber]/relativeNumber;
                democratFixed = democratElection[holdYearNumber]/relativeNumber;
                independentFixed = independentElection[holdYearNumber]/relativeNumber;
                holdYearNumber++;
                
                if(republicanFixed < .115 && democratFixed < .115 && independentFixed < .115){
                    notFixed = false;
                    System.out.println(republicanFixed + " " + democratFixed + " " + independentFixed);
                }//end if
                else{
                    notFixed = true;
                    i=0;
                    holdYearNumber = 0;
                    relativeNumber = relativeNumber+100000;
                    
                }//end else
                
            }
           /* if(republicanFixed < .115 && democratFixed < .115 && independentFixed < .115){
                notFixed = false;
            }//end if
            else{
                relativeNumber = relativeNumber+100000;
            }//end else
*/
            for(int i=0; i<republicanElection.length; i++){   

                xPos = xPos+.009;//sets the initial position of the points
                
                StdDraw.setPenRadius(.005);//increases the pen size

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
                elecYear = elecYear + 4;    
            }//end for
                        
        }//end notFixed 
        
        notFixed = true;
        
        return ratio;//??? Breaks without it...
  
    }//end ratio
    
    
    
    /**
     * Draws a new box over the old graph, and redraws everything (lines, legend, etc.) The election data is re-implemented later on in the program.
     * @param graphX The central x value of the graph
     * @param graphY The central y value of the graph
     * @param graphSize The size of the graph
     */
    public void resetGraph(double graphX, double graphY, double graphSize){
        
        StdDraw.setPenRadius(0.0009);//changes the pen size
 
        //Draws the box & graph lines
        
        //Draws the box
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(graphX, graphY, graphSize);//box
        StdDraw.filledSquare(graphX, graphY, graphSize);//box
        
        //Draws the lines of graph
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(graphX-.05, graphX-.05, graphX+.08, graphX-.05);//lower line (x)
        StdDraw.line(graphX-.05, graphX-.05, graphX-.05, graphX+.08);//upper line (y)

        
        //Draws the graph legend
        
        //writes republican
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(graphX-.09, graphY+.03, "Republican");
        
        //writes democratic
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(graphX-.09, graphY, "Democratic");
        
        //writes independent
        StdDraw.setPenColor(0, 160, 0);
        StdDraw.text(graphX-.09, graphY-.03, "Independent");

        //Sets the pen back to normal
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(graphX-.09, graphY+.06, trueTitle);//Writes the name of the state
        StdDraw.setPenRadius(0.0005);

    }//end reset Graph
    
}//end class
