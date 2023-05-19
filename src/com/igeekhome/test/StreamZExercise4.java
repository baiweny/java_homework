package com.igeekhome.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建一个List集合 添加10条数据 用流将对应位置的数据进行交换并输出
 * 比如第1个和第10个进行交换 第2个和第9个进行交换 ....
 */
public class StreamZExercise4 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d","e","f","g","h","i","j");

        list1.add(list.stream().reduce((num1, num2) -> num1+ " " + num2).get());

        List<StringBuffer> reserveList = list1.stream().map(StringBuffer::new).map(StringBuffer::reverse).collect(Collectors.toList());

        for (int i = 0; i < reserveList.size(); i++) {
            String  str = String.valueOf(reserveList.get(i));
            String[] newStr = str.split(" ");
            for (String s : newStr) {
                System.out.println(s);
            }
        }

    }
}
