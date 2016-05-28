/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 * LaDawna McEnhimer, Forest Kim, Jacob Lesley
 * <p> DrawIndividualStates
 * <p> VARIABLES: <ul>cleared - tells the map if its drawing a single country. Used to determine how much to draw.</ul> <ul>lati - the final latitude. Used to hold the double statically.</ul><ul>longi - the final longitude. Used to hold the double statically</ul> <ul>first - the first time running through that loop. Used to determine whether to get new relative numbers</ul> <ul>relativeNumber - the lat relative number. Used to save the static version of the relativeNumber.</ul><ul> relativeyNumber - the long relative number. Used to save the static version of the relativeyNumber.</ul> <ul>xLargest - holds the largest x value. Used to determine the state's bounding box.</ul> <ul>yLargest - holds the largest y value. Used to determine the state's bounding box.</ul> <ul>xSmallest - holds the smallest x value. Used to determine the state's bounding box.</ul><ul>ySmallest - holds the smallest y value. Used to determine the state's bounding box.</ul> <ul>okay - holds whether or not the map is within the bounding box. Tells the map whether it needs to repeat.</ul><ul>longe - an array holding the longitudinal points. Used to save the revised longitude points.</ul><ul>lat - an array holding the latitudinal points. Used to save the revised latitudinal points.</ul><ul> xHalf - holds the central latitude point of a state. Used to get states as close to the center of the map as possible</ul><ul> yHalf - holds the central longitude point of a state. Used to get states as close to the center of the map as possible</ul><ul> repeat - tells the program whether or not the correct value to add/subtract by has been found. Used to end/start a loop. </ul><ul> xSubtract - the x value to add/subtract from. Used to subtract a devised value & put the map in place.</ul><ul> ySubtract - the y value to add/subtract from. Used to subtract a devised value & put the map in place.</ul><ul>
 * <p> METHODS: <ul>findBoundingBox() - finds the outermost points of the state to be plotted.</ul><ul>checkBoundingBox() - checks to see if the bounding box is on the map.</ul><ul> improveLocation() - moves the map to a more preferable location.</ul>
 */
public class DrawIndividualStates {
    

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
        
    boolean first;
    
    double relativeNumber;
    double relativeyNumber;
    
    double lati;
    double longi;
    
    boolean notTrue;
    boolean cleared;
    
    double xLargest;
    double yLargest;
    double xSmallest;
    double ySmallest;
    
    boolean okay;
    
    double[] longe;
    double[] lat;
    
    double xHalf;
    double yHalf;
    boolean repeat;
    
    double xSubtract;
    double ySubtract;
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////CONSTRUCTOR/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public DrawIndividualStates(){
        cleared = false;
    }//end constructor
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////GETTERS/SETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    public double[] getLonge(){
        return longe;
    }//end getLonge
    
    public double[] getLat(){
        return lat;
    }//end getLat
    
    public boolean getOkay(){
        return okay;
    }//end getOkay
    
    public void setRelativeNumber(double r){
        relativeNumber = r;
    }//end relativeNumber
    
    public double getRelativeNumber(){
        return relativeNumber;
    }//end relativeNumber
    
    public void setRelativeyNumber(double r){
        relativeyNumber = r;
    }//end relativeNumber
    
    public double getRelativeyNumber(){
        return relativeyNumber;
    }//end relativeNumber
    
    public void setFirst(boolean l){
        first = l;
    }//end setLongi
    
    public boolean getFirst(){
        return first;
    }//end getLongi
    
    public void setLongi(double l){
        longi = l;
    }//end setLongi
    
    public double getLongi(){
        return longi;
    }//end getLongi
    
    public void setLati(double l){
        lati = l;
    }//end setLati
    
    public double getLati(){
        return lati;
    }//end getLati
    
    public void setCleared(boolean c){
        cleared = c;
    }//end cleared
    
    public boolean getCleared(){
        return cleared;
    }//end cleared
    
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
    
    
        
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    public void findBoundingBox(double holdLat, double holdLong){
        
        //Checks for the bounding box of the state
        if(holdLat > xLargest){//If that latitude point is the farthest to the right so far
            xLargest = holdLat;//the latitude point becomes the new farthest latitude
        }//end if
        
        else if(holdLat < xSmallest){//If that latitude point is the farthest to the left so far
            xSmallest = holdLat;//the latitude point becomes the new smallest latitude
        }//end else if

        if(holdLong > yLargest){//If that longitude point is the highest so far
            yLargest = holdLong;//the longitude point becomes the new highest longitude
        }//end if
        
        else if(holdLong < ySmallest){//If that longitude point is the lowest so far
            ySmallest = holdLong;//the longitude point becomes the new lowest longitude
        }//end else if

        
    }//end findBoundingBox
    
    
    public boolean checkBoundingBox(double[] latitude, double[] longitude){
        okay = false;//Resets okay
        
        if(xLargest < .7 && xSmallest > .3){//checks to see if the longitude is on the screen
            if(yLargest < .7 && ySmallest > .3){//checks to see if the latitude is on the screen
                okay = true;//Tells the program the state isn't on the screen
            }//end if
        }//end if
        
        return okay;
        
    }//end checkBoundingBox
    
    
    
    public void improveLocation(double[] latitude, double[] longitude, String title){
        
        //Gets the points in the center of the graph
        xHalf = (xLargest - xSmallest) + xSmallest;
        yHalf = (yLargest - ySmallest) + ySmallest;
        
        //Resets the points the program is going to subtract from
        xSubtract = 0;
        ySubtract = 0;
        
        //An exception for Texas
        if(title.equals("Texas")){
            for(int i=0; i<latitude.length; i++){
                latitude[i] = latitude[i] + .2;//Changes Texas by the degree it requires
            }//end for
        }//end if
        
        //An exception for Idaho
        else if(title.equals("Idaho")){
            for(int i=0; i<longitude.length; i++){
                longitude[i] = longitude[i] - .2;//Changes Idaho by the degree it requires
            }//end for
        }//end else if
        
        else{
            repeat = true;//tells the program to repeat the first loop

            //the x value's while loop
            while(repeat){
                if(xHalf < .2 || xHalf > .8){//If the x value isn't on the screen...
                    if(xHalf > .5){//If the x value is more than halfway down...
                        xHalf = xHalf - xSubtract;//Sets an normalized number to see how much the program needs taken away.
                        if(xHalf > .4 && xHalf < .6){//Checks to see if the state is positioned properly
                            repeat = false;//Ends the loop
                            
                            for(int i=0; i<latitude.length; i++){
                                    latitude[i] = Math.abs(latitude[i] - xSubtract);//Alters each latitude point to be positioned properly

                            }//end for

                        }//end if
                        
                        else{//Otherwise, the number to be subtracted by is incremented
                            xSubtract = xSubtract + .5;
                        }//end else
                    }
                    else if(xHalf < .5){//If the x value is less than halfway down...
                        xHalf = xHalf + xSubtract;//Sets an normalized number to see how much the program needs taken away.
                        if(xHalf > .4 && xHalf < .6){//Checks to see if the state is positioned properly
                            repeat = false;//ends the loop

                            for(int i=0; i<latitude.length; i++){
                                latitude[i] = Math.abs(latitude[i] + xSubtract);//Alters each latitude point to be positioned properly
                            }//end for

                        }//end if
                        
                        else{
                            xSubtract = xSubtract + .5;
                        }//end else
                        
                    }//end else if

                }//end if
                
                else{
                    repeat = false;//otherwise, ends the loop
                }//end else
                


            }//end while

            repeat = true;//tells the program to repeat the second loop

            //the y value's while loop
            while(repeat){
                if(yHalf < .2 || yHalf > .8){//If the y value isn't on the screen...
                    if(yHalf > .5){//If the y value is more than halfway down...

                        yHalf = yHalf - ySubtract;//Sets an normalized number to see how much the program needs taken away.
                        if(yHalf > .4 && yHalf < .6){//Checks to see if the state is positioned properly
                            repeat = false;//ends the loop
                            
                            for(int i=0; i<longitude.length; i++){
                                    longitude[i] = Math.abs(longitude[i] - ySubtract);//Alters each latitude point to be positioned properly
                            }//end for

                        }//end if
                        
                        else{//Otherwise, the number to be subtracted by is incremented
                            ySubtract = ySubtract + .5;
                        }//end else
                        
                    }//end if

                    else if(yHalf < .5){//If the y value is less than halfway down...

                        yHalf = yHalf + ySubtract;//Sets an normalized number to see how much the program needs taken away.
                        if(yHalf > .4 && yHalf < .6){//Checks to see if the state is positioned properly
                            repeat = false;//ends the loop
                            
                            for(int i=0; i<longitude.length; i++){
                                longitude[i] = Math.abs(longitude[i] - ySubtract);//Alters each latitude point to be positioned properly
                            }//end for

                        }//end if
                        
                        else{//Otherwise, the number to be subtracted by is incremented
                            ySubtract = ySubtract + .5;
                        }//end else
                        
                    }//end else if
                    
                }//end if
                
                else{
                    repeat = false;//ends the loop
                }//end else

            }//end while
        
    }//end else
        
        
    //Sets arrays the program can retrieve to lat/long
    lat = latitude;
    longe = longitude;
    
    
    }//end improveLocation
    
    
}//end class
