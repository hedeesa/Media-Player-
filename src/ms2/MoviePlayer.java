/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import java.awt.Toolkit;
import java.io.File;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import static ms2.MusicPlayer.count;

/**
 *
 * @author Farhad
 */
public class MoviePlayer {
    int width= Toolkit.getDefaultToolkit().getScreenSize().width-30;
    int height= Toolkit.getDefaultToolkit().getScreenSize().height-90;
    String address;
    MediaPlayer player;
    int count;
    int pauseCount;
    
    public MoviePlayer(Stage primaryStage) {
        
        primaryStage.setTitle("Video Player");
        primaryStage.getIcons().add(new Image("images/movieIcon.png"));
        Label currentTime = new Label("");
        currentTime.setLayoutX(10);
        currentTime.setLayoutY(25);
        currentTime.setPrefSize(49,17);
        currentTime.setTextFill(Color.web("#fbf8f8"));
        currentTime.getStyleClass().add("label");
        currentTime.setAlignment(Pos.CENTER);
        
        Label lengthOfTime = new Label("");
        lengthOfTime.setLayoutX(width-60);
        lengthOfTime.setLayoutY(25);
        lengthOfTime.setPrefSize(49,17);
        lengthOfTime.setTextFill(Color.web("#fbf8f8"));
        lengthOfTime.getStyleClass().add("label");
        lengthOfTime.setAlignment(Pos.CENTER);
        
        AnchorPane Apane = new AnchorPane();
        ImageView folder=new ImageView(new Image("folder2.png"));
         folder.setX(520);
         folder.setY(35);
                   
         
         Slider musicSlider=new Slider();
         musicSlider.setPrefWidth(width);
         musicSlider.setTranslateY(10);
        
         ImageView play=new ImageView(new Image("play.jpg"));
         play.setX(600);
         play.setY(25);
        
         
         ImageView stop=new ImageView(new Image("stop.jpg"));
         stop.setX(680);
         stop.setY(35);
         
        Pane pane=new Pane();
        pane.setPrefSize(width+20,130);
        pane.setLayoutY(578);
        pane.setStyle("-fx-background-color: #585858;");
        pane.getChildren().addAll(folder,musicSlider,play,stop,currentTime,lengthOfTime);
        
        StackPane videoPane = new StackPane();
        videoPane.setPrefSize(width+20,579);
        videoPane.setStyle("-fx-background-color: #000000;");
        videoPane.setAlignment(Pos.CENTER);
        
        
         FileChooser fileChooser = new FileChooser();
         
         
         
         folder.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                folder.setScaleX(1.2);
                folder.setScaleY(1.2);
            }
        });
         
         folder.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                folder.setScaleX(1.0);
                folder.setScaleY(1.0);
            }
        });
         
          folder.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                 File file = fileChooser.showOpenDialog(primaryStage);
                    if (file != null) {
                        if(file.getName().endsWith(".mp4")){
                          primaryStage.setTitle("Video Player -"+file.getName());
                           address="file:///"+ file.getPath().replace("\\","/").replace(" ","%20");
                           if(count==1){
                               player.stop();
                           }
                Media media=new Media(address);
                player=new MediaPlayer(media);
                MediaView view=new MediaView(player);
                videoPane.getChildren().add(view);
                view.setFitHeight(width);
                view.setFitHeight(579);
                count=1;
                player.play();
                pauseCount=1;
                play.setImage(new Image("pause.jpg"));
                player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

                               @Override
                               public void changed(ObservableValue<? extends Duration> observable, Duration duration, Duration current) {
                                          musicSlider.setValue(current.toSeconds());
                                           int time = (int) musicSlider.getValue();
                       
                                             currentTime.setText(setTime(time));
                                             
                                             if(currentTime.getText().equals(lengthOfTime.getText())){
                          
                                                  player.stop();
                                                  play.setImage(new Image("play.jpg"));
                                                  pauseCount=0;
                                             }
                               }
                           });
          player.setOnReady(new Runnable() {

                               @Override
                               public void run() {
                                   
                                   view.setFitHeight(579);
                                   view.setFitWidth(width);
                                   int time=(int) player.getTotalDuration().toSeconds();
                           
                           lengthOfTime.setText(getTime(time));
                                    musicSlider.setMax(player.getTotalDuration().toSeconds());
                                    
                                    
                               }
                           });
          musicSlider.setOnMousePressed(new EventHandler<MouseEvent>() {

                               @Override
                               public void handle(MouseEvent event) {
                                  player.seek(Duration.seconds(musicSlider.getValue()));
                               }
                           });
          play.setOnMousePressed(new EventHandler<MouseEvent>() {

                               @Override
                               public void handle(MouseEvent event) {
                                  if(pauseCount==0){
                                      player.play();
                                      pauseCount=1;
                                      play.setImage(new Image("pause.jpg"));
                                  }
                                  else{
                                      player.pause();
                                      play.setImage(new Image("play.jpg"));
                                      pauseCount=0;
                                  }
                               }
                           });
          
          stop.setOnMousePressed(new EventHandler<MouseEvent>() {

                               @Override
                               public void handle(MouseEvent event) {
                                   player.stop();
                                   play.setImage(new Image("play.jpg"));
                                      pauseCount=0;
                               }
                           });
          
                        }
                        
                    }
            }
        });
         
        Apane.getChildren().addAll(pane,videoPane);
        Scene scene = new Scene(Apane,width,height);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(height-30);
        primaryStage.setMinWidth(width-30);
        primaryStage.setResizable(false);
        primaryStage.show();
        
         primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                
                primaryStage.close();
                 primaryStage.hide();
                 if(count!=0){
                 player.stop();}
                 
                  count=0;
                  pauseCount=0;
                
            }
        
        }
        );
        
    }

    /**
     * @param args the command line arguments
     */
    
      public static  String setTime(int time){
         String ms = null;
                  String ss = null;
                  int m=time/60;
                  if(m<10){
                     ms= "0"+m;
                  }
                  else{
                      ms=""+m;
                  }
                  
                  int s=time%60;
                  if(s<10){
                      ss="0"+s;
                  }
                  else{
                      ss=""+s;
                  }
                  
                  return "00"+":"+ms+":"+ss;
       }
      
       public static String getTime(int time){
        
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
}
