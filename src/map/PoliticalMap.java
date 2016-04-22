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
//import data.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap {
    public static void main(String[] args) throws Exception{
        
        Countries country = new Countries();//Creates an instance of the countries class. Potentially useless.
        
        File file = new File("AK.txt");//creates the file.
        Scanner scan = country.fileReader(file);//Creates a scanner to read the file.
        
        
        //makes it so that you can see the pen.
        StdDraw.setPenRadius(0.01);//changes the pen size
        StdDraw.setPenColor(StdDraw.BLACK);//changes the pen color
        
        //Draws points at the highest and lowest points of the graph
        for(int i=0; i<=2; i++){
            StdDraw.point(Math.abs(scan.nextInt()/300), Math.abs(scan.nextInt()/300));//scan.nextInt(), scan.nextInt());
        }//end for
        
            int number = scan.nextInt();//Gets the number of countries that make up the state
        
        //Plots the points of the country.
        for(int i=0; i<=number; i++){
            
            //Discards the name of the country, and the abbreviation of the state 
            scan.next();
            scan.next();
            
            int numberTwo = scan.nextInt();//Gets the number of points that make up the country
            
            //scrolls through all of the provided points, and plots them accordingly
            for(int z=0; z<numberTwo; z=z+2){
                StdDraw.point(Math.abs(scan.nextInt()/300), Math.abs(scan.nextInt()/300));//Draws the point
            }//end for
            
        }//end for
        
        
    }
}
