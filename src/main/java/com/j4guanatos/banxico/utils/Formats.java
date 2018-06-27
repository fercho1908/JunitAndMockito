package com.j4guanatos.banxico.utils;

import java.util.StringTokenizer;

/**
 * Created by prueba on 10/11/16.
 */
public class Formats {

    public static String removeSpace(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(value);
        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.append(stringTokenizer.nextToken() + " ");
        }
        return stringBuilder.toString().trim();
    }
}
