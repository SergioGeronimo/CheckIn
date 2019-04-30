package gui;
//BasicController by Sergio Geronimo on 27/04/2019

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class BasicController {
    @FXML
    private Label date;

    public void toHome(ActionEvent event){
        Scene scene = ((Node)event.getSource()).getScene();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/home.fxml"));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene findSceneByEvent(Event actionEvent){
        return ((Node)actionEvent.getSource()).getScene();
    }

    private void time(){

    }
}
