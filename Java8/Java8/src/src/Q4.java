package src;

import java.util.List;
import java.util.stream.Collectors;

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> arr = List.of("sanjeev","peadator","turbou","mouse");
		
		List<String> arr1 = arr.stream().filter(i -> i.length() >= 5).filter(i -> i.contains("u")).collect(Collectors.toList());
		System.out.println(arr1);
	}

}
