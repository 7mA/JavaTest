package listDemo;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Dog dog1=new Dog("Ooh","Shilnery");
		Dog dog2=new Dog("Arye","Harsikey");
		Dog dog3=new Dog("Mimi","Labourador");
		Dog dog4=new Dog("Fiffy","Harsikey");
		
		List dogs=new ArrayList();
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		dogs.add(dog4);
		
		LinkedList dogs=new LinkedList();
		dogs.add(dog2);
		dogs.add(dog3);
		dogs.addFirst(dog1);
		dogs.addLast(dog4);
		
		Dog d1=(Dog)dogs.getFirst();
		d1.print();
		Dog d2=(Dog)dogs.getLast();
		d2.print();
		
		System.out.println("Total:"+dogs.size());
		dogs.remove(dog2);
		
		System.out.println("Information:");
		for(int i=0;i<dogs.size();i++){
			Dog dog=(Dog)dogs.get(i);
			dog.print();
			System.out.print("\n");
		}
		
		if(dogs.contains(dog4)){
			dog4.print();
		}
		
		Map countries=new HashMap();
		countries.put("CHN", "People Republic of China");
		countries.put("RUS", "Russian Federation");
		countries.put("FRA", "The French Republic");
		countries.put("USA", "United States of America");
		
		String country=(String)countries.get("FRA");
		System.out.println("FRA:"+country);
		System.out.println("Total:"+countries.size());
		
		countries.containsKey("USA");
		countries.containsValue("United States of America");
		
		System.out.println(countries.keySet());
		System.out.println(countries.values());
		System.out.println(countries);
		
		countries.clear();
		countries.isEmpty();
		
		Dog dog1=new Dog("Ooh","Shilnery");
		Dog dog2=new Dog("Arye","Harsikey");
		Dog dog3=new Dog("Mimi","Labourador");
		Dog dog4=new Dog("Fiffy","Harsikey");
		
		Penguin p1=new Penguin("abc","Female");
		Penguin p2=new Penguin("def","Male");
		
		Map dogs=new HashMap();
		dogs.put("Ooh",dog1);
		dogs.put("Arye",dog2);
		dogs.put("Mimi",dog3);
		dogs.put("Fiffy",dog4);
		dogs.put("abc",p1);
		dogs.put("def",p2);
		
		if(dogs.containsKey("Arye")){
			/*Dog d=(Dog)dogs.get("Arye");
			d.print();
		}
		
		Set keys=dogs.keySet();
		Iterator it=keys.iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			Dog d=(Dog)dogs.get(key);
			d.print();
		}
		
		for(Object key:keys){
			Dog d=(Dog)dogs.get(key);
			d.print();
		}*/
		
		Penguin p1=new Penguin(1,"abc","Female");
		Penguin p2=new Penguin(2,"def","Male");
		
		Map<Integer,Penguin> pgn=new HashMap();
		pgn.put(p1.getId(),p1);
		pgn.put(p2.getId(),p2);
		
		Set<Integer> keys=pgn.keySet();
		Iterator<Integer> it=keys.iterator();
		while(it.hasNext()){
			int i=it.next();
			Penguin p=pgn.get(i);
			System.out.println("Id:"+p.getId()+" Name:"+p.getName()+" sex:"+p.getSex());
		}
		
		System.out.print("\n");
		for(int i:pgn.keySet()){
			Penguin p=pgn.get(i);
			System.out.println("Id:"+p.getId()+" Name:"+p.getName()+" sex:"+p.getSex());
		}
		
	}

}
