package com.dungeon;

import com.dungeon.module.AbstractModule;

public class VolumeValidationUtil {
    private VolumeValidationUtil() {
    }

    public static void validateVolume(AbstractModule module)
            throws IncorrectVolumeException {
        double volume = (double) (module.getHeight() * module.getLength() * module.getWidth()) / 1000;
        double difference = volume / module.getVolume();
        if (difference < 1.15) {
            throw new IncorrectVolumeException(difference);
        }
    }
}
