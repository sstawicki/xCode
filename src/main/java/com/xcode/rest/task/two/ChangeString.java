package com.xcode.rest.task.two;

import java.util.regex.Pattern;

public class ChangeString {
    private static final String INIT_PATTERN = "\\d+";
    private static final Pattern pattern = Pattern.compile(INIT_PATTERN);

    public static int[] changeString(String numbers) {
        String data[] = numbers.split(",");
        int result[] = new int[data.length];
        for (int i = 0; i < data.length; i++){
            if(pattern.matcher(data[i]).matches())
            result[i]=Integer.parseInt(data[i]);
            else return null;
        }
        return result;
    }
}
