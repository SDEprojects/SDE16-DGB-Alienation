package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.CanOpen;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.parseinput.Input;

import java.util.ArrayList;
import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.charactersetc.Player.setInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class OpenItems {

    //Open something
    public static void open(Rooms currentRoom) throws Exception {
        setItem1(Input.getItem1()); // Chips

        List<String> items = getAvailableItemsMap().get(currentRoom);

        if(items.contains(getItem1())) {
            try {
                CanOpen itemToOpen = CanOpen.valueOf(getItem1().toUpperCase()); // cage
                //String upperAnswer = getItem1().toUpperCase();

                if(!getInventory().contains("code")){ // make the key code not cage
                    System.out.println(getAnsiRed() + "\nIt's locked" + getAnsiReset());
                }else {
                    System.out.println(getAnsiYellow() + "\nNew item added to inventory." + getAnsiReset());
                    List<String> newItems = new ArrayList<>();
                    newItems = getInventory();
                    newItems.add("ignition Switch");
                    // delete item from room and code from inventory
                    items.remove("Ignition Switch");
                    setAvailableItemsMap(currentRoom, items);
                    newItems.remove("Code");
                    setInventory(newItems);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(getAnsiRed() + "\nYou can't open that!" + getAnsiReset());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(getAnsiRed() + "\n" + action.toString().toLowerCase() +
                    " what?" + getAnsiReset());
        }
        else {
            System.out.println(getAnsiRed() + "\n" + "That's not in this room." + getAnsiReset());
        }
        displayMenu();
    }
}
