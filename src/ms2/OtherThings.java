/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import static ms2.ForwardAndBackwardAction.p;
import static ms2.MusicPlayer.address;
import static ms2.MusicPlayer.clearTheRandomic;
import static ms2.MusicPlayer.count;
import static ms2.MusicPlayer.currentTime;
import static ms2.MusicPlayer.coverImage;
import static ms2.MusicPlayer.lengthOfTime;
import static ms2.MusicPlayer.list;
import static ms2.MusicPlayer.media;
import static ms2.MusicPlayer.musicSlider;
import static ms2.MusicPlayer.nameOfSong;
import static ms2.MusicPlayer.numberOfSong;
import static ms2.MusicPlayer.pauseI;
import static ms2.MusicPlayer.playB;
import static ms2.MusicPlayer.playI;
import static ms2.MusicPlayer.player;
import static ms2.MusicPlayer.randomic;
import static ms2.MusicPlayer.repeatCount;
import static ms2.MusicPlayer.tableList;
import static ms2.MusicPlayer.total;
import static ms2.MusicPlayer.volumeSlider;
import static ms2.MusicPlayer.propertiesItems;
import static ms2.MusicPlayer.backToFirst;
/**
 *
 * @author Farhad
 */
public class OtherThings {
    
    public void PreviousOrStay(){
         if(currentTime.getText().equals("00:00:02")||currentTime.getText().equals("00:00:01")||currentTime.getText().equals("00:00:00")){
             numberOfSong=Integer.parseInt(total.get(total.size()-clearTheRandomic));
                                 
            ++clearTheRandomic;
        }
        else{
        }
    }
    
    public void playing(){
        
        tableList.getSelectionModel().select(numberOfSong);
        if(count!=0){
            player.stop();}
            media = new Media(address.get(numberOfSong));
            player=new MediaPlayer(media);
            player.setVolume(volumeSlider.getValue());
    }
    
    public void TimeWork(){
        int time=(int) player.getTotalDuration().toSeconds();
        Time timing = new Time();
        lengthOfTime.setText(timing.getTime(time));
        musicSlider.setMax(player.getTotalDuration().toSeconds());
    }
    
    public void getPerperties(){
        
                  ++count;
                  ObservableList<String> items =FXCollections.observableArrayList ();
                  items.clear();
                  items.add(nameOfSong.get(numberOfSong));
                  list.setItems(items);
                 coverImage.setImage(new Image("images/kratom-experiences.png"));
                   propertiesItems.clear();
                   
                   ObservableMap<String,Object> meta_data=media.getMetadata();
                  
                    meta_data.addListener(new MapChangeListener<String,Object>(){
                        
          @Override
          public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> ch) { 
               
             if(ch.wasAdded()){
                   
                   String key=ch.getKey();
                   Object value=ch.getValueAdded(); 
                   
                 
             switch(key){
               case "album":
                   
                   propertiesItems.add("Album: "+value.toString());
                   break;
               case "artist":  
                   
                    propertiesItems.add("Artist: "+value.toString());
                   break;
               case "title":
                  
                   propertiesItems.add("Title: "+value.toString());
                  
                   break;
               case "year":
                   
                    propertiesItems.add("Year: "+value.toString());
                   break;
                   
                 case "genre":
                 
                    propertiesItems.add("Genre: "+value.toString());
                   break;   
               case "image":
                   
                       coverImage.setImage((Image)value);
                   
                   
                   break;
           }
             
              }

                ObservableList<String> items =FXCollections.observableArrayList ();
               
               for(int i=propertiesItems.size()-1;i>=0;--i){
                   items.add(propertiesItems.get(i));
               }
                    list.setItems(items);
                    
          }
     });
    }
    
    public void whatToDo(){
        playB.setGraphic(new ImageView(pauseI));
                  
                  player.play();
                  player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                        private int l;

                       @Override
                       public void changed(ObservableValue<? extends Duration> observable, Duration duration, Duration current) {
                         musicSlider.setValue(current.toSeconds());
                        int time = (int) musicSlider.getValue();
                         Time timing = new Time();
                        currentTime.setText(timing.setTime(time));
                        if(currentTime.getText().equals(lengthOfTime.getText() )){
                            if(repeatCount==0){
                                player.stop();
                            playB.setGraphic(new ImageView(playI));
                            }
                            else if(repeatCount==1){
                                player.stop();
                                player.play();
                            }
                            else if(repeatCount==2 && nameOfSong.size()==randomic.size()){
                                
                                 player.stop();
                            playB.setGraphic(new ImageView(playI));
                            randomic.clear();
                             randomic.add(""+numberOfSong);
                             if(p==1){
                                total.add(""+numberOfSong);
                             }
                                
                            }
                            else if(repeatCount==2 && nameOfSong.size()>=randomic.size()){
                               ForwardAndBackwardAction.forwardAction();
                              
                            }
                            else if (repeatCount==3 && nameOfSong.size()-1>numberOfSong){
                               
                                ForwardAndBackwardAction.forwardAction();
                            }
                            else if(repeatCount==3 && nameOfSong.size()-1==numberOfSong ){
                                backToFirst=1;
                               if(p==0){
                                   l=1;
                               }
                                
                                 player.stop();
                            playB.setGraphic(new ImageView(playI));
                            }
                            else{
                                
                            }
                        }
                       }
                   });
    }
}
