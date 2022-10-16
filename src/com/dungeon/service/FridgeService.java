package com.dungeon.service;


import com.dungeon.module.Fridge;
import com.dungeon.module.FridgeList;
import com.dungeon.module.Shelf;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


public class FridgeService {

    public static final String HEADER = "                                           `            Холодильник                                     ";
    private static final String MANUFACTURE = StringUtils.left("Производитель:             ", 44);
    private static final String MODEL = StringUtils.left("Модель:                    ", 44);
    private static final String YEAR = StringUtils.left("Год выпуска:               ", 44);
    private static final String LINE = "                                                                                                       ";
    private static final String LINE_FRIDGE = "              Холодильная камера                             Полки холодильной камеры                  ";
    private static final String LINE_PARAMETER = "(ширина,высота,длина,в сантиметрах)               (ширина,высота,длина,в сантиметрах, кол-во полок)    ";
    private static final String PARAMETER = "(ширина,высота,длина,в сантиметрах)              ";
    private static final String LINE_FREEZER="                Морозильная камера                            полки морозильной  камеры                ";
    private static final String LINE_DOOR_FRIDGE="                Дверь холодильной камеры                   Полки двери холодильной камеры              ";
    private static final String LINE_DOOR_FREEZER="               Дверь морозильной камеры                                                                ";
    private static final String EXTERNAL_DIMENSIONS="                 Общие габариты                  ";



    public FridgeList readFridgeFile() {
        FridgeList fridges = new FridgeList();
        String filePath = "fridges.xml";
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(FridgeList.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (FridgeList) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }

    //    public   void showFridge() {
//        for (Fridge fridge : fridges) {
//            System.out.println(fridge.toString());
//        }
//    }
    public void saveFridge(FridgeList fridges) {
        String filePath = "fridges.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(FridgeList.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(fridges, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void showFridge(Fridge fridge) {
        Shelf shelf=fridge.getDoor().getShelfList().get(0);
        Shelf shelf1=fridge.getFreezer().getShelfList().get(0);
        System.out.println(HEADER);
        System.out.println(LINE);
        System.out.println(MANUFACTURE + fridge.getCompany());
        System.out.println(MODEL + fridge.getModel());
        System.out.println(YEAR + fridge.getYear());
        System.out.println(LINE);
        System.out.println(LINE_FRIDGE);
        System.out.println(LINE_PARAMETER);
        System.out.println("           "+fridge.getWidth()
                +"X"+ fridge.getHeight()+
                "X"+fridge.getLength()+
                "X"+fridge.getVolume()+"                                  "
                );
        System.out.println(LINE);
        System.out.println(LINE_FREEZER);
        System.out.println(LINE_PARAMETER);
        System.out.println( "           "+fridge.getFreezer().getWidth()+
                "X"+fridge.getFreezer().getHeight()+
                "X"+ fridge.getFreezer().getLength()+
                "X"+fridge.getFreezer().getVolume()+"                                        "+
                shelf1.getWidth()+
                        "X"+shelf1.getHeight()+
                        "X"+shelf1.getLength()+
                        "X"+shelf1.getVolume()+
                "        "+fridge.getFreezer().getShelfList().size()
                );
        System.out.println(LINE);
        System.out.println(LINE_DOOR_FRIDGE);
        System.out.println(LINE_PARAMETER);
        System.out.println("          "+fridge.getDoor().getWidth()+
                "X"+fridge.getDoor().getHeight()+
                "X"+fridge.getDoor().getLength()+
                "X"+fridge.getDoor().getVolume()+"                                        "+
                shelf.getWidth()+
                "X"+shelf.getHeight()+
                "X"+shelf.getLength()+
                "X"+shelf.getVolume()+
                "       "+fridge.getDoor().getShelfList().size());
        System.out.println(LINE);
        System.out.println(LINE_DOOR_FREEZER);
        System.out.println(PARAMETER);
        System.out.println("           "+ fridge.getDoor().getWidth()+"X"+fridge.getDoor().getHeight()+"X"+fridge.getDoor().getLength()+"X"+fridge.getDoor().getVolume());
        System.out.println(EXTERNAL_DIMENSIONS);
        System.out.println("           "+fridge.getWidth()+
                "X"+fridge.getHeight()+
                "X"+fridge.getLength()+
                "X"+fridge.getVolume()
        );
        System.out.println(LINE);

    }

}
