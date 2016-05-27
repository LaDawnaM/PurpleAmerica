/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/** 
 * LaDawna McEnhimer, Forest Kim, Jacob Lesley
 * <p>DataReader
 * <p>Variables:  <ul>fileName - saves the name of the next .txt file. Used when creating a text file.</ul> <ul>holder - the index of the state abbreviation names. Used when determining fileName.</ul> <ul>numberTwo - saves the number of points to be plotted. Used when scrolling through the .txt files.</ul> <ul>abbreviations - A list of the .txt file names of the states. Used to determine which .txt the program should read in next.</ul> <ul>longAbbreviations - A list of the full names of the states. To be used to determine which state the program is in to be used to draw the states.</ul> <ul>years - Holds the election years. Used to sort through the election data.</ul> <ul>next - holds the country's name. Used to separate country name from the number of lat/long points.</ul> <ul>distance - holds the latitude point's distance from the center. Used when flipping the map.</ul> <ul>foundTheData - holds the wanted part of the full line of election data. Used when finding the correct country & saving the election data.</ul> <ul>founded - tells the program if its found the proper string. Used when sorting through the election data Strings.</ul> <ul>holdIt - an index for the lat/long arrays. Used whenever the lat/long arrays are used.</ul> <ul>repub - tells the program whether the republican data has been found. Used to determine which election data number the program is on.</ul> <ul>demo - tells the program whether the democratic data has been found. Used to determine which election data number the program is on.</ul> <ul>republican - holds the republican election data. Used to determine the colors of the graph.</ul> <ul>democrat - holds the democratic election data. Used to determine the colors of the graph.</ul> <ul>independent holds the independent election data. Used to determine the colors of the graph.</ul> <ul>bad - tells the program whether the name of the country exists. Used to end a while loop.</ul> <ul>notNamed - tells the program whether it has the name of the country. Used to end the while loop.</ul> <ul>countryDivisor - tells the program whether or not it's found the country name. Used to end a while loop. <ul>data - holds the election data. Used when figuring out what colors should be drawn.</ul> <ul>newYear - stores which year the program is currently on. Used to hold years in the main method.</ul> <ul>holdThat - holds the name of a specific country. Used to save the string so that hold can continue cycling through</ul><ul>cleared - tells the map if its drawing a single country. Used to determine how much to draw.</ul> <ul>lati - the final latitude. Used to hold the double statically.</ul><ul>longi - the final longitude. Used to hold the double statically</ul> <ul>first - the first time running through that loop. Used to determine whether to get new relative numbers</ul> <ul>relativeNumber - the lat relative number. Used to save the static version of the relativeNumber.</ul><ul> relativeyNumber - the long relative number. Used to save the static version of the relativeyNumber.</ul>
 * <p>Methods:  <ul>electionData() - deciphers the election data</ul> <ul>electionData() - finds a certain state in the election data</ul> <ul>latitude() - reverses the map</ul> <ul>countrySearch() - finds a specific country in the election data & sorts through that information. </ul> <ul>drawStates() - gets the name & number of lat/long points of a state</ul> <ul>countryDivisor() - finds a specific county & deciphers the election data.</ul>
 */
 class DataReader {

    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////VARIABLES///////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
        
    String fileName;
    int holder = 0;
    int numberTwo = 0;
    String countryName;
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
    boolean founded;
    
    String holdIt;
    boolean repub;
    boolean demo;
    
    int republican;
    int democrat;
    int independent;
    
    boolean bad;
    boolean notNamed;
    
    boolean countryDivisor;
    double[] data;
    int newYear;
    String holdThat;
    boolean cleared;
    
    double lati;
    double longi;
    boolean first;

    double relativeNumber;
    double relativeyNumber;
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////CONSTRUCTOR/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    //Creates a blueprint for an instance of the dataReader class.
    public DataReader(){
        data = new double[4];
        bad = true;
        
        holdIt = "";
        repub = true;
        demo = true;
        
        founded = false;
        cleared = false;
    }//end constructor
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
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
    
    public int getNewYear(){
        return newYear;
    }//end getNewYear
    
    public void setNewYear(int y){
        newYear = y;
    }//end setNewYear
    
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
    
    public void setFileName(String f){
        fileName = f;
    }//end setFileName
    
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
    
    public double getData(int i){
        return data[i];
    }//end getData
    
    public void setCleared(boolean c){
        cleared = c;
    }//end cleared
    
    public boolean getCleared(){
        return cleared;
    }//end cleared
    
    
    
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
                    
                    //creates strings to hold the broken down portion of hold.
                    String holderTwo = "";
                    holdThat = "";
                    String holder = "";
                    int lash = 0;

                    //finds the country name
                    for(int q=0; q<whole.length(); q++){
                        if(whole.charAt(q) == 44){//checks to see if the String has reached a comma
                            //if so, it runs through the string up until the comma, and sets that as the country name
                            for(int e=0; e<i; e++){
                                holdThat = holdThat + whole.charAt(e);
                            }

                            q=whole.length()+10;

                        }        //sets booleans to discern republican from democratic from independent.
                      lash++;      
                    }        

                    //seperates the election results by party
                    for(int e=lash; e<whole.length(); e++){
                        holder = holder + whole.charAt(e);//starts reading in the numbers

                        //the first comma becomes republican
                        if(whole.charAt(e) == 44 && repub){//checks to see if it's encountered a comma
                            republican = Integer.parseInt(holderTwo);//sets the republican value to the current answer
                            holderTwo = "";//resets HolderTwo
                            data[1] = republican;
                            //System.out.println("repub: " + data[1]);
                            repub = false;//points the program towards democratic next time
                            demo = true;
                        }//end if

                        //the second comma becomes democratic
                        else if(whole.charAt(e) == 44 && demo == true){
                            democrat = Integer.parseInt(holderTwo);//sets the democratic value to the current answer
                            //System.out.println("dem: " + democrat);
                            data[2] = democrat;
                            //System.out.println("demos: " + data[2]);
                            holderTwo = "";//resets HolderTwo
                            demo = false;//points the program towards independent next time
                        }//end else if

                        //the third comma is independent
                        else if(whole.charAt(e) == 44 && demo == false){
                            independent = Integer.parseInt(holderTwo);//resets HolderTwo
                            data[3] = independent;
                            //System.out.println(data[3]);
                            holderTwo = "";//resets holderTwo

                            //resets the party discerning booleans to their initial state
                            repub = true;
                            demo = true;
                            e = whole.length()+1;
                        }//end else if

                        //no commas have been encountered thus far
                        else{
                            holderTwo = holderTwo + whole.charAt(e);//tacks the current number on to the end, & repeats the process
                        }//end else

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
    public double[] countryDivisor(String hold){
        
        data[1] = 0;
        data[2] = 0;
        data[3] = 0;
        
        //creates strings to hold the broken down portion of hold.
        String holderTwo = "";
        String holder = "";
        holdThat = "";
        int lash = 0;

        //finds the country name
        for(int i=0; i<hold.length(); i++){
            if(hold.charAt(i) == 44){//checks to see if the String has reached a comma
                //if so, it runs through the string up until the comma, and sets that as the country name
                for(int e=0; e<i; e++){
                    holdThat = holdThat + hold.charAt(e);
                }//end for
                
                i=hold.length()+10;
                
            }//end if        
          lash++;      
        }//end for        

        //seperates the election results by party
        for(int e=lash; e<hold.length(); e++){
            holder = holder + hold.charAt(e);//starts reading in the numbers

            //the first comma becomes republican
            if(hold.charAt(e) == 44 && repub){//checks to see if it's encountered a comma
                republican = Integer.parseInt(holderTwo);//sets the republican value to the current answer
                holderTwo = "";//resets HolderTwo
                data[1] = republican;
                repub = false;//points the program towards democratic next time
                demo = true;
            }//end if

            //the second comma becomes democratic
            else if(hold.charAt(e) == 44 && demo == true){
                democrat = Integer.parseInt(holderTwo);//sets the democratic value to the current answer
                //System.out.println("dem: " + democrat);
                data[2] = democrat;
                holderTwo = "";//resets HolderTwo
                demo = false;//points the program towards independent next time
            }//end else if

            //the third comma is independent
            else if(hold.charAt(e) == 44 && demo == false){
                independent = Integer.parseInt(holderTwo);//resets HolderTwo
                data[3] = independent;
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
                
        hold = holdThat;//sets the original hold to the temporary holder value

        //resets the holders
        holdThat = "";
        holder = "";
                
        //checks to see if the program had located the correct country.
        if(hold.equals(countryName)){
            countryDivisor = false;//tells the while loop to end
        }//end if
                
        return data;
        
    }//end countryDivisor
    
}//end class