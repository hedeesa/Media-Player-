/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static ms2.MusicPlayer.address;
import static ms2.MusicPlayer.count;
import static ms2.MusicPlayer.currentTime;
import static ms2.MusicPlayer.numberOfSong;
import static ms2.MusicPlayer.lengthOfTime;
import static ms2.MusicPlayer.media;
import static ms2.MusicPlayer.musicSlider;
import static ms2.MusicPlayer.nameOfSong;
import static ms2.MusicPlayer.player;
import static ms2.MusicPlayer.randomValue;
import static ms2.MusicPlayer.randomic;
import static ms2.MusicPlayer.repeatCount;
import static ms2.MusicPlayer.tableList;
import static ms2.MusicPlayer.total;
import static ms2.MusicPlayer.volumeSlider;
import static ms2.MusicPlayer.clearTheRandomic;

/**
 *
 * @author Farhad
 */
public class ForwardAndBackwardAction {
   static int p;
    public static void forwardAction(){
        
       
         if(count!=0){
              p=0;
            if(repeatCount==0||repeatCount==1 || repeatCount==3){
                
                if(numberOfSong==nameOfSong.size()-1){
                    
                    if(repeatCount==3){
                       numberOfSong=0;
                    }
                           
                }
                else{ 
                    numberOfSong=numberOfSong+1;
                }
                       
            }
            if(repeatCount==2){
                          
                if(nameOfSong.size()==randomic.size()){
                    randomic.clear();                  
                }
                MakeRandom rand=new MakeRandom(); 
                numberOfSong= rand.random(randomValue, randomic,numberOfSong);
                randomic.add(""+numberOfSong);
                total.add(""+numberOfSong);
                clearTheRandomic=2;
            }
            
            OtherThings other=new OtherThings();
            other.playing();
            
            player.setOnReady(new Runnable() {

                       @Override
                       public void run() {
                           
                           other.TimeWork();
                       }
                   });
           
            
            other.whatToDo();
            
                  musicSlider.setOnMousePressed((MouseEvent mouseEvent) -> {
                        SliderActions sliderAction=new SliderActions();
                        sliderAction.musicSliderAction();
                  
              });
                  
                  
                  other.getPerperties();
                 
                                    
          }
    }
    
    public static void backwardAction(){
        
        if(count!=0){
            p=1;
            if(repeatCount==0 || repeatCount==1 || repeatCount==3){
                if(numberOfSong==0);
                    else{
                        if(currentTime.getText().equals("00:00:02")||currentTime.getText().equals("00:00:01")||currentTime.getText().equals("00:00:00")){
                            numberOfSong=numberOfSong-1;
                        }
                        else;   
                    }
                        
            }
                    
            OtherThings other=new OtherThings();
                    
            if(repeatCount==2){
                if(total.size()-clearTheRandomic>=0){
                    other.PreviousOrStay();
                }
                else{
                    clearTheRandomic=1;
                    other.PreviousOrStay();
                       
                }
            }
             
            other.playing();
            
            player.setOnReady(new Runnable() {

                @Override
                public void run() {
                  
                    other.TimeWork();
                }
            });
           
            
            other.whatToDo();
            
            
                  musicSlider.setOnMousePressed((MouseEvent mouseEvent) -> {
                           SliderActions sliderAction=new SliderActions();
                        sliderAction.musicSliderAction();
                  
              });
               
                    other.getPerperties();
                    
                
                }
    }
}
