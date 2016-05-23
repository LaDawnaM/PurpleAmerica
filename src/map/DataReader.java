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
    
    boolean bad = true;
    boolean notNamed;
    
    boolean countryDivisor;

    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public int getHolder(){
        return holder-1;
    }//end getHolder
    
    public String getCountryName(){
        return countryName;
    }//end getCountryName
    
    public void setCountryName(String c){
        countryName = c;
    }//end setCountryName
    
    public String[] getAbbreviations(){
        return abbreviations;
    }//end getAbbreviations
    
    public String getAbbreviations(int i){
        return abbreviations[i];
    }//end getAbbreviations
    
    public void setHolder(int h){
        holder = h;
    }//end setHolder
    
    public String getFileName(){
        return fileName;
    }//end getFileName
    
    public String getYears(int i){
        return years[i];
    }//end getYears
    
    public String[] getYears(){
        return years;
    }//end getYears
    
    public void setNext(String n){
        next = n;
    }//end next

    public int getNumberTwo(){
        return numberTwo;
    }//end getNumberTwo
    
    public void setNumberTwo(int n){
        numberTwo = n;
    }//end setNumberTwo
    
    public void setFoundTheData(String f){
        foundTheData = f;
    }//end setFoundTheData
    
    public String getFoundTheData(){
        return foundTheData;
    }//end getTheDAta
    
    public void setFounded(boolean f){
        founded = f;
    }//end setFounded
    
    public boolean getFounded(){
        return founded;
    }//end getFounded
    
    public int getDemocrat(){
        return democrat;
    }//end getDemocrat
    
    public int getIndependent(){
        return independent;
    }//end getIndependent
    
    public int getRepublican(){
        return republican;
    }//end getRepublican
    
    public String[] getLongAbbreviations(){
        return longAbbreviations;
    }//end getLongAbbreviations
    
    public String getLongAbbreviations(int i){
        return longAbbreviations[i];
    }//end getLongAbbreviations
    
    public boolean getBad(){
        return bad;
    }//end getBad
    
    public void setBad(boolean b){
        bad = b;
    }//end setBad
    
    public boolean getNotNamed(){
        return notNamed;
    }//end getNotNamed
    
    public void getNotNamed(boolean b){
        notNamed = b;
    }//end getNotNamed
    
    public void setCountryDivisor(boolean c){
        countryDivisor = c;
    }//end setCountryDivisor
    
    public boolean getCountryDivisor(){
        return countryDivisor;
    }//end getCountryDivisor
    
    
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Retrieves the name of the next file to be accessed from the array
     * @return Filename - The name of the file
     */
    public String newCountyName(){
    
        holder++;//Increments the number to ensure none of  the states are constantly repeated.
        fileName = abbreviations[holder-1];//sets the name of the file to the current .txt
        return fileName;
    
    }//end newCountyName
    
    
    
    /**
     * Goes through the arrays until it finds the abbreviation equivalent to the election state the program is in. Creates the fileName based off of that abbreviation.
     * @param holdYear the year the program is searching for
     * @return FileName - the name of the file for the election year
     */
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
    
    
    /**
     * Goes through the arrays until it finds the abbreviation equivalent to the election state the program is in. Creates the fileName based off of that abbreviation.
     * @param holdYear The year the program is searching for
     * @param name The country the program is looking for
     * @return FileName - the name of the file for the election year
     */
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
        
        notNamed = true;
        
        while(notNamed){
            
            //Checks to see whether or not the next value is a number.
            if((next.charAt(0)<65)){
                if(next.charAt(0) == 45){//checks to see if it's a negative number
                    
                    //removes the negative sign
                    for(int i=1; i<next.length(); i++){
                        next = next + next.charAt(i);
                    }//end for
                
                }//end if
                
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
    
    
    /**
     * Reverses the map
     * @param lat The current latitude of the map (before reversal)
     * @return lat - The fixed latitude of the map (after reversal)
     */
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
        
        lat = lat - .0534;//sets the latitude to the perfect position 
        return lat;
        
    }//end latitude
    
    
    
    /**
     * Deciphers the election data for a certain state. First figures out whether the first word is the proper state, and then goes to save the republican, democratic, and independent election values.
     * @param whole The string with the entire line of election data
     * @param search The name of the state the program is looking for
     * @return foundTheData - The name of the country.
     */
    public String countrySearch(String whole, String search){
        holdIt = "";//makes a temporary variable to save the String to a certain point.
        
        //makes booleans to tell which party it's on
        repub = true;
        demo = true;
    
        //Scrolls through the string
        for(int i=0; i<whole.length(); i++){
            
            if(whole.charAt(i) == 44){//checks to see if it's at a comma
                
                if(foundTheData.equals(search)){//checks to see if the program found the right county line 
                    
                    founded = true;//tells the program it's found the proper string
                    
                    //Scrolls through the remainder of the String
                    for(int e=i+1; e<whole.length()-1; e++){
                                                
                        if(whole.charAt(e) == 44){//checks to see if the String has reached a comma
                                                                                                                        
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

                        }//end if
                        else{
                            holdIt = holdIt + whole.charAt(e);//tacks the current number on to the end, & repeats the process
                        }//end else
                        
                        i = whole.length()+10;//ends the large loop
                    
                    }//end for
                    
                }//end if
                
                else{//clears the line of data
                    foundTheData = "";
                }//end else
            
            }//end if
            
            else{//it's not at a comma
                foundTheData = foundTheData + whole.charAt(i);//tacks the current String on to the end, & repeats the process
            }//end else
            
        }//end for                     
        
        return foundTheData;
        
    }//end countrySearch
    
    
    
    /**
     * Figures out how many states need to be drawn, and the name of the state.
     * @param next The number of countries to be plotted OR the name of the country
     */
    public void drawStates(String next){

        //Checks to see whether or not the next value is a number.
        if((next.charAt(0)<65)){
            numberTwo = Integer.parseInt(next);//Saves the number of points to be plotted.
            bad = false;//Tells the program to move on to drawing the country.

        }//end if

        //Saves the country name
        else if((next.charAt(0)>=65) && notNamed){
            countryName = next;//sets the country name to the pre-saved value
            notNamed = false;//Tells the program the country has already been named.

        }//end else if
    
    }//end drawStates
    
    
    
    /**
     * Figures out the name of the country the program is currently drawing & saves the election data accordingly. 
     * @param hold The string the program is currently searching through
     */
    public void countryDivisor(String hold){

        //creates strings to hold the broken down portion of hold.
        String holderTwo = "";
        String holder = "";

        //finds the country name
        for(int i=0; i<hold.length(); i++){
            if(hold.charAt(i) == 44){//checks to see if the String has reached a comma
                //if so, it runs through the string up until the comma, and sets that as the country name
                for(int e=0; e<i; e++){
                    holder = holder + hold.charAt(e);
                }
                //sets booleans to discern republican from democratic from independent.
                boolean repub = true;
                boolean demo = true;

                //seperates the election results by party
                for(int e=i+1; e<hold.length(); e++){
                    holder = holder + hold.charAt(e);//starts reading in the numbers

                    //the first comma becomes republican
                    if(hold.charAt(e) == 44 && repub == true){//checks to see if it's encountered a comma
                        republican = Integer.parseInt(holderTwo);//sets the republican value to the current answer
                        holderTwo = "";//resets HolderTwo
                        repub = false;//points the program towards democratic next time
                    }//end if

                    //the second comma becomes democratic
                    else if(hold.charAt(e) == 44 && repub == false){
                        democrat = Integer.parseInt(holderTwo);//sets the democratic value to the current answer
                        holderTwo = "";//resets HolderTwo
                        demo = false;//points the program towards independent next time
                    }//end else if

                    //the third comma is independent
                    else if(hold.charAt(e) == 44 && demo == false){
                        independent = Integer.parseInt(holderTwo);//resets HolderTwo
                        holderTwo = "";//resets holderTwo

                        //resets the party discerning booleans to their initial state
                        repub = true;
                        demo = true;
                        e = hold.length()+1;
                    }//end else if

                    //no commas have been encountered thus far
                    else{
                        holderTwo = holderTwo + hold.charAt(e);//tacks the current number on to the end, & repeats the process
                    }//end else

                }//end for

                i = hold.length()+1;//ends the for loop

            }//end for

        }//end for

        hold = holder;//sets the original hold to the temporary holder value
        holder = "";//resets holder

        //checks to see if the program had located the correct country.
        if(hold.equals(countryName)){
            countryDivisor = false;//tells the while loop to end
        }//end if
        
    }//end countryDivisor
    
}//end class