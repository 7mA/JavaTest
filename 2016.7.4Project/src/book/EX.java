package book;

public abstract class EX {
	private double price;//�۸�
	private String ex_name;//����Ʒ��

	/**
	 * ����Ʒ�۸����
	 * @return
	 */
	public double cost() {
		System.out.print("����Ʒ��");
		System.out.println(ex_name + ":" + price);
		System.out.println("--------------");
		return price;
	}

	public String getEx_name() {
		return ex_name;
	}

	public void setEx_name(String exName) {
		ex_name = exName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
