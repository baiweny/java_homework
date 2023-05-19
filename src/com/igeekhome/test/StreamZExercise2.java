package com.igeekhome.test;

/**
 * 创建一个ArrayList的集合(泛型为String),使用键盘录入5个元素
 * 使用流完成如下需求:
 * 1 打印集合中的元素个数
 * 2 只打印第2个和第4个元素
 * 3 删除第5个元素
 * 4 修改第3个元素的值 值任意
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamZExercise2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("请输入第" + i + "个数");
            String next = scanner.next();
            list.add(next);
        }
        System.out.println("-------------------------");

        //1,打印集合中的元素个数
        System.out.println("集合中元素的个数是:"+list.stream().count()+"个");

        System.out.println("--------------------------");

        //2，只打印第2个和第4个元素
        list.stream().skip(1).limit(1).forEach(data-> System.out.println("第二个元素是"+data));
        list.stream().skip(3).limit(1).forEach(data-> System.out.println("第四个元素是"+data));

        System.out.println("----------------------------");

        //3 删除第5个元素
        list.stream().limit(4).forEach(System.out::println);

        System.out.println("----------------------------");

        //4 修改第3个元素的值 值任意
        //  想法一：有bug 必须要求第3个元素的值唯一不重复  否则会全部替换
//        System.out.println("请输入您要修改的值：");
//        String modifyStr = scanner.next();
//        List<String> collect = list.stream().skip(2).limit(1).collect(Collectors.toList());
//        for (int i = 0; i < collect.size(); i++) {
//            String s = collect.get(i);
//            list.stream().map(data->data.equals(s)?data.replace(data,modifyStr):data).forEach(System.out::println);
//        }

        //  想法二：分别取出在拼接
        System.out.println("请输入您要修改的值：");
        String modifyStr = scanner.next();
        List<String> list2 = list.stream().skip(2).limit(1).collect(Collectors.toList());
        //进行第二元素的替换
        for (int i = 0; i < list2.size(); i++) {
            //拼接
            Stream<String> temperList = Stream.concat(list.stream().limit(2), list2.stream().map(data -> data.replace(data, modifyStr)));
            Stream.concat(temperList,list.stream().skip(3)).forEach(System.out :: println);
        }


    }
}
