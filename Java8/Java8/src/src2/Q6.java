package src2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Fraud{
	
	int id;
	int policyNumber;
	double amount;
	String transactionDate;
	boolean isFraudlent;
	
	public Fraud(int id,int policyNumber,double amount,String transactionDate, boolean isFraudlent) {
		this.id = id;
		this.policyNumber = policyNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.isFraudlent = isFraudlent;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPolicyNumber() {
		return policyNumber;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public boolean getIsFraudlent() {
		return isFraudlent;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " PolicyNumber " + policyNumber + " Transaction Date " +transactionDate + " Amount " + amount + " FraudLent " + isFraudlent;
	}
	
	
}


class FraudSummary {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;
    boolean alert;

    public FraudSummary(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
        this.alert = (fraudCount > 5 || totalFraudAmount > 50_000);
    }

    @Override
    public String toString() {
        return "FraudSummary{" +
               "policyNumber='" + policyNumber + '\'' +
               ", fraudCount=" + fraudCount +
               ", totalFraudAmount=" + totalFraudAmount +
               ", alert=" + alert +
               '}';
    }
}


public class Q6 {
	
	public static List<Fraud> manage(List<Fraud> arr) {
		List<Fraud>res = arr.stream().filter( i -> i.getIsFraudlent() && i.getAmount() > 10000)
				.collect(Collectors.groupingBy(Fraud :: getPolicyNumber,
						Collectors.summarizingDouble(Fraud :: getAmount)))
						.entrySet().stream()
						.map( i -> new FraudSummary(i.getKey(),i.getValue().getCount(),i.getValue().getSum()))
						.collect(Collectors.toList());
		
		res.forEach(System.out :: println);
		
//		res.forEach((key,value)->{
//			System.out.print(key + " --> ");
//			value.forEach(System.out :: println);
//		});
		
		
		return arr;
	}

	public static void main(String[] args) {
		List<Fraud> arr = List.of(
				new Fraud(101,2232,122999,"12/23/2023",true),
				new Fraud(102,34223,122999,"12/23/2023",true),
				new Fraud(101,2232,122999,"12/23/2023",true),
				new Fraud(101,2232,122999,"12/23/2023",true),
				new Fraud(101,2232,122999,"12/23/2023",true),
				new Fraud(103,5334,8999,"12/23/2023",true),
				new Fraud(104,23232,7999,"12/23/2023",false),
				new Fraud(105,3534,52999,"12/23/2023",false)
				);
		manage(arr);
		
	}

}
