/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static ms2.MusicPlayer.count;
import static ms2.MusicPlayer.musicSlider;
import static ms2.MusicPlayer.muteB;
import static ms2.MusicPlayer.muteCounter;
import static ms2.MusicPlayer.player;
import static ms2.MusicPlayer.vol;
import static ms2.MusicPlayer.volumeSlider;

/**
 *
 * @author Farhad
 */
public class SliderActions {
    
    public void musicSliderAction(){
        player.seek(Duration.seconds(musicSlider.getValue()));
    }
    
     public void volumeSliderAction(){
              if(count!=0){
              player.setVolume(volumeSlider.getValue());
              vol.add(""+volumeSlider.getValue());
              if(muteCounter==1 && volumeSlider.getValue()!=0.0 ){
                  muteB.setGraphic(new ImageView(new Image("images/sound.jpg")));
               
                  muteCounter=0;
                  
              }
              if(muteCounter==0 && volumeSlider.getValue()==0.0){
                   muteCounter=1;
              }
                }
         }
}
