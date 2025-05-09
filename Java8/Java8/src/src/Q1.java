package src;

interface InterFace {
	double add(int a, int b);
}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			InterFace intf = (a,b) -> a+b;
			System.out.println(intf.add(10,20));
			
	}

}
