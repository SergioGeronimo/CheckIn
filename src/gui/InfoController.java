package gui;
//InfoController by Sergio Geronimo on 27/04/2019

import dao.PersonDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Person;

import java.io.IOException;
import java.sql.SQLException;

public class InfoController extends BasicController{
    @FXML
    private TextField workerID;
    @FXML
    private PasswordField confirmation;

    public void viewInformation(ActionEvent event){
        Scene scene = findSceneByEvent(event);
        workerID = (TextField) scene.lookup("#workerID");
        confirmation = (PasswordField) scene.lookup("#confirmation");

        try {
            Person currentUser = PersonDAO.selectPerson(workerID.getText());
            if(currentUser.getPin() != Integer.valueOf(confirmation.getText())){
                Alert pinError = new Alert(Alert.AlertType.ERROR);
                pinError.setTitle("Incorrect PIN");
                pinError.setHeaderText("Incorrect PIN");
                pinError.setContentText("Try again");
                pinError.show();
            }else {
                try {
                    FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/gui/user.fxml"));
                    Parent userInfo = userLoader.load();
                    UserController controller = userLoader.getController();
                    scene.setRoot(userInfo);
                    controller.setFields(scene, currentUser);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (NullPointerException nullEx){
            nullEx.printStackTrace();
            Alert noWorker = new Alert(Alert.AlertType.ERROR);
            noWorker.setTitle("Worker doesn't exist");
            noWorker.setHeaderText("Worker doesn't exist");
            noWorker.setContentText("There is no existence of specified Worker ID");
            noWorker.show();
        }
    }
}
