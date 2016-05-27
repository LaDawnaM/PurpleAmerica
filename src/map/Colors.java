/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 * LaDawna McEnhimer, Forest Kim, Jacob Lesley
 * <p> Colors
 * <p> Variables: <ul>total - the amount of republican, independent, and democratic votes combined. Used to complete the formula.</ul><ul>colors - holds the final colors. Used when creating the color object.</ul><ul>box - determines which button the user clicked on. Used to determine which one to change the color text of.</ul><ul>truth - determines whether the program is running for the first time. Used to tell the program to make the first button blue.</ul><ul>
 * <p> Methods: colorChooser() - determines which colors the map should be filled in with
 */
public class Colors {
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////VARIABLES///////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    double total;
    double[] colors;
    
    double[] box;
    boolean truth;
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////CONSTRUCTOR/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    //Creates a blueprint for an instance of the color class.
    public Colors(){
        box = new double[3];
        colors = new double[4];
        
    }//end colors
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    public double getColor(int i){
        return colors[i];
    }//end getColor
    
    public boolean getTruth(){
        return truth;
    }//end getTruth
    
    public void setTruth(boolean t){
        truth = t;
    }//end setTruth
    
    public void setColor(int i, int j){
        colors[i] = j;
    }//end setColor
    
    public void setBox(int i, double j){
        box[i] = j;
    }//end setBox
    
    public double getBox(int i){
        return box[i];
    }//end getBox
    
    

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////METHODS/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    /**
     * The program receives the already-deciphered election data & uses that data to determine what the percent of the color each party should make up.
     * @param electionData - the year's election data
     * @return colors - an array holding all of the color values.
     */
    public double[] colorChooser(double[] electionData){
        
        total = electionData[1] + electionData[2] + electionData[3];//gets the total of all of them
        
        colors[1] = (electionData[1]/total)*255;//Creates the republican color
        
        colors[2] = (electionData[2]/total)*255;//Creates the democratic color
        
        colors[3] = (electionData[3]/total)*255;//Creates the independent color
        
        return colors;
        
    }//end colorChooser
    
    
}//end colors
