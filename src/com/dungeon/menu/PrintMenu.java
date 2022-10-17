package com.dungeon.menu;

import com.dungeon.InputUtils;
import com.dungeon.language.ApplicationConstants;
import com.dungeon.language.LanguageUtil;
import com.dungeon.module.Fridge;
import com.dungeon.module.FridgeList;
import com.dungeon.service.FridgeService;

import java.util.Scanner;

public class PrintMenu {
    private AdminMenu adminMenu;
    private FridgeService fridgeService;

    public PrintMenu(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
        this.adminMenu=new AdminMenu(fridgeService);
    }

    public void startPrintMenu(FridgeList fridges) {
        System.out.println("Выберите язык / Оберіть мову / Choose language");
        System.out.println("Е: 1");
        System.out.println("русиш: 2");
        System.out.println("Украинский: 3");
        int choice1=InputUtils.readInt("введите число");
        switch (choice1){
            case 1:{
                LanguageUtil.getInstance().switchToEnglish();
                break;
            }
            case 2:{
                LanguageUtil.getInstance().switchToRussian();
                break;
            }
            case 3:{
                LanguageUtil.getInstance().switchToUkrainian();
                break;
            }
            default:
        }
        do {
            System.out.println(LanguageUtil.getMessage(ApplicationConstants.MAIN_MENU_TEXT));


            int choice = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.CHOICE));
            switch (choice) {
                case 1: {
                    printMenuAdmin(fridges);
                    break;
                }
                case 2: {
                    for (Fridge fridge : fridges) {
                        fridgeService.showFridge(fridge);
                    }
                    break;
                }
                case 3: {
                    return;
                }
            }
        } while (true);
    }

    public void printMenuAdmin(FridgeList fridges) {

        int choice = 0;
        do {
            System.out.println(LanguageUtil.getMessage(ApplicationConstants.ADMIN_MENU_TEXT));

            choice = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.CHOICE));
            switch (choice) {
                case 1: {
                    adminMenu.addNewFridge(fridges);


                    break;
                }
                case 2: {
                    AdminMenu.deleteFridge(fridges);
                    break;
                }
                case 3: {
                    return;
                }
            }

        } while (true);
    }

    public static void print(String s) {
    }
}
