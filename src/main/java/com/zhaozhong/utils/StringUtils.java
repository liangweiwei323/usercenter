package com.zhaozhong.utils;

/**
 * Custom StringUtils to replace Apache Commons Lang3
 *
 */
public class StringUtils {

    /**
     * Check if any of the provided strings are blank (null or empty/whitespace).
     * 
     * @param strings the strings to check
     * @return true if any string is null or empty/whitespace, false otherwise
     */
    public static boolean isAnyBlank(String... strings) {
        if (strings == null) {
            return true;
        }
        for (String str : strings) {
            if (str == null || str.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

