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
    
    static int numberTwo;
    
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
                        
            boolean keepGoing;
        
        //Plots the points of the country.
        for(int z=0; z<number; z++){    
            //Discards the name of the country, and the abbreviation of the state 
            
            boolean bad = true;
            String next;
            
            while(bad){
                if(StdIn.hasNextChar()){
                    next = StdIn.readString();
                    
                    System.out.println("next: " +  next);
                    
                    
                    if((next.charAt(0)<65)){

                        for(int i=0; i<next.length(); i++){
                            
                            numberTwo = Integer.parseInt(next);
                        }
                        
                        
                        bad = false;
                    }
                    
                }
                else{
                    bad = false;
                    keepGoing = false;
                }
                
            }
        
                               
        ////////////////////////////////////////////////////////////////////////
        
            System.out.println(numberTwo);
            
        if(keepGoing = true){
            double[] x = new double[numberTwo+10];
            double[] y = new double[numberTwo+10];

            for(int i=0; i<numberTwo; i++){
                    
                    x[i] = Math.abs(StdIn.readDouble()/300);
                    y[i] = Math.abs(StdIn.readDouble()/300);
                }

                StdDraw.polygon(x, y);
                
                numberTwo = 0;
            }
            
        
        
        }
        
    }
}
