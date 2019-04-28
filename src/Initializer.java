//Initializer by Sergio Geronimo on 26/04/2019

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("gui/home.fxml"));
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add("gui/general.css");
        primaryStage.setTitle("Check-in System");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
