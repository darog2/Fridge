package com.dungeon.module;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"year", "company", "model", "freezer", "door"} )
public  class Fridge  {
    @XmlAttribute
    private int year;
    @XmlAttribute
    private String company;
    @XmlAttribute
    private String model;
    @XmlAttribute
    private Freezer freezer;
    @XmlAttribute
    private Door door;


    public Fridge(int year, String company, String model, Freezer freezer, Door door) {
        this.year = year;
        this.company = company;
        this.model = model;
        this.freezer = freezer;
        this.door = door;
    }

    public Fridge() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public void setFreezer(Freezer freezer) {
        this.freezer = freezer;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "year=" + year +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", freezer=" + freezer +
                ", door=" + door +
                '}';
    }
}
