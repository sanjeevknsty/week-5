package src;

import java.util.function.BiFunction;

public class Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "new";
		String str2 = "age";
		BiFunction<String, String, String> attached = (i,j)-> i.concat(" " +j);
		String ans = attached.apply(str1, str2);
		System.out.println(ans);
	}

}
