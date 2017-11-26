package cn.itcast.Dome;

import java.util.ArrayList;

/*定义一个Teacher类(教师类)，包含满参构造方法和以下成员属性：

成员属性: 姓名（String）

   工龄（int）

   所授学科（String）



a. 定义一个测试类Test，在Test类的main方法中利用满参构造创建三个教师对象

“王宇”，3，java；"张强"，4，python；  "郝伟"，10，php

b. 将这三个对象存入ArrayList<Teacher>集合中

c. 遍历集合输出工龄在5年以下的教师姓名以及所授学科都是什么;*/
public class Test04 {
	public static void main(String[] args) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		Teacher t1 = new Teacher("王宇",3,"java");
		Teacher t2 = new Teacher("张强",4,"python");
		Teacher t3 = new Teacher("郝伟",10,"php");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		for (int i = 0; i <list.size(); i++) {
			if ((list.get(i).getAge()<5)){
				System.out.println(list.get(i).getName()+" 所授的学科是："+list.get(i).getXueke());
		}
	}
}}
