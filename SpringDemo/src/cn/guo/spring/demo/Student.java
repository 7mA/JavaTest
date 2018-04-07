package cn.guo.spring.demo;

public class Student implements Person{
	private TeachingService teachingService;
	private String name;
	private String country;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Student: set method: SetName: " + name);
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		System.out.println("Student: set method: SetCountry: " + country);
		this.country = country;
	}

	public Student(){
		System.out.println("Student Default construct is called ...");
	}
	
	public void initMethod(){
		System.out.println("User customized init-method is called.");
	}
	
	public void destroyMethod(){
		System.out.println("User customized destroy-method is called.");
	}

	public void setTeachingService(TeachingService Service) {
		System.out.println("Student: set method: SetTeachingService");
		this.teachingService = Service;
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello, I am a student.";
	}
}
