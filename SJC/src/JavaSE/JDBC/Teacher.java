package JavaSE.JDBC;

import java.lang.reflect.Field;

public class Teacher {
/*
	public static final String tid = "id";
	public static final String tname = "sname";
	public static final String tsex = "tsex";
	public static final String tage = "tage";
	public static final String tphonenum = "phoneNumber";
	*/
	public String tid;
	public String tname;
	public String tsex;
	public String tage;
	public String tphonenu;

	


	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}


	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}


	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}


	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}


	/**
	 * @return the tsex
	 */
	public String getTsex() {
		return tsex;
	}


	/**
	 * @param tsex the tsex to set
	 */
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}


	/**
	 * @return the tage
	 */
	public String getTage() {
		return tage;
	}


	/**
	 * @param tage the tage to set
	 */
	public void setTage(String tage) {
		this.tage = tage;
	}


	/**
	 * @return the tphonenu
	 */
	public String getTphonenu() {
		return tphonenu;
	}


	/**
	 * @param tphonenu the tphonenu to set
	 */
	public void setTphonenu(String tphonenu) {
		this.tphonenu = tphonenu;
	}

//使用 DBUtils 时 要有 无参构造函数。
	public Teacher(){
		super();
	}


	public Teacher(String tid, String tname, String tsex, String tage,
			String tphonenu) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tphonenu = tphonenu;
	}
	

	static public String[] fileds(){
		
		Field[]stuFiledArr =  Teacher.class.getFields();
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
