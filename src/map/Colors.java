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
public class Colors {
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////VARIABLES///////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    double republicanColors;
    double democraticColors;
    double independentColors;
    
    double total;
    int relativeNumber;
    boolean nope = true;
    
    double difference;
    double[] colors = new double[4];
    static double largest;
    
    static double[] box = new double[3];
    static boolean truth;
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////SETTERS/GETTERS/////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public double getColor(int i){
        return colors[i];
    }
    
    public boolean getTruth(){
        return truth;
    }
    
    public void setTruth(boolean t){
        truth = t;
    }
    
    public void setColor(int i, int j){
        colors[i] = j;
    }
    
    public void setBox(int i, double j){
        box[i] = j;
    }
    
    public double getBox(int i){
        return box[i];
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////METHODS/////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public double[] colorChooser(double[] electionData, String h){
        
        total = electionData[1] + electionData[2] + electionData[3];
        
        colors[1] = (electionData[1]/total)*255;
        
        colors[2] = (electionData[2]/total)*255;
        
        colors[3] = (electionData[3]/total)*255;
        
        return colors;
        
    }//end colorChooser
    
    
}
