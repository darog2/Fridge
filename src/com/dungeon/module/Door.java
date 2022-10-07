package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

public class Door extends AbstractContainer{
    public Door(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }
}
