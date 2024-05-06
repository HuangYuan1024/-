package org.CurriculumDesign.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

    public static boolean Regex(String regex, String userInput) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建匹配器
        Matcher matcher = pattern.matcher(userInput);

        // 进行匹配
        return matcher.matches();
    }

    public static boolean Find(String regex, String userInput) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建匹配器
        Matcher matcher = pattern.matcher(userInput);

        // 进行匹配
        return matcher.find();
    }

}
