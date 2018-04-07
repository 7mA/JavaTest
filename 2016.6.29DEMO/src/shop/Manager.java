package shop;

public class Manager {
	String username="Guo";
	String password="961212";
	public void show(){
		System.out.println("username:"+username+" password:"+password);
	}
	public boolean test(String s1,String s2){
		if(s1.equals(username) && s2.equals(password)){
			return true;
		}else{
			return false;
		}
	}
}
