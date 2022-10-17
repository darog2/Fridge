package com.dungeon.menu;


import com.dungeon.IncorrectVolumeException;
import com.dungeon.InputUtils;
import com.dungeon.language.ApplicationConstants;
import com.dungeon.language.LanguageUtil;
import com.dungeon.module.*;
import com.dungeon.service.FridgeService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private FridgeService fridgeService;

    public AdminMenu(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    private static Freezer createFreezer() {
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.MENU_CREATE_FREEZER_TEXT));
        int width = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.WIDTH_TEXT));
        int height = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.HEIGHT_TEXT));
        int length = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.LENGTH_TEXT));
        int volume = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.VOLUME_TEXT));

        Freezer freezer = null;
        try {
            freezer = new Freezer(width, height, length, volume);
            freezer.setShelfList(createShelves());
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println(LanguageUtil.getMessage(ApplicationConstants.IS_CORRECT_TEXT));
            return createFreezer();
        }
        return freezer;

    }

    private static  List<Shelf> createShelves() {
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.SHELF_PARAMETR_TEXT));
        int width = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.WIDTH_TEXT));
        int height = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.HEIGHT_TEXT));
        int length = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.LENGTH_TEXT));
        int volume = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.VOLUME_TEXT));
        int count = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.COUNT_SHELF_TEXT));
        List<Shelf> shelves = null;
        try {
            shelves = ShelfFactory.createShelves(width, height, length, volume, count);
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println(LanguageUtil.getMessage(ApplicationConstants.IS_CORRECT_TEXT));
        }
        return shelves;
    }

    private static Door createDoor() {
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.DOOR_PARAMERT_TEXT));
        int width = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.WIDTH_TEXT));
        int height = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.HEIGHT_TEXT));
        int length = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.LENGTH_TEXT));
        int volume = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.VOLUME_TEXT));
        Door door = null;
        try {
            door = new Door(width, height, length, volume);
            door.setShelfList(createShelves());
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println(LanguageUtil.getMessage(ApplicationConstants.IS_CORRECT_TEXT));
        }

        return door;
    }

    public  void addNewFridge(FridgeList fridges) {
        Fridge fridge = new Fridge();
        fridge.setYear(InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.YEAR_FRIDGE_TEXT)));
        fridge.setCompany(InputUtils.readLine(LanguageUtil.getMessage(ApplicationConstants.COMPANY_FRIDGE_TEXT)));
        fridge.setModel(InputUtils.readLine(LanguageUtil.getMessage(ApplicationConstants.MODEL_FRIDGE_TEXT)));
        fridge.setWidth(InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.WIDTH_TEXT)));
        fridge.setHeight(InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.HEIGHT_TEXT)));
        fridge.setLength(InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.LENGTH_TEXT)));
        fridge.setVolume(InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.VOLUME_TEXT)));
        fridge.setFreezer(createFreezer());
        fridge.setDoor(createDoor());
        fridgeService.showFridge(fridge);
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.SAVE_FRIDGE_TEXT));
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.START_NEW_FRIDGE_TEXT));
        System.out.println(LanguageUtil.getMessage(ApplicationConstants.OUT_FRIDGE_TEXT));
        int choice= InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.CHOICE));
        switch (choice){
            case 1 :{
                fridges.add(fridge);
                return;
            }
            case 2 :{
                    break;
            }
            case 3:{
                return;
            }
            default:
        }


    }

    protected static void deleteFridge(FridgeList fridges) {
        List<Fridge> fridgeList = fridges.getFridges();
        System.out.println( LanguageUtil.getMessage(ApplicationConstants.MENU_DELETE_TEXT));
        do {
            for (Fridge fridge : fridges) {
                System.out.println(fridge.toString());
            }
            int a = InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.COUNT_TEXT));
            if (a > 0 && a <= fridgeList.size()) {
                Fridge fridge = fridgeList.get(a - 1);
                System.out.println(fridge.toString());
                int confirm=InputUtils.readInt(LanguageUtil.getMessage(ApplicationConstants.MENU_TEXT));
                if(confirm==1) {
                    fridgeList.remove(fridge);
                    System.out.println(LanguageUtil.getMessage(ApplicationConstants.MENU_DELETE_FRIDGE_TEXT));
                }
                    return;
            }else {
                System.out.println(LanguageUtil.getMessage(ApplicationConstants.MENU_SEARCH_TEXT));
            }
        }while (true);

    }

    }


