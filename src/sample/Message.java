package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Message {
    public static String[] rulescant = {"z","b","m","k","v","h","q","r","t","u","y", "there","it","water","ship","fight","dancing", "tea party","birthday party","hopscotch","painted"};
    //public static String[] rulescantletters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    //public static String[] rulescantphrases = {"You can't use the word the","You can't use the word it","You can't use the word water","You can't use the word ship","You can't use the word fight","You have to use the word dance"};
    //public static String[] rulescanphrases = {"You have to use the word tea","You have to use the word party","You have to use the word hopscotch","You have to use the word painted"};
    public static String[] phrases1 = {"wind in our sails","sailing as fast as a ","on the compass","a crew of ","enough supplies for a ","following the ","sailing for a few ", "purchased several ", "to prepare for the voyage"};
    public static String[] phrases2 = {"asked the neighborhood ", "found a ","scared by a ","decided to take ", "chose to go to the ", "stopped by a", "discovered that "};
    public static String[] phrases3 = {"had some trouble with the ", "found out that one of our crew members ","our supplies are ","bought some ", "discovered a cave with ", "found small islands where "};
    public static String[] phrases4 = {"found the kraken by accident", "played a game of chess against a ","spotted a few narwhals and said ","decided to do some whale watching and realized that ", "lost a few of my ","faced some whirlpools and","can't find my ","drifted away from "};
    public static String[] phrases5 = {"had a cannon fight with nearby pirates","had to rescue a sea serpent from ","received a gift for ","accidentally ran over a sea serpent and ","closer to the island by ", "should get there around ","realized I wanted to ","lost my "};
    public static String[] phrases6 = {"reached the island beaches","fought the king crab off with a ","started a campfire and sang ","found some fake treasure chests","drank some bad coconut milk","started missing my","forgot that I had a ","needed to find a ","couldn't find my "};
    private static String[] basis = new String[10];

    public static String[] setRules(int rulenum, int bottle)
    {
        String[] setrules = new String[2+rulenum];
        String addstring;
        for(int i = 0; i < rulenum;i++)
        {
            int randomsetter = (int) (Math.random() * rulescant.length);
            if(rulescant[randomsetter].length()==1)
            {
                addstring = "You can't use the letter " + rulescant[randomsetter];
            }
            else if (randomsetter < 16){
                addstring = "You can't use the word " + rulescant[randomsetter];
            }
            else
            {
                addstring = "You have to use the word " + rulescant[randomsetter];

            }
            basis[i] = rulescant[randomsetter];
            setrules[i] = addstring;
        }

        String p = "\n You Must Include the Phrases";
        setrules[2] = p;


            if (bottle == 1) {
                norepeats(setrules,rulenum,phrases1);
            }
            if (bottle == 2) {
                norepeats(setrules,rulenum,phrases2);
            }
            if (bottle == 3) {
                norepeats(setrules,rulenum,phrases3);
            }
            if (bottle == 4) {
                norepeats(setrules,rulenum,phrases4);
            }
            if (bottle == 5) {
                norepeats(setrules,rulenum,phrases5);
            }
            if (bottle == 6) {
                norepeats(setrules,rulenum,phrases6);
            }

        for(int k = 3; k < setrules.length; k++)
        {
            basis[k] = setrules[k];
        }
        for(int k = setrules.length; k < basis.length; k++)
        {
            basis[k] = "ddd";
        }
        return setrules;
    }

    public static String[] norepeats(String[] setrules, int rulenum, String[] phrases) {
        int[] phrasechoice = new int[phrases.length];
        for (int i = 0; i < phrasechoice.length; i++) {
            phrasechoice[i] = i;
        }

        for(int i = 0; i < phrasechoice.length;i++)
        {
            int rand = (int)(Math.random()*phrasechoice.length);
            int temp = phrasechoice[i];
            phrasechoice[i] = phrasechoice[rand];
            phrasechoice[rand] = temp;
        }


        for (int i = 1; i < rulenum; i++) {
            setrules[i + 2] = phrases[phrasechoice[i]];
        }
        return setrules;
    }

    public static int checkrules(TextArea text, Label missed, int btlenum)
    {
        String fullmsg = text.getText();
        String[] eachword = fullmsg.split(" ");
        String missing = "Oh no! You made a mistake and need to pay 50 points for more paper!";
        int wordlim = 10 * btlenum;

        if(eachword.length < wordlim)
        {
            missing = missing + "\n Sorry, the word count for this level is " + wordlim;
        }

        for(int i = 0; i < basis.length;i++) {
            //if(basis[i].length() < 7 && !fullmsg.contains(basis[i]) || basis[i].length() >= 7 && fullmsg.contains(basis[i]))
            if (basis[i].length() >= 7 && fullmsg.indexOf(basis[i]) != -1 || basis[i].length() < 7 && fullmsg.indexOf(basis[i]) == -1) {
            }
            if (basis[i].length() < 7 && fullmsg.indexOf(basis[i]) != -1) {
                missing = missing + "\n " + "Sorry, you cannot include the word " + basis[i];
            }
            if (basis[i].length() >= 7 && fullmsg.indexOf(basis[i]) == -1) {
                missing = missing + "\n " + "Sorry, you need to include the word " + basis[i];
            }
        }
        missed.setText(missing);
        missed.setMaxHeight(220);
        String checker = missed.getText();
        if(fullmsg.contains("testercheatkittens"))
        {
            return 2;
        }
        if(checker.contains("Sorry"))
        {
            return 0;
        }
        return 1;
    }
}
