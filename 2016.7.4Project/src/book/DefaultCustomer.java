package book;

public class DefaultCustomer implements Normal{
	/**
	 * ��д��ѯͼ��
	 */
	public void query() {
		BookBiz bookBiz=new BookBiz();
		bookBiz.query();
	}

	/**
	 * ��д����Ʒ 
	 */
	public EX buyEx(int exCode) {
		BookBiz bookBiz=new BookBiz();
		return bookBiz.buyEx(exCode);
	}
	/**
	 * ��д����ͼ��
	 */
	public Book buy(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		return bookBiz.buyBook(bookId,num);
	}

	/**
	 * ��д����
	 */
	public void chekout(Book book) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.checkout(book);	
	}
}
