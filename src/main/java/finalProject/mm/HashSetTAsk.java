package finalProject.mm;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTAsk {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("maryna");
		hs.add("java");
		hs.add("testing");
		hs.add("java");
		System.out.println(hs);
		hs.size();
		hs.remove("java");
		hs.isEmpty();
		Iterator<String> i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

}
