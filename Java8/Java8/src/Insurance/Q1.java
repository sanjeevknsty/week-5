package Insurance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Policy{
	String policyNumber;
	String holderName;
	double amount;
	
	public Policy(String policyNumber,String holderName,double amount) {
		this.policyNumber = policyNumber;
		this.amount = amount;
		this.holderName = holderName;

	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getHolderName() {
		return holderName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	@Override
	public String toString() {
		return "policyNumber " + policyNumber + " holderName " + holderName + " amount " + amount;
	}
	
}

//interface PolicyInterface{
//	List<Policy> filterByAmount();
//}
//implements PolicyInterface

class HandlePolicies {
	
	
	List<Policy> arr = new ArrayList();
	
	public void addPolicy(Policy p) {
		arr.add(p);
	}
	
	public void filterByAmount() {
		
		List<Policy> res = arr.stream().filter(i -> i.amount >= 1200).collect(Collectors.toList());

		System.out.println(res);
	}
	
	public void sortPolicies() {
		List<Policy> res = arr.stream().sorted(Comparator.comparing(Policy::getHolderName)).collect(Collectors.toList());
		System.out.println(res);
	}
	
	public void totalPremimum() {
		double res = arr.stream().map(i-> i.getAmount()).reduce(0.0,(add,i)-> add+i );
		System.out.println(res);
	}
	
	public void filterByAmountByRange(double num1,double num2) {
			
			List<Policy> res = arr.stream().filter(i -> i.amount >= num1 && i.amount <= num2).collect(Collectors.toList());
	
			System.out.println(res);
	}

	public void highPremium() {
		double res = arr.stream().map(i-> i.getAmount()).reduce(0.0,(add,i)-> add+i );

	}
	public void average() {
		double res = arr.stream().map(i -> i.getAmount()).reduce(0.0,(total,j)-> total + j) / arr.size();
		System.out.println(res);
	}
	
	public void premiumByRange() {
		
		  Map<String, Long> res = arr.stream()
		            .collect(Collectors.groupingBy(
		                i -> {
		                    double premium = i.getAmount();
		                    if (premium <= 1000) return "$0 - $1,000";
		                    else if (premium <= 2000) return "$1,001 - $2,000";
		                    else return ">$2,000";
		                },
		                Collectors.counting()
		            ));
		  
		  res.forEach((i,j)->{
			  System.out.println("Range " + i + "  " + j);
		  });
	}
	
	
}




public class Q1 {

	public static void main(String[] args) {
		
		HandlePolicies pp = new HandlePolicies();
		pp.addPolicy(new Policy("2341","Predator",300.3));
		pp.addPolicy(new Policy("1231","Chair",1100.3));
		pp.addPolicy(new Policy("5321","Helios",1200.3));
		pp.addPolicy(new Policy("5321","Helios",2400.3));

		
		pp.filterByAmount();
		pp.sortPolicies();
		pp.totalPremimum();
		pp.filterByAmountByRange(1200,2000);
		pp.average();
		pp.premiumByRange();

	}

}
