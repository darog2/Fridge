package com.dungeon.menu;

import com.dungeon.InputUtils;
import com.dungeon.module.Fridge;
import com.dungeon.module.FridgeList;
import com.dungeon.service.FridgeService;

import java.util.List;
import java.util.Scanner;

public class PrintMenu {
    private FridgeService fridgeService;

    public PrintMenu(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    public void startPrintMenu(FridgeList fridges) {
        do {
            System.out.println("выбирете режим пользования");
            System.out.println("1 режим администратора");
            System.out.println("2 режим пользователя ");
            System.out.println("3 оставь надежду всяк сюда входящий");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
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
            System.out.println("1 режим добавления холодильика");
            System.out.println("2 режим удаления  холодильика");
            System.out.println("3 выход выход из программы");

            choice = InputUtils.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: {
                    AdminMenu.addNewFridge(fridges);
                    System.out.println("3 выход");
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
