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
 class DataReader {

    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
        
    static String fileName;
    static int holder = 0;
    static int numberTwo = 0;
    static String countryName;
    String [] abbreviations = {"AL.txt", "AR.txt", "AZ.txt", "CA.txt", "CO.txt", "CT.txt", "DC.txt", "DE.txt", "FL.txt", "GA.txt", "IA.txt", "ID.txt", "IL.txt", "IN.txt",  "KS.txt", "KY.txt",
         "LA.txt", "MA.txt", "MD.txt", "ME.txt", "MI.txt", "MN.txt", "MO.txt", "MS.txt", "MT.txt", "NC.txt", "ND.txt", "NE.txt", "NH.txt", "NJ.txt", "NM.txt", "NV.txt", "NY.txt", "OH.txt", "OK.txt",
                 "OR.txt", "PA.txt", "RI.txt", "SC.txt", "SD.txt", "TN.txt", "TX.txt", "UT.txt", "VA.txt", "VT.txt", "WA.txt", "WI.txt", "WV.txt", "WY.txt", "USA.txt"};
    String [] longAbbreviations = {"Alabama", "Arkansas", "Arizona", "California", "Colorado", "Connecticut", "District of Colombia", "Delaware", "Florida", "Georgia", "Iowa", "Idaho", "Illinois",
            "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota",
            "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming"};

    String [] years = {"1960", "1964", "1968", "1972", "1976", "1980", "1984", "1988", "1992", "1996", "2000", "2004", "2008", "2012"};
    String next;
    double distance;
    String foundTheData;
    boolean founded = false;
    
    String holdIt = "";
    boolean repub = true;
    boolean demo = true;
    static int republican;
    static int democrat;
    static int independent;

    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public int getHolder(){
        return holder-1;
    }
    
    public String getCountryName(){
        return countryName;
    }
    
    public String[] getAbbreviations(){
        return abbreviations;
    }
    
    public String getAbbreviations(int i){
        return abbreviations[i];
    }
    
    public void setHolder(int h){
        holder = h;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public String getYears(int i){
        return years[i];
    }
    
    public String[] getYears(){
        return years;
    }
    
    public void setNext(String n){
        next = n;
    }

    public int getNumberTwo(){
        return numberTwo;
    }
    
    public void setNumberTwo(int n){
        numberTwo = n;
    }
    
    public void setFoundTheData(String f){
        foundTheData = f;
    }
    
    public String getFoundTheData(){
        return foundTheData;
    }
    
    public void setFounded(boolean f){
        founded = f;
    }
    
    public boolean getFounded(){
        return founded;
    }
    
    public int getDemocrat(){
        return democrat;
    }
    
    public int getIndependent(){
        return independent;
    }
    
    public int getRepublican(){
        return republican;
    }
    
    public String[] getLongAbbreviations(){
        return longAbbreviations;
    }
    
    public String getLongAbbreviations(int i){
        return longAbbreviations[i];
    }
    
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public String newCountyName(){
    
        holder++;//Increments the number to ensure none of  the states are constantly repeated.
        fileName = abbreviations[holder-1];
        return fileName;
    
    }
    
    public String electionData(int holdYear){
        
        String name = abbreviations[holder-1];
        String nameFinal = "";//initializes the String for the name of the state

        boolean notEndOfCounty = true;//used to determine whether 
        int c = 0;

        //Checks for the number of letters in the state name & saves them.
        while(notEndOfCounty){
            char hold = name.charAt(c);//compiles the name of the state the election is in
            c++;//increases char the program is reading in.

            //checks to see if the program has hit the decimal in the name
            if(hold == 46){
               notEndOfCounty = false;//if so,it ends the loop 
            }//end if

            else{
                nameFinal = nameFinal + hold;//otherwise, it saves the previously read in value as a letter in the abbreviation
            }//end else
        }//end for

        fileName = (nameFinal + holdYear + ".txt");//Compiles the different parts of the fileName to get the .txt file name
        
        return fileName;
        
    }//end electionData
    
    public String electionData(int holdYear, String name){
        
        String nameFinal = "";//initializes the String for the name of the state

        boolean notEndOfCounty = true;//used to determine whether 
        int c = 0;

        //Checks for the number of letters in the state name & saves them.
        while(notEndOfCounty){
            char hold = name.charAt(c);//compiles the name of the state the election is in
            c++;//increases char the program is reading in.

            //checks to see if the program has hit the decimal in the name
            if(hold == 46){
               notEndOfCounty = false;//if so,it ends the loop 
            }//end if

            else{
                nameFinal = nameFinal + hold;//otherwise, it saves the previously read in value as a letter in the abbreviation
            }//end else
        }//end for

        fileName = (nameFinal + holdYear + ".txt");//Compiles the different parts of the fileName to get the .txt file name
        
        return fileName;
        
    }//end electionData
    
    
    public void countryPoints(){
        
        boolean notNamed = true;
        
        while(notNamed){
            
            //Checks to see whether or not the next value is a number.
            if((next.charAt(0)<65)){
                if(next.charAt(0) == 45){
                    for(int i=1; i<next.length(); i++){
                        next = next + next.charAt(i);
                        
                    }
                
                
                }
                numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
                notNamed = false;//Tells the program to move on to drawing the country.
                
            }//end if

            //Saves the country name
            else if((next.charAt(0)>=65) && notNamed){
                countryName = next;//sets the country name to the pre-saved value
                notNamed = false;//Tells the program the country has already been named.

            }//end else if
        
        

    
            }//end while
        
    
    }//end countryPoints
    
    public double latitude(double lat){
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
        
        return lat;
    }
    
    public String countrySearch(String whole, String search){
        holdIt = "";
        repub = true;
        demo = true;
    
        for(int i=0; i<whole.length(); i++){
            if(whole.charAt(i) == 44){
                if(foundTheData.equals(search)){
                    
                    founded = true;
                    
                    
                   // System.out.println(foundTheData + " equals " + search);
                    for(int e=i+1; e<whole.length()-1; e++){
                                                
                        if(whole.charAt(e) == 44){//checks to see if the String has reached a comma
                                                                                                                        
                            //holder = holder + whole.charAt(e);//starts reading in the numbers
                            //the first comma becomes republican
                            if(whole.charAt(e) == 44 && repub == true){//checks to see if it's encountered a comma
                                republican = Integer.parseInt(holdIt);//sets the republican value to the current answer
                                holdIt = "";//resets HolderTwo
                                repub = false;//points the program towards democratic next time
                            }//end if

                            //the second comma becomes democratic
                            else if(whole.charAt(e) == 44 && repub == false){
                                democrat = Integer.parseInt(holdIt);//sets the democratic value to the current answer
                                holdIt = "";//resets HolderTwo
                                demo = false;//points the program towards independent next time
                            }//end else if

                            //the third comma is independent
                            else if(whole.charAt(e) == 44 && demo == false){
                                independent = Integer.parseInt(holdIt);//resets HolderTwo
                                holdIt = "";//resets holderTwo

                                //resets the party discerning booleans to their initial state
                                repub = true;
                                demo = true;
                                e = whole.length()+1;
                            }//end else if

                            //no commas have been encountered thus far
                            


                        }
                        else{
                            holdIt = holdIt + whole.charAt(e);//tacks the current number on to the end, & repeats the process
                        }//end else
                        
                    i = whole.length()+10;
                    
                }
                }
                else{
                    foundTheData = "";
                    
                }
            }
            else{
                foundTheData = foundTheData + whole.charAt(i);
                //System.out.println("parted:    " + foundTheData);
            }
            
        }                                   
        
        return foundTheData;
    }
    
    
    
    /*public int findNumberTwo(){
        
if(scan.hasNext()){//The settings for the normal states
                                next = scan.next();//Holds the first value on the sheet

                                //Checks to see whether or not the next value is a number.
                                if((next.charAt(0)<65)){

                                    numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
                                    bad = false;//Tells the program to move on to drawing the country.

                                }//end if

                                //Saves the country name
                                else if((next.charAt(0)>=65) && notNamed){
                                    countryName = next;//sets the country name to the pre-saved value
                                    notNamed = false;//Tells the program the country has already been named.

                                }

                            }//end else if
    }*/
    
}