package javalearnn.comsci.java.thanatorn.com.javalearnn.utils;

import java.util.List;

public class Utils {

    public static boolean isNotNull(Object data) {
        return data != null;
    }

    public static boolean isNotNull(List<?> data) {
        return data != null && !data.isEmpty();
    }

}

