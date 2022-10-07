package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

public class Shelf extends AbstractContainer {
    public Shelf(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }

}
