/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.control.Slider;
import static ms2.MusicPlayer.musicSlider;
import static ms2.MusicPlayer.volumeSlider;

/**
 *
 * @author Farhad
 */
public class MakeSliders {
    
    public void makeMusicSlider(){
        
        musicSlider = new Slider();
        musicSlider.setLayoutY(9);
        musicSlider.setPrefSize(597,10);
        
    }
    
    public void makeVolumeSlider(){
        
         volumeSlider = new Slider();
        volumeSlider.setLayoutY(100);
        volumeSlider.setLayoutX(470);
        volumeSlider.setPrefWidth(100);
        volumeSlider.setMax(1.0);
        volumeSlider.setValue(0.5);
    }
    
}
