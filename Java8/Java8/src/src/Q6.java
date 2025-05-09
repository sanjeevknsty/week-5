package src;
import java.util.function.Function;

public class Q6 {

	public static void main(String[] args) {
		
		int radius = 3;
		Function<Integer, Double> area = r -> Math.PI * (radius*radius) ;
		Double ans =area.apply(radius);
		System.out.println(ans);
		
	}

}
