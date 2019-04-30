package gui;
//CheckController by Sergio Geronimo on 27/04/2019

import dao.CheckDAO;
import dao.PersonDAO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import models.Check;
import models.Person;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

public class CheckController extends BasicController{
    @FXML
    private TextField workerName;
    @FXML
    private Label title;
    @FXML
    private FlowPane top;
    @FXML
    private Label date;
    @FXML
    private PasswordField pin;
    @FXML
    private TextField workerID;

    public void check(ActionEvent event){
        Scene scene = super.findSceneByEvent(event);
        workerID = (TextField) scene.lookup("#workerID");
        pin = (PasswordField) scene.lookup("#pin");
        if(workerID.getText().equals("") || pin.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty ID or PIN");
            alert.setHeaderText("Empty ID or PIN");
            alert.setContentText("Worker ID and PIN are both required, fill them before check in");
            alert.showAndWait();
        }else {

            try{
                Person worker = PersonDAO.selectPerson(workerID.getText());
                if (worker.getPin() != Integer.valueOf(pin.getText())) {
                    Alert pinError = new Alert(Alert.AlertType.ERROR);
                    pinError.setTitle("Incorrect PIN");
                    pinError.setHeaderText("Incorrect PIN");
                    pinError.setContentText("Try again");
                    pinError.show();
                }else {
                    Calendar now = Calendar.getInstance();

                    Check currentCheck = new Check(0,
                            new Date(now.getTimeInMillis()),
                            new Time(now.getTimeInMillis()),
                            workerID.getText(),
                            now.get(Calendar.MINUTE) < 15);

                    CheckDAO.insertCheck(currentCheck);
                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("Successful check-in");
                    success.setHeaderText("Your check-in information");
                    success.setContentText(currentCheck.toString());
                    success.show();
                }
            } catch (SQLException e) {
                if (e.getErrorCode() == 1452){
                    Alert noWorker = new Alert(Alert.AlertType.ERROR);
                    noWorker.setTitle("Worker doesn't exist");
                    noWorker.setHeaderText("Worker doesn't exist");
                    noWorker.setContentText("There is no existence of specified Worker ID");
                    noWorker.show();
                }
            } catch (NullPointerException nullEx) {
                nullEx.getCause();

            }
        }
    }

    public void searchWorker(KeyEvent event){
        Scene scene = super.findSceneByEvent(event);
        workerID = (TextField) scene.lookup("#workerID");
        workerName = (TextField) scene.lookup("#workerName");

        try {
            Person worker = PersonDAO.selectPerson(workerID.getText());
            workerName.setText(worker.toString());

        } catch (SQLException e) {

            workerName.setText(e.getSQLState() + "-\t" + e.getErrorCode() + "-\t " + e.getMessage());

        } catch (NullPointerException nullEx){
            workerName.setText("No worker found");
        }
    }

}
