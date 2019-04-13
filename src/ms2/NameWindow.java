/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Farhad
 */
public class NameWindow {
    
    public NameWindow(){
        Stage stage=new Stage();
        
        Label name=new Label("Saeedeh Moghimi");
        name.setTranslateX(110);
        name.setTranslateY(140);
        name.setStyle("-fx-font-size:15px;");
    
        
        Label uni=new Label("Alzahra University Of Tehran");
        uni.setTranslateX(80);
        uni.setTranslateY(180);
        uni.setStyle("-fx-font-size:15px;");
        Label term=new Label("(Second Term)");
         
        term.setTranslateX(120);
        term.setTranslateY(210);
        term.setStyle("-fx-font-size:15px;");
       
        ImageView image = new ImageView(new Image("flower.jpg"));
        
        Pane pane=new Pane();
        pane.getStyleClass().add("pane");
        pane.getChildren().addAll(image,name,uni,term);
        Scene scene=new Scene(pane,350,350);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setX(900);
        stage.setY(200);
        stage.show();
        
        pane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                  stage.close();
            }
        });
        
    }
}
