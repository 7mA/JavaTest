package listDemo;

/**
 * 企鹅类，宠物的子类。
 * @author 
 */
public class Penguin  {
	int id;//编号
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	String name = "";// 昵称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String sex;// 性别
	/**
	 * 有参构造方法。
	 * @param name 昵称
	 * @param sex 性别
	 */
	
	public Penguin(int id,String name, String sex) {
		this.id=id;
		this.name=name;		
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}	
}