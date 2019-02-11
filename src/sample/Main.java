package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {

    Scene scene1, scene2, scene3, scene4;
    boolean b1stat, b2stat, b3stat, b4stat, b5stat, b6stat;

    //add the police song message in a bottle or one of the instrumentals or both
    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("SceneTest");
        Label desc = new Label();
//Scene 1
        Label label1= new Label("This is the first scene");
        Button button1= new Button("Go to scene 2");
        button1.setOnAction(event -> primaryStage.setScene(scene2));
        Pane layout1 = new Pane();
        layout1.getChildren().addAll(label1, button1);
        scene1= new Scene(layout1, 1200, 800);
        layout1.setId("s1");

//Scene 2
        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 3");
        button2.setOnAction(event -> primaryStage.setScene(scene3));

        //MAINGAMESETUP
        Button bot1= new Button("BOTTLE1");
        Button bot2= new Button("BOTTLE2");
        Button bot3= new Button("BOTTLE3");
        Button bot4= new Button("BOTTLE4");
        Button bot5= new Button("BOTTLE5");
        Button bot6= new Button("BOTTLE6");
        Button yourship = new Button("");
        Button theirship = new Button("");
        Button treasureisland = new Button("");

        bot1.setId("b1");
        bot2.setId("b2");
        bot3.setId("b3");
        bot4.setId("b4");
        bot5.setId("b5");
        bot6.setId("b6");

        yourship.setId("yours");
        theirship.setId("theirs");
        treasureisland.setId("treasure");
        yourship.relocate(100.0,400.0);
        theirship.relocate(300.0,100.0);
        treasureisland.relocate(1000,500);
        //ENDOFMAINGAMESETUP


        Pane layout2 = new Pane();
        layout2.getChildren().addAll(label2, button2, bot1, bot2, bot3, bot4, bot5, bot6,yourship,theirship,treasureisland,desc);

        bot1.relocate(215.0,215.0);
        bot1.resize(70.0,70.0);
        bot2.relocate(327,365);
        bot2.resize(70.0,70.0);
        bot3.relocate(510.0,145.0);
        bot3.resize(70.0,70.0);
        bot4.relocate(613.0,338.0);
        bot4.resize(70.0,70.0);
        bot5.relocate(792.0,215.0);
        bot5.resize(70.0,70.0);
        bot6.relocate(933.0,390.0);
        bot6.resize(70.0,70.0);
        layout2.setId("s2");

        desc.resize(1000,200);
        desc.relocate(100,700);
        desc.setText("Time to start your voyage! Click on the first bottle.");

        scene2= new Scene(layout2,1200,800);


        bot1.setOnAction(event -> Controller.clickedButton(desc, b1stat, 1, primaryStage, scene3));
        bot2.setOnAction(event -> Controller.clickedButton(desc, b1stat, 2, primaryStage, scene3));
        bot3.setOnAction(event -> Controller.clickedButton(desc, b1stat, 3, primaryStage, scene3));
        bot4.setOnAction(event -> Controller.clickedButton(desc, b1stat, 4, primaryStage, scene3));
        bot5.setOnAction(event -> Controller.clickedButton(desc, b1stat, 5, primaryStage, scene3));
        bot6.setOnAction(event -> Controller.clickedButton(desc, b1stat, 6, primaryStage, scene3));

//Scene 3
        Label label3 = new Label("This is the third scene");
        Button button3 = new Button("Go to scene 4");
        button3.setOnAction(event -> primaryStage.setScene(scene4));
        Pane layout3 = new Pane();

        TextField usermessage = new TextField();

        layout3.getChildren().addAll(label3, button3, usermessage);
        scene3= new Scene(layout3,1200,800);
        layout3.setId("s3");

        //Scene 4
        Label label4 = new Label("This is the fourth scene");
        Button button4 = new Button("Go to scene 1");
        button4.setOnAction(event -> primaryStage.setScene(scene1));
        Pane layout4 = new Pane();
        layout4.getChildren().addAll(label4, button4);
        scene4= new Scene(layout4,1200,800);
        layout4.setId("s4");

        layout1.getStylesheets().add("/sample/bottlestyle.css");
        layout2.getStylesheets().add("/sample/bottlestyle.css");
        layout3.getStylesheets().add("/sample/bottlestyle.css");
        layout4.getStylesheets().add("/sample/bottlestyle.css");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
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
