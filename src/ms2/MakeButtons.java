/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static ms2.MusicPlayer.muteB;
import static ms2.MusicPlayer.playB;
import static ms2.MusicPlayer.playI;
import static ms2.MusicPlayer.repeatB;
/**
 *
 * @author Farhad
 */
public class MakeButtons {
    
    
     public void makePalyB(){
         
        playI=new Image("images/play.jpg");
        ImageView iv1=new ImageView(playI);
        iv1.setFitHeight(67);
        iv1.setFitWidth(69);
        
        playB=new Button("",iv1);
        playB.setLayoutX(282);
        playB.setLayoutY(65);
        playB.setPrefSize(67,69);
        playB.setStyle("-fx-background-color: #585858;");
        
     }
     
     public Button makeForwardB(){
        
        ImageView iv2=new ImageView(new Image("images/forward.jpg"));
        iv2.setFitHeight(54);
        iv2.setFitWidth(52);
        
        Button forwardB=new Button("",iv2);
        forwardB.setLayoutX(358);
        forwardB.setLayoutY(75);
        forwardB.setPrefSize(54,52);
        forwardB.setStyle("-fx-background-color: #585858;");
        
        return forwardB;
     }
     
     public Button makeBackwardB(){
        
        ImageView iv3=new ImageView(new Image("images/backward.jpg"));
        iv3.setFitHeight(54);
        iv3.setFitWidth(52);
        
        Button backwardB=new Button("",iv3);
        backwardB.setLayoutX(165);
        backwardB.setLayoutY(75);
        backwardB.setPrefSize(20,20);
        backwardB.setStyle("-fx-background-color: #585858;");
        
        return backwardB;
     }
     
     public Button makeStopB(){
        
        ImageView iv4=new ImageView(new Image("images/stop.jpg"));
        iv4.setFitHeight(54);
        iv4.setFitWidth(52);
        
        Button stopB=new Button("",iv4);
        stopB.setLayoutX(223);
        stopB.setLayoutY(75);
        stopB.setPrefSize(54,52);
        stopB.setStyle("-fx-background-color: #585858;");
        
        return stopB;
     }
     
     public Button makeRepeatB(){
         
        ImageView iv5=new ImageView(new Image("images/default.jpg"));
        repeatB=new Button("",iv5);
        repeatB.setLayoutX(110);
        repeatB.setLayoutY(85);
        repeatB.setPrefSize(5,5);
        repeatB.setStyle("-fx-background-color: #585858;");
        
        return repeatB;
     }
     
     public Button makeMuteB(){
         
        ImageView iv6=new ImageView(new Image("images/sound.jpg"));
        muteB=new Button("",iv6);
        muteB.setLayoutX(425);
        muteB.setLayoutY(85);
        muteB.setPrefSize(10,10);
        muteB.setStyle("-fx-background-color: #585858;");
        
        return muteB;
     }
     
     public Button makeOpenB(){
         
        Button openB=new Button("");
        openB.setGraphic(new ImageView(new Image("folder.png")));
        openB.setStyle("-fx-background-color: #585858;");
        openB.setLayoutX(20);
        openB.setLayoutY(70);
        openB.setPrefSize(10,10);
        
        return openB;
     }
}
