package sample;

import javafx.application.Platform;
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
    public static int bottlenow = 1;
    public static boolean on = false;
    public static int timeneeded;
    public static int points = 600;

    public static void submitmsg(TextArea text, Stage stage, Scene scene, Label end, Label missed, Label desc, Label funds, Label results, Scene resultscene) {
        String usermessage = text.getText();
        sentmsgs[btleopened] = usermessage;
        //ifrulesaremet
        if(Message.checkrules(text, missed,bottlenow) == 0)
        {
            points = points - 50;
            return;
        }
        on = false;
        points = points + timeneeded;
        text.clear();
        desc.setText("Good job! You sent off the bottle!");
        btleopened++;
        String fullstory = changestory();
        end.setText(fullstory);
        stage.setScene(scene);
        funds.setText("Funds: " + points);
        if(bottlenow == 7)
        {
            //animation?
            if(points < 300) { results.setText("You ran out of money, and had to turn back. \n You didn't get to find any treasure, and instead ended in debt."); }
            else {results.setText("You had enough resources left to stay and scour \n the island long enough to find the treasure! \n Your friend and your crew are all proud and rich and in your debt.");}
            results.setPrefWidth(800);
            results.setWrapText(true);
            stage.setScene(resultscene);
        }
        System.out.println(points);
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

    public static void clickedHome(Label texter) {
        texter.setText("My Home");
    }

    public static void clickedLocation(Label texter, String string, Stage stage, Scene scene) {
        texter.setText(string);
        stage.setScene(scene);
    }

    public static void clickedmain(Label texter) {texter.setText("Month 1 of Your Business"); }

    public static void clickedStore(Label texter) {
        texter.setText("Local Store");
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

    public static void settier(int bottle, Label timeshow) throws InterruptedException {
        int timeneeded = bottle + 1;
        timeneeded = timeneeded*100;
        timeshow.setText(String.valueOf(timeneeded));
        while(on == true) {
            timeshow.setText(String.valueOf(timeneeded));
            timeneeded--;
            if(timeneeded == 0)
            {
                return;
            }
        }
    }

    public static void settimer(int bottle, Label timeshow) {
        timeneeded = 100*bottle;
        Timer messset = new Timer();
        TimerTask cdown = new TimerTask(){ public void run() { Platform.runLater(new Runnable() {public void run() {timeneeded--; timeshow.setText(String.valueOf(timeneeded));}});}};
        messset.scheduleAtFixedRate(cdown,1000,1000);
    }

    public static int getfunds()
    {return points;}
}
