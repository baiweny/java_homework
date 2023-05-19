package com.igeekhome.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * 键盘录入一个字符串 用流去除掉其中重复的字符 然后打印出不同的字符
 * 要求保证顺序 比如aaabbccdddd-> abcd
 */
public class StreamZExercise3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一串字符");
        String str = scanner.next();

        ArrayList<String> list = new ArrayList<>();

        //将字符中的元素添加到集合中
        for (int i = 0; i < str.length(); i++){
            list.add(str.substring(i,i+1));
        }

        list.stream().distinct().forEach(System.out ::print);


    }
}
