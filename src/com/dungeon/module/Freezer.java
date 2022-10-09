package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Freezer extends AbstractContainer {

    public Freezer(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }

    public Freezer() {
        super();
    }
}
