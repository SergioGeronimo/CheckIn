package gui;
//CheckController by Sergio Geronimo on 27/04/2019

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CheckController extends BasicController{
    public TextField workerName;
    public TextField workerLast;
    @FXML
    private PasswordField confirm;
    @FXML
    private TextField workerID;

    public void check(ActionEvent event){
        Scene scene = super.findSceneByEvent(event);
        workerID = (TextField) scene.lookup("#workerId");
        System.out.println(workerID.getText());
        //Check it

    }


}
