package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Controller {
    public static int[] openedbtles = {0, 0, 0, 0, 0, 0, 0};
    public static String[] sentmsgs = new String[6];
    public static int btleopened;
    public static int points = 600;
    public static int remtime;
    public static int bottlenow = 1;
    public static boolean on = false;
    public static int timeneeded;

    public static void submitmsg(TextArea text, Stage stage, Scene scene, Label end, Label missed, Label desc) {
        String usermessage = text.getText();
        sentmsgs[btleopened] = usermessage;
        //ifrulesaremet
        if(Message.checkrules(text, missed) == 0)
        {
            points = points - 50;
            return;
        }
        on = false;
        points = points + 10 * remtime;
        text.clear();
        desc.setText("Good job! You sent off the bottle!");
        btleopened++;
        String fullstory = changestory();
        end.setText(fullstory);
        stage.setScene(scene);
    }

    public static String changestory()
    {
        String fullstory = "";
        for(int i = 0; i < 6;i++)
        {
            int k = i + 1;
            fullstory = fullstory + "\n Day " + k + "\n" + sentmsgs[i];
        }
        return fullstory;
    }

    public static void clickedYourShip(Label texter) {
        texter.setText("This is your ship.");
    }

    public static void clickedTheirShip(Label texter) {
        texter.setText("This is your friend's ship.");
    }

    public static void clickedmain(Label texter) {texter.setText("Click on the next bottle."); }

    public static void clickedIsland(Label texter) {
        texter.setText("Could the treasure be here?");
    }

    public static void clickedButton(Label texter, int bottle, Stage stage, Scene scene, Button button, Label rulelist, Label timer) {
        System.out.println(bottlenow);
        if(openedbtles[bottle] == 0) {
            {
                if(bottle > bottlenow)
                {
                    if(openedbtles[bottlenow] == 0)
                    {
                        texter.setText("You haven't reached that bottle yet!");
                        return;
                    }
                }
                else {
                    texter.setText("Let's open bottle " + bottle + "!");
                    button.setOpacity(0.3);
                    //setanimation
                    //wait(2000);
                    //setanimation
                    openedbtles[bottle] = bottle;
                    bottlenow++;
                    String[] botrles = Message.setRules(bottle + 2, bottle);
                    String rulestring = "Bottle Rules \n";
                    for (int i = 0; i < botrles.length; i++) {
                        rulestring = rulestring + botrles[i] + "\n";
                    }
                    rulelist.setText(rulestring);
                    on = true;
                    settimer(bottlenow, timer);
                    stage.setScene(scene);
                }
            }
        }
        else
        {
            texter.setText("Bottle " + bottle + " has already been sent off.");
        }
    }

    public static void settimr(int bottle, Label timeshow) {
        int timeneeded = bottle + 1;
        timeneeded = timeneeded*100;
        timeshow.setText(String.valueOf(timeneeded));
        while(on == true) {
            timeneeded--;
            timeshow.setText(String.valueOf(timeneeded));
            if(timeneeded == 0)
            {
                return;
            }
        }
    }

    public static void settimer(int bottle, Label timeshow) {
        timeneeded = 100*bottle;
        Timer messset = new Timer();
        TimerTask cdown = new TimerTask(){public void run() {timeneeded--; timeshow.setText(String.valueOf(timeneeded));}};
        messset.scheduleAtFixedRate(cdown,1000,1000);
        Controller ct = new Controller();
        ct.start();
    }
}
