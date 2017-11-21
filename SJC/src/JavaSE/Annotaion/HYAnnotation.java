package JavaSE.Annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 元注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.METHOD , ElementType.CONSTRUCTOR , ElementType.FIELD})
public @interface HYAnnotation {
/*
 * 1.可以定义的数据类型 1.字符串    2.枚举  3.注解   4.基本数据类型   5.Class  6.一维数组
 * 2.属性名：自定义
 * 3.默认值：可有可无
 * 4.注解可以没有属性，属性名为value且只有一个，可以不写。
 */
	
	public String username() default "sunny";
	public int age() default 12;
	public String[]arr();
}
