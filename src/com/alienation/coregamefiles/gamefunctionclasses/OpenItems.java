package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.CanOpen;
import com.alienation.coregamefiles.enums.Rooms;

import java.util.ArrayList;
import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.charactersetc.Player.setInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class OpenItems {

    //Open something
    public static void open(Rooms currentRoom) throws Exception {
        setItem1(capitalizeAll(Input.getItem1())); // Chips
        setItem2(capitalizeAll(Input.getItem2())); // Oxygen Tank

        List<String> items = getAvailableItemsMap().get(currentRoom);

        if(items.contains(getItem2()) || items.contains(getItem1())) {
            try {
                CanOpen itemToOpen = CanOpen.valueOf(getItem1().toUpperCase()); // cage
                String upperAnswer = getItem1().toUpperCase();
                if (itemToOpen.toString().equals(upperAnswer)) { // new answer it cage
                    if(!getInventory().contains("Code")){ // make the key code not cage
                        System.out.println(ANSI_RED + "\nIt's locked" + ANSI_RESET);
                    }else{
                        System.out.println(ANSI_YELLOW + "\nNew item added to inventory."+ ANSI_RESET);
                        List<String> newItems = new ArrayList<>();
                        newItems = getInventory();
                        newItems.add("Ignition Switch");
                        // delete item from room and code from inventory
                        items.remove("Ignition Switch");
                        setAvailableItemsMap(currentRoom, items);
                        newItems.remove("Code");
                        setInventory(newItems);
                    }
                } else {
                    System.out.println("here");
                    displayMenu();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "\nYou can't open that!" + ANSI_RESET);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
        }
        displayMenu();
    }
}
