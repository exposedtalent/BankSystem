/*
    Name : Tanishq Mor
    Student ID : 1216879638
    Class : CSE 360
    Instructor : Balasooriya
    Project : HW # 3
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main Class to launch the javafx program
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bank System");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
