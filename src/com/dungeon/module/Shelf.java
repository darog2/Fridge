package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Shelf extends AbstractContainer {
    public Shelf(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }

    public Shelf() {
        super();
    }
}
