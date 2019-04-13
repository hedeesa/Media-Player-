/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import java.util.ArrayList;
import java.util.Random;
import static ms2.MusicPlayer.nameOfSong;

/**
 *
 * @author Farhad
 */
public class Time {
    int randomValue;
    public String getTime(int time){
        
        String hourS;
        String secS;
        String minS;
                  
                  
        time = time%1000;
        int hour = time/3600;
        if(hour<10){
            hourS="0"+hour;
        }
        else{
            hourS=""+hour;
        }
          
        int sec=time%60;
        if(sec<10){
            secS="0"+sec;
        } 
        else{
            secS=""+sec;
        }
                 
        int min = time/60;
        if(min<10){
            minS="0"+min;
        }
        else{
            minS=""+min;
        }
        return hourS+":"+minS+":"+secS;
    }
    
    public String setTime(int time){
        
        String minS = null;
        String secS = null;
        String hourS=null;
         
        int hour = time/3600;
        if(hour<10){
            hourS="0"+hour;
        }
        else{
            hourS=""+hour;
        }
                  
        int m=time/60;
        if(m<10){
           minS= "0"+m;
        }
        else{
            minS=""+m;
        }
                  
        int s=time%60;
        if(s<10){
            secS="0"+s;
        }
        else{
            secS=""+s;
        }
                  
        return hourS+":"+minS+":"+secS;
       }
    
    
    public int random(Random randomNumber,ArrayList<String> randomic,int i){
        
       
         randomValue=randomNumber.nextInt(nameOfSong.size());
        
       
                                
          for(int j=0;j<randomic.size();++j){
               if(Integer.parseInt(randomic.get(j))==randomValue ){
                   
                    
                   random(randomNumber, randomic,i);
           }   
             
     }
        if(i==randomValue){
            random(randomNumber, randomic,i);
        }
         
      return randomValue;                          
    }
    
  
    
}
