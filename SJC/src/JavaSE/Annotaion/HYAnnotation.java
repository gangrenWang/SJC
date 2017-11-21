package JavaSE.Annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Ԫע��
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.METHOD , ElementType.CONSTRUCTOR , ElementType.FIELD})
public @interface HYAnnotation {
/*
 * 1.���Զ������������ 1.�ַ���    2.ö��  3.ע��   4.������������   5.Class  6.һά����
 * 2.���������Զ���
 * 3.Ĭ��ֵ�����п���
 * 4.ע�����û�����ԣ�������Ϊvalue��ֻ��һ�������Բ�д��
 */
	
	public String username() default "sunny";
	public int age() default 12;
	public String[]arr();
}
