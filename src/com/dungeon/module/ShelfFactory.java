package com.dungeon.module;
import com.dungeon.IncorrectVolumeException;

import java.util.LinkedList;
import java.util.List;

public class ShelfFactory  {


   public static List<Shelf>createShelves(int width, int height, int length, int volume, int count)
           throws IncorrectVolumeException {
       List<Shelf> shelves= new LinkedList<>();
       for (int i = 0; i < count; i++) {
           shelves.add(new Shelf(width, height, length, volume));
       }
       return shelves;
   }
}
