package com.dungeon.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageUtil {
    private static LanguageUtil instance;
    private static final Locale enLocale = new Locale("en", "US");
    private static final Locale ruLocale = new Locale("ru", "UA");
    private static final Locale uaLocale = new Locale("ua", "UA");
    private static String BUNDLE_NAME = "ApplicationMessages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    private LanguageUtil() {
    }

    public static LanguageUtil getInstance() {
        if (instance == null) {
            instance = new LanguageUtil();
        }
        return instance;
    }

    public static String getMessage(String messageName) {
        return instance.resourceBundle.getString(messageName);
    }

    public void switchToRussian() {
        locale = ruLocale;
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public void switchToUkrainian() {
        locale = uaLocale;
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public void switchToEnglish() {
        locale = enLocale;
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }
}
