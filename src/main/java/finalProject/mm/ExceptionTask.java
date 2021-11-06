package finalProject.mm;

public class ExceptionTask {
	int a = 4;
	 int b =7; 
	 int c = 1; //should 0
	
	public int getData() {
		int k = 0;
	try {
		k= b/c;
		}
		catch (Exception e){
			System.out.println("Exception");
		}
	finally {
		System.out.println("Delete cocies, close browser");
	}
	return k;
	}
	public void main(String[] args) {
		getData();
	}
}
