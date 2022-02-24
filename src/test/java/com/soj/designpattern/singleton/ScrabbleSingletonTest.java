package com.soj.designpattern.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ScrabbleSingletonTest {

    @Test
    void getSingletonInstance() {
      ScrabbleSingleton instance1= ScrabbleSingleton.getInstance();
      ScrabbleSingleton instance2= ScrabbleSingleton.getInstance();
      Assertions.assertEquals(true,instance1==instance2);
    }

    @Test
    void testToGetLetterList() {
        String[] scrabbleLetters={"a","a","a","a","a","a","b","b","b",
                "c","c","c","d","d","d","e","e","e","f","f","f","g","g",
                "k","k","l","l","m","m","n","n","o","o","p","p","q","q",
                "r","r","s","s","s","t","t","t","u","u","v","v","w","w",
                "x","x","y","y","z"};
        ScrabbleSingleton instance= ScrabbleSingleton.getInstance();
        LinkedList<String> letterList=new LinkedList<>(Arrays.asList(scrabbleLetters));
       Collections.shuffle(letterList);
        Assertions.assertEquals(instance.getLetterList().size(),letterList.size());
    }

    @Test
    void testToGetTiles() {
        ScrabbleSingleton instance= ScrabbleSingleton.getInstance();
        LinkedList<String> tiles=new LinkedList<>();
        tiles.add(instance.getLetterList().remove(0));
        List<String> result=instance.getTiles(3);
        Assertions.assertEquals(4,result.size());
    }
}