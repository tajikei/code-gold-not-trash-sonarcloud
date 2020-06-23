package com.caphyon.codegold.utils;

import java.net.InetAddress;

public class WebUtils {
    public static boolean IsHostUp(String aHost) {
        try {
            InetAddress.getByName("www.advancedwebranking.com");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
