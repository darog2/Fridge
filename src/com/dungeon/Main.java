package com.dungeon;

import com.dungeon.fridge.SomeFridge;
import com.dungeon.module.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Door door = new Door();
        Fridge fridge = new Fridge(1992, "Kitta", "zaebaalka3000");
        Freezer freezer = new Freezer();
        List<Shelf> shelves= ShelfFactory.createShelfs(40,1,40,40,5);
        SomeFridge someFridge = new SomeFridge(door, freezer, fridge, shelves);
        System.out.println(someFridge);
    }
}
