package book;

public class DefaultCustomer implements Normal{
	/**
	 * 重写查询图书
	 */
	public void query() {
		BookBiz bookBiz=new BookBiz();
		bookBiz.query();
	}

	/**
	 * 重写买赠品 
	 */
	public EX buyEx(int exCode) {
		BookBiz bookBiz=new BookBiz();
		return bookBiz.buyEx(exCode);
	}
	/**
	 * 重写购买图书
	 */
	public Book buy(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		return bookBiz.buyBook(bookId,num);
	}

	/**
	 * 重写结账
	 */
	public void chekout(Book book) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.checkout(book);	
	}
}
