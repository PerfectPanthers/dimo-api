package com.thoughtworks.dimoapi.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class PropertyUtils {

//    protected static Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static String getProperty(String key) {
//        return dotenv.get(key);
        return "perfectPanthers";
    }
}
