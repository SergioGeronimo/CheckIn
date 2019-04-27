package gui;
//HomeController by Sergio Geronimo on 26/04/2019

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HomeController extends BasicController {

    public void toCheck(ActionEvent event){

        Scene scene = ((Node)event.getSource()).getScene();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/check.fxml"));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void toInfo(ActionEvent event){
        Scene scene = ((Node)event.getSource()).getScene();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/info.fxml"));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toRegister(ActionEvent event){
        Scene scene = ((Node)event.getSource()).getScene();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/register.fxml"));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
