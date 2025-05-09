package src2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim{
	int id;
	int policyNumber;
	int claimAmount;
	String claimDate;
	boolean status;
	public Claim(int id, int policyNumber,int claimAmount, String claimDate, boolean status) {
		
		this.id = id;
		this.policyNumber = policyNumber;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public int getPolicyNumber() {
		return policyNumber;
	}
	public int getClaimAmount() {
		return claimAmount;
	}
	
	public String getDate() {
		return claimDate;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " PolicyNumber " + policyNumber + " Claim Date " + claimDate + " claim Amount " + claimAmount + " Status " + status;
	}
	
	
}


class ClaimManager{
	
	List<Claim> arr = new ArrayList<>();
	
	public void add(Claim c) {
		arr.add(c);
	}
	
	public void filter() {
		List<Claim> res = arr.stream().filter(i ->( i.status && i.claimAmount > 5000)).collect(Collectors.toList());
		res.forEach(System.out::println);
	}
	
	public void grouping() {
		Map<Integer,List<Claim>> res = arr.stream().collect(Collectors.groupingBy(Claim :: getPolicyNumber));
		
		res.forEach((key,val) ->{
			System.out.println(key);
			val.forEach(System.out :: println);
		});
	}
	
}

public class Q4 {
	
	public static void main(String[] args) {
		ClaimManager c = new ClaimManager();
		c.add(new Claim(101, 52354,5001,"12/03/2123",true));
		c.add(new Claim(102, 54345,84001,"12/03/2023",true));
		c.add(new Claim(103, 345543,35008,"12/03/2033",true));
		c.add(new Claim(104, 25543,45004,"12/03/2023",false));
		c.add(new Claim(105, 45242,1001,"12/03/2723",true));
		c.add(new Claim(106, 4243,1201,"12/03/23",false));
		c.filter();
		c.grouping();
	}

}
