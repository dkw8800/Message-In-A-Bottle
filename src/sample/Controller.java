package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;


public class Controller {
    public static void submitmsg(TextArea text) {
        String usermessage = text.getText();
    }

    public static void clickedYourShip(Label texter) {
        texter.setText("This is your ship.");
    }

    public static void clickedTheirShip(Label texter) {
        texter.setText("This is your friend's ship.");
    }

    public void clickedIsland(ActionEvent actionEvent, Label texter) {
        texter.setText("Could the treasure be here?");
    }

    public static void clickedButton(Label texter, boolean opened, int bottle, Stage stage, Scene scene) {
        if(opened == false) {
            texter.setText("Let's open bottle " + bottle + "!");
            //setanimation
            //wait(2000);
            //setanimation
            stage.setScene(scene);
        }
        else
        {
            texter.setText("Bottle " + bottle + " has already been sent off.");
        }
    }

    public void clickedB2(ActionEvent actionEvent, Label texter) {
        texter.setText("This is your ship.");
    }

    public void clickedB3(ActionEvent actionEvent, Label texter) {
        texter.setText("This is your ship.");
    }

    public void clickedB4(ActionEvent actionEvent, Label texter) {
        texter.setText("This is your ship.");
    }

    public void clickedB5(ActionEvent actionEvent, Label texter) {
        texter.setText("This is your ship.");
    }

    public void clickedB6(ActionEvent actionEvent, Label texter) {
        texter.setText("This is your ship.");
    }
}
