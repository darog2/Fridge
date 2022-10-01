package com.dungeon.fridge;

import com.dungeon.module.*;

import java.util.List;

public class SomeFridge {
    private Door door;
    private Freezer freezer;
    private Fridge fridge;


    public SomeFridge(Door door, Freezer freezer, Fridge fridge) {
        this.door = door;
        this.freezer = freezer;
        this.fridge = fridge;

    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public void setFreezer(Freezer freezer) {
        this.freezer = freezer;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }



    @Override
    public String toString() {
        return "SomeFridge{" +
                "door=" + door +
                ", freezer=" + freezer +
                ", fridge=" + fridge +

                '}';
    }
}
