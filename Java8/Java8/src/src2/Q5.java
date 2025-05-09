package src2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class PolicyHolder{
	int id;
	String name;
	int age;
	String policyType;
	int amount;
	
	public PolicyHolder(int id,String name,int age,String policyType,int amount) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.policyType = policyType;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPolicyType() {
		return policyType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " Name " + name + " Age " + age + " Policy Type " + policyType + " Amount " + amount;
	}
	
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;
    String riskCategory;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
        this.riskCategory = (riskScore > 0.5) ? "High Risk" : "Low Risk";
    }

    @Override
    public String toString() {
        return "RiskAssessment{" +
               "holderId=" + holderId +
               ", name='" + name + '\'' +
               ", riskScore=" + riskScore +
               ", riskCategory='" + riskCategory + '\'' +
               '}';
    }
}

public class Q5 {
	
	public static List<RiskAssessment> analyzePolicyHolders(List<PolicyHolder> policyHolders) {
        return policyHolders.stream()
            .filter(i -> i.getPolicyType().equals("Life") && i.getAge() > 60) 
            .map(i -> new RiskAssessment(i.getId(), i.getName(), i.getAmount() / i.getAge())) // **Transform**
            .sorted(Comparator.comparingDouble(r -> -r.riskScore)) 
            .collect(Collectors.toList()); 
    }
	public static void main(String[] args) {
			
		
		List<PolicyHolder> policyHolders = Arrays.asList(
	            new PolicyHolder(1, "John Doe", 65, "Life", 400),
	            new PolicyHolder(2, "Jane Smith", 72, "Life", 300),
	            new PolicyHolder(3, "Michael Brown", 59, "Life", 500), 
	            new PolicyHolder(4, "Emily Davis", 68, "Car", 200),   
	            new PolicyHolder(5, "Robert White", 75, "Life", 450)
	        );
		List<RiskAssessment> riskAssessments = analyzePolicyHolders(policyHolders);
        riskAssessments.forEach(System.out::println);
    
	}

}
