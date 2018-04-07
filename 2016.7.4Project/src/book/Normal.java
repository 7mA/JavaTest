package book;

public interface Normal {
	public void query();//查询图书
	public Book buy(int bookId,int num);//买书
	public EX buyEx(int exCode);//买赠品
	public void chekout(Book book);//结账
}
