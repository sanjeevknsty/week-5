package src;

import java.util.List;
import java.util.Optional;


public class Q9 {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(23,2,21,524,65);
		
		Optional<Integer> maxNum = list.stream().max(Integer:: compare);
				
		maxNum.ifPresentOrElse(i -> System.out.println(i), ()->System.out.println(-1));
	}

}
