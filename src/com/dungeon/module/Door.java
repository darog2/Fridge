package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Door extends AbstractContainer{
    public Door(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);
    }

    public Door() {
        super();
    }
}
