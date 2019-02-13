package sample;

public class Message {
    public static String[] rulescant = {"a","b","c","d","e","f","g","h","i","l","m","n","o","r","s","t","u","w", "You can't use the word the","You can't use the word it","You can't use the word water","You can't use the word ship","You can't use the word fight","You have to use the word dance", "You have to use the word tea","You have to use the word party","You have to use the word hopscotch","You have to use the word painted"};
    //public static String[] rulescantletters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    //public static String[] rulescantphrases = {"You can't use the word the","You can't use the word it","You can't use the word water","You can't use the word ship","You can't use the word fight","You have to use the word dance"};
    //public static String[] rulescanphrases = {"You have to use the word tea","You have to use the word party","You have to use the word hopscotch","You have to use the word painted"};
    public static String[] phrases1 = {"wind in our sails","sailing as fast as a ","on the compass","a crew of ","enough supplies for a ","following the ","sailing for a few ", "purchased several ", "to prepare for the voyage"};
    public static String[] phrases2 = {"asked the neighborhood ", "found a ","scared by a ","decided to take ", "chose to go to the ", "stopped by a", "discovered that "};
    public static String[] phrases3 = {"had some trouble with the ", "found out that one of our crew members ","our supplies are ","bought some ", "discovered a cave with ", "found small islands where "};
    public static String[] phrases4 = {"found the kraken by accident", "played a game of chess against a ","spotted a few narwhals and said ","decided to do some whale watching and realized that ", "lost a few of my ","faced some whirlpools and"};
    public static String[] phrases5 = {"had a cannon fight with nearby pirates","had to rescue a sea serpent from ","received a gift for ","accidentally ran over a sea serpent and ","closer to the island by ", "should get there around "};
    public static String[] phrases6 = {"reached the island beaches","fought the king crab off with a ","started a campfire and sang ","found some fake treasure chests","drank some bad coconut milk"};

    public Message(String[] rules, String[] qualifiers, String[] phrases, int wordcount)
    {

    }

    public void setMessage()
    {

        int randomsetter = (int)Math.random()*rulescant.length;
    }

    public static String[] setRules(int rulenum, int bottle)
    {
        String[] setrules = new String[rulenum+4];
        String addstring;
        for(int i = 0; i < rulenum;i++)
        {
            int randomsetter = (int) (Math.random() * 10);
            if(rulescant[i].length()==1)
            {
                addstring = "You can't use the letter " + rulescant[randomsetter];
            }
            else {
                addstring = rulescant[randomsetter];
            }
            setrules[i] = addstring;
        }

        String p = "\n You Must Include the Phrases";
        setrules[rulenum] = p;


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


        return setrules;
    }

    public static String[] norepeats(String[] setrules, int rulenum, String[] phrases)
    {
        int lastround = 50;
        for(int i=0;i < 3;i++) {
            int thisround = (int) (Math.random() * phrases.length);
            if (thisround == lastround) {
                thisround = (int) (Math.random() * phrases.length);
                setrules[rulenum + 1 + i] = phrases[thisround];
            }
            else {
                lastround = thisround;
                setrules[rulenum + 1 + i] = phrases[thisround];
            }
        }
            return setrules;

    }
}
