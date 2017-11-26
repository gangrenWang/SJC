package cn.itcast.Dome;

public class Teacher {
	private String name;
	private int age;
	private String xueke;
	public Teacher() {
	
	}
	public Teacher(String name, int age, String xueke) {
		super();
		this.name = name;
		this.age = age;
		this.xueke = xueke;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
}
