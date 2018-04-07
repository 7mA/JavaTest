package cn.guo.hf.demo;

public class HumanFactory {
	/*public Human createHuman(String gender){
		if(gender.equals("male")){
			return new Male();
		}else if(gender.equals("female")){
			return new Female();
		}else{
			System.out.println("Wrong input!");
			return null;
		}
	}*/
	
	public static Male createMale(){
		return new Male();
	}
	
	public static Female createFemale(){
		return new Female();
	}
}
