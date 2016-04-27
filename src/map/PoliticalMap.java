/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;
import edu.princeton.cs.introcs.*;
//import data.AK;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap {
    public static void main(String[] args) throws Exception{
        
        ////////////////////////////////////////////////////////////////////////
        
        /*File file = new File("AL.txt");//creates the file.
        Countries country = new Countries();//Creates an instance of the countries class. Potentially useless*/
        System.setIn(new FileInputStream("C:\\Users\\hcps-mcenhimlr\\Documents\\(6) Programming\\Java\\NetBeans\\GitHub\\Purple America\\PurpleAmerica\\src\\data\\AK.txt"));
        
        //Scanner scan = new Scanner(file);//Creates a scanner to read the file.

        
        //makes it so that you can see the pen.
        StdDraw.setPenRadius(0.0001);//changes the pen size
        StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color
        
        //Draws points at the highest and lowest points of the graph
        for(int i=0; i<2; i++){
            StdDraw.point(Math.abs(StdIn.readDouble()/300), Math.abs(StdIn.readDouble()/300));//scan.nextInt(), scan.nextInt());
        }//end for
        
            int number = StdIn.readInt();//Gets the number of countries that make up the state
        
        
        //Plots the points of the country.
        /*for(int i=0; i<=number; i++){
            
            //Discards the name of the country, and the abbreviation of the state */
            StdIn.readString();            
            StdIn.readString();            
            StdIn.readString();            
            StdIn.readString();            
            int numberTwo = StdIn.readInt();//scan.nextInt();//Gets the number of points that make up the country
            
            //scrolls through all of the provided points, and plots them accordingly
            /*for(int z=0; z<numberTwo; z=z+2){
                StdDraw.point(Math.abs(scan.nextInt()/300), Math.abs(scan.nextInt()/300));//Draws the point
            }//end for
            
        }//end for*/
                    
        ////////////////////////////////////////////////////////////////////////
                    
        double[] x = new double[numberTwo+10];
        double[] y = new double[numberTwo+10];
        
        
        //for(int z=0; z<=number; z++){
        
            for(int i=0; i<numberTwo; i++){
                x[i] = Math.abs(StdIn.readDouble()/300);
                y[i] = Math.abs(StdIn.readDouble()/300);
            }


            StdDraw.polygon(x, y);
            
        //}
        
    }
}
