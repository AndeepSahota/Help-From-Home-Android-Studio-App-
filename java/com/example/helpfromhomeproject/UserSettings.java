package com.example.helpfromhomeproject;

import android.app.Application;

public class UserSettings extends Application {
    public static final String PREFERENCES = "preferences";
    public static final String CUSTOM_THEME = "customTheme";
    public static final String LIGHT_MODE = "lightTheme";
    public static final String DARK_MODE = "darkTheme";

    public String getCustomTheme() {
        return CustomTheme;
    }

    public void setCustomTheme(String customTheme) {
        CustomTheme = customTheme;
    }

    private String CustomTheme;


}
