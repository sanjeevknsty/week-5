package src;

import java.util.List;

import java.util.function.Consumer;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = List.of("ivala","mahindra","predator","fullhd");
			
		Consumer<String> arr1 = i -> System.out.println("Upper " + i.toUpperCase());
		arr.forEach(arr1);
		
		
	}

}
