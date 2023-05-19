package com.igeekhome.test;

import com.igeekhome.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * 需求
 *
 *   1.新建一个人类 里面有三个属性 name，sex，age
 *   2，新建多个对象 属性自己赋值
 *   3，计算所有人的年龄总和 计算出对象中的最大年龄，按性别计算年龄的平均值
 */
public class StreamZExercise1 {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        Person person1 = new Person("jack", "男", 20);
        Person person2 = new Person("rose", "女", 14);
        Person person3 = new Person("小黑", "男", 30);
        Person person4 = new Person("小白", "女", 27);

        Collections.addAll(list,person1,person2,person3,person4);

        Optional<Integer> reduce = list.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("所有人的年龄总和为："+reduce.get());

        Optional<Integer> max = list.stream().map(Person::getAge).max(((o1, o2) -> o1 - o2));
        System.out.println("对象中的最大年龄为："+max.get());

        OptionalDouble averageMan = list.stream().filter(data -> data.getSex().equals("男")).mapToInt(Person::getAge).average();
        System.out.println("男士的年龄平均值是："+averageMan.getAsDouble());

        double averageWoman = list.stream().filter(data -> data.getSex().equals("女")).mapToDouble(Person::getAge).average().getAsDouble();
        System.out.println("女士的年龄平均值是："+averageWoman);
    }
}
