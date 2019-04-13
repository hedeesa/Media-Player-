/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static ms2.MusicPlayer.coverImage;

/**
 *
 * @author Farhad
 */
public class MakeImageIcon {
    
    public void makeWelcomeIcon(){
        
        Image imageIcon = new Image("images/WelcomeOriginalBlue.jpg");
        coverImage=new ImageView(imageIcon);
        coverImage.setFitWidth(348);
        coverImage.setFitHeight(300);
        coverImage.setLayoutX(250);
        coverImage.setLayoutY(100);
    }
}
