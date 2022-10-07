package com.dungeon.fridge;

import com.dungeon.module.Fridge;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
@XmlType(name="Fridges")
@XmlRootElement

public class FridgeList implements Iterable<Fridge> {
    @XmlElementWrapper(name="Fridges")
    @XmlElement(name="Fridge")
    private List<Fridge> fridges = new LinkedList<>();

    public void remove(int index) {
        fridges.remove(index);
    }
        public void add (Fridge fridge){
            fridges.add(fridge);
        }

    public List<Fridge> getFridges() {
        return fridges;
    }
    @Override
    public Spliterator<Fridge> spliterator() {
        return fridges.spliterator();
    }

    @Override
    public Iterator<Fridge> iterator() {
        return null;
    }
}
