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
    
    ////////////////////////////////////////////////////////////////////////////    
    ////////////////////////////////METHODS/////////////////////////////////////    
    ////////////////////////////////////////////////////////////////////////////
    
    public void decipherIntro(String intro){
        
        System.out.println(intro);
        someLeft = true;
        goAhead = false;
        
        while(someLeft){
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
                        }//end if

                        else if(democrat.length() > 0){//independent
                            independent = holdTitles;
                            someLeft = false;
                        }//end else if

                        else{//republican
                            republican = holdTitles;
                        }//end else

                        holdTitles = "";
                
                    }//end if
                    
                    goAhead = true;
                
                }//end else if
                
                else{
                    holdTitles = holdTitles + intro.charAt(i);
                }//end else
            
            }//end for
            
        }//end while
                
    }//end decipherIntro
    
}
