/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 *
 * <ul>cleared - tells the map if its drawing a single country. Used to determine how much to draw.</ul> <ul>lati - the final latitude. Used to hold the double statically.</ul><ul>longi - the final longitude. Used to hold the double statically</ul> <ul>first - the first time running through that loop. Used to determine whether to get new relative numbers</ul> <ul>relativeNumber - the lat relative number. Used to save the static version of the relativeNumber.</ul><ul> relativeyNumber - the long relative number. Used to save the static version of the relativeyNumber.</ul> <ul>xLargest - holds the largest x value. Used to determine the state's bounding box.</ul> <ul>yLargest - holds the largest y value. Used to determine the state's bounding box.</ul> <ul>xSmallest - holds the smallest x value. Used to determine the state's bounding box.</ul><ul>ySmallest - holds the smallest y value. Used to determine the state's bounding box.</ul> <ul>okay - holds whether or not the map is within the bounding box. Tells the map whether it needs to repeat.</ul>
 * @author hcps-mcenhimlr
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
    }
    
    public double[] getLat(){
        return lat;
    }
    
    public boolean getOkay(){
        return okay;
    }
    
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
        okay = false;
        
        if(xLargest < .9 && xSmallest > .1){
            if(yLargest < .9 && ySmallest > .1){
                okay = true;
            }
        }
        
        return okay;
        
    }
    
    public void improveLocation(double[] latitude, double[] longitude){
        for(int i=0; i<latitude.length; i++){
            if(xLargest > .9){
                latitude[i] = Math.abs(latitude[i] + (xLargest-.9));
            }
            if(xSmallest < .1){
                latitude[i] = Math.abs(latitude[i] + (xSmallest-.1));
            }
            if(yLargest > .9){
                longitude[i] = Math.abs(longitude[i] + (yLargest-.9));
            }
            if(ySmallest < .1){
                longitude[i] = Math.abs(longitude[i] + (ySmallest-.1));
            }
            
            //System.out.println("lat: " + latitude[i] + " long: " + longitude[i]);
            
        }
        
        lat = latitude;
        longe = longitude;
        
    }
    
    
    
    
    public boolean comparisons(){
        if(lati < .65 && lati > .45){
            notTrue = false;
        }
        else{
            relativeNumber = relativeNumber + .05;
        }

        if(longi < .65 && longi > .45){
            if(notTrue == false){
                notTrue = false;
            }
        }
        else{
            relativeyNumber = relativeyNumber +.05;
            notTrue = true;
        }
        
        return notTrue;
    }
    
    
    
    public void drawTheStates(double holdLat, double holdLong){
        
    
        if(first == true){
            relativeNumber = 0.6;
            relativeyNumber = 0.5;
            notTrue = true;
            while(notTrue){

                lati = Math.abs(((Math.abs(((holdLat+50)/62)+.26))*5)+.26-relativeNumber);
                longi = Math.abs(((Math.abs(((holdLong+50)/25)+2.98))*5)-2.98-relativeyNumber);

                if(lati < .59 && lati > .49){
                    notTrue = false;
                }
                else{
                    relativeNumber = relativeNumber + .5;
                }

                if(longi < .59 && longi > .49){
                    if(notTrue == false){
                        notTrue = false;
                        System.out.println(longi);
                    }
                }
                else{
                    relativeyNumber = relativeyNumber +.5;
                    notTrue = true;
                }


            }

            first = false;

        }//end if


        lati = Math.abs(((Math.abs(((holdLat+50)/62)+.26))*5)+.26-relativeNumber);
        longi = Math.abs(((Math.abs(((holdLong+50)/25)+2.98))*5)-2.98-relativeyNumber);

        
    }
    
}
