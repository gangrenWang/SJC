package JavaSE.XML;

import java.io.File;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.text.Document;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo_01 {

/**
* @param XML  ����չ�Ա������
	 
*  1. �ĵ�����  
 *  	<?xml version="1.0" encoding="UTF-8"?> 
 *  2. Ԫ��  element  
 *     xml�ļ�������ɵ�λ. 	
 *     <��ʼ��ǩ>Ԫ����</������ǩ> 
 *     Ԫ���� ,�������ı�,Ҳ������Ԫ��. 
 * 
 * 3.�����������
 * 4.Լ��:DTDԼ��  Schema Լ��
 * 5.������DOM���ɶ���д   SAX��ֻ�ܶ�   PULL����
 * dom4j:���ĵ�ת��ΪDocument���󣬸����ĵ��ṹ��ȡ���е�ֵ��
 *     �����ࣺSAXReader
 * @throws DocumentException 
 */
	 
	public static void main(String[] args) throws DocumentException {
		//1.��ȡSAXReader����
		SAXReader sr = new SAXReader();
		//2.����ĳ���ĵ�,��ȡDocument����
		org.dom4j.Document doc  = sr.read(new File("NewFile.xml"));
		//3.��ȡ��Ŀ¼����ȡԪ��
		org.dom4j.Element rootElement = (org.dom4j.Element) doc.getRootElement();
		//4.��ȡԪ��
		translateXml(rootElement);
	}
	public static void translateXml(org.dom4j.Element element){
		//��ӡ��ǩ������
		System.out.println(element.getName());
		//��ӡ��ǩ������
		System.out.println(element.attributes());
		//����˱�ǩ�»���Ԫ�أ�������ݹ���ø÷�����
		ArrayList<org.dom4j.Element>list = (ArrayList<org.dom4j.Element>) element.elements();
		if(!list.isEmpty()){
			for (org.dom4j.Element element2 : list) {
				translateXml(element2);
			}
			
		}
	}

}
