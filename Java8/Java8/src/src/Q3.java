package src;

import java.util.*;
import java.util.stream.Collectors;

public class Q3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> arr = List.of(2,3,2,2,2,2);
		System.out.println(arr);
		
		
		int sum = arr.stream().map(i ->  i*i ).filter(i -> i % 2 == 0).reduce(0,(add,i)-> add+i );
		
		
		System.out.println(sum);
		
		
	}

}
