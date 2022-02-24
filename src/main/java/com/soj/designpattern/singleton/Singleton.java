package com.soj.designpattern.singleton;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Singleton {
    static final Logger logger= LogManager.getLogger(Singleton.class.getName());

    private static Singleton firstInstance=null;

    String[] scrabbleLetters={"a","a","a","a","a","a","b","b","b",
            "c","c","c","d","d","d","e","e","e","f","f","f","g","g",
            "k","k","l","l","m","m","n","n","o","o","p","p","q","q",
            "r","r","s","s","s","t","t","t","u","u","v","v","w","w",
            "x","x","y","y","z"};
    private LinkedList<String> letterList=new LinkedList<>(Arrays.asList(scrabbleLetters));
    static boolean firstThread=true;

    private Singleton() {
    }
    public static synchronized Singleton getInstance(){

        if(firstInstance==null) {
            while (firstThread) {
                firstThread = false;
                Thread.currentThread();
                try {
                    Singleton.class.wait(1000);
                } catch (InterruptedException e) {

                    logger.log(Level.WARN,"Interrupted! ",e);
                    Thread.currentThread().interrupt();



                }
            }
            synchronized (Singleton.class) {


                firstInstance = new Singleton();

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
