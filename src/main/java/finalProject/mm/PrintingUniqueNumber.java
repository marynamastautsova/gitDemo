package finalProject.mm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PrintingUniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,5,4,6,6,9,4};
		// 4 - 3, 5 - 2, 6 - 2, 9 - 1
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		 for (int i : a) {
	            hs.add(i);
	        }
		
		Iterator<Integer> i = hs.iterator();
		
		while (i.hasNext()) {
			int element = i.next();
			System.out.print(element + " - ");
			int k=0;
			for (int j : a) {
				if (element == j) {k++;}
			}
			System.out.println(k);
		}
		
		PrintingUniqueNumber pn = new PrintingUniqueNumber();
		pn.getUnique();
		
		
	}
	
	public void getUnique() { // TODO Auto-generated method stub
		System.out.println();
		int a[] ={ 4,5,5,5,4,6,6,9,4}; // Print unique number from the list- Amazon  //print the string in reverse 
		ArrayList<Integer>ab =new ArrayList<Integer>(); 
		for(int i=0;i<a.length;i++) { 
			int k=0; 
			if(!ab.contains(a[i])) { 
				ab.add(a[i]); 
				k++; 
				for(int j=i+1;j<a.length;j++) { 
					if(a[i]==a[j]) { k++; } 
					} 
				
				System.out.println(a[i] + " - " + k); 
				
			}
		}

		}

}
