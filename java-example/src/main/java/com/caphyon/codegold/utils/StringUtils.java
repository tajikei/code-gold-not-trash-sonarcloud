package com.caphyon.codegold.utils;

public class StringUtils {
//    Tells if aString starts with aSubstring

    public static boolean StartsWith(String aString, String aSubstring) {
    if (aSubstring.length() > aString.length())
    {
        return false;
    }

return aString.regionMatches(true, 0, aSubstring, 0, aSubstring.length());
}

    public static String Substring(String aValue, int aBeginIndex)

    {
        return aValue.substring(aBeginIndex);
    }

    public static String Substring(String aValue, int aBeginIndex, int aEndIndex)
    {
        if(aEndIndex > 0) {
            return aValue.substring(aBeginIndex);
        } else {
            return aValue.substring(aBeginIndex, aEndIndex);
        }
    }

}
