package cn.itcast.Dome;

import java.util.ArrayList;

/*����һ��Teacher��(��ʦ��)���������ι��췽�������³�Ա���ԣ�

��Ա����: ������String��

   ���䣨int��

   ����ѧ�ƣ�String��



a. ����һ��������Test����Test���main�������������ι��촴��������ʦ����

�������3��java��"��ǿ"��4��python��  "��ΰ"��10��php

b. ���������������ArrayList<Teacher>������

c. �����������������5�����µĽ�ʦ�����Լ�����ѧ�ƶ���ʲô;*/
public class Test04 {
	public static void main(String[] args) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		Teacher t1 = new Teacher("����",3,"java");
		Teacher t2 = new Teacher("��ǿ",4,"python");
		Teacher t3 = new Teacher("��ΰ",10,"php");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		for (int i = 0; i <list.size(); i++) {
			if ((list.get(i).getAge()<5)){
				System.out.println(list.get(i).getName()+" ���ڵ�ѧ���ǣ�"+list.get(i).getXueke());
		}
	}
}}
