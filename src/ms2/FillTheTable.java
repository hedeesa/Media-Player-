/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static ms2.MusicPlayer.nameOfSong;

/**
 *
 * @author Farhad
 */
public class FillTheTable {
    
    private String name;
    
    public FillTheTable(String name){
        this.name=name;
    }
    
    public String getName(){
        
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public static ArrayList<TableColumn<FillTheTable,String>> getColumn(TableView TableList){
        
        
        ArrayList<TableColumn<FillTheTable,String>> columns;
        columns = new ArrayList<TableColumn<FillTheTable,String>>();
        TableColumn <FillTheTable,String> col=new TableColumn<>("Name Of The Songs");
       
        col.setCellValueFactory(new PropertyValueFactory<FillTheTable,String>("name"));
        
        col.setPrefWidth(250);
        col.setSortable(false);
        columns.add(col);
        
        return columns;
        
    }
     public static ObservableList<FillTheTable> FillCellsOfTable(){
        ObservableList<FillTheTable> data=FXCollections.observableArrayList();
         
        for(String nameS:nameOfSong){
             data.add(new FillTheTable(nameS));
        }
       
        return data;
    }
    
}
