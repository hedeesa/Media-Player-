/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Farhad
 */
public class MusicPlayer {
    
    static int count;//if App started or not
    static int muteCounter;
    static MediaPlayer player;
    static Media media;
    static Label lengthOfTime;
    static Label currentTime;
    static Slider musicSlider;
    static int repeatCount;
    static int pauseAndPlayCounter;
    static int numberOfSong;
    static int clearTheRandomic=2;
    static Slider volumeSlider;
    static  ArrayList <String> propertiesItems=new ArrayList<String>();
    static ArrayList<String> nameOfSong=new ArrayList<>();
    static ArrayList<String> address=new ArrayList<>();
    static ArrayList<String> vol=new ArrayList<String>();
    static Random randomValue=new Random();
    static ArrayList<String> randomic=new ArrayList<>();
    static ArrayList<String> total=new ArrayList<>();
    static TableView<FillTheTable> tableList;
    static Button playB; 
    static Image pauseI;
    static Image playI;
    static ListView list;
    static ImageView coverImage;
    static int backToFirst;
    static Button repeatB;
    static Button muteB;
   
    
    public MusicPlayer(Stage stage){
        
        vol.add(""+0.5);
        
        MakeLabels makeLabels = new MakeLabels();
        makeLabels.makeLengthOfTimeL();
        makeLabels.makeCurrentTime();

        MakeImageIcon makeImageIcon=new MakeImageIcon();
        makeImageIcon.makeWelcomeIcon();
      
        MakeList makeList=new MakeList();
        makeList.makeListView();
       
        MakeList makeTable=new MakeList();
        makeTable.makeTableView();
        
        playI=new Image("images/play.jpg");
        pauseI=new Image("images/pause.jpg");
       
        MakeButtons makeButtons=new MakeButtons();
        makeButtons.makePalyB();
      
        Button forwardB=new Button("");
        forwardB=makeButtons.makeForwardB();
       
        Button backwardB=new Button("");
        backwardB=makeButtons.makeBackwardB();

        Button stopB=new Button("");
        stopB=makeButtons.makeStopB();

        repeatB=makeButtons.makeRepeatB();


        Button muteB=new Button("");
        muteB=makeButtons.makeMuteB();


        Button openB=new Button("");
        openB=makeButtons.makeOpenB();
    
       
        
        repeatB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               Actions action=new Actions();
               action.repeatAction();
            }
        });
        muteB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               Actions action=new Actions();
               action.muteAction();
            }
        });
        
        forwardB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               ForwardAndBackwardAction.forwardAction();
            }
        }
        );
        
        backwardB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ForwardAndBackwardAction.backwardAction();
            }
        });
        stopB.setOnAction(new EventHandler<ActionEvent>() {

              @Override
              public void handle(ActionEvent event) {
                  Actions action=new Actions();
               action.stopAction();
              }
          });
        
        playB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               Actions action=new Actions();
               action.playAction();
        }
        });
        
       
            openB.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    
                    Actions action=new Actions();
                    action.openAction(stage);
                }
            });
         
            tableList.setOnMouseClicked(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
                Actions action=new Actions();
                    action.what2();
           }
       });
           
        MediaView view = new MediaView(player);
        MakeSliders makeSlider=new MakeSliders();
        makeSlider.makeMusicSlider();
      
        
        MakePanes makePanes=new MakePanes();
        Pane sliderPane = makePanes.makeSliderPane();
        
        Pane musicPane = makePanes.makeMusicPane();
        Pane timePane=makePanes.makeTimePane();
       
        makeSlider.makeVolumeSlider();
        
        volumeSlider.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               SliderActions action=new SliderActions();
                    action.volumeSliderAction();
            }
        });
        
        musicPane.getChildren().addAll(stopB,playB,forwardB,backwardB,repeatB,muteB,openB);
        musicPane.getChildren().add(volumeSlider);
        musicPane.getChildren().add(sliderPane);
        musicPane.getChildren().add(timePane);
        
        
         AnchorPane Apane = new AnchorPane();
        Apane.setPrefSize(597,540);
        
     
        Apane.getChildren().addAll(musicPane,list,tableList,coverImage);
        
        Scene scene = new Scene(Apane,587,537);
        scene.getStylesheets().add("file:///C:/Users/Farhad/Documents/NetBeansProjects/ms2/src/ms2/sheet.css");
        tableList.getStyleClass().add("tableList");
        list.getStyleClass().add("list");
        stage.getIcons().add(new Image("images/musicIcon.png"));
        stage.setTitle("Music Player");
       
        stage.setResizable(false);
        
        stage.setScene(scene);
        stage.show();
      
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                
                 stage.close();
                 stage.hide();
                 if(count!=0){
                 player.stop();}
                clearTheRandomic=2;
                backToFirst=0;
                
                
                pauseAndPlayCounter=0;
                count=0;
                muteCounter=0;
                repeatCount=0;
                numberOfSong=0;
                total.clear();
                randomic.clear();
            }
        
        }
        );
        
    }
}
