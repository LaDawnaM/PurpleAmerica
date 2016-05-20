/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import edu.princeton.cs.introcs.StdDraw;

/**
 *
 * @author hcps-mcenhimlr
 */
public class GraphingFunctionality {

    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    String parties[];
    boolean someLeft;
    boolean goAhead;
    
    String holdYear;
    String holdTitles;
    
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
    
    static boolean found = false;
    static boolean second = false;
    static boolean keepGoing = true;
    static boolean notPresent = false;
    
    double latHalf;
    double longHalf;

    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public String getIndependent(){
        return independent;
    }
    
    public String getDemocrat(){
        return democrat;
    }
    
    public String getRepublican(){
        return republican;
    }
    
    public void setNumberTwo(int n){
        latitude = new double[n];
        longitude = new double[n];
        numberTwo = n;
    }
    
    public int getNumberTwo(){
        return numberTwo;
    }
    
    public void setHoldIt(int h){
        holdIt = h;
    }
    
    public int getHoldIt(){
        return holdIt;
    }
    
    public boolean getFound(){
        return found;
    }
    
    public void setFound(boolean f){
        found = f;
    }
    
    public void setXSmallest(int s){
        xSmallest = s;
    }
    
    public void setYSmallest(int s){
        ySmallest = s;
    }
    
    public void setXLargest(int s){
        xLargest = s;
    }
    
    public void setYLargest(int s){
        yLargest = s;
    }
    
    public void setSecond(boolean s){
        second = s;
    }
    
    public boolean getNotPresent(){
        return notPresent;
    }
    
    public void setNotPresent(boolean p){
        notPresent = p;
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public void decipherIntro(String intro){
        
        someLeft = true;
        goAhead = false;
                       
        for(int i=0; i<intro.length(); i++){

            if(intro.charAt(i) >=48 && intro.charAt(i) <= 57){
                holdYear = holdYear + intro.charAt(i);
            }

            else if(intro.charAt(i) == 32){
                holdTitles = "";
            }//end else if

            else if(intro.charAt(i) == 44){

                    if(goAhead){
                        if(republican.length() > 0){//democratic
                            democrat = holdTitles;
                            holdTitles = "";
                        }//end if

                        else if(democrat.length() > 0){//independent
                            independent = holdTitles;
                            holdTitles = "";
                            someLeft = false;
                            i = intro.length()+10;
                        }//end else if

                        else{//republican
                            republican = holdTitles;
                        }//end else
                    }
                    else{
                        goAhead = true;

                        holdTitles = "";
                    }//end else

            }//end else if

            else{
                holdTitles = holdTitles + intro.charAt(i);
            }//end else

        }//end for
                            
    }//end decipherIntro
    
    public void findLocation(double lats, double longs, double xVal, double yVal, String title){
        
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

           
          //  System.out.println("holdIt:" + holdIt);
            latitude[holdIt] = lats-.0534;//Repositions latitude to a good place on the map
            longitude[holdIt] = Math.abs(((longs+50)/25)-2.98);//Retrieves and repositions longitude on the map
            
            if(second == true){
                
                 latHalf = (xLargest-xSmallest)/2;
                 latHalf = latHalf + xSmallest;
                 
                 longHalf = (yLargest-ySmallest)/2;
                 longHalf = longHalf + ySmallest;
                 
                 //System.out.println("lat: " + latHalf + "large first: " + xLargest + " " + xSmallest + " long:" + longHalf + "large first: " + yLargest + " " + ySmallest);
                /* 
                 StdDraw.setPenColor(StdDraw.CYAN);
                 StdDraw.point(latitude[holdIt], longitude[holdIt]);
                 StdDraw.point(latHalf, longHalf);
                 StdDraw.setPenColor(StdDraw.BLACK);
                */
                 
                 
                if(latitude[holdIt] < latHalf){
                    if(latitude[holdIt] > xVal){
                        if(longitude[holdIt] < longHalf){
                            if(longitude[holdIt] > yVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                            }

                        }//end if
                        else{
                            if(longitude[holdIt] < yVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                            }
                               
                        }
                        
                        
                    }//end if
                    

                }//end if
                else if(latitude[holdIt] > latHalf){
                    if(latitude[holdIt] < xVal){
                        if(longitude[holdIt] > longHalf){
                            if(longitude[holdIt] < yVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                            }

                        }//end if
                        else{
                            if(longitude[holdIt] > yVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                            }
                               
                        }
                        
                        
                        
                    }//end if
                    

                }//end if
                
            }//end if
            
            else{
                
                
                
            
                if(latitude[holdIt] > xLargest){
                    xLargest = latitude[holdIt];

                }
                else if(latitude[holdIt] < xSmallest){
                    xSmallest = latitude[holdIt];

                }

                if(longitude[holdIt] > yLargest){
                    yLargest = longitude[holdIt];

                }
                else if(longitude[holdIt] < ySmallest){
                    ySmallest = longitude[holdIt];

                }
                
                if(xSmallest < Math.abs(xVal) && xLargest > Math.abs(xVal)){
                    if(ySmallest < Math.abs(yVal) && yLargest > Math.abs(yVal)){

                        keepGoing = true;

                        /*if(holdIt == numberTwo){
                            //System.out.println("found: " + title);
                            found = true;
                           // System.out.println("xsmall " + xSmallest + " xlarge " + xLargest + " ysmall " + ySmallest + " ylarge " + yLargest + "xVal" + xVal + "yVal" + yVal);
                            StdDraw.setPenRadius(.005);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.point(xSmallest, ySmallest);
                            StdDraw.point(xLargest, yLargest);
                            StdDraw.setPenRadius(.00005);
                            StdDraw.setPenColor(StdDraw.BLACK);
                           // System.out.println(title);
                        }*/




                    }
                
                }
                
                else{
                    keepGoing = false;
                }
            
            
            
            
            /*if(latitude[holdIt] == xVal){
                if(longitude[holdIt] == yVal){
                    System.out.println("found");
                }
            }*/
            
            //System.out.println("lat:" + latitude[holdIt] + " long:" + longitude[holdIt]);
            
            
            }
            
            
            
            
            //if(title.equals("California")){
                /*System.out.println("real lat: " + latitude[holdIt] + "verses new lat: " + xVal);
                System.out.println("real long: " + longitude[holdIt] + "verses new long: " + yVal);
                System.out.println("comp: " + (longitude[holdIt]/yVal));
                System.out.println("comp: " + (latitude[holdIt]/xVal));*/
              //  System.out.println(" xSmall " + xSmallest + " ySmall " + ySmallest + " xLarge " + xLargest + " yLarge " + yLargest);
                //System.out.println("real xVal:" + xVal + " real yVal:" + yVal);
            //}
            
        //System.out.println(data.getFileName());

    }
    
}
