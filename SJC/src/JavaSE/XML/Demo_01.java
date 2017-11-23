package JavaSE.XML;

import java.io.File;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.text.Document;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo_01 {

/**
* @param XML  可扩展性标记语言
	 
*  1. 文档声明  
 *  	<?xml version="1.0" encoding="UTF-8"?> 
 *  2. 元素  element  
 *     xml文件基本组成单位. 	
 *     <开始标签>元素体</结束标签> 
 *     元素体 ,可以是文本,也可以是元素. 
 * 
 * 3.基本定义操作
 * 4.约束:DTD约束  Schema 约束
 * 5.解析：DOM：可读可写   SAX：只能读   PULL：拉
 * dom4j:将文档转换为Document对象，根据文档结构获取其中的值。
 *     核心类：SAXReader
 * @throws DocumentException 
 */
	 
	public static void main(String[] args) throws DocumentException {
		//1.获取SAXReader对象
		SAXReader sr = new SAXReader();
		//2.关联某个文档,获取Document对象
		org.dom4j.Document doc  = sr.read(new File("NewFile.xml"));
		//3.获取根目录，获取元素
		org.dom4j.Element rootElement = (org.dom4j.Element) doc.getRootElement();
		//4.获取元素
		translateXml(rootElement);
	}
	public static void translateXml(org.dom4j.Element element){
		//打印标签的名字
		System.out.println(element.getName());
		//打印标签的属性
		System.out.println(element.attributes());
		//如果此标签下还有元素，则继续递归调用该方法。
		ArrayList<org.dom4j.Element>list = (ArrayList<org.dom4j.Element>) element.elements();
		if(!list.isEmpty()){
			for (org.dom4j.Element element2 : list) {
				translateXml(element2);
			}
			
		}
	}

}
