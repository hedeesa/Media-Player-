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
public class MakeRandom {
    int randomValue;
    
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
