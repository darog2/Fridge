package com.dungeon;

import com.dungeon.menu.AdminMenu;
import com.dungeon.menu.PrintMenu;
import com.dungeon.module.Fridge;
import com.dungeon.module.FridgeList;
import com.dungeon.service.FridgeService;


import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws IncorrectVolumeException,
            UnsupportedEncodingException {
        FridgeService fridgeService= new FridgeService();
        FridgeList fridges = fridgeService.readFridgeFile();


//        FridgeList fridges = new FridgeList();
        System.out.println(fridges.getFridges().size());
        PrintMenu printMenu= new PrintMenu(fridgeService);
        printMenu.startPrintMenu(fridges);
       fridgeService.saveFridge(fridges);

    }
}
