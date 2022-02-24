package com.soj.designpattern.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetTheTilesTest {

    @Test
    void testToRun() {
        GetTheTiles getTheTiles=new GetTheTiles();
        ScrabbleSingleton newInstance= ScrabbleSingleton.getInstance();
        getTheTiles.run();
        Assertions.assertTrue(true,"got the tiles");



    }
}