package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;
import com.dungeon.VolumeValidationUtil;


import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"width", "height", "length", "volume","modules"} )

public class AbstractModule {
    @XmlAttribute
    protected int width;
    @XmlAttribute
    protected int height;
    @XmlAttribute
    protected int length;
    @XmlAttribute
    protected int volume;
@XmlElementWrapper
    protected List<AbstractModule> modules;

    public AbstractModule(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        this.width = width;
        this.height = height;
        this.length = length;
        this.volume = volume;
        VolumeValidationUtil.validateVolume(this);
    }

    public AbstractModule() {
    }

    public List<AbstractModule> getModules() {
        return modules;
    }

    public void setModules(List<AbstractModule> modules) {
        this.modules = modules;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", volume=" + volume +
                '}';
    }
}

