package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;
import com.dungeon.Product;

import java.util.LinkedList;
import java.util.List;

public class AbstractContainer extends AbstractModule {
    private List<Shelf> shelfList;
    private int count;


    protected List<Product> products;

    public int setCount() {
        return count;
    }

    public AbstractContainer(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);

    }

    public List<Shelf> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<Shelf> shelfList) {
        this.shelfList = shelfList;
    }


}
