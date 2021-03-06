/*
 *      Alienation
 *      TLG Learning: Capstone Project
 *      Originally Created by Team Alienation &&
 *      Edited by Team Capstone Mafia
 *      https://github.com/Capstone-Mafia
 *
 *      Team Alienation Members:
 *      Brad Smialek (https://github.com/bradsmialek)
 *      Dhruti Kosta (https://github.com/dhruti-kosta)
 *      Terrell Douglas (https://github.com/Dougie105)
 *      Original project repo:
 *      https://github.com/bradsmialek/Alienation
 *
 *      Capstone Mafia Members:
 *      Bruce West (https://github.com/BruceBAWest)
 *      Gurinder Batth (https://github.com/GurinderB)
 *      Daeun Lok (https://github.com/koreareefclub)
 *      Capstone Mafia fork:
 *      https://github.com/Capstone-Mafia/Alienation
 */

package com.alienation.coregamefiles.rooms;

import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.gameart.Death;
import com.alienation.tools.Time;

public abstract class Room {
    private static int minusOxy = 10; // TODO: Make random number??


    static String getStory() {
        return null;
    }


    public static void loadEnvironment() throws Exception {
        Player.checkHealth();
        Oxygen.minOxygen(minusOxy);
        Oxygen.checkOxy();

//        System.out.println(getStory());
//        if (Player.getTime().secondsElapsed()>600){
//            Death.death();
//        };

    }
}


