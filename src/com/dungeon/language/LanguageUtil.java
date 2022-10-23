package com.dungeon.language;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Locale;
import java.util.Properties;

public class LanguageUtil {
    private static LanguageUtil instance;
    private static final Locale enLocale = new Locale("en", "US");
    private static final Locale ruLocale = new Locale("ru", "UA");
    private static final Locale uaLocale = new Locale("ua", "UA");
    private static String BUNDLE_NAME = "ApplicationMessages";
    private Properties properties;

    private LanguageUtil() {
    }

    public static LanguageUtil getInstance() {
        if (instance == null) {
            instance = new LanguageUtil();
        }
        return instance;
    }

    public void readFridgeFile(String file) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(MessageList.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            MessageList unmarshal = (MessageList) un.unmarshal(new File(file));
            properties = new Properties();
            for (Message message : unmarshal.getMessages()) {
                properties.put(message.getName(), message.getValue());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static String getMessage(String messageName) {
        return (String) instance.properties.get(messageName);
    }

    public void switchToRussian() {
        readFridgeFile("resources/Messages_ru.xml");

    }

    public void switchToUkrainian() {

        readFridgeFile("resources/Messages_ua.xml");
    }

    public void switchToEnglish() {

        readFridgeFile("resources/Messages_en.xml");
    }
}
