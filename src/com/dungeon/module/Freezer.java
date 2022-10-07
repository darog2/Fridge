package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

public class Freezer extends AbstractContainer {
    public Freezer(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }

}
