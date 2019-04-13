/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ms2;

import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import static ms2.MusicPlayer.list;
import static ms2.MusicPlayer.tableList;

/**
 *
 * @author Farhad
 */
public class MakeList {
    
    public void makeListView(){
        
        list=new ListView();     
        list.setLayoutX(249);
        list.setPrefSize(348,100);
    }
    
    public void makeTableView(){
        
        tableList = new TableView<FillTheTable>();
        tableList.setPrefSize(250,400);
        tableList.getColumns().addAll(FillTheTable.getColumn(tableList));
        tableList.setItems(FillTheTable.FillCellsOfTable());
        
    }
}
