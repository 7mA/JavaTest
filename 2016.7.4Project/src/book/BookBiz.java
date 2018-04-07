package book;

public class BookBiz {
public static Book[] books = new Book[30];// 图书书架
	
	/**
	 * 初始化书的信息
	 */
	public static void makeData() {
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book();

		book1.setId(10001);
		book1.setName("鬼吹灯");
		book1.setAuthor("天下霸唱");
		book1.setPub_date("2008-7-1");
		book1.setPrice(27.80);
		book1.setStore(87);

		book2.setId(10002);
		book2.setName("魔戒1");
		book2.setAuthor("莫尔斯");
		book2.setPub_date("2005-3-14");
		book2.setPrice(54.00);
		book2.setStore(13);

		book3.setId(10003);
		book3.setName("哈利波特1");
		book3.setAuthor("罗琳");
		book3.setPub_date("2003-2-14");
		book3.setPrice(43.50);
		book3.setStore(99);

		book4.setId(10004);
		book4.setName("时间机器");
		book4.setAuthor("威尔");
		book4.setPub_date("1965-3-3");
		book4.setPrice(21.30);
		book4.setStore(75);

		book5.setId(10005);
		book5.setName("宇宙奥秘");
		book5.setAuthor("霍金");
		book5.setPub_date("2003-12-23");
		book5.setPrice(87.30);
		book5.setStore(14);

		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		books[3] = book4;
		books[4] = book5;
	}
	
	/**
	 * 图书入库
	 */
	public void inBook(int bookId, int num) {
		Book book=findBookById(bookId);
		if(book==null){
			System.out.println("没有此ID的图书，请选择新增图书！");
			return;
		}else{
			for (int i = 0; i < books.length; i++) {// 遍历书架
				if (bookId == books[i].getId()) {// 如果库中已有要入库的图书
					books[i].setStore(books[i].getStore() + num);// 修改图书数量
					break;
				}
			}
		}
	}
	
	/**
	 * 图书出库
	 */
	public void outBook(int bookId,int num) {
		Book book=findBookById(bookId);
		if(book==null){
			System.out.println("此书不存在，请确认！");
			return;
		}else{
			for (int i = 0; i < books.length; i++) {// 遍历书架
				if (bookId == books[i].getId()) {//如果找到欲出库图书
					if(books[i].getStore()<num){//判断库存量
						System.out.println("库存不足，请确认！");
						return;
					}else{
						books[i].setStore(books[i].getStore() - num);//出库（减少库存数量）
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 新增图书
	 */
	public void saveBook(Book book){
		for (int i = 0; i < books.length; i++) {// 遍历书架
			if (books[i] == null) {//找到书架的空位置
				int newId=books[i-1].getId()+1;//给新书编号
				book.setId(newId);
				books[i]=book;//存储新书
				break;
			} 
		}
	}
	
	/**
	 * 查询图书
	 */
	public void query() {
		System.out.println("书号\t\t书名\t\t作者\t\t发布日期\t\t价格\t库存");
		for (int i = 0; i < books.length; i++) {//遍历书架
			Book temp = books[i];
			if (temp == null)//判断书架是否有书
				break;
			else {//显示图书信息
				int id = temp.getId();
				String name = temp.getName();
				String author = temp.getAuthor();
				String pub_date = temp.getPub_date();
				double price = temp.getPrice();
				int store = temp.getStore();
				System.out.println(id + "\t\t" + name + "\t\t" + author
						+ "\t\t" + pub_date + "\t" + price + "\t" + store);
			}
		}
	}
	
	/**
	 * 购买图书
	 * @return
	 */
	public Book buyBook(int bookId,int num){
		Book book=findBookById(bookId);//查找到图书
		if(book==null){//如果没有此书，返回null
			System.out.println("此书不存在，请确认！");
			return null;
		}else{
			for (int i = 0; i < books.length; i++) {// 遍历书架
				if (bookId == books[i].getId()) {//如果找到欲出库图书
					if(books[i].getStore()<num){//判断库存量
						System.out.println("库存不足，请确认！");
						return null;
					}else{
						books[i].setNum(num);//设置购买数量
						return books[i];
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 购买附赠品
	 * @return 附赠品
	 */
	public EX buyEx(int exCode) {
		return ExFactory.create(exCode);//调用工厂里的方法得到附赠品
	}
	
	/**
	 * 结账
	 */
	public void checkout(Book book){
		book.setStore(book.getStore() - book.getNum());//减少库存数量
		double price = book.cost();// 计算价格
		System.out.println("总价格为：" + price+"\n");	
	}
	
	/**
	 * 查询图书是否存在
	 * @param id
	 * @return
	 */
	public Book findBookById(int id) {
		for (int i = 0; i < books.length; i++) {//遍历书架
			if (books[i] == null){//如果书架为空，结束查找	
				return null;
			}
			if (id == books[i].getId()) {//找到图书则返回
				return books[i];
			}
		}
		return null;
	}
}
