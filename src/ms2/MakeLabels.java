/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static ms2.MusicPlayer.currentTime;
import static ms2.MusicPlayer.lengthOfTime;

/**
 *
 * @author Farhad
 */
public class MakeLabels {
    
    public void makeLengthOfTimeL(){
        
        lengthOfTime = new Label("");
        lengthOfTime.setLayoutX(540);
        lengthOfTime.setLayoutY(4);
        lengthOfTime.setPrefSize(49,17);
        lengthOfTime.setTextFill(Color.web("#fbf8f8"));
        lengthOfTime.getStyleClass().add("label");
        lengthOfTime.setAlignment(Pos.CENTER);
    }
    
    public void makeCurrentTime(){
        
        currentTime = new Label("");
        currentTime.setLayoutX(11);
        currentTime.setLayoutY(4);
        currentTime.setPrefSize(49,17);
        currentTime.setTextFill(Color.web("#fbf8f8"));
        currentTime.getStyleClass().add("label");
        currentTime.setAlignment(Pos.CENTER);
    }
}
