/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

//import edu.princeton.cs.introcs.StdDraw;

import edu.princeton.cs.introcs.StdDraw;


/**
 *
 * @author hcps-mcenhimlr
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
    static double holdXUppoer;
    static double holdXLower;
    
    static boolean found = false;
    static boolean second = false;
    static boolean keepGoing = true;
    static boolean notPresent = false;
    
    double latHalf;
    double longHalf;
    
    double ratio;
    double total;
    
    double republicanFixed;
    double democratFixed;
    double independentFixed;
    
    static double xPos;
    static String trueTitle;
    static boolean finalRound;    

    
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
    
    public double getXSmallest(){
        return xSmallest;
    }
    
    public double getYSmallest(){
        return ySmallest;
    }
    
    public double getXLargest(){
        return xLargest;
    }
    
    public double getYLargest(){
        return yLargest;
    }
    
    
    public void setXTrueSmallest(int s){
        xTrueSmallest = s;
    }
    
    public void setYTrueSmallest(int s){
        yTrueSmallest = s;
    }
    
    public void setXTrueLargest(int s){
        xTrueLargest = s;
    }
    
    public void setYTrueLargest(int s){
        yTrueLargest = s;
    }
    
    public double getXTrueSmallest(){
        return xTrueSmallest;
    }
    
    public double getYTrueSmallest(){
        return yTrueSmallest;
    }
    
    public double getXTrueLargest(){
        return xTrueLargest;
    }
    
    public double getYTrueLargest(){
        return yTrueLargest;
    }
    
    
    public double getLatHalf(){
        return latHalf;
    }
    
    public double getLongHalf(){
        return longHalf;
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
   
                
                }
                
                else{
                    keepGoing = false;
                    //notPresent = true;
                }
            

            }
                else{
                    keepGoing = false;
                }
                
                

    }
    
    
        public void findLocation(double xVal, double yVal, String title){
            
            latHalf = (xLargest - xSmallest)/2;
            latHalf = latHalf + xSmallest;
            
            longHalf = (yLargest - ySmallest)/2;
            longHalf = longHalf + ySmallest;
            
                    if(latitude[holdIt] > xVal){
                        if(latitude[holdIt] < xTrueLargest){
                            xTrueLargest = latitude[holdIt];
                           if(longitude[holdIt] > longHalf){
                               holdYUpper = longitude[holdIt];
                            }//end if
                            else{
                              holdYLower = longitude[holdIt];
                            }//end else
                        }//end if
                    }//end if
                    else if(latitude[holdIt] < xVal){
                        if(latitude[holdIt] > xTrueSmallest){
                            xTrueSmallest = latitude[holdIt];
                            if(longitude[holdIt] > longHalf){
                                holdYUpper = longitude[holdIt];
                            }//end if
                            else{
                                holdYLower = longitude[holdIt];
                            }//end else
                        }//end if
                    }//end else if
                    
                    if(longitude[holdIt] > yVal){
                        if(longitude[holdIt] < yTrueLargest){
                            yTrueLargest = longitude[holdIt];
                           
                        }//end if
                    }//end if
                    
                    else if(longitude[holdIt] < yVal){
                        if(longitude[holdIt] > yTrueSmallest){
                            yTrueSmallest = longitude[holdIt];
                            
                        }//end if
                    }//end else if

                        
        if(finalRound){
           finalRound = false;
            if(xSmallest<xVal && xLargest > xVal){
                if(ySmallest < yVal && yLargest > yVal){
                
                        
                        if((xVal < xTrueLargest) && (xVal >xTrueSmallest)){
                            if((yVal > holdYLower && yVal < holdYUpper)){//PROBLEM LIES HERE: for some, lower is larger than higher. others, higher is larger than lower. Longitude comparisons to longHalf?
                                trueTitle = title;
                            }
                            else{
                                notPresent = true;
                                System.out.println("not " + title);
                                System.out.println("title: " + title + " large: " + holdYUpper + " yVal: " + yVal + " small: " + holdYLower);
                                StdDraw.setPenColor(StdDraw.CYAN);
                                StdDraw.point(xTrueLargest, holdYUpper);
                                StdDraw.setPenColor(StdDraw.GREEN);
                                StdDraw.point(xTrueLargest, holdYLower);
                            }
                        }
                        else{
                            notPresent = true;
                            System.out.println("not one " + title);
                            System.out.println("title: " + title + " large: " + xTrueLargest + " xVal: " + xVal + " small: " + xTrueSmallest);
                            StdDraw.setPenColor(StdDraw.RED);
                            StdDraw.point(xTrueLargest, holdYUpper);
                            StdDraw.setPenColor(StdDraw.BLUE);
                            StdDraw.point(xTrueSmallest, holdYUpper);
                        }    
                    
                    
                
                    
                    
                    ////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////
                    
                }
                else{
                    notPresent = true;
                }
                
                
            }
            else{
                notPresent = true;
            }
                
    }
        }
        
    
    public double ratio(double republican, double democrat, double independent, int position, double x, double y, double graphSize, String elecYear){
        total = republican+democrat+independent;

        
        //sets them to less than one
        republicanFixed = republican/45000000;
        democratFixed = democrat/45000000;
        independentFixed = independent/45000000;
        
        xPos = xPos+.009;
        
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point((xPos), (y-.043)+republicanFixed);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point((xPos), (y-.043)+democratFixed);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.point((xPos), (y-.043)+independentFixed);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.0005);
        
        StdDraw.text(xPos, (y-.043)-.04, elecYear, 90);

        if(republican>independent){
            
        }
        else{
            
        }
        
        return ratio; 
       
    }//end ratio
    
    public void resetGraph(double graphX, double graphY, double graphSize){
        StdDraw.setPenRadius(0.0009);//changes the pen size
 
                
                //Draws the box & graph lines
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledSquare(graphX, graphY, graphSize);//box
                StdDraw.filledSquare(graphX, graphY, graphSize);//box
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(graphX-.05, graphX-.05, graphX+.08, graphX-.05);//lower line (x)
                StdDraw.line(graphX-.05, graphX-.05, graphX-.05, graphX+.08);//upper line (y)
              //  StdDraw.li

                //Graph Legend
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.text(graphX-.09, graphY+.03, "Republican");
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.text(graphX-.09, graphY, "Democratic");
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(graphX-.09, graphY-.03, "Independent");
                
                //Sets the pen back to normal settings
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.0005);//changes the pen size
                
    }
    
}
