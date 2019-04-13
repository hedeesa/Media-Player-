/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;


import java.io.IOException;
import java.net.ServerSocket;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

/**
 *
 * @author Farhad
 */
public class MainWindow extends Application {
    
    @Override
    public void start(Stage mainStage) {
        
        
     
       mainStage.getIcons().add(new Image("images/mainStageIcon.jpg"));
       
       Group root=new Group();
       
       ImageView animation=new ImageView(new Image("images/welcomeMain.gif"));
       animation.setX(110);
        
       ImageView dock=new ImageView(new Image("images/dock.png"));
       dock.setY(200);
       
       ImageView closeIcon=new ImageView(new Image("images/close.png"));
       closeIcon.setX(600);
       
       ImageView minimizeIcon=new ImageView(new Image("images/minimize.png"));
       minimizeIcon.setX(550);
       minimizeIcon.setY(10);
       
       ImageView musicIcon=new ImageView(new Image("images/headphone-icon .png"));
       musicIcon.setY(160);
       musicIcon.setX(100);
       Reflection reflection = new Reflection();
       reflection.setFraction(0.4);
       musicIcon.setEffect(reflection);
      
       ImageView videoIcon=new ImageView(new Image("images/movies-icon .png"));
       videoIcon.setY(160);
       videoIcon.setX(250);
       videoIcon.setEffect(reflection);
       
       
       ImageView nameIcon=new ImageView(new Image("images/box-full-icon.png"));
       nameIcon.setY(160);
       nameIcon.setX(400);
       nameIcon.setEffect(reflection);
       
       minimizeIcon.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                mainStage.setIconified(true);
            }
        });
       
       nameIcon.setOnMouseEntered(new EventHandler<MouseEvent>() {
       
            @Override
            public void handle(MouseEvent event) {
                nameIcon.setScaleX(1.1);
                nameIcon.setScaleY(1.1);
            }
       });
       
       nameIcon.setOnMouseExited(new EventHandler<MouseEvent>() {
       
            @Override
            public void handle(MouseEvent event) {
                nameIcon.setScaleX(1.0);
                nameIcon.setScaleY(1.0);
            }
       });
       
       closeIcon.setOnMousePressed(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
               System.exit(0);
           }
       });
       
       musicIcon.setOnMouseEntered(new EventHandler<MouseEvent>() {
       
            @Override
            public void handle(MouseEvent event) {
                musicIcon.setScaleX(1.1);
                musicIcon.setScaleY(1.1);
            }
       });
       
       musicIcon.setOnMouseExited(new EventHandler<MouseEvent>() {
       
            @Override
            public void handle(MouseEvent event) {
                musicIcon.setScaleX(1.0);
                musicIcon.setScaleY(1.0);
            }
       });
       
       videoIcon.setOnMouseEntered(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
               videoIcon.setScaleX(1.1);
               videoIcon.setScaleY(1.1);
           }
       });
       
       videoIcon.setOnMouseExited(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
               videoIcon.setScaleX(1.0);
               videoIcon.setScaleY(1.0);
           }
       });
       
       musicIcon.setOnMousePressed(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
                Stage musicStage=new Stage();
                MusicPlayer musicPlayer=new MusicPlayer(musicStage);
               
           }
       });
       
       nameIcon.setOnMousePressed(new EventHandler<MouseEvent>() {

           @Override
           public void handle(MouseEvent event) {
                NameWindow nameWindow=new NameWindow();
               
           }
       });
       
       videoIcon.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                MoviePlayer video=new MoviePlayer(new Stage());
                
               }
        });
       
       root.getChildren().addAll(animation,dock,musicIcon,videoIcon,nameIcon,closeIcon,minimizeIcon);
       
       mainStage.setScene(new Scene(root,650,300,Color.GRAY));
       mainStage.initStyle(StageStyle.UNDECORATED);
       mainStage.show();
     
    }

    
    @Override
    public void stop(){
        
        Platform.exit();
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[]args ){
        ServerSocket socket = null;
        try {
          socket = new ServerSocket(34567);
          launch(args);
          try{ Thread.sleep(100000); } catch(InterruptedException e){ }
          socket.close();
        }
        catch (IOException ex) {  
        }
        finally {
          if (socket != null){
              try{ 
                  socket.close(); 
              } 
              catch(IOException e){
              }
            }  
        }
        
     }
             
   }
