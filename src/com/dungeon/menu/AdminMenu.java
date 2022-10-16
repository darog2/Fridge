package com.dungeon.menu;


import com.dungeon.IncorrectVolumeException;
import com.dungeon.InputUtils;
import com.dungeon.module.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {


    private static Freezer createFreezer() {
        System.out.println("введите параметры холодильной камеры");
        int width = InputUtils.readInt("введите ширину");
        int height = InputUtils.readInt("введите высоту");
        int length = InputUtils.readInt("введите длину");
        int volume = InputUtils.readInt("введите обьем");

        Freezer freezer = null;
        try {
            freezer = new Freezer(width, height, length, volume);
            freezer.setShelfList(createShelves());
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect input, try again");
            return createFreezer();
        }
        return freezer;

    }

    private static List<Shelf> createShelves() {
        System.out.println("введите параметры полок");
        int width = InputUtils.readInt("введите ширину");
        int height = InputUtils.readInt("введите высоту");
        int length = InputUtils.readInt("введите длину");
        int volume = InputUtils.readInt("введите обьем");
        int count = InputUtils.readInt("введите количесво полок");
        List<Shelf> shelves = null;
        try {
            shelves = ShelfFactory.createShelves(width, height, length, volume, count);
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect input,true again");
        }
        return shelves;
    }

    private static Door createDoor() {
        System.out.println("введите параметры двери");
        int width = InputUtils.readInt("введите ширину");
        int height = InputUtils.readInt("введите высоту");
        int length = InputUtils.readInt("введите длину");
        int volume = InputUtils.readInt("введите обьем");
        Door door = null;
        try {
            door = new Door(width, height, length, volume);
            door.setShelfList(createShelves());
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect input, try again");
        }

        return door;
    }

    protected static void addNewFridge(FridgeList fridges) {

        Fridge fridge = new Fridge();
        fridge.setYear(InputUtils.readInt("введите год холодильника"));
        fridge.setCompany(InputUtils.readLine("введите название компании"));
        fridge.setModel(InputUtils.readLine("введите название модели"));
        fridge.setWidth(InputUtils.readInt("введите ширину холодильника "));
        fridge.setHeight(InputUtils.readInt("введите высоту"));
        fridge.setLength(InputUtils.readInt("введите длину"));
        fridge.setVolume(InputUtils.readInt("введите обьем"));
        fridge.setFreezer(createFreezer());
        fridge.setDoor(createDoor());

        fridges.add(fridge);


    }

    protected static void deleteFridge(FridgeList fridges) {
        List<Fridge> fridgeList = fridges.getFridges();
        System.out.println("выбирете холодильник для удаления: ");
        do {
            for (Fridge fridge : fridges) {
                System.out.println(fridge.toString());
            }
            int a = InputUtils.readInt("введите номер ");
            if (a > 0 && a <= fridgeList.size()) {
                Fridge fridge = fridgeList.get(a - 1);
                System.out.println(fridge.toString());
                int confirm=InputUtils.readInt("1 нажмите для потверждения удаления: ");
                if(confirm==1) {
                    fridgeList.remove(fridge);
                    System.out.println("холодильник был удален");
                }
                    return;
            }else {
                System.out.println("введите сущесвующий номер холодильника: ");
            }
        }while (true);

    }

    }


