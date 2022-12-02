package com.doontcare.adventplus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static int getYear() {
        return Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));
    }

}
