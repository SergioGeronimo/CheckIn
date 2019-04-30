package gui;
//UserController by Sergio Geronimo on 27/04/2019

import dao.CheckDAO;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import models.Person;

import javax.annotation.Resources;
import java.net.URL;
import java.sql.SQLException;

public class UserController extends BasicController {
    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField attendances;
    @FXML
    private TextField absences;

    void setFields(Scene scene, Person worker){
        name = (TextField) scene.lookup("#name");
        lastName = (TextField) scene.lookup("#lastName");
        attendances = (TextField) scene.lookup("#attendances");
        absences = (TextField) scene.lookup("#absences");

        name.setText(worker.getName());
        lastName.setText(worker.getLastName());

        try {
            attendances.setText(CheckDAO.numAllChecks(worker.getId()) + "");

            absences.setText(CheckDAO.numUnattendances(worker.getId()) + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException nullEx){
            nullEx.printStackTrace();
        }

    }

}
