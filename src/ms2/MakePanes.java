/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.layout.Pane;
import static ms2.MusicPlayer.currentTime;
import static ms2.MusicPlayer.lengthOfTime;
import static ms2.MusicPlayer.musicSlider;

/**
 *
 * @author Farhad
 */
public class MakePanes {
    
    public Pane makeSliderPane(){
        
         Pane sliderPane = new Pane();
        sliderPane.setPrefSize(597,30);
        sliderPane.setLayoutY(30);
        sliderPane.setStyle("-fx-background-color:#0CE0CB ;");
        sliderPane.getChildren().add(musicSlider);
        
        return sliderPane;
    }
    
    public Pane makeMusicPane(){
         Pane musicPane = new Pane();
        musicPane.setPrefSize(597,147);
        musicPane.setLayoutY(400);
        musicPane.setStyle("-fx-background-color: #585858;");
        
        return musicPane;
    }
    public Pane makeTimePane(){
         Pane timePane=new Pane();
        timePane.setLayoutY(1);
        timePane.setPrefSize(597,23);
        timePane.setStyle("-fx-background-color: #F7628B;");
        timePane.getChildren().addAll(lengthOfTime,currentTime);
        
        return timePane;
    }
}
