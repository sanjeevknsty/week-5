package src2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
	int id;
	int quantity;
	int price;
	public Product(int id, int price,int quantity){
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " price " + price + " quantity " + quantity ;
	}
	
	
	
}

class ProductManager{
	List<Product> arr = new ArrayList<Product>();
	HashMap<Integer,Integer> hash= new HashMap<>();
	
	
	public void add(Product p) {
		arr.add(p);
		hash.put(p.id,p.getQuantity()*p.getPrice());
	}
	
	public void filterProduct() {
		List <Product> res = arr.stream().filter(i -> i.getQuantity() >= 10).collect(Collectors.toList());
		
		res.forEach(System.out :: println);
	}
	
	public void transform() {
		System.out.println(hash);
	}
	
	public void sortByRevenue() {
		List<Product> res = arr.stream().sorted(Comparator.comparing(i -> hash.get(i.getId()))).collect(Collectors.toList()).reversed();
		res.forEach(System.out :: println);
	}
	
}



public class Q2 {

	public static void main(String[] args) {
		
		ProductManager pr = new ProductManager();
		pr.add(new Product(101,999,12));
		pr.add(new Product(102,4999,3));
		pr.add(new Product(103,599,9));
		pr.add(new Product(104,9299,32));
		pr.add(new Product(105,1999,10));
		
		
		pr.transform();
		pr.filterProduct();
		System.out.println("----->Sorted<----------");
		pr.sortByRevenue();
		
	}

}
