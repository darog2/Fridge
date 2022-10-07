package com.dungeon;

import com.dungeon.fridge.FridgeList;
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
        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        FridgeList fridges = readFridgeFile();
//        Freezer freezer= new Freezer(40,100,50,160);
//        freezer.setShelfList(ShelfFactory.createShelves(35,95,45,124,5));
//        Door door= new Door(40,50,100,130);
//        door.setShelfList(ShelfFactory.createShelves(39,49,95,134,2));
//    Fridge fridge= new Fridge(1999,"Honda","powerBoy", freezer, door);
//        System.out.println(fridge);
        printMenu(fridges);

    }


    private static void startPrintMenu() {
        System.out.println("выбирете режим пользования");
        System.out.println("1 режим администратора");
        System.out.println("2 режим пользователя ");
    }

    public static void printMenu(FridgeList fridges) {
        int choice = 0;
        do {
            startPrintMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {

                }
                case 2: {
                    break;
                }
            }

        } while (true);
    }

    public static void print(String s) {
    }

    private static void saveFridge(Fridge fridge) {
        String filePath = System.getenv("apartments.path");
        try {
            JAXBContext context = JAXBContext.newInstance(Fridge.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(fridge, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static FridgeList readFridgeFile() {
        FridgeList fridges = new FridgeList();
        String filePath = System.getenv("fridge.path");
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(fridges.getClass());
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
        System.out.println("введите параметры морозилки");
        fridge.setFreezer(createFreezer());
        System.out.println("введите параметры двери");
        fridge.setDoor(createDoor());
        fridges.add(fridge);

    }

    private static Freezer createFreezer() {
        int width = InputUtils.readInt("введите ширину");
        int height = InputUtils.readInt("введите высоту");
        int length = InputUtils.readInt("введите длину");
        int volume = InputUtils.readInt("введите обьем");

        Freezer freezer = null;
        try {
            freezer = new Freezer(width, height, length, volume);
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect input, try again");
            return createFreezer();
        }
        freezer.setShelfList(createShelves());
        return freezer;

    }

    private static List<Shelf> createShelves() {
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
        int width = InputUtils.readInt("введите ширину");
        int height = InputUtils.readInt("введите высоту");
        int length = InputUtils.readInt("введите длину");
        int volume = InputUtils.readInt("введите обьем");
        Door door = null;
        try {
            door = new Door(width, height, length, volume);
        } catch (IncorrectVolumeException e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect input, try again");
        }
        return door;
    }


}
