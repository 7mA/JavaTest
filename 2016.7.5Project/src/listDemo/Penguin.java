package listDemo;

/**
 * ����࣬��������ࡣ
 * @author 
 */
public class Penguin  {
	int id;//���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	String name = "";// �ǳ�
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String sex;// �Ա�
	/**
	 * �вι��췽����
	 * @param name �ǳ�
	 * @param sex �Ա�
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