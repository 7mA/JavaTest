package book;

public class Book {
	private int id;	//���
	private String name;//����
	private String author;//����
	private String pub_date;//����ʱ��
	private int store;//�������
	private double price;//�۸�
	private int num = 1;//�������� 
	private EX ex;//����Ʒ
		
	/**
	 * �����Ǯ
	 * @return
	 */
	public double cost() {
		System.out.println(this.getName() + ":" + this.getPrice()+"\n����:"+this.num);
		System.out.println("С�ǣ�"+this.getPrice()*this.num);
		System.out.println("--------------");
		if(ex==null)//�ж��Ƿ����˸���Ʒ
			return price;//������ļ۸�
		else
			return price * num+ex.cost();//������ļ۸�+����Ʒ�۸�
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pubDate) {
		pub_date = pubDate;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public EX getEx() {
		return ex;
	}
	public void setEx(EX ex) {
		this.ex = ex;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
}
