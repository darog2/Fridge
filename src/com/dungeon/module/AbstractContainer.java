package com.dungeon.module;

import com.dungeon.IncorrectVolumeException;
import com.dungeon.Product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class AbstractContainer extends AbstractModule {
    @XmlElementWrapper(name = "shelves")
    @XmlElement(name="shelf")
    private List<Shelf> shelfList;

    @XmlTransient
    protected List<Product> products;



    public AbstractContainer(int width, int height, int length, int volume)
            throws IncorrectVolumeException {
        super(width, height, length, volume);

    }

    public AbstractContainer() {
        super();
    }

    public List<Shelf> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<Shelf> shelfList) {
        this.shelfList = shelfList;
    }


}
