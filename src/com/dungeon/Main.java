package com.dungeon;

import com.dungeon.module.FridgeList;
import com.dungeon.module.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectVolumeException, UnsupportedEncodingException {

        FridgeList fridges = readFridgeFile();
//        FridgeList fridges = new FridgeList();
        System.out.println(fridges.getFridges().size());
        printMenu(fridges);
       saveFridge(fridges);

    }


    private static void startPrintMenu() {
        System.out.println("выбирете режим пользования");
        System.out.println("1 режим администратора");
        System.out.println("2 режим пользователя ");
        System.out.println("3 оставь надежду всяк сюда входящий");
    }

    public static void printMenu(FridgeList fridges) {
        int choice = 0;
        do {
            startPrintMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                 addNewFridge( fridges);
                }
                case 2: {
                    break;
                }
                case 3:{
                    return;
                }
            }

        } while (true);
    }

    public static void print(String s) {
    }

    private static void saveFridge(FridgeList fridges) {
        String filePath = "fridges.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(FridgeList.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(fridges, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static FridgeList readFridgeFile() {
        FridgeList fridges = new FridgeList();
        String filePath ="fridges.xml" ;
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(FridgeList.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (FridgeList) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void addNewFridge(FridgeList fridges) {
        Fridge fridge = new Fridge();
        fridge.setYear(InputUtils.readInt("введите год холодильника"));
        fridge.setCompany(InputUtils.readLine("введите название компании"));
        fridge.setModel(InputUtils.readLine("введите название модели"));
        fridge.setFreezer(createFreezer());
        fridge.setDoor(createDoor());
        fridges.add(fridge);

    }

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


}
