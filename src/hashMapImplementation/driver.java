package hashMapImplementation;


public class driver {
	public static void main(String[] args) {
		//testing the HashMap
		myHashMap<String, Integer> map = new myHashMap<String,Integer>();

		map.put("XYZ", 4);
		map.put("ABC", 4);
		map.put("QWERTY", 5);
		map.printMap();
		System.out.println(map.get("XYZ"));
		map.put("XYZ", 10);
		System.out.println(map.get("XYZ"));
		map.printMap();
		map.put("ghj", 99);
		map.put("abc", 99);
		map.put("qwerty", 35);
		System.out.println(map.get("qwerty"));
		map.printMap();
		map.remove("ABC");
		map.printMap();
		
		
		
	}
}
