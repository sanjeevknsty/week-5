package src2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Book{
	String title;
	String author;
	String genre;
	double rating;
	public Book(String title,String author,String genre,double rating) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getgenre() {
		return genre;
	}
	public double getRating() {
		return rating;
	}
	
	@Override
	public String toString() {
		return "Title " + title + " Author " + author + " Genre " + genre + " Rating " + rating;
	}
}


class BookManager{
	
	List<Book> arr = new ArrayList<>();
	HashMap<String,Double> hash = new HashMap<>();
	
	public void add(Book b) {
		arr.add(b);
		hash.put(b.getTitle(), b.getRating());
	}
	
	public void filter() {
		List<Book> res = arr.stream().filter(i -> i.genre.equalsIgnoreCase("science") && i.getRating() > 4).collect(Collectors.toList());
		res.forEach(System.out :: println);
		
	}
	
	public void transform() {
		System.out.println(hash);
	}
	
	public void sortByRating() {
		arr = arr.stream().sorted(Comparator.comparing(Book :: getRating)).collect(Collectors.toList()).reversed();
		arr.forEach(System.out :: println);
	}
	
	public List<List<Book>> paginate() {
		int page =5;
		List<List<Book>> pages = new ArrayList<>();
		for(int i =0 ; i< arr.size() ; i+=5) {
			System.out.println(i);
			pages.add(arr.subList(i, Math.min(i+5, arr.size())));
		}
		return pages;
		
	}
	
}

public class Q3 {

	public static void main(String[] args) {
	
		BookManager b = new BookManager();
		b.add(new Book("Avengers", "Chris","Science",4.5));
		b.add(new Book("Devara", "Evan","Comedy",3.5));
		b.add(new Book("King", "John","Science",2.4));
		b.add(new Book("Predator", "Don","Science",4.1));
		b.add(new Book("SpiderMan", "James","Comedy",4.3));
		b.add(new Book("Batman", "Pattrick","Action",3.9));
		b.transform();
		b.filter();
		System.out.println("------>SORTED<-------------");
		b.sortByRating();
		
		List<List<Book>> pages = b.paginate();
		for(int i =0 ; i< pages.size();i++) {
			System.out.println("Page " + (i+1));
			pages.get(i).forEach(System.out :: println);
		}
	}
	
}
