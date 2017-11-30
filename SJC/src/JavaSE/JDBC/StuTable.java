package JavaSE.JDBC;

import java.lang.reflect.Field;

public class StuTable {

	public static final String id = "id";
	public static final String sname = "sname";
	public static final String sage = "sage";
	public static final String phoneNumber = "phoneNumber";
	public static final String qqNumber = "qqNumber";
	public static final String registClass = "registClass";
	public static final String money = "money";
	public static final String major = "major";
	public static final String gradSchool = "gradSchool";
	public static final String score = "score";
	public static final String admission = "admission";
	public static final String remarks = "remarks";
	public static final String examtime = "examtime";
	public static final String gradYear = "gradYear";
	public static final String examMode = "examMode";
	public static final String examTeacher = "examTeacher";

	static public String[] fileds(){
		
		Field[]stuFiledArr =  StuTable.class.getFields();
		String filedNames = "";
		String wenHaos = "";
		for(int i =1;i<stuFiledArr.length;i++){
			filedNames= filedNames+stuFiledArr[i].getName();
			wenHaos+="?";
			if(i<stuFiledArr.length-1){
				filedNames+=",";
				wenHaos+=",";
				} 
		}
		String[] returnArr = {filedNames,wenHaos};
		return returnArr;
		}
	

}
