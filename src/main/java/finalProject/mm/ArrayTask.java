package finalProject.mm;

public class ArrayTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i[][] = { { 2, 4, 5 }, { 3, 9, 7 }, { 1, 0, 9 } };
		int min = i[0][0];

		int columnNumber = 0;

		for (int j = 1; j < i.length; j++) {
			for (int k = 0; k < 3; k++) {
				if (min > i[j][k]) {
					min = i[j][k];
					columnNumber = k;

				}
				;
			}
		}
		
		int max = i[0][columnNumber];
		for (int j = 1; j < 3; j++) {
			if (max < i[j][columnNumber]) {
				max = i[j][columnNumber];
			}
		}
		
		System.out.println(max);
	}

}
