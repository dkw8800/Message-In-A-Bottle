package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {

    Scene scene1, scenebtwn, scene2, scene3, businessPage, housePage, storePage, scene4, scene5;
    //add the police song message in a bottle or one of the instrumentals or both?
    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("We Work");
        Label desc = new Label();
        Label timer = new Label("Action Desc!");
        timer.setId("timer");
        timer.relocate(100,550);
        Label funds = new Label();
        funds.relocate(10,625);
        funds.setId("funds");
        funds.setText("Funds: " + Controller.getfunds());
//Scene 1
        Pane titlepage = new Pane();
        Label opening = new Label("We Work");
        Button start = new Button("Start");
        opening.relocate(440,300);
        start.relocate(450,550);
        start.setOnAction(event -> primaryStage.setScene(scenebtwn));
        titlepage.getChildren().addAll(opening, start);
        opening.setId("op");
        start.setId("st");
        scene1= new Scene(titlepage, 1200, 800);
        titlepage.setId("s1");

        Pane intropage = new Pane();
        Label instructions = new Label("You have just quit because of your sexist boss. \n You plan to start your own business instead! \n Hire and fire employees and deal with their \n situations. Invest in items from the store or \n advertisements to boost stats. \n Try to get your business to the top!");
        Button setoff = new Button("Let's go!");
        instructions.relocate(250,100);
        setoff.relocate(450,550);
        setoff.setOnAction(event -> primaryStage.setScene(scene2));
        intropage.getChildren().addAll(instructions,setoff);
        scenebtwn = new Scene(intropage, 1200, 800);
        setoff.setId("stoff");
        instructions.setId("in");
        intropage.setId("sbtwn");
//Scene 2
        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 3");
        button2.setOnAction(event -> primaryStage.setScene(scene3));

        //MAINGAMESETUP
        Button businessbutton= new Button("Business");
        Button storebutton= new Button("Store");
        Button homebutton= new Button("Home");
        //Button bot4= new Button("BOTTLE4");
        //Button bot5= new Button("BOTTLE5");
        //Button bot6= new Button("BOTTLE6");
        Button yourship = new Button("");
        Button theirship = new Button("");
        Button treasureisland = new Button("");
        Button bottleinst = new Button("                    \n                     \n                     \n                     \n");

        businessbutton.setId("b1");
        storebutton.setId("b2");
        homebutton.setId("b3");
        //bot4.setId("b4");
        //bot5.setId("b5");
        //bot6.setId("b6");

        yourship.setId("yours");
        theirship.setId("theirs");
        treasureisland.setId("treasure");
        bottleinst.setId("btlemain");
        yourship.relocate(50.0,400.0);
        theirship.relocate(300.0,100.0);
        treasureisland.relocate(850,500);
        bottleinst.relocate(10,550);
        //bottleinst.resize(1000,100);
        //ENDOFMAINGAMESETUP


        Pane homescreen = new Pane();
        homescreen.getChildren().addAll(button2, businessbutton, storebutton, homebutton, desc);

        businessbutton.relocate(800,350);
        businessbutton.resize(200,200);
        storebutton.relocate(300,350);
        storebutton.resize(200,200);
        homebutton.relocate(550,500);
        homebutton.resize(200,200);
        //bot4.relocate(613.0,338.0);
        //bot4.resize(70.0,70.0);
        //bot5.relocate(792.0,215.0);
        //bot5.resize(70.0,70.0);
        //bot6.relocate(933.0,390.0);
        //bot6.resize(70.0,70.0);
        homescreen.setId("s2");

        desc.resize(1000,200);
        desc.relocate(450,100);
        desc.setText("Month 1 Of Your Business");
        desc.setId("dsc");
        Label criteria = new Label("testthis");
        Label businesslabel = new Label("My Business \n");
        Label storelabel = new Label("Items You Can Buy \n");
        Label houselabel = new Label("My House \n");

        scene2= new Scene(homescreen,1200,800);

        businessbutton.setOnAction(e -> Controller.clickedLocation(desc, "My Business", primaryStage, scene3));
        storebutton.setOnAction(e -> Controller.clickedLocation(desc, "Local Store", primaryStage, storePage));
        homebutton.setOnAction(e -> Controller.clickedLocation(desc, "My House", primaryStage, housePage));
        //bot4.setOnAction(e -> Controller.clickedButton(desc, 4, primaryStage, scene3, bot4, criteria, timer));
        //bot5.setOnAction(e -> Controller.clickedButton(desc, 5, primaryStage, scene3, bot5, criteria, timer));
        //bot6.setOnAction(e -> Controller.clickedButton(desc, 6, primaryStage, scene3, bot6, criteria, timer));


        //yourship.setOnAction(e -> Controller.clickedStore(desc));
        //theirship.setOnAction(e -> Controller.clickedHome(desc));
        //treasureisland.setOnAction(e -> Controller.cli(desc));
        bottleinst.setOnAction(e -> Controller.clickedmain(desc));
//Scene 3
        Label businessPage = new Label("This is the third scene");
        Button button3 = new Button("Go to scene 4");
        button3.setOnAction(e -> primaryStage.setScene(scene4));
        Pane layout3 = new Pane();


        //TextArea userbox = new TextArea("Start writing your message here!");
        //Label criteria = new Label("Bottle Rules \n");
        //userbox.setId("usebx");
        //desc.resize(1000,200);
        //desc.relocate(450,100);
        desc.setText("Store");
        criteria.setId("crit");
        Rectangle r = new Rectangle(100, 100, 1366, 1366);
        //userbox.setWrapText(true);
        //userbox.relocate(10,50);
        criteria.relocate(670,50);
        criteria.resize(300,1100);

        Label missing = new Label("If you make a mistake, you will have to pay 50 coins from your funds to replace the paper. Run out of funds and you won't have enough to keep your crew to find the treasure.");
        missing.setWrapText(true);
        missing.setPrefWidth(640);
        criteria.setPrefWidth(500);
        missing.relocate(10,300);
        missing.setId("mss");

        //Scene 4
        Label label4 = new Label("This is the fourth scene");
        Button button4 = new Button("Go to scene 5");
        Label end = new Label("This is the end");
        Button lastbtn = new Button("See Your Story");
        button4.setOnAction(e -> primaryStage.setScene(scene5));
        lastbtn.setOnAction(e -> primaryStage.setScene(scene5));
        end.relocate(200,200);
        lastbtn.relocate(450,500);
        end.setId("lastwords");
        lastbtn.setId("lastbtn");
        Pane layout4 = new Pane();
        layout4.getChildren().addAll(label4, button4, lastbtn, end);
        scene4= new Scene(layout4,1200,800);
        layout4.setId("s4");


        Label label5 = new Label("This is the fifth scene");
        Label ending = new Label("endtexthere");
        ending.setPrefWidth(600);
        ending.setWrapText(true);
        ending.setId("ending");
        Button button5 = new Button("Go to scene 1");
        button5.setOnAction(e -> primaryStage.setScene(scene1));
        Pane layout5 = new Pane();
        layout5.getChildren().addAll(label5, button5, ending);
        scene5 = new Scene(layout5,1200,800);
        layout5.setId("s5");


        Button submitMessage = new Button("Send Message");
        submitMessage.setId("submsg");
        //submitMessage.setOnAction(e -> Controller.submitmsg(userbox, primaryStage, scene2, ending, missing, desc, funds, end,scene4));
        submitMessage.relocate(400,550);
        ending.relocate(100,100);
        ending.setWrapText(true);

        layout3.getChildren().addAll(businessPage, button3, desc, criteria, submitMessage, missing, timer);
        scene3= new Scene(layout3,1200,800);
        layout3.setId("s3");

        titlepage.getStylesheets().add("/sample/bottlestyle.css");
        intropage.getStylesheets().add("/sample/bottlestyle.css");
        homescreen.getStylesheets().add("/sample/bottlestyle.css");
        layout3.getStylesheets().add("/sample/bottlestyle.css");
        layout4.getStylesheets().add("/sample/bottlestyle.css");
        layout5.getStylesheets().add("/sample/bottlestyle.css");
        //storePage.getStylesheets().add("/sample/bottlestyle.css");
        //housePage.getStylesheets().add("/sample/bottlestyle.css");
        businessPage.getStylesheets().add("/sample/bottlestyle.css");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }









    //NOTES
    //Label label1= new Label("This is the first scene"); This contains text. It can be text or an image. Here, a text box is placed and defined as label1 with the quote inside displayed.
    //Button button1= new Button("Go to scene 2"); This creates a button, the text inside is what will be on it
    //button1.setOnAction(e -> primaryStage.setScene(scene2)); This sets an action for the button to have. setScene is built in. We have to create new scenes.
    //VBox layout1 = new VBox(20); This reopens the virtual box, but it keeps it at the same size
    //layout1.getChildren().addAll(label1, button1); This function adds the label and button as children of the virtual box
    //scene1= new Scene(layout1, 300, 250); This initializes the first scene. The first scene is the layout with its children and the size is set up.
    //for the stylesheet to work you gotta add it to the layout and set ids for the things you make here
    //whatamidoingnow i should start with the third scene, the main game, and make buttons with images of bottles. The buttons will have to work.
    //plan - first scene title, second instructions, third main game, fourth bottle main game, fifth level results, sixth end game??
    //either way i can just work on the main game, THEN set it permanently to a scene. Scene for now will be scene #2.
    //now how in the world do i do this? first - make the buttons and place them second make them do something.
    //

}
