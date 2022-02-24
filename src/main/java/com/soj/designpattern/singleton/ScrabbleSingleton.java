package com.soj.designpattern.singleton;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ScrabbleSingleton {
    static final Logger logger= LogManager.getLogger(ScrabbleSingleton.class.getName());

    private static ScrabbleSingleton firstInstance=null;

    String[] scrabbleLetters={"a","a","a","a","a","a","b","b","b",
            "c","c","c","d","d","d","e","e","e","f","f","f","g","g",
            "k","k","l","l","m","m","n","n","o","o","p","p","q","q",
            "r","r","s","s","s","t","t","t","u","u","v","v","w","w",
            "x","x","y","y","z"};
    private LinkedList<String> letterList=new LinkedList<>(Arrays.asList(scrabbleLetters));
    static boolean firstThread=true;



    static synchronized ScrabbleSingleton getInstance(){

        if(firstInstance==null) {
            while (firstThread) {
                firstThread = false;
                Thread.currentThread();
                try {
                    ScrabbleSingleton.class.wait(1000);
                } catch (InterruptedException e) {

                    logger.log(Level.WARN,"Interrupted! ",e);
                    Thread.currentThread().interrupt();



                }
            }
            synchronized (ScrabbleSingleton.class) {


                firstInstance = new ScrabbleSingleton();

            Collections.shuffle(firstInstance.letterList);
        }
        }
         return firstInstance;
    }
    public List<String> getLetterList(){
        return firstInstance.letterList;
    }

    public List<String> getTiles(int howManyTiles){
        LinkedList<String> tilesToSend=new LinkedList<>();
        for (int i=0; i<=howManyTiles; i++){
            tilesToSend.add(firstInstance.letterList.remove(0));
        }
        return tilesToSend;
    }
}
