package com.soj.designpattern.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class GetTheTiles implements Runnable {
    static final Logger logger= LogManager.getLogger(GetTheTiles.class.getName());
    @Override
    public void run() {
        ScrabbleSingleton newInstance= ScrabbleSingleton.getInstance();
        List<String> playerOneTiles=newInstance.getTiles(7);
        logger.debug("Instance ID: {}",System.identityHashCode(newInstance));
        logger.debug(newInstance.getLetterList());
        logger.debug("Player : {}" ,playerOneTiles);
        logger.debug("GOT TILES");

    }
}
