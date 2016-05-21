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
    
    String parties[];
    boolean someLeft;
    boolean goAhead;
    
    String holdYear;
    String holdTitles;
    String savedTitle = "";
    
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
    
    double ratio;
    double total;
    
    double republicanFixed;
    double democratFixed;
    double independentFixed;
    
    static double xPos;
    
    static double xAverage;
    static double yAverage;

    static boolean chance;
    
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
    
    public double getXAverage(){
        return xAverage;
    }
    
    public void setXAverage(double x){
        xAverage = x;
    }
    
    public double getYAverage(){
        return yAverage;
    }
    
    public void setYAverage(double x){
        yAverage = x;
    }
    
    public void setChance(boolean c){
        chance = c;
    }
    
    public boolean getChance(){
        return chance;
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
    
    public void findLocation(double lats, double longs, double xVal, double yVal, String title/*, double minLat, double maxLat, double minLong, double maxLong*/){
        
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
                        
            
            
            /*else{
                xAverage = latitude[holdIt] + xAverage;
                xAverage = xAverage/2;

                yAverage = longitude[holdIt] + yAverage;
                yAverage = yAverage/2;
                
                
            }  */
                
            
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
                        //System.out.println("Maybe? " + title);
                        keepGoing = true;
                      //  notPresent = false;
                        
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




                   // }
                
                }
                
                else{
                    keepGoing = false;
                    //notPresent = true;
                }
            
            
            
            
            /*if(latitude[holdIt] == xVal){
                if(longitude[holdIt] == yVal){
                    System.out.println("found");
                }
            }*/
            
            //System.out.println("lat:" + latitude[holdIt] + " long:" + longitude[holdIt]);
            
            
            }
                else{
                    keepGoing = false;
                }
            
            
            
            
            //if(title.equals("California")){
                /*System.out.println("real lat: " + latitude[holdIt] + "verses new lat: " + xVal);
                System.out.println("real long: " + longitude[holdIt] + "verses new long: " + yVal);
                System.out.println("comp: " + (longitude[holdIt]/yVal));
                System.out.println("comp: " + (latitude[holdIt]/xVal));*/
              //  System.out.println(" xSmall " + xSmallest + " ySmall " + ySmallest + " xLarge " + xLargest + " yLarge " + yLargest);
                //System.out.println("real xVal:" + xVal + " real yVal:" + yVal);
            //}
            
        //System.out.println(data.getFileName());*/

    }
    
    
        public void findLocation(double xVal, double yVal, String title){
          
            if(xSmallest<xVal && xLargest > xVal){
                if(ySmallest < yVal && yLargest > yVal){
                    System.out.println("HALELUYER " + title);
                    System.out.println("title: " + title + " xSmallest: " + xSmallest + " xVal: " + xVal + " xLargest: "  + xLargest + " ySmallest " + ySmallest +  " yVal: " + yVal + " yLargest: " + yLargest);

                }
                else{
                    System.out.println("LOST sec. title: " + title + " real lat: " + xSmallest + " " + xLargest + " x: " + xVal + " yx " + ySmallest + " " + yLargest +  " y: " + yVal);
                    notPresent = true;
                }
                
                
            }
            else{
                System.out.println("LOST first. title: " + title + " real lat: " + xSmallest + " " + xLargest + " x: " + xVal + " yx " + ySmallest + " " + yLargest +  " y: " + yVal);
                notPresent = true;
            }
            
            /* // if(second == true){
                //System.out.println(xLargest);
                 latHalf = (xLargest - xSmallest)/2;
                 latHalf = latHalf + xSmallest;
                 
                 longHalf = (yLargest-ySmallest)/2;
                 longHalf = longHalf + ySmallest;
                 */
            //     StdDraw.point(xVal, yVal);
          //       StdDraw.point(latHalf, longHalf);
                 
                 //System.out.println("lat: " + latHalf + "large first: " + xLargest + " " + xSmallest + " long:" + longHalf + "large first: " + yLargest + " " + ySmallest);
                
               /*  StdDraw.setPenColor(StdDraw.CYAN);
                 StdDraw.setPenRadius(.05);
                 //StdDraw.point(latitude[holdIt], longitude[holdIt]);
              //   StdDraw.point(xAverage, yAverage);
                 System.out.println("title" + title + "x: " + xAverage + "y: " + yAverage);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius(.0005);*/
                
                // System.out.println(title);
                 //The xAverage is the combined, so should be in the center of the states. Don't know if it works. Latest change. 
                 
              //  System.out.println("lat: " + latitude[holdIt] + " long: " + longitude[holdIt] + " hold: " + holdIt);
                 
               /* if(latitude[holdIt] > latHalf){
                    if(latitude[holdIt] > yVal){
                        if(longitude[holdIt] < longHalf){
                            if(longitude[holdIt] < xVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                                System.out.println("one title: " + title + " real lat: " + latitude[holdIt] + " x: " + xVal + " real long: " + longitude[holdIt] + " y: " + yVal);
                            }

                        }//end if
                        else{
                            if(longitude[holdIt] > xVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                                System.out.println("two title: " + title + " real lat: " + latitude[holdIt] + " x: " + xVal + " real long: " + longitude[holdIt] + " y: " + yVal);

                            }
                               
                        }
                        
                        
                    }//end if
                    

                }//end if
                else if(latitude[holdIt] < latHalf){
                    if(latitude[holdIt] < yVal){
                        if(longitude[holdIt] > longHalf){
                            if(longitude[holdIt] > xVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                                System.out.println("three title: " + title + " real lat: " + latitude[holdIt] + " x: " + xVal + " real long: " + longitude[holdIt] + " y: " + yVal);
                            }

                        }//end if
                        else{
                            if(longitude[holdIt] < xVal){
                                
                            }
                            else{
                                notPresent = true;
                                keepGoing = false;
                                System.out.println("four title: " + title + " real lat: " + latitude[holdIt] + " x: " + xVal + " halfLat: " + latHalf + " real long: " + longitude[holdIt] + " y: " + yVal + " halfLong: " + longHalf);
                            }
                               
                        }
                        
                        
                        
                    }//end if
                    

                }//end if
                */
          //  }//end if
                
    }
    
    public double ratio(double republican, double democrat, double independent, int position, double x, double y, double graphSize){
        total = republican+democrat+independent;
/*        
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledSquare(x+.019, y+.02, .065);
            StdDraw.setPenColor(StdDraw.BLACK);
*/
//  System.out.println(republican);
        
        //sets them to less than one
        republicanFixed = republican/45000000;
        democratFixed = democrat/45000000;
        independentFixed = independent/45000000;
        
      //  System.out.println("one: " + republicanFixed);
        
       /* republicanFixed = republicanFixed/50;
        democratFixed = democratFixed/50;
        independentFixed = independentFixed/50;*/
        
      //  System.out.println("two: " + republicanFixed);
        
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
     //   System.out.println("val : " + republicanFixed+(x-.05) + " " + (y-.05));
      //  StdDraw.point(ratio, ratio);
        
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
