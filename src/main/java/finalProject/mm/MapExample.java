package finalProject.mm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0,"hello");
		hm.put(1,"bye");
		hm.put(2,"morning");
		hm.put(3,"everning");
		
		System.out.println(hm.get(0));
		hm.remove(0);
		System.out.println(hm.get(0));
		Set sn = hm.entrySet();
		
		Iterator it = sn.iterator();
		while(it.hasNext()) {
			Map.Entry mp = (Map.Entry) it.next(); 
			
		System.out.println(mp);
		}
	}

}
