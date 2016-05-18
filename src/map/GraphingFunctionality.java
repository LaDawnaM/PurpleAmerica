/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

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
            double lat = Math.abs(((lats+50)/62)+0.26);
            double distance;

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

           
          //  System.out.println("holdIt:" + holdIt);
            latitude[holdIt] = lat-.0534;//Repositions latitude to a good place on the map
            longitude[holdIt] = Math.abs(((longs+50)/25)-2.98);//Retrieves and repositions longitude on the map
            
            if(latitude[holdIt] == xVal){
                if(longitude[holdIt] == yVal){
                    System.out.println("found");
                }
            }
            
            
            if(title.equals("California")){
                System.out.println("real lat: " + latitude[holdIt] + "verses new lat: " + xVal);
                System.out.println("real long: " + longitude[holdIt] + "verses new long: " + yVal);
                System.out.println("comp: " + (longitude[holdIt]/yVal));
                System.out.println("comp: " + (latitude[holdIt]/xVal));
            }
            
        //System.out.println(data.getFileName());

    }
    
}
