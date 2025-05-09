package src;
import java.util.function.*;

@FunctionalInterface
interface customFunc{
	int customMeth(int num);
	
}

public class Q8 {
	public static void main(String[] args) {
		
		int num = 10;
		customFunc square = i -> i*i;
		int ans = square.customMeth(num);
		
		System.out.println(ans);
	}
}
