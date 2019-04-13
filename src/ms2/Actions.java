/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import java.io.File;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import static ms2.MusicPlayer.address;
import static ms2.MusicPlayer.count;
import static ms2.MusicPlayer.currentTime;
import static ms2.MusicPlayer.backToFirst;
import static ms2.MusicPlayer.media;
import static ms2.MusicPlayer.musicSlider;
import static ms2.MusicPlayer.muteB;
import static ms2.MusicPlayer.muteCounter;
import static ms2.MusicPlayer.nameOfSong;
import static ms2.MusicPlayer.numberOfSong;
import static ms2.MusicPlayer.pauseI;
import static ms2.MusicPlayer.playB;
import static ms2.MusicPlayer.playI;
import static ms2.MusicPlayer.player;
import static ms2.MusicPlayer.randomic;
import static ms2.MusicPlayer.repeatB;
import static ms2.MusicPlayer.repeatCount;
import static ms2.MusicPlayer.tableList;
import static ms2.MusicPlayer.total;
import static ms2.MusicPlayer.vol;
import static ms2.MusicPlayer.volumeSlider;
import static ms2.MusicPlayer.pauseAndPlayCounter;

/**
 *
 * @author Farhad
 */
public class Actions {
 
    
    public void repeatAction(){
        
         if(count!=0){
              
            switch(repeatCount){

                case 0:
                    
                    randomic.clear();
                    total.clear();
                    repeatB.setGraphic(new ImageView(new Image("images/repeat.jpg")));
                    repeatCount=1;
                    break;
                    
                case 1:

                   randomic.add(""+numberOfSong);
                    total.add(""+numberOfSong);
                    repeatB.setGraphic(new ImageView(new Image("images/shuffle.jpg")));
                    repeatCount=2;
                    break;
                    
                    

                case 2:
                    randomic.clear();
                    total.clear();
                    System.out.println("play all ");
                    repeatB.setGraphic(new ImageView(new Image("images/repeatAll.jpg")));
                    repeatCount=3;
                    break;
                    
                    
                    
                case 3:
                    randomic.clear();
                    total.clear();
                    repeatB.setGraphic(new ImageView(new Image("images/default.jpg")));
                    repeatCount=0;
                    break;
            }        
        }
    }
    
    public void muteAction(){
        if(count!=0){
            
            if(muteCounter==0){
                player.setVolume(0.0);
                volumeSlider.setValue(0.0);
                muteB.setGraphic(new ImageView(new Image("images/mute.jpg")));
                muteCounter=1;
            }
            else{  
                
                double changeVol = Double.parseDouble(vol.get(vol.size()-1));
                muteB.setGraphic(new ImageView(new Image("images/sound.jpg")));
                player.setVolume(changeVol);
                volumeSlider.setValue(changeVol);
                muteCounter=0;
            }
        } 
    }
    
    public void stopAction(){
        if(count!=0){
            
            player.stop();
            playB.setGraphic(new ImageView(playI));
            currentTime.setText("");
            randomic.clear();
            randomic.add(""+numberOfSong);
            total.add(""+numberOfSong);
                        
        }   
    }
    
    public void playAction(){
    if(count!=0){
             
        if(backToFirst==1){
           numberOfSong=0;
           backToFirst=0;
           
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
                 player.seek(Duration.seconds(musicSlider.getValue()));
                  
              });
            
            other.getPerperties();
              
                   }
                     if(pauseAndPlayCounter==0){
                   playB.setGraphic(new ImageView(playI));
                   player.pause();
                   pauseAndPlayCounter=1;
                   
                   }
                   else{
                   playB.setGraphic(new ImageView(pauseI));
                   player.play();
                   pauseAndPlayCounter=0;
                   }
               } 
            }
    
         public void openAction(Stage stage){
              FileChooser fileChooser = new FileChooser();
             List<File> list =
                        fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                            if(file.getName().endsWith(".mp3")||file.getName().endsWith(".m4a")||file.getName().endsWith(".wav")){
                            nameOfSong.add(file.getName());
                            
                            String Path="file:///"+ file.getPath().replace("\\","/").replace(" ","%20");
                            address.add(Path);
                        }
                            
                        }
                    }
                    tableList.setItems(FillTheTable.FillCellsOfTable());
         }  
         
         public void what2(){
              
               
                if(count!=0){
                    player.stop();
                }
               if(tableList.getSelectionModel().getSelectedIndex()>=0){
                  
                   numberOfSong = tableList.getSelectionModel().getSelectedIndex();
            
                   String Path=address.get(numberOfSong);
                  media = new Media(Path);
                  player=new MediaPlayer(media);
                player.setVolume(volumeSlider.getValue());
             OtherThings other=new OtherThings();
                  player.setOnReady(new Runnable() {

                       @Override
                       public void run() {
                          
                          other.TimeWork();
                       }
                   });
                  other.whatToDo();
                  
                  musicSlider.setOnMousePressed((MouseEvent mouseEvent) -> {
                 player.seek(Duration.seconds(musicSlider.getValue()));
                  
              });
            
                other.getPerperties();
             }
         }
         
        
    }


