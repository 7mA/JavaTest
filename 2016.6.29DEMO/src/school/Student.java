package school;

public class Student {
	private String name;
	private int age;
	private String classNo;
	private String hobby;
	private static double score=90;
	private static int count=0;
	
	public Student(String name,int age,String classNo,String hobby){
		this.name=name;
		this.age=age;
		this.classNo=classNo;
		this.hobby=hobby;
		count++;
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
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {

		this.hobby = hobby;
	}
	
	public void show(){
		System.out.print("name:"+name+" age:"+age+" classNo:"+classNo+" hobby:"+hobby+"\n");
	}
	public static void showScr(){
		System.out.println("score:"+score);
	}
	public static void showCnt(){
		System.out.println("count:"+count);
	}
}
